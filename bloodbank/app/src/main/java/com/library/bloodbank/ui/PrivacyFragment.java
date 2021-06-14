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
 * Use the {@link PrivacyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrivacyFragment extends Fragment {

    Button btn;

    public PrivacyFragment() {
        // Required empty public constructor
    }


    public static PrivacyFragment newInstance(String param1, String param2) {
        PrivacyFragment fragment = new PrivacyFragment();
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

        View view = inflater.inflate(R.layout.fragment_privacy, container, false);
        // Inflate the layout for this fragment

        btn = view.findViewById(R.id.policy);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Policies Accepted",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}