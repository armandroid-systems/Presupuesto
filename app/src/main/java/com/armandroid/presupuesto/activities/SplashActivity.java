package com.armandroid.presupuesto.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.model.CatWrapper;
import com.armandroid.presupuesto.model.Users;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.UtilFunctions;

import java.util.List;

public class SplashActivity extends BaseActivity {
    private final static String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        List mUsers = ((CatWrapper)this.getApplication()).arrayUsers;


        if(!mUsers.isEmpty()){
            Log.d(TAG, "PARAM NOT NULL...");
            startActivity(new Intent(SplashActivity.this,
                    MainActivity.class).putExtra(Constants.KEY_ACTIVITY_PARAM,
                    (Users)mUsers.get(0)));
            finish();
        }else{
            Log.d(TAG,"PARAM NULL...");
            startActivity(new Intent(SplashActivity.this,IntroActivity.class));
            finish();
        }
    }


}
