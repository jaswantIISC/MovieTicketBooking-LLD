package strategy.lockMethods;

public class RedisLockManger implements LockManager{

    @Override
    public boolean lockSeat(String key, String userId, long TTL) {
        throw new UnsupportedOperationException("Unimplemented method 'lockSeat'");
    }

    @Override
    public void unLockSeats(String key) {
        throw new UnsupportedOperationException("Unimplemented method 'unLockSeats'");
    }

    @Override
    public boolean isLockExpired(String key) {
        throw new UnsupportedOperationException("Unimplemented method 'isLockExpired'");
    }

    @Override
    public boolean isLockedBy(String key, String userId) {
        throw new UnsupportedOperationException("Unimplemented method 'isLockedBy'");
    }

}
