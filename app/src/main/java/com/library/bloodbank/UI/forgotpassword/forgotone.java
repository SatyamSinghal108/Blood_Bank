package com.library.bloodbank.UI.forgotpassword;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.library.bloodbank.MainActivity;
import com.library.bloodbank.R;
import com.library.bloodbank.Utility.ConnectionStatus;
import com.library.bloodbank.Utility.StoreManager;
import com.library.bloodbank.Utility.TransparentDialog;

public class forgotone extends AppCompatActivity {

    Intent intent;
    ConnectionStatus connectionStatus;
    private Boolean isInternetPresent;
    private TransparentDialog pd;
    private Handler h;
    private Runnable r;
    StoreManager storeManager;
    EditText fmail;
    Button otp;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotone);

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

        fmail = (EditText) findViewById(R.id.femail);
        otp = (Button) findViewById(R.id.OTP);

        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInternetPresent) {
                    if (fmail.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Empty Feild Found!", Toast.LENGTH_SHORT).show();
                    } else {

                        intent = new Intent(forgotone.this, forgetotp.class);
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