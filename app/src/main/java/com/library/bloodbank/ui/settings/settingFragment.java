package com.library.bloodbank.ui.settings;

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
import com.library.bloodbank.ui.PrivacyFragment;
import com.library.bloodbank.ui.about.AboutFragment;
import com.library.bloodbank.ui.termsFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link settingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class settingFragment extends Fragment {


    public settingFragment() {
        // Required empty public constructor
    }


    public static settingFragment newInstance(String param1, String param2) {
        settingFragment fragment = new settingFragment();
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
        View view=inflater.inflate(R.layout.fragment_setting, container, false);

        Button acc=(Button)view.findViewById(R.id.btn1);
        Switch s=view.findViewById(R.id.sswitch);
        Button privacy=(Button)view.findViewById(R.id.btn3);
        Button terms=(Button)view.findViewById(R.id.btn4);
        Button help=(Button)view.findViewById(R.id.btn5);

        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frames, new AccFragment()).commit();

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

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s.isChecked()){
                    Toast.makeText(getContext(),"Notifications On",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"Notifications Off",Toast.LENGTH_LONG).show();

                }
            }
        });

        return view;
    }
}