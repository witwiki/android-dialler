package com.example.dialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
*
*   @author: Vikram Udyawer (04316827)
*   @date: 23rd August 2017
*   @summary: A Single Activity Dialer Application
*
* */

public class MainActivity extends AppCompatActivity {

    // Request Code variable for CALL_PHONE permissions (Choice of a random integer as long as it is >=0)
    private static final int CALL_PERMISSION_CODE = 1;

    // Declarations for EditText, Buttons and String of edit text to manipulate
    EditText numView;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, delBtn, starBtn, hashBtn, callBtn;
    private String phNum;

    //  Key to save the String during state changes
    private static final String DISPLAYED_PHONE_NUMBER = "displayedPhoneNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Generic private method to request Dangerous Permissions (in this case, "CALL_PHONE")
        getUserPermission(Manifest.permission.CALL_PHONE, CALL_PERMISSION_CODE);

        // Type casting layout elements to variables in Main Activity
        numView = (EditText) findViewById(R.id.num_view);
        b0 = (Button) findViewById(R.id.nullBtn);
        b1 = (Button) findViewById(R.id.eins);
        b2 = (Button) findViewById(R.id.zwei);
        b3 = (Button) findViewById(R.id.drei);
        b4 = (Button) findViewById(R.id.vier);
        b5 = (Button) findViewById(R.id.funf);
        b6 = (Button) findViewById(R.id.sechs);
        b7 = (Button) findViewById(R.id.sieben);
        b8 = (Button) findViewById(R.id.acht);
        b9 = (Button) findViewById(R.id.neun);
        delBtn = (Button) findViewById(R.id.delBtn);
        starBtn = (Button) findViewById(R.id.starBtn);
        hashBtn = (Button) findViewById(R.id.hashBtn);
        callBtn = (Button)findViewById(R.id.anruf);

        //  Get text from Edit Text --> Convert to string and place in 'phNum' String variable
        phNum = numView.getText().toString();

        /*
            Below are 14 Click Listeners for all Dial Keys from keys 0 through to 9;
            '*'; '#'; backspace & Call buttons
         */
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phNum = phNum + "0";
                numView.setText(phNum);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phNum = phNum + "1";
                numView.setText(phNum);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phNum = phNum + "2";
                numView.setText(phNum);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phNum = phNum + "3";
                numView.setText(phNum);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phNum = phNum + "4";
                numView.setText(phNum);

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phNum = phNum + "5";
                numView.setText(phNum);

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phNum = phNum + "6";
                numView.setText(phNum);

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phNum = phNum + "7";
                numView.setText(phNum);

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phNum = phNum + "8";
                numView.setText(phNum);

            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phNum = phNum + "9";
                numView.setText(phNum);

            }
        });

        starBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phNum = phNum + "*";
                numView.setText(phNum);

            }
        });

        hashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phNum = phNum + "#";
                numView.setText(phNum);

            }
        });

        //  Click Listener for the Delete Button
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String builtStr;
                //  Check length of EditText box is greater than zero
                if(numView.getText().length()>0){
                    // If length larger than zero create new String Builder initialised with character sequence
                    StringBuilder stringBuilder = new StringBuilder(numView.getText());
                    // Get length odf character sequence and delete the last character in the index
                    // Remove char at given index position
                    stringBuilder.deleteCharAt(numView.getText().length() - 1);
                    // convert the character sequence to a string
                    builtStr = stringBuilder.toString();
                    //  append string to phNum string
                    phNum = "" + builtStr;
                    //  set phNum string to EditText variable to display
                    numView.setText(phNum);
                }
            }
        });

        //  Click Listener for the Call Button
        callBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                placeCall();
            }
        });


        ////  Restoring savedInstanceState on any Hardware Configuration Change (such as device rotation)
        if (savedInstanceState != null){
            phNum = (String)savedInstanceState.get(DISPLAYED_PHONE_NUMBER);
            Log.d("TAG", "Restored instance state: phNum => " + phNum);
        }


    }   /// End of onCreate()

    //  Saving Activity state on any Hardware Configuration Change (such as device rotation)
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable(DISPLAYED_PHONE_NUMBER, phNum);
    }


    /*
       Method to call the Intent for ACTION_CALL; setting URI
       and starting the activity
    */
    public void placeCall(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phNum));
        startActivity(intent);
    }

    // Generic private method to request Dangerous Permissions (in this case, "CALL_PHONE")
    private void getUserPermission(String requestedPerm, Integer requestedCode){
        //  Checking if the Build version is API greater than 22
        if ((Build.VERSION.SDK_INT > 22)){
            //  Checking to see with the Permission(s) is Granted or Not
            //  If Permission(s) is NOT GRANTED
            if (ContextCompat.checkSelfPermission(MainActivity.this, requestedPerm) != PackageManager.PERMISSION_GRANTED){
                Log.v("TAG","Permission is granted");
                // Check to see the user has denied permission(s) previously
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, requestedPerm)){
                    //  Ask permission again in the case the user has denied permissions previously (as it is an important Permission)
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{requestedPerm}, requestedCode);
                }
                //  If Permission was Not Denied previously, a request is made
                else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {requestedPerm}, requestedCode);
                }
            }
            //  If Permission(s) GRANTED we add a message to say the Permission was granted
            else {
                Toast.makeText(this, "" + requestedPerm + " is already granted", Toast.LENGTH_SHORT).show();
            }
        } else {
            //  If build is lower than 23 then Permission requested and granted during app install
            Log.v("TAG","Permission is granted");
        }
    }

    //  Method to handle a requested permission
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        //  Switch case statement is used to handle multiple request permission codes (if needed)
        switch (requestCode){
            //  Permission code for CALL_PHONE
            case CALL_PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //  Permission Denied
                    Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }
}
