package com.example.vpet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton pet;
    private ProgressBar pgsBar;
    private double i = 0;
    private Handler hdlr = new Handler();
    private int weight_d=0;
    private int height_d=20;
    private int bmi= weight_d/(height_d*height_d);
    String[] conver = new String[]{"HI", "WOW", "Hello", "OK"};

    @SuppressLint({"WrongViewCast", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pet = (ImageButton) findViewById(R.id.pet);
        Button txt = (Button) findViewById(R.id.conversation);
        Button feed = (Button) findViewById(R.id.Feed);
        pgsBar = (ProgressBar) findViewById(R.id.progressBar);
        TextView weight=(TextView) findViewById(R.id.weight);
        TextView BMI=(TextView) findViewById(R.id.bmi);
        TextView height=(TextView) findViewById(R.id.height);
        TextView hunger=(TextView) findViewById(R.id.hunger);
        weight.setText("Weight ：" + weight_d);
        height.setText("Height ：" + height_d);
        BMI.setText("BMI : "+ bmi);

        i = pgsBar.getProgress();
        new Thread(new Runnable() {
            public void run() {
                while (i < 100) {
                    i = (i + 0.3);
                    hdlr.post(new Runnable() {
                        public void run() {
                            pgsBar.setProgress((int) i);
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.pet) {
            Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
            pet.startAnimation(shake);
            Button txt = (Button) findViewById(R.id.conversation);
            txt.setVisibility(View.VISIBLE);
            Random r = new Random();
            int index = r.nextInt(conver.length);
            txt.setText(conver[index]);
        }
        if(v.getId() == R.id.conversation) {
            Button txt = (Button) findViewById(R.id.conversation);
            txt.setVisibility(View.INVISIBLE);
        }
        if(v.getId() == R.id.edit) {
            Intent open = new Intent (MainActivity.this, EditValues.class);
            startActivity(open);
        }
    }
}