package com.example.android.sunshine.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate root fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Create data for the ListView.
        String[] forecastArray = {
                "Today - Sunny - 88/63",
                "Tomorrow - Foggy - 77/40",
                "Wed  Cloudy - 72/63",
                "Thurs - Asteroids - 75/65",
                "Fri - Heavy Rain - 65/56",
                "Sat - HELP TRAPPED IN WEATHERSTATION - 60/51",
                "Sun - Sunny - 80/68"
        };
        List<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));

        // use it to fill the ListView it's attached to.
        ArrayAdapter mForecastAdapter =  new ArrayAdapter<String>(
                            //The actual context "this"
                            getActivity(),
                            R.layout.list_item_forecast, // The name of the layout ID.
                            R.id.list_item_forecast_textview, // The ID of the textview to fill.
                            weekForecast);

        //Get references to the list view and connect adapater
        ListView listView =(ListView) rootView.findViewById(
                R.id.listview_forecast);
        listView.setAdapter(mForecastAdapter);


        return  rootView;
    }
}