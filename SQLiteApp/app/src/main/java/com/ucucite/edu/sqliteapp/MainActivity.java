package com.ucucite.edu.sqliteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, contact, idnum, address;
    Button btnAdd, btnUpdate, btnDelete, btnView;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        contact=findViewById(R.id.contact);
        idnum=findViewById(R.id.idnum);
        address=findViewById(R.id.address);

        btnAdd=findViewById(R.id.btnAdd);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        btnView=findViewById(R.id.btnView);

        DB = new DBHelper (this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String idnumTXT = idnum.getText().toString();
                String addTXT = address.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, contactTXT, idnumTXT, addTXT);
                if (checkinsertdata==true)
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String idnumTXT = idnum.getText().toString();
                String addTXT = address.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, contactTXT, idnumTXT, addTXT);
                if (checkupdatedata==true)
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                Boolean checkdeletedata = DB.deletedata(nameTXT);
                if (checkdeletedata==true)
                    Toast.makeText(MainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Entry Failed to Delete", Toast.LENGTH_SHORT).show();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getdata();
                if (res.getCount()==0){
                    Toast.makeText(MainActivity.this, "No Entry", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Name: " +res.getString(0)+"\n");
                    buffer.append("Contact: " +res.getString(1)+"\n");
                    buffer.append("ID Number: " +res.getString(2)+"\n");
                    buffer.append("Address: " +res.getString(3)+"\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}