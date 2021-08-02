package com.library.bloodbank.ui.homepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.navigation.NavigationView;
import com.library.bloodbank.MainActivity;
import com.library.bloodbank.R;
import com.library.bloodbank.model.MyAdadpter;
import com.library.bloodbank.model.MyAdapter;
import com.library.bloodbank.model.Pojo;
import com.library.bloodbank.model.Pojoone;
import com.library.bloodbank.ui.about.AboutFragment;
import com.library.bloodbank.ui.adminset.adminsettFragment;
import com.library.bloodbank.ui.donate.donateFragment;
import com.library.bloodbank.ui.findblood.BloodFragment;
import com.library.bloodbank.ui.list.listFragment;
import com.library.bloodbank.ui.settings.settingFragment;

import java.util.ArrayList;
import java.util.List;

public class adminhomepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FrameLayout frameLayout;
    Intent intent;
    ListView listView;
    SearchView searchView;
    MyAdapter adapter;
    List<Pojoone> listen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhomepage);

        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        frameLayout = (FrameLayout) findViewById(R.id.frames);
        searchView = (SearchView)findViewById(R.id.search);
        listView = (ListView) findViewById(R.id.lll);


        drawerLayout = findViewById(R.id.admindraw);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.nav_open, R.string.nav_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listshow();
        adapter = new MyAdapter(this,listen);
        listView.setAdapter(adapter);
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item){

        switch(item.getItemId()){
            case R.id.homes:
                intent = new Intent(adminhomepage.this,adminhomepage.class);
                startActivity(intent);
                finish();
                break;
            case R.id.finds:
                toolbar.setTitle("Find Blood Nearby");
                getSupportFragmentManager().beginTransaction().replace(R.id.frames,new BloodFragment()).commit();
                break;
            case R.id.donates:
                toolbar.setTitle("Donate Blood");
                getSupportFragmentManager().beginTransaction().replace(R.id.frames,new donateFragment()).commit();
                break;
            case R.id.hospitals:
                toolbar.setTitle("List Of Hospitals");
                getSupportFragmentManager().beginTransaction().replace(R.id.frames,new listFragment()).commit();
                break;
            case R.id.setting:
                toolbar.setTitle("Administrator Settings");
                getSupportFragmentManager().beginTransaction().replace(R.id.frames,new adminsettFragment()).commit();
                break;
            case R.id.abouts:
                toolbar.setTitle("About");
                getSupportFragmentManager().beginTransaction().replace(R.id.frames,new AboutFragment()).commit();
                break;
            case R.id.logouts:
                intent = new Intent(adminhomepage.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;

            default:

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }


    public  void listshow(){
        listen = new ArrayList<>();

        listen.add(new Pojoone(R.drawable.ic_blood,"Military Hospital"));
        listen.add(new Pojoone(R.drawable.ic_blood,"Samarpan Blood Bank"));
        listen.add(new Pojoone(R.drawable.ic_blood,"District Hospital Blood Bank"));
        listen.add(new Pojoone(R.drawable.ic_blood,"S.N. Medical College"));
        listen.add(new Pojoone(R.drawable.ic_blood,"Agra City Blood Bank"));
        listen.add(new Pojoone(R.drawable.ic_blood,"Goyal Jan Suvidha Charitable Blood Bank"));
        listen.add(new Pojoone(R.drawable.ic_blood,"Life Line Charitable Blood Bank"));
        listen.add(new Pojoone(R.drawable.ic_blood,"Sanjeevani Charitable Blood Bank"));
        listen.add(new Pojoone(R.drawable.ic_blood,"Lokhitam Blood Bank"));
        listen.add(new Pojoone(R.drawable.ic_blood,"Lions Agra Mahan Charitable Blood Bank (Suspande)"));
        listen.add(new Pojoone(R.drawable.ic_blood,"Pushpa Maa Samaj Charitable Blood Bank"));
    }
}