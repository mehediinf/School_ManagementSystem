package com.mtach.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<ContactModel> allContacts;
    Context mContaxt;

    public CustomAdapter(ArrayList<ContactModel> allContacts, Context mContaxt) {
        this.allContacts = allContacts;
        this.mContaxt = mContaxt;
    }


    @Override
    public int getCount() {
        return allContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return allContacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null){
            view= LayoutInflater.from(mContaxt).inflate(R.layout.item_view,viewGroup,false);
        }

        ContactModel cm = allContacts.get(i);

        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtPhone = view.findViewById(R.id.txtPhone);
        TextView txtEmail = view.findViewById(R.id.txtEmail);
        Button btnUpdate = view.findViewById(R.id.btnUpdate);
        Button btnDelete = view.findViewById(R.id.btnDelete);

        txtName.setText(cm.getName());
        txtPhone.setText(cm.getPhone());
        txtEmail.setText(cm.getEmail());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContaxt, EntryDataActivity.class);
                intent.putExtra("id",cm.getId());
                intent.putExtra("name",cm.getName());
                intent.putExtra("phone",cm.getPhone());
                intent.putExtra("email",cm.getEmail());

                mContaxt.startActivity(intent);


            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContactTable ct = new ContactTable(mContaxt);
                ct.DeleteContact(cm.getId());
                allContacts.remove(i);
                notifyDataSetChanged();

                Toast.makeText(mContaxt,"Contact Delete",Toast.LENGTH_SHORT).show();


            }
        });

        return view;
    }
}
