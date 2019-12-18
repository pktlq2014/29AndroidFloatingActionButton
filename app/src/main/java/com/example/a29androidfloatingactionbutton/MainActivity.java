package com.example.a29androidfloatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity
{
    FloatingActionButton floatingActionButton, floatFB, floatSkype, floatGoogle;
    Animation moveLeft, moveTop, moveCenter;
    boolean i = false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.fab);
        floatFB = findViewById(R.id.fab_fb);
        floatGoogle = findViewById(R.id.fab_google);
        floatSkype = findViewById(R.id.fab_skype);

        moveLeft = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_trai);
        moveTop = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_tren);
        moveCenter = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_giua);
        floatingActionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Bạn Click Mở", Toast.LENGTH_SHORT).show();
                if(i == false)
                {
                    moveLeft();
                    moveTop();
                    moveCenter();
                    hienRa();
                    i = true;
                }
                else
                {
                    anDi();
                    i = false;
                }
            }
        });
        floatFB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Bạn Click Mở", Toast.LENGTH_SHORT).show();
            }
        });
        floatSkype.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Bạn Click Mở", Toast.LENGTH_SHORT).show();
            }
        });
        floatGoogle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Bạn Click Mở", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void moveLeft()
    {
        // dùng frame vì bên class fab_layout dùng frame để bao
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) floatFB.getLayoutParams();
        layoutParams.rightMargin = (int) (floatFB.getWidth() * 1.7);
        floatFB.setLayoutParams(layoutParams);
        floatFB.startAnimation(moveLeft);
    }
    private void moveTop()
    {
        // dùng frame vì bên class fab_layout dùng frame để bao
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) floatGoogle.getLayoutParams();
        layoutParams.bottomMargin = (int) (floatGoogle.getWidth() * 1.7);
        floatGoogle.setLayoutParams(layoutParams);
        floatGoogle.startAnimation(moveTop);
    }
    private void moveCenter()
    {
        // dùng frame vì bên class fab_layout dùng frame để bao
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) floatSkype.getLayoutParams();
        layoutParams.bottomMargin = (int) (floatSkype.getWidth() * 1.7);
        layoutParams.rightMargin = (int) (floatSkype.getWidth() * 1.7);
        floatSkype.setLayoutParams(layoutParams);
        floatSkype.startAnimation(moveCenter);
    }
    private void anDi()
    {
        floatSkype.hide();
        floatGoogle.hide();
        floatFB.hide();
    }
    private void hienRa()
    {
        floatFB.show();
        floatGoogle.show();
        floatSkype.show();
    }
}
