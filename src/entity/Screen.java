package entity;

import java.util.HashMap;
import java.util.Map;

public class Screen {

    private final String id;
    private final String name;
    private final Map<String, Seat> seats;

    public Screen(String id, String name) {
        this.id = id;
        this.name = name;
        this.seats = new HashMap<>();
    }

    public void addSeat(Seat seat) {
        this.seats.put(seat.getId(), seat);
    }

    public Seat getSeat(String seatId) {
        return seats.get(seatId);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    

    @Override
    public String toString() {
        return "Screen [id=" + id + ", name=" + name + ", seats=" + seats + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((seats == null) ? 0 : seats.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Screen other = (Screen) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (seats == null) {
            if (other.seats != null)
                return false;
        } else if (!seats.equals(other.seats))
            return false;
        return true;
    }
    
}
