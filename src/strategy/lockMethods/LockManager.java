package strategy.lockMethods;

public interface LockManager {

    public boolean lockSeat(String key, String userId, long TTL);
    public void unLockSeats(String key);
    public boolean isLockExpired(String key);
    public boolean isLockedBy(String key, String userId);
}
