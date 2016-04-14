package com.yjm.activity;

import android.app.Activity;
import android.os.Bundle;

import com.yjm.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lzy on 2016/3/22.
 */
public class SplashActivity extends Activity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                MainActivity.startActivity(SplashActivity.this);
                finish();
            }
        }, 2000l);
    }

    @Override
    public void onBackPressed() {
        timer.cancel();
        super.onBackPressed();
    }
}
