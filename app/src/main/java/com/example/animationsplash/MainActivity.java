package com.example.animationsplash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
 LottieAnimationView anime;
 Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        anime=findViewById(R.id.animation);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anime.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);
                anime.playAnimation();
                Thread thread=new Thread(){
                    public void run(){
                        try {
                            sleep(1000);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        finally {
                            Intent intent=new Intent(MainActivity.this, CovidActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                };thread.start();
            }
        });
    }
}