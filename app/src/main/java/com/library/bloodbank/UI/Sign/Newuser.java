package com.library.bloodbank.UI.Sign;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.library.bloodbank.R;
import com.library.bloodbank.UI.Login.Adminlogin;
import com.library.bloodbank.UI.Login.Userlogin;
import com.library.bloodbank.Utility.ConnectionStatus;
import com.library.bloodbank.Utility.StoreManager;
import com.library.bloodbank.Utility.TransparentDialog;
import com.library.bloodbank.ui.homepage.userhomepage;

public class Newuser extends AppCompatActivity {

    Intent intent;
    ConnectionStatus connectionStatus;
    private Boolean isInternetPresent;
    private TransparentDialog pd;
    private Handler h;
    private Runnable r;
    StoreManager storeManager;
    EditText et1,et2,et3,et4;
    Button sign;
    TextView login;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);

        connectionStatus =new ConnectionStatus(getApplicationContext());
        isInternetPresent =connectionStatus.isConnectingToInternet();
        storeManager = new StoreManager(getApplicationContext());
        h = new Handler();
        pd = new TransparentDialog(this, R.drawable.loader);
        r =new Runnable() {
            @Override
            public void run() {
                if (pd.isShowing()) {
                    pd.dismiss();
                }
            }
        };

        sign = (Button) findViewById(R.id.sign);
        et1 = (EditText) findViewById(R.id.name);
        et2 = (EditText) findViewById(R.id.email);
        et3 = (EditText) findViewById(R.id.pass);
        et4 = (EditText) findViewById(R.id.confpass);
        login = (TextView) findViewById(R.id.nwuser);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInternetPresent){
                    intent = new Intent(Newuser.this, Userlogin.class);
                    startActivity(intent);
                    pd.show();
                }
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Validation(et1.getText().toString(),et2.getText().toString(),
                        et3.getText().toString().trim(),et4.getText().toString().trim())){
                    if(isInternetPresent) {
                        pd.show();
                        intent = new Intent(Newuser.this, userhomepage.class);
                        startActivity(intent);
                       finish();
                    }
                }
            }
        });
    }


    public Boolean Validation(String finame,String semail,String pass,String cpass){
        if(finame.isEmpty()){
            et1.setError("Enter Full Name");
            et1.requestFocus();
            return false;
        }

        else if(semail.isEmpty()){
            et2.setError("Enter Email");
            et2.requestFocus();
            return false;
        }
        else if(!semail.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")){
            et2.setError("Enter Valid Email");
            et2.requestFocus();
            return false;
        }

        else if(pass.isEmpty()){
            et3.setError("Enter Password");
            et3.requestFocus();
            return false;
        }
        else if(cpass.isEmpty()){
            et4.setError("Enter Confirm Password");
            et4.requestFocus();
            return false;
        }
        else if(!pass.equals(cpass)){
            et4.setError("Password and Confirm Password are not same");
            et4.requestFocus();
            return false;
        }
        else {
            return true;
        }
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    public void onBackPressed() {
        startActivity(new Intent(this, Userlogin.class));
        finish();
    }
}