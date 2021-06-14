package com.library.bloodbank.model;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.library.bloodbank.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context context;
    List<Pojoone> listPojos;

    public MyAdapter(Context context, List<Pojoone> listPojos) {
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

        view = LayoutInflater.from(context).inflate(R.layout.bankview, parent, false);

        ImageView image = view.findViewById(R.id.imge);
        TextView title = view.findViewById(R.id.main);

        image.setImageResource(listPojos.get(position).getImage());
        title.setText(listPojos.get(position).getTitle());



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Position " + position, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
