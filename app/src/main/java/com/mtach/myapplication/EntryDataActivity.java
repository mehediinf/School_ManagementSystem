package com.mtach.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EntryDataActivity extends AppCompatActivity {

    private EditText edtName,edtEmail,edtPhoneNumber;
    private Button btnSave,btnDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data);

        edtName = findViewById(R.id.edt_Name);
        edtEmail = findViewById(R.id.edt_Email);
        edtPhoneNumber = findViewById(R.id.edt_Phone);
        btnSave = findViewById(R.id.btn_Save);
        btnDataList = findViewById(R.id.btn_ListViewPage);

        btnDataList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(EntryDataActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",-1);

        if (id!=-1){
            edtName.setText(intent.getStringExtra("name"));
            edtPhoneNumber.setText(intent.getStringExtra("phone"));
            edtEmail.setText(intent.getStringExtra("email"));
            btnSave.setText("Update");
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContactTable ct = new ContactTable(EntryDataActivity.this);
                String name = edtName.getText().toString();
                String phone = edtPhoneNumber.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();

                if (id==-1){
                    ct.InsertContact(new ContactModel(name,phone,email));
                    Toast.makeText(EntryDataActivity.this,"Contact Added!",Toast.LENGTH_SHORT).show();
                }

                else {

                    ContactModel cm = new ContactModel(name,phone,email);
                    cm.setId(id);
                    ct.UpdateContact(cm);
                    Toast.makeText(EntryDataActivity.this, "Contact Updated", Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });


    }
}