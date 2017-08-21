package com.example.dialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // EditText for viewing the phone number
    EditText numView;

    // Request Code variable for CALL_PHONE permissions (Choice of a random integer as long as it is >=0)
    static int CALL_PERMISSION_CODE = 0x3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Type casting layout id to java edit text instance variable
        numView = (EditText) findViewById(R.id.num_view);
    }

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
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch (requestCode){
            case CALL_PERMISSION_CODE:
        }
    }


    // Switch Case statement within a Try-Catch
    public void dialingEvent(View v){
        String phNum = numView.getText().toString();
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
                case R.id.anruf:

            }
            getUserPermission(Manifest.permission.CALL_PHONE, CALL_PERMISSION_CODE);
            String callNum = "tel:" + phNum;
            Intent callIntnt = new Intent(Intent.ACTION_CALL);
            callIntnt.setData(Uri.parse(callNum));
            startActivity(callIntnt);
            } catch (Exception ex){

        }
        }

//    }
}
