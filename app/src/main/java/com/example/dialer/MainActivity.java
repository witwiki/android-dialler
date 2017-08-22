package com.example.dialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Config;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Request Code variable for CALL_PHONE permissions (Choice of a random integer as long as it is >=0)
    private static final int CALL_PERMISSION_CODE = 1;

    // EditText for viewing the phone number
    EditText numView;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, delBtn, starBtn, hashBtn, callBtn;
    String phNum = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Generic private method to request Dangerous Permissions (in this case, "CALL_PHONE")
        getUserPermission(Manifest.permission.CALL_PHONE, CALL_PERMISSION_CODE);

        // Type casting layout id to java edit text instance variable
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

        phNum = numView.getText().toString();


        //  Click Listeners for all Dial Keys
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

        //  Delete Button
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String builtStr;
                if(numView.getText().length()>0){
                    StringBuilder stringBuilder = new StringBuilder(numView.getText());
                    stringBuilder.deleteCharAt(numView.getText().length() - 1);
                    builtStr = stringBuilder.toString();
                    phNum = "" + builtStr;
                    numView.setText(phNum);
                }
            }
        });

        //  Call Button
        callBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                placeCall();
            }
        });
    }

    public void placeCall(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phNum));
        startActivity(intent);
    }

    /*
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(MainActivity.this, "Landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(MainActivity.this, "Portrait", Toast.LENGTH_SHORT).show();
        }
    }
    */

    /*
    //  Removes the Last Character in the String
    public static String removeLastNum(String s){
        if (s == null || s.length()== 0){
            return null;
        } else {
            return (s.substring(0, s.length() - 1));
        }
    }*/

/*
    public boolean isPermissionGranted(){
        if (Build.VERSION.SDK_INT >= 23){
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                Log.v("TAG", "Permission is GRANTED");
                return true;
            } else {
                Log.v("TAG", "Permission is REVOKED");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        } else {
            //  Automatic Granting Permissions on APIs < 23 on app installation
            Log.v("TAG", "Permission is GRANTED");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestedCode, String requestedPerms[], int[] grantResults){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
                placeCall();
            } else {
                Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
            }
    }

*/


    // Generic private method to request Dangerous Permissions (in this case, "CALL_PHONE")
    private void getUserPermission(String requestedPerm, Integer requestedCode){
        //  Checking to see with the Permission(s) is Granted or Not
        //  If Permission(s) is NOT GRANTED
        if (ContextCompat.checkSelfPermission(MainActivity.this, requestedPerm) != PackageManager.PERMISSION_GRANTED){
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
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case CALL_PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }
/*
    // Switch Case statement within a Try-Catch
    public void dialingEvent(View v){
        try{
            switch (v.getId()){
                case R.id.starBtn:
                    phNum += "*";
                    numView.setText(phNum);
                    break;
                case R.id.hashBtn:
                    phNum += "#";
                    numView.setText(phNum);
                    break;
                case R.id.nullBtn:
                    phNum += "0";
                    numView.setText(phNum);
                    break;
                case R.id.eins:
                    phNum += "1";
                    numView.setText(phNum);
                    break;
                case R.id.zwei:
                    phNum += "2";
                    numView.setText(phNum);
                    break;
                case R.id.drei:
                    phNum += "3";
                    numView.setText(phNum);
                    break;
                case R.id.funf:
                    phNum += "4";
                    numView.setText(phNum);
                    break;
                case R.id.vier:
                    phNum += "5";
                    numView.setText(phNum);
                    break;
                case R.id.sechs:
                    phNum += "6";
                    numView.setText(phNum);
                    break;
                case R.id.sieben:
                    phNum += "7";
                    numView.setText(phNum);
                    break;
                case R.id.acht:
                    phNum += "8";
                    numView.setText(phNum);
                    break;
                case R.id.neun:
                    phNum += "9";
                    numView.setText(phNum);
                    break;
                case R.id.delBtn:
                    if (phNum != null && phNum.length() > 0){
                        phNum = phNum.substring(0, phNum.length() - 1);
                    }
                    numView.setText(phNum);
                    break;
            }
        } catch (Exception ex) {
        }
    }
    */
}
