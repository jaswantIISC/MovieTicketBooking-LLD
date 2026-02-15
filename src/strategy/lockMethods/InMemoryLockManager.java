package strategy.lockMethods;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InMemoryLockManager implements LockManager{

    private final ConcurrentHashMap<String, UserLockExpiry> locks = new ConcurrentHashMap<>();
    private final ScheduledExecutorService cleaupJob = Executors.newSingleThreadScheduledExecutor();
   
    public InMemoryLockManager(){
        cleaupJob.scheduleAtFixedRate(this::cleanup, 1, 1, TimeUnit.MINUTES);
    }
   
    public void cleanup() {
        for(Map.Entry<String, UserLockExpiry> e : locks.entrySet()) {
            if(e.getValue().deadline <= System.currentTimeMillis()){
                locks.remove(e.getKey());
            }
        }
    }


    @Override
    public boolean lockSeat(String seatKey, String userId, long ttlMillis) {

        if (seatKey == null || userId == null || ttlMillis <= 0) {
            throw new IllegalArgumentException("Invalid lock parameters");
        }
    
        final long now = System.currentTimeMillis();
        final long expiryTime = now + ttlMillis;
        final UserLockExpiry newLockExpiry = new UserLockExpiry(expiryTime, userId);
    
        UserLockExpiry result = locks.compute(seatKey, (key, existingLock) -> {
            if (existingLock == null || existingLock.deadline <= now) {
                return newLockExpiry;
            }
            return existingLock;
        }); 
        return result == newLockExpiry;
    }
    

    @Override
    public void unLockSeats(String key) {
        locks.remove(key);
    }

    @Override
    public boolean isLockExpired(String key) {
        if(!locks.contains(key)){
            return false;
        }
        UserLockExpiry userLockExpiry = locks.get(key);
        long currentTimeMillis = System.currentTimeMillis();
        return userLockExpiry !=null && userLockExpiry.deadline < currentTimeMillis;
    }

    @Override
    public boolean isLockedBy(String key, String userId) {
        if(!locks.contains(key)){
            return false;
        }
        UserLockExpiry userLockExpiry = locks.get(key);
        return userLockExpiry != null && userLockExpiry.owner.equalsIgnoreCase(userId);
    }


    private static class UserLockExpiry{
        private final long deadline;
        private final String owner;
        
        public UserLockExpiry(long deadline, String owner) {
            this.deadline = deadline;
            this.owner = owner;
        }
    }

}
