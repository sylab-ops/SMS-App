package com.sylabblueprint.smsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPhone;
    private  EditText editTxtSMS;
    private Button sendBtn, cancelBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        editTextPhone = findViewById(R.id.editTextPhone);
        editTxtSMS = findViewById(R.id.editTxtSMS);
    }

    public void sendSMS(View view){
        String message = editTxtSMS.getText().toString();
        String number = editTextPhone.getText().toString();
        SmsManager mySmsmanager = SmsManager.getDefault();
        mySmsmanager.sendTextMessage(number, null, message, null, null);
    }

}
