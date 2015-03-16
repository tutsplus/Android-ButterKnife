package com.androidheroes.butterknifeproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import adapter.ListViewAdapter;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class ListViewActivity extends ActionBarActivity {

    /* Declaring the variables using the Butterknife annotations */
    @InjectView(R.id.listView)
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ButterKnife.inject(this);

        /* Setting the adapter for the listview */
        list.setAdapter(new ListViewAdapter((LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE)));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);
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
