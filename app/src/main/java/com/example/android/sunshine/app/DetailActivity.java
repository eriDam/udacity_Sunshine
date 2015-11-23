
package com.example.android.sunshine.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class DetailActivity extends AppCompatActivity {

    private final String LOG_TAG = DetailActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new DetailFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
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

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class DetailFragment extends Fragment {
        //Add a few usuful things, LOG_TAg,a String for the share hastag
        private static final String LOG_TAG = DetailFragment.class.getSimpleName();

        private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
        //Make a member variable mForecastStr
        private String mForecastStr;
        ShareActionProvider mShareActionProvider;


        public DetailFragment() {
            setHasOptionsMenu(true);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

            Intent intent = getActivity().getIntent();
            if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)){
                //Populate our member variable
                mForecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
            ((TextView) rootView.findViewById(R.id.detail_text))
                    //Use it(variable) to set the text
                    .setText(mForecastStr);
        }
            return rootView;

        }

        @Override
               public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
                       // Inflate the menu; this adds items to the action bar if it is present.
                                inflater.inflate(R.menu.detailfragment, menu);

                                // Retrieve the share menu item
                                        MenuItem menuItem = menu.findItem(R.id.action_share);

                               // Get the provider and hold onto it to set/change the share intent.
                                      mShareActionProvider =(ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

                                // Attach an intent to this ShareActionProvider.  You can update this at any time,
                                        // like when the user selects a new piece of data they might like to share.
                                               if (mShareActionProvider != null ) {
                                mShareActionProvider.setShareIntent(createShareForecastIntent());
                            } else {
                                Log.d(LOG_TAG, "Share Action Provider is null?");
                            }
                    }

                        private Intent createShareForecastIntent() {
                       Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_TEXT,
                                        mForecastStr + FORECAST_SHARE_HASHTAG);
                            setShareIntent(shareIntent);
                        return shareIntent;
                    }

        private void setShareIntent(Intent shareIntent){
            if (mShareActionProvider != null){
                mShareActionProvider.setShareIntent(shareIntent);
            }
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
