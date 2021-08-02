package com.library.bloodbank.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.library.bloodbank.R;

import java.util.List;

public class MyAdadpter extends BaseAdapter {

    Context context;
    List<Pojo> listPojos;

    public MyAdadpter(Context context, List<Pojo> listPojos) {
        this.context = context;
        this.listPojos = listPojos;
    }

    @Override
    public int getCount() {
        return listPojos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = LayoutInflater.from(context).inflate(R.layout.hospitallistview, parent, false);


        TextView title = view.findViewById(R.id.head);
        TextView description = view.findViewById(R.id.address);
        TextView number = view.findViewById(R.id.number);


        title.setText(listPojos.get(position).getTitle());
        description.setText(listPojos.get(position).getDescription());
        number.setText(listPojos.get(position).getNumber());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Position " + position, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}