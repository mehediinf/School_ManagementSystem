package com.mtach.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    Button btn_DataInsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =findViewById(R.id.listViewId);
        btn_DataInsert =findViewById(R.id.btn_dataInsert);

        btn_DataInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, EntryDataActivity.class);
                startActivity(intent);

            }
        });

        loadContacts();

    }

    private void loadContacts() {
        ContactTable ct = new ContactTable(this);
        ArrayList<ContactModel> allContacts = ct.ReadContacts();
        listView.setAdapter(new CustomAdapter(allContacts, this));

    }

    protected void onResume() {
        super.onResume();
        loadContacts();
    }




}