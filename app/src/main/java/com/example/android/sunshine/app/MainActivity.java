package com.example.android.sunshine.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new ForecastFragment())
//                    .commit();
//        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "EriDev you should Prepare an action for this button", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //The Log is the tool to control or to debug our app
        //They are nothing more than reading what is happening in our application.
        //Log incorporate the end of each method activity android
        Log.i(LOG_TAG, "on create");
        Log.d(LOG_TAG, "Debug");
        Log.e(LOG_TAG, "Error");
        Log.v(LOG_TAG, "Mensaje de Registro - Verbose Log");
        Log.w(LOG_TAG, "Mensaje de Advertencia - Warn");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.forecast_fragment, menu);
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
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        if (id == R.id.action_map) {
            openPreferredLocationInMap();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openPreferredLocationInMap() {
        SharedPreferences sharedPrefs =
                PreferenceManager.getDefaultSharedPreferences(this);
        String location = sharedPrefs.getString(
                getString(R.string.pref_location_key),
                getString(R.string.pref_location_default));

        // Using the URI scheme for showing a location found on a map.  This super-handy
        // intent can is detailed in the "Common Intents" page of Android's developer site:
        // http://developer.android.com/guide/components/intents-common.html#Maps
        Uri geoLocation = Uri.parse("geo:0,0?").buildUpon()
                .appendQueryParameter("q", location)
                .build();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d(LOG_TAG, "Couldn't call " + location + ", no receiving apps installed!");
        }
    }

    //Generamos e incorporamos los metodos de Log, automaticamente desde botón dcho source-Override/Implement methodes
    //Override, en realidad ni sobrecarga ni sustituye, le dice al compilador que haga caso a este método y no al del padre
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Log.i(LOG_TAG, "onStart");
        Log.d(LOG_TAG, "Debug");
        Log.e(LOG_TAG, "Error");
        Log.v(LOG_TAG, "Mensaje de Registro - Verbose Log");
        Log.w(LOG_TAG, "Mensaje de Advertencia - Warn");
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Log.i(LOG_TAG, "onResume");
        Log.d(LOG_TAG, "Debug");
        Log.e(LOG_TAG, "Error");
        Log.v(LOG_TAG, "Mensaje de Registro - Verbose Log");
        Log.w(LOG_TAG, "Mensaje de Advertencia - Warn");
    }
        @Override
        protected void onPause () {
            // TODO Auto-generated method stub
            super.onPause();
            Log.i(LOG_TAG, "onPause");
            Log.d(LOG_TAG, "Debug");
            Log.e(LOG_TAG, "Error");
            Log.v(LOG_TAG, "Mensaje de Registro - Verbose Log");
            Log.w(LOG_TAG, "Mensaje de Advertencia - Warn");
        }

        @Override
        protected void onStop () {
            // TODO Auto-generated method stub
            super.onStop();
            Log.i(LOG_TAG, "onStop");
            Log.d(LOG_TAG, "Debug");
            Log.e(LOG_TAG, "Error");
            Log.v(LOG_TAG, "Mensaje de Registro - Verbose Log");
            Log.w(LOG_TAG, "Mensaje de Advertencia - Warn");
        }

        @Override
        protected void onRestart () {
            // TODO Auto-generated method stub
            super.onRestart();
            Log.i(LOG_TAG, "onRestart");
            Log.d(LOG_TAG, "Debug");
            Log.e(LOG_TAG, "Error");
            Log.v(LOG_TAG, "Mensaje de Registro - Verbose Log");
            Log.w(LOG_TAG, "Mensaje de Advertencia - Warn");
        }
        @Override
        protected void onDestroy () {
            // TODO Auto-generated method stub
            super.onDestroy();
            Log.i(LOG_TAG, "onDestroy");
            Log.d(LOG_TAG, "Debug");
            Log.e(LOG_TAG, "Error");
            Log.v(LOG_TAG, "Mensaje de Registro - Verbose Log");
            Log.w(LOG_TAG, "Mensaje de Advertencia - Warn");
        }
    }
