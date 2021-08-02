package com.library.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.library.bloodbank.Utility.ConnectionStatus;

public class SplashScreen extends AppCompatActivity {

    Handler handler;
    private ConnectionStatus connectionStatus;
    private Boolean isInternetPresent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        connectionStatus =new ConnectionStatus(getApplicationContext());
        isInternetPresent =connectionStatus.isConnectingToInternet();


        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isInternetPresent){
                Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();}
                else{
                    Toast.makeText(getApplicationContext(),"No Internet",Toast.LENGTH_SHORT).show();
                }
            }
        },3000);
    }
}