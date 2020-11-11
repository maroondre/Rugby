package com.rugby.Classes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import com.example.rugby.R;
import com.kaiguanjs.SplashLietener;
import com.kaiguanjs.utils.YQCUtils;
import com.rugby.Connections.Calling;

public class Splash extends Activity {

    Handler handler;
    Calling calls;
    CountDownTimer cdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        calls = new Calling(this);

        YQCUtils.splashAction(this, new SplashLietener() {
            @Override
            public void startMySplash(int version, String downUrl) {
                calls.loadBet();
                calls.loadTeam();
                // calls.loadNews();
                //calls.loadStandings();
                //calls.loadSchedules();
                //calls.clearData();
                // calls.loadPlayers();

                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(Splash.this, News.class);
                        startActivity(intent);
                        finish();
                    }
                },10000);
            }
        });
    }

    public void timer(){

    }

    public void loop(){
        timer();
    }
}
