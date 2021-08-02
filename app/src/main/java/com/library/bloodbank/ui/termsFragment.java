package com.library.bloodbank.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.library.bloodbank.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link termsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class termsFragment extends Fragment {

    Button acept,decline;

    public termsFragment() {
        // Required empty public constructor
    }

    public static termsFragment newInstance(String param1, String param2) {
        termsFragment fragment = new termsFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_terms, container, false);
        // Inflate the layout for this fragment
        acept = view.findViewById(R.id.accept);
        decline = view.findViewById(R.id.dec);

        acept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Terms Accepted",Toast.LENGTH_LONG).show();
            }
        });


        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Terms Declined",Toast.LENGTH_LONG).show();
            }
        });

        return  view;
    }
}