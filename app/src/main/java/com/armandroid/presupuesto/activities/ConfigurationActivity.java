package com.armandroid.presupuesto.activities;

import android.os.Bundle;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.fragments.FragmentConfiguration;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.ScreenManager;

public class ConfigurationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        if(findViewById(R.id.configurationWrapper) != null){
            if(savedInstanceState == null){
                try {

                    ScreenManager.screenChange(ConfigurationActivity.this,
                            R.id.configurationWrapper,
                            FragmentConfiguration.class,
                            null,
                            Constants.VIEW_CONFIGURATION,
                            Constants.BIN_TRUE);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
