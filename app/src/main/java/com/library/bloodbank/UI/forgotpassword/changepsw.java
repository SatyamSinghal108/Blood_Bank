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
import android.widget.Toast;

import com.library.bloodbank.MainActivity;
import com.library.bloodbank.R;
import com.library.bloodbank.UI.Login.Adminlogin;
import com.library.bloodbank.UI.Sign.Newadmin;
import com.library.bloodbank.Utility.ConnectionStatus;
import com.library.bloodbank.Utility.StoreManager;
import com.library.bloodbank.Utility.TransparentDialog;
import com.library.bloodbank.ui.homepage.adminhomepage;

public class changepsw extends AppCompatActivity {

    Button btn;
    EditText pass,confpass;
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
        setContentView(R.layout.activity_changepsw);

        connectionStatus = new ConnectionStatus(getApplicationContext());
        isInternetPresent = connectionStatus.isConnectingToInternet();
        storeManager = new StoreManager(getApplicationContext());
        h = new Handler();
        pd = new TransparentDialog(this, R.drawable.loader);
        r = new Runnable() {
            @Override
            public void run() {
                if (pd.isShowing()) {
                    pd.dismiss();
                }
            }
        };

        btn = findViewById(R.id.Submit);
        pass=findViewById(R.id.pass);
        confpass=findViewById(R.id.confpass);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(Validation(pass.getText().toString(),confpass.getText().toString())){
                        if (isInternetPresent) {
                        pd.show();
                        intent = new Intent(changepsw.this, MainActivity.class);
                        startActivity(intent);}


                }
            }
        });

    }

    public Boolean Validation(String pas,String cpas){

        if(pas.isEmpty()){
            pass.setError("Enter Password");
            pass.requestFocus();
            return false;
        }
        else if(cpas.isEmpty()){
            confpass.setError("Enter Confirm Password");
            confpass.requestFocus();
            return false;
        }
        else if(!pas.equals(cpas)){
            confpass.setError("Password and Confirm Password are not same");
            confpass.requestFocus();
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
            startActivity(new Intent(this, forgotone.class));
            finish();
        }


}