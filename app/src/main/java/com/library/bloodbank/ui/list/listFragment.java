package com.library.bloodbank.ui.list;

import android.os.Bundle;

import android.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.library.bloodbank.R;
import com.library.bloodbank.model.MyAdadpter;
import com.library.bloodbank.model.Pojo;

import java.util.ArrayList;
import java.util.List;


public class listFragment extends Fragment  {

    ListView listView;
    SearchView searchView;
    MyAdadpter adapter;

    List<Pojo> list;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    public listFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        searchView = (SearchView)rootView.findViewById(R.id.search);
        listView = rootView.findViewById(R.id.list_item);


        list= new ArrayList<>();
        list.add(new Pojo("Moolchand Medcity ","NH-2, Agra","+91-8123456789"));
        list.add(new Pojo("Dev Ortho-Spine Injury and Trauma Centre ","3 Kirpal Colony, Near Bhagwan Talkies Bhagwan Cinema, Agra - 282005","+91-9837352274"));
        list.add(new Pojo("Upadhyay Hospital and Metro Heart Institute ","Agra Cantonment , Near Shaheed Nagar Crossing , Agra - 282001","+91-9927970674"));
        list.add(new Pojo("Ram TEJ Hospital ","A-16/8c, Vibhav Nagar Road, Naulakha, Hospital Market Agra Cantt, Agra - 282001","0562 233 2357"));
        list.add(new Pojo("Rainbow Hospitals ","NH-2, Near Guru Ka Tal Gurudwara , Agra - 282007","+91-8191022444"));
        list.add(new Pojo("Rashmi Medicare Centre ","Kamla Nagar Kamla Nagar, Agra - 282004","0562 288 0634"));
        list.add(new Pojo("Dr. Kamlesh Tandon Multi Speciality Hospital ","4/48-B, Laipat Kunj Bagh Farzana, Agra - 282002","+91-9837053990"));
        list.add(new Pojo("Care Well Hospital (Trans Yamuna) ","A- 8, Firozabad Road, Rambagh Trans Yamuna, Agra - 282006","+91-9876457349"));
        list.add(new Pojo("Heritage Hospital ","Near Peoples Honda, Bye Pass Road Jawahar Nagar, Agra - 282005","+91-7865467869"));
        list.add(new Pojo("Vohra Hospital","Arjun Nagar Tiraha Agra Ho, Agra - 282001","+91-8234598234"));
        list.add(new Pojo("Welfare Hospital ","D-906 & 907 - Hig, Kalindi Vihar, Near Nari Niketan Ram Bagh, Agra - 282006","0562 234 3456"));
        list.add(new Pojo("Mahajan Hospital and Research Centre ","146, Jaipur House Shah Ganj, Agra - 282010","0562 245 6784"));
        list.add(new Pojo("Pareek Hospital and Research Centre ","4/10, Bagh Farzana Civil Line, Agra - 282002","+91-9415202079"));
        list.add(new Pojo("Pushpanjali Hospital & Research Centre ","Pushpanjali Palace, Delhi Gate , Agra - 282002","+8976543211"));
        list.add(new Pojo("Shanti Manglick Hospital ","Fatehabad Road, Near Mughal Hotel , Agra - 282001","+91-9845455609"));
        list.add(new Pojo("G G Medical Institute ","106/2 Sanjay Place, Agra - 282002","+91-8765454098"));
        list.add(new Pojo("Limt Hospital and Research Centre ","34, Bye Pass Road, Lawyers Colony Ganesh Nagar, Agra - 282005","+91-7878656502"));


        adapter = new MyAdadpter(getContext(),list);
        listView.setAdapter(adapter);


        return rootView;
        // Inflate the layout for this fragment

    }


}