package com.example.esoukhanov.androidlab_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import static com.example.esoukhanov.androidlab_1.R.id.editText;

public class LoginActivity extends Activity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
    SharedPreferences sharedPref ;
    Button loginButton;
    EditText mEmailView;
    EditText passwordView;
    public static final String LAB_3 ="Lab_3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(ACTIVITY_NAME, "In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        loginButton = (Button) findViewById(R.id.button2);// finding and assigning instance to loginbutton
        mEmailView = (EditText) findViewById(editText);//finding and assigning instance to name field
      //  SharedPreferences sharedPreferences = getSharedPreferences(LAB_3, Context.MODE_PRIVATE);// GET SHARED PREFERENCES
     //   mEmailView.setText(sharedPreferences.getString("Email", " "));// set email in the name field

        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPref  = getSharedPreferences(LAB_3, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                mEmailView = (EditText) findViewById(R.id.editText);

                editor.putString("Email", mEmailView.getText().toString());
                editor.commit();

                LoginActivity.this.startActivity(new Intent(LoginActivity.this, StartActivity.class));
                Intent intent = new Intent(LoginActivity.this, StartActivity.class);

                startActivity(intent);

            }

            });



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
        sharedPref = getSharedPreferences(LAB_3, Context.MODE_PRIVATE);// GET SHARED PREFERENCES
        mEmailView.setText(sharedPref.getString("Email", null));// set email in the name field
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
