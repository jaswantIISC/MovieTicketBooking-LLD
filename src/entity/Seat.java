package entity;

import enums.SeatStatus;
import enums.SeatType;

public abstract class Seat {

    private final String id;
    private final String row;
    private final int num;
    private SeatStatus status;

    public Seat(String row, int num){
        this.id = row + "-" + num;
        this.row = row;
        this.num = num;
        this.status = SeatStatus.AVAILABLE;
    }

    public abstract SeatType getType();

    public String getId() {
        return id;
    }

    public String getRow() {
        return row;
    }
   
    public int getNum() {
        return num;
    }
  
    public SeatStatus getStatus() {
        return status;
    }
    
    public void setStatus(SeatStatus status){
        this.status = status;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((row == null) ? 0 : row.hashCode());
        result = prime * result + num;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
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
        Seat other = (Seat) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (row == null) {
            if (other.row != null)
                return false;
        } else if (!row.equals(other.row))
            return false;
        if (num != other.num)
            return false;
        if (status != other.status)
            return false;
        return true;
    }

    
}
