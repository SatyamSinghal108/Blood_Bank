package com.library.bloodbank.UI.Login;

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
import android.widget.Toast;

import com.library.bloodbank.MainActivity;
import com.library.bloodbank.R;
import com.library.bloodbank.UI.Sign.Newadmin;
import com.library.bloodbank.UI.Sign.Newuser;
import com.library.bloodbank.UI.forgotpassword.forgotone;
import com.library.bloodbank.Utility.ConnectionStatus;
import com.library.bloodbank.Utility.StoreManager;
import com.library.bloodbank.Utility.TransparentDialog;
import com.library.bloodbank.ui.homepage.adminhomepage;

public class Adminlogin extends AppCompatActivity {

    Button btn;
    EditText email,pass;
    TextView frgt,sign;
    Intent intent;
    ConnectionStatus connectionStatus;
    private Boolean isInternetPresent;
    private TransparentDialog pd;
    private Handler h;
    private Runnable r;
    StoreManager storeManager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

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

        btn = (Button) findViewById(R.id.alogin);
        email = (EditText) findViewById(R.id.aemail);
        pass = (EditText) findViewById(R.id.apass);
        frgt = (TextView) findViewById(R.id.afrgtpass);
        sign = (TextView) findViewById(R.id.anwadmin);

        frgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInternetPresent) {
                    pd.show();
                    intent = new Intent(Adminlogin.this, forgotone.class);
                    startActivity(intent);

                }
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isInternetPresent) {
                    pd.show();
                    intent = new Intent(Adminlogin.this, Newadmin.class);
                    startActivity(intent);

                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInternetPresent) {
                    if (email.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Empty Feild Found!", Toast.LENGTH_SHORT).show();
                    } else {
                        intent = new Intent(Adminlogin.this, adminhomepage.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}