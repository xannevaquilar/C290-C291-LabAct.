package com.ucucite.edu.telephony;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    ImageButton mess1, mess2, mess3, mess4, mess5;
    ImageButton call1, call2, call3, call4, call5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mess1=findViewById(R.id.mess1);
        mess2=findViewById(R.id.mess2);
        mess3=findViewById(R.id.mess3);
        mess4=findViewById(R.id.mess4);
        mess5=findViewById(R.id.mess5);

        call1=findViewById(R.id.call1);
        call2=findViewById(R.id.call2);
        call3=findViewById(R.id.call3);
        call4=findViewById(R.id.call4);
        call5=findViewById(R.id.call5);


        mess1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09279408520";
                Intent intent = new Intent(getApplicationContext(), Message.class);
                intent.putExtra("Text Message", Contact);
                startActivity(intent);
            }
        });

        mess2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09064085263";
                Intent intent = new Intent(getApplicationContext(), Message.class);
                intent.putExtra("Text Mesasge", Contact);
                startActivity(intent);
            }
        });

        mess3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09950272928";
                Intent intent = new Intent(getApplicationContext(), Message.class);
                intent.putExtra("Text Mesasge", Contact);
                startActivity(intent);
            }
        });

        mess4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09218231145";
                Intent intent = new Intent(getApplicationContext(), Message.class);
                intent.putExtra("Text Mesasge", Contact);
                startActivity(intent);
            }
        });

        mess5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09661796212";
                Intent intent = new Intent(getApplicationContext(), Message.class);
                intent.putExtra("Text Mesasge", Contact);
                startActivity(intent);
            }
        });



        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09279408520";
                Intent intent = new Intent(getApplicationContext(), Call.class);
                intent.putExtra("Call", Contact);
                startActivity(intent);
            }
        });

        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09064085263";
                Intent intent = new Intent(getApplicationContext(), Call.class);
                intent.putExtra("Call", Contact);
                startActivity(intent);
            }
        });

        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09950272928";
                Intent intent = new Intent(getApplicationContext(), Call.class);
                intent.putExtra("Call", Contact);
                startActivity(intent);
            }
        });

        call4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09218231145";
                Intent intent = new Intent(getApplicationContext(), Call.class);
                intent.putExtra("Call", Contact);
                startActivity(intent);
            }
        });

        call5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09661796212";
                Intent intent = new Intent(getApplicationContext(), Call.class);
                intent.putExtra("Call", Contact);
                startActivity(intent);
            }
        });

    }

}