package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity implements View.OnClickListener {

    Button btnStart, btnStop;
    ImageView icanchor;
    Animation roundingAlone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        init();

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    private void init()
    {
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        icanchor = findViewById(R.id.ivCircle);

        // animation
        roundingAlone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        //create optional animation
        btnStop.setAlpha(0);

        // Import fonts
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        btnStart.setTypeface(MMedium);
    }

    @Override
    public void onClick(View v)
    {
        icanchor.startAnimation(roundingAlone);
        btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
        btnStart.animate().alpha(0).setDuration(300).start();

    }
}
