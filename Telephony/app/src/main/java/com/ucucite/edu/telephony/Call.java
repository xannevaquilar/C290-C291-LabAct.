package com.ucucite.edu.telephony;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Call extends AppCompatActivity {

    EditText editNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        editNum=findViewById(R.id.editNum);

        Bundle call = getIntent().getExtras();
        String CALL = call.getString("call");
        editNum.setText(String.valueOf(CALL));

    }
    public void btnCall (View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if(permissionCheck == PackageManager.PERMISSION_GRANTED) {
            String Num = editNum.getText().toString().trim();
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+Num));
            startActivity(callIntent);

        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
        }
    }
}