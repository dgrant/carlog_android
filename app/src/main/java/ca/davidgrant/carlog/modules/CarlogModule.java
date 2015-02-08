package ca.davidgrant.carlog.modules;

import javax.inject.Singleton;

import ca.davidgrant.carlog.CarlogApplication;
import ca.davidgrant.carlog.TripListActivity;
import ca.davidgrant.carlog.services.TripService;
import dagger.Module;
import dagger.Provides;
import hugo.weaving.DebugLog;

/**
 * Created by david on 08/02/15.
 */
@Module(
        injects = TripListActivity.class,
        complete = false
)
public class CarlogModule {

    @Provides @Singleton
    TripService provideTripService() {
        return new TripService();
    }
}
