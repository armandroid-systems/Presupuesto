package com.armandroid.presupuesto.activities;

import android.os.Bundle;
import android.util.Log;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.fragments.FragmentConfiguration;
import com.armandroid.presupuesto.fragments.FragmentMenu;
import com.armandroid.presupuesto.model.Users;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.ScreenManager;

public class MainActivity extends BaseActivity {

    private final static String TAG = MainActivity.class.getSimpleName();
    //private Users dataRetrieved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.mainActivityWrapper) != null){
            if(savedInstanceState == null){
                //dataRetrieved = getIntent().getLongExtra(Constants.KEY_ACTIVITY_PARAM,0l);
                try {

                        ScreenManager.screenChange(MainActivity.this,
                                R.id.mainActivityWrapper,
                                FragmentMenu.class,
                                getIntent().getExtras(),
                                Constants.VIEW_MENU,
                                Constants.BIN_TRUE);

                } catch (IllegalAccessException e) {
                    Log.e(TAG,"ERR ["+e+"]");
                } catch (InstantiationException e) {
                    Log.e(TAG,"INS ERR ["+e+"]");
                }

            }
        }
    }
}
