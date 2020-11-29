package com.ucucite.edu.telephony;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Message extends AppCompatActivity {

    EditText editPhone, editMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        editPhone = findViewById(R.id.editPhone);
        editMessage = findViewById(R.id.editMessage);

        Bundle sms = getIntent().getExtras();
        String SMS = sms.getString("sms");
        editPhone.setText(String.valueOf(SMS));

    }
    public void btnSend(View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if (permissionCheck== PackageManager.PERMISSION_GRANTED) {
            sendMessage();
        }
        else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);
        }

    }
    private void sendMessage() {
        String phone, message;

        phone = editPhone.getText().toString().trim();
        message = editMessage.getText().toString().trim();

        SmsManager smsManager = SmsManager.getDefault();

        smsManager.sendTextMessage(phone, null, message, null, null);

        Toast.makeText(this, "Message Sent", Toast.LENGTH_LONG).show();
    }
}