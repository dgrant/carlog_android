package ca.davidgrant.carlog;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import ca.davidgrant.carlog.events.TripsEvent;
import ca.davidgrant.carlog.services.TripService;
import hugo.weaving.DebugLog;


public class TripListActivity extends ActionBarActivity {
    private static final String TAG = "TripListActivity";
    private RelativeLayout outer_layout;

    @Inject
    TripService tripService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Perform injection so that when this call returns all dependencies will be available for use.
        ((CarlogApplication) getApplication()).inject(this);

        setContentView(R.layout.activity_trip_list);

        outer_layout = (RelativeLayout) findViewById(R.id.outer_layout);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (tripService == null) {
            Log.e(TAG, "tripService is null!");
        }
        tripService.updateTrips();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trip_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Subscribe
    @DebugLog
    public void handleTrips(TripsEvent tripsEvent) {

    }

}
