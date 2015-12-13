package com.orenstudio.gnmnetwork;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import ApiRefit.ServiceGenerator;

import retrofit.Call;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        // Create a very simple REST adapter which points the GitHub API endpoint.
        ServiceGenerator.GitHubClient client = ServiceGenerator.createService(ServiceGenerator.GitHubClient.class);
        Log.d(TAG, "MainActivity -- Create ApiClient");

        // Fetch and print a list of the contributors to this library.
        Call<List<ServiceGenerator.Contributor>> call =
                client.contributors("sylius", "sylius");
        Log.d(TAG, "MainActivity -- Set client.contributors");


        List<ServiceGenerator.Contributor> contributors;
        contributors = call.execute().body();
/*        try {
            contributors = call.execute().body();
        } catch (IOException e) {
            //e.printStackTrace();
        }*/

        /*        try {
                    List<ServiceGenerator.Contributor> contributors = call.execute().body();
                } catch (IOException e) {
                    // handle errors
                    Log.d( TAG, "MainActivity -- " );
                }*/

/*                for (ServiceGenerator.Contributor contributor : contributors) {
                    System.out.println(
                            contributor.login + " (" + contributor.contributions + ")");
                }*/
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
