package ca.davidgrant.carlog.services;

import android.util.Log;

import java.util.List;

import ca.davidgrant.carlog.model.Trip;
import ca.davidgrant.carlog.model.TripData;
import hugo.weaving.DebugLog;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by david on 08/02/15.
 */
public class TripService {
    private RestService restService;

    public TripService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://carlog2.davidgrant.ca")
                .build();

        restService = restAdapter.create(RestService.class);
    }

    @DebugLog
    public void updateTrips() {
        restService.listTrips(new Callback<TripData>() {
            @Override
            public void success(TripData tripData, Response response) {
                Log.d("TripService", "yay got trips");
                for (Trip trip : tripData.getResults()) {
                    Log.d("TripService", trip.toString());
                }

            }

            @Override
            public void failure(RetrofitError error) {
                // failed
                Log.e("TripService", "failed to get trips: " + error.toString() + error.getBody());
            }
        });
    }
}
