package com.armandroid.presupuesto.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.armandroid.presupuesto.R;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {

    @Override
    public void init(Bundle savedInstanceState) {

        addSlide(new AppIntroFragment().newInstance("TEST ONE","TEST ONE DESC", R.mipmap.ic_launcher, Color.BLUE));
        addSlide(new AppIntroFragment().newInstance("TEST TWO","TEST 2 DESC", R.mipmap.ic_launcher, Color.BLUE));
        addSlide(new AppIntroFragment().newInstance("TEST THREE","TEST 3 DESC", R.mipmap.ic_launcher, Color.BLUE));
        addSlide(new AppIntroFragment().newInstance("TEST FOURR","TEST 4 DESC", R.mipmap.ic_launcher, Color.BLUE));

    }

    @Override
    public void onSkipPressed() {
        startActivity(new Intent(IntroActivity.this,ConfigurationActivity.class));
        finish();
    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(IntroActivity.this,ConfigurationActivity.class));
        finish();
    }

    @Override
    public void onSlideChanged() {

    }
}
