package com.library.bloodbank.Utility;

import android.content.Context;
import android.content.SharedPreferences;

public class StoreManager {

    private SharedPreferences.Editor editor;
    private Context _context;
    public SharedPreferences pref;
    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "opencart_Store";


    public StoreManager(Context _context) {
        this._context = _context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public void setLoginStatus(Boolean Islogin) {
        editor.putBoolean("LoginValue", Islogin);
        System.out.println("Login Status" + " " + Islogin);
        editor.commit();
    }

    public Boolean getLoginStatus() {
        return pref.getBoolean("LoginValue", false);
    }

    public void setLanguage(int language) {
        editor.putInt("language", language);
        editor.commit();
    }

    public int getLanguage() {
        return pref.getInt("language", 1);
    }

}
