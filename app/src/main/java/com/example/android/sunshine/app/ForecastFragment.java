package com.example.android.sunshine.app;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.sunshine.app.data.WeatherContract;

/**
 * Encapsulates fetching the forecast and displaying it as a {@link ListView} layout.
 */
public class ForecastFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int FORECAST_LOADER = 0;
    private ForecastAdapter mForecastAdapter;
    private final String LOG_TAG = ForecastFragment.class.getSimpleName();

    private ArrayAdapter<String> mForecastAdapter = null;

    public ForecastFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add this line in order for this fragment to handle menu events.
        setHasOptionsMenu(true);
    }
//If don't comment see duplicate menu
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.forecast_fragment, menu);
//
//    }
@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    inflater.inflate(R.menu.forecast_fragment, menu);
}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
        //3.08 Call updateWather Method
            updateWeather();
//            FetchWeatherTask weatherTask = new FetchWeatherTask();
//            weatherTask.execute("Valencia,ESP");
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        // The ArrayAdapter will take data from a source and
//        // use it to populate the ListView it's attached to.
//        mForecastAdapter =
//                new ArrayAdapter<String>(
//                        getActivity(), // The current context (this activity)
//                        R.layout.list_item_forecast, // The name of the layout ID.
//                        R.id.list_item_forecast_textview, // The ID of the textview to populate.
//                        new ArrayList<String>());
//
//        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // The CursorAdapter will take data from our cursor and populate the ListView.
        mForecastAdapter = new ForecastAdapter(getActivity(), null, 0);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(mForecastAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                String forecast = mForecastAdapter.getItem(position);
//                Intent intent = new Intent(getActivity(), DetailActivity.class)
//                        .putExtra(Intent.EXTRA_TEXT, forecast);
//                startActivity(intent);
//            }
//        });

        return rootView;
    }

    @Override
       public void onActivityCreated(Bundle savedInstanceState) {
               getLoaderManager().initLoader(FORECAST_LOADER, null, this);
               super.onActivityCreated(savedInstanceState);
           }

    private void updateWeather() {
        FetchWeatherTask weatherTask = new FetchWeatherTask(getActivity());
        String location = Utility.getPreferredLocation(getActivity());
        weatherTask.execute(location);
    }
        //String location = PreferenceManager.getDefaultSharedPreferences(getActivity())
         //       .getString(getString(R.string.pref_location_key),
            //        getString(R.string.pref_location_default);
        //weatherTask.execute(location);


    }
    @Override
    public void onStart(){
        super.onStart();
        updateWeather();
        Log.i(LOG_TAG, "on create");
        Log.d(LOG_TAG, "Debug");
        Log.e(LOG_TAG, "Error");
        Log.v(LOG_TAG, "Mensaje de Registro - Verbose Log");
        Log.w(LOG_TAG, "Mensaje de Advertencia - Warn");
    }





@Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
                String locationSetting = Utility.getPreferredLocation(getActivity());

               // Sort order:  Ascending, by date.
               String sortOrder = WeatherContract.WeatherEntry.COLUMN_DATE + " ASC";
                Uri weatherForLocationUri = WeatherContract.WeatherEntry.buildWeatherLocationWithStartDate(
                        locationSetting, System.currentTimeMillis());

               return new CursorLoader(getActivity(),
                       weatherForLocationUri,
                       null,
                        null,
                        null,
                        sortOrder);
            }

            @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
                mForecastAdapter.swapCursor(cursor);
            }

            @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
               mForecastAdapter.swapCursor(null);
            }
        }