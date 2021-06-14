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
import android.widget.TextView;

import com.library.bloodbank.MainActivity;
import com.library.bloodbank.R;
import com.library.bloodbank.Utility.ConnectionStatus;
import com.library.bloodbank.Utility.StoreManager;
import com.library.bloodbank.Utility.TransparentDialog;

public class forgetotp extends AppCompatActivity {

    Intent intent;
    ConnectionStatus connectionStatus;
    private Boolean isInternetPresent;
    private TransparentDialog pd;
    private Handler h;
    private Runnable r;
    StoreManager storeManager;
    EditText a,b,c,d,e,f;
    Button check;
    TextView time;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetotp);

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

        a = (EditText) findViewById(R.id.one);
        b = (EditText) findViewById(R.id.two);
        c = (EditText) findViewById(R.id.three);
        d = (EditText) findViewById(R.id.four);
        e = (EditText) findViewById(R.id.five);
        f = (EditText) findViewById(R.id.six);
        time = (TextView) findViewById(R.id.count);
        check = (Button) findViewById(R.id.verify);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInternetPresent) {
                    pd.show();
                    intent = new Intent(forgetotp.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        });

    }
}