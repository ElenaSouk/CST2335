package com.example.esoukhanov.androidlab_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends Activity {
    protected static final String ACTIVITY_NAME = "StartActivity";
    Button I_Am_Button;
    Button StartChat;
    Button weatherForecast;
    static final int REQUEST_IMAGE_CAPTURE = 10;  // The request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        setContentView(R.layout.activity_start_avtivity);

        I_Am_Button = (Button) findViewById(R.id.button);
        I_Am_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
                startActivityForResult(intent, 10);// Activity is started with requestCode 10

            }

        });

        StartChat = (Button)findViewById(R.id.button3);
        StartChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(ACTIVITY_NAME, "User clicked Start Chat");
                Intent intent = new Intent(StartActivity.this, ChatWindow.class);
                startActivity(intent);
            }
        });
        //start ListItems Activity
        //Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
        //Bundle bundleOptions = new Bundle();
       // startActivityForResult(intent, 10);// Activity is started with requestCode 10
        // finding and assigning instance to weatherForecast button
        weatherForecast = (Button) findViewById(R.id.button4);
        weatherForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(ACTIVITY_NAME, "User clicked weatherForecast");
                Intent intent = new Intent(StartActivity.this, WeatherForecast.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        //super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 10
        if(requestCode==10)
        {
            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
        }

        if(resultCode == StartActivity.RESULT_OK){
            String messagePassed = data.getStringExtra("Response");
            if (messagePassed.length() > 0) {
                CharSequence text = "ListItemsActivity passed: My information to share";
                int duration = Toast.LENGTH_LONG;
                Toast toast1 = Toast.makeText(this, text, duration);
                toast1.show();
            }
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
