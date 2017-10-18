package com.example.esoukhanov.androidlab_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import static com.example.esoukhanov.androidlab_1.StartActivity.REQUEST_IMAGE_CAPTURE;

public class ListItemsActivity extends Activity {
    protected static final String ACTIVITY_NAME = "ListItemsActivity";
    ImageButton camera_Button;
    Switch switchButton;
    CheckBox checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        camera_Button = (ImageButton) findViewById(R.id.imageButton);
        camera_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }

        });

        switchButton = (Switch) findViewById(R.id.switch_button);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                CharSequence text;
                int duration;

                if (buttonView.isChecked()) {
                    text = "Switch is On";
                    duration = Toast.LENGTH_SHORT;

                } else {
                    text = "Switch is Off";
                    duration = Toast.LENGTH_LONG;

                }

                Toast toast = Toast.makeText(ListItemsActivity.this, text, duration); //this is the ListActivity
                toast.show();
            }
        });

        checkButton = (CheckBox)findViewById(R.id.check_button);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Store values at the time of the login attempt.
                AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);

                    // Chain together various setter methods to set the dialog characteristics
                builder.setMessage(R.string.dialog_message); //Added a dialog message to strings.xml
                builder.setTitle(R.string.dialog_title);//Added a dialog title message to strings.xml
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent resultIntent = new Intent(  );
                        resultIntent.putExtra("Response", "Here is my response");
                        setResult(Activity.RESULT_OK, resultIntent);

                        finish();

                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

        Log.i(ACTIVITY_NAME, "In onCreate()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //ImageButton imButton = (ImageButton) findViewById(R.id.imageButton);
            camera_Button.setImageBitmap(imageBitmap);
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
