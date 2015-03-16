package com.androidheroes.butterknifeproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends ActionBarActivity {

    /* Declaring the variables using the Butterknife annotations */
    @InjectView(R.id.sample_textview)
    TextView sample_textview;

    @InjectView(R.id.sample_button)
    Button sample_button;

    /*
    *    Normal declaration of the variables
    *

    Button sample_button;
    TextView sample_textview;

    */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * This is a regular implementation BEFORE BUTTERKNIFE
        *

        sample_textview = (TextView) findViewById(R.id.sample_textview);
        sample_button = (Button) findViewById(R.id.sample_button);

        // These are the events for the views
        sample_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "This is a message from the activity", Toast.LENGTH_SHORT).show();
            }
        });

        sample_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sample_button.getText() == getResources().getString(R.string.activity_button_text)){
                    sample_button.setText(R.string.activity_button_pressed_text);
                }
                else{
                    sample_button.setText(R.string.activity_button_text);
                }
            }
        });
        */

        /*
        * This is an implementation AFTER BUTTERKNIFE
        */

        ButterKnife.inject(this);
    }

    /* These are the events managed by Butterknife library */

    @OnClick(R.id.sample_textview)
    public void showToastMessage(){
        Toast.makeText(MainActivity.this, "This is a message from the activity", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.sample_button)
    public void changeText(){
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }


}
