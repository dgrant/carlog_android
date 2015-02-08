package ca.davidgrant.carlog;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import ca.davidgrant.carlog.modules.AndroidModule;
import ca.davidgrant.carlog.modules.CarlogModule;
import dagger.ObjectGraph;
import hugo.weaving.DebugLog;

/**
 * Created by david on 08/02/15.
 */
public class CarlogApplication extends Application {
    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();
        graph = ObjectGraph.create(getModules().toArray());
//        graph.get(CarlogApplication.class);
    }

    protected List<Object> getModules() {
        return Arrays.asList(
                new AndroidModule(this),
                new CarlogModule()
        );
    }

    public void inject(Object object) {
        graph.inject(object);
    }
}
