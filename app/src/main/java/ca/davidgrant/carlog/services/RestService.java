package ca.davidgrant.carlog.services;

import java.util.List;

import ca.davidgrant.carlog.model.Trip;
import ca.davidgrant.carlog.model.TripData;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by david on 08/02/15.
 */
public interface RestService {
    @GET("/trips/")
    void listTrips(Callback<TripData> cb);
}
