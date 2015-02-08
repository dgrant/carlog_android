package ca.davidgrant.carlog.model;

import java.util.Date;

/**
 * Created by david on 07/02/15.
 */
public class Trip {
    private String destination;
    private Date date;
    private String reason;
    private float distance;
    private int carId;

    public Date getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public String getReason() {
        return reason;
    }

    public float getDistance() {
        return distance;
    }

    public int getCarId() {
        return carId;
    }
}
