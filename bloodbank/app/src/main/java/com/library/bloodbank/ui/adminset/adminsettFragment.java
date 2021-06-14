package com.library.bloodbank.ui.adminset;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.library.bloodbank.R;
import com.library.bloodbank.ui.AccFragment;
import com.library.bloodbank.ui.AdminFragment;
import com.library.bloodbank.ui.PrivacyFragment;
import com.library.bloodbank.ui.about.AboutFragment;
import com.library.bloodbank.ui.termsFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link adminsettFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class adminsettFragment extends Fragment {


    public adminsettFragment() {
        // Required empty public constructor
    }

    public static adminsettFragment newInstance(String param1, String param2) {
        adminsettFragment fragment = new adminsettFragment();
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

        View view=inflater.inflate(R.layout.fragment_adminsett, container, false);

        Button acc=(Button)view.findViewById(R.id.abtn1);
        Switch sw=view.findViewById(R.id.swwitch);
        Button privacy=(Button)view.findViewById(R.id.abtn3);
        Button terms=(Button)view.findViewById(R.id.abtn4);
        Button help=(Button)view.findViewById(R.id.abtn5);

        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frames, new AdminFragment()).commit();

            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frames, new PrivacyFragment()).commit();

            }
        });

        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frames, new termsFragment()).commit();

            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frames, new AboutFragment()).commit();
            }
        });

        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw.isChecked()){
                    Toast.makeText(getContext(),"Notifications On",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"Notifications Off",Toast.LENGTH_LONG).show();

                }
            }
        });

        return view;
        // Inflate the layout for this fragment
    }
}