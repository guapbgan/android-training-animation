package com.example.demo5_animaiton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(v->doAnimation1());

        findViewById(R.id.button3).setOnClickListener(view -> doAnimation2());
        findViewById(R.id.button4).setOnClickListener(view -> doAnimation3());


    }

    private void doAnimation3() {
        Animation anim3 = AnimationUtils.loadAnimation(this, R.anim.animation2);
        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.startAnimation(anim3);
    }

    private void doAnimation2() {
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.animation2);
        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.startAnimation(anim2);
    }

    private static final String TAG = "ANIMATION";
    private void doAnimation1() {
        Animation anim1 = AnimationUtils.loadAnimation(this,R.anim.animation1);
        ImageView imageView = findViewById(R.id.imageView);
        Log.v(TAG, "before start animation");
        imageView.startAnimation(anim1); //非同步，不會等動畫結束，會先直接往下
        //此特性可以讓程式先往下LOAD，動畫持續播放讓使用者不會有程式是否崩潰的疑慮
        Log.v(TAG, "animation return");
        imageView.setVisibility(View.INVISIBLE);
        Log.v(TAG, "set visibility to invisible");
    }
}