package com.example.carquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Achievements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);

        final int level_1 = save.getInt("LevelAchiv", 0);

        Button button_start = (Button)findViewById(R.id.btn_bck);
        final int [] x = {
                R.id.imageView2,
                R.id.imageView3,
                R.id.imageView4,
                R.id.imageView5,
                R.id.imageView6,
                R.id.imageView7,
                R.id.imageView8,
                R.id.imageView9,
                R.id.imageView10,
                R.id.imageView11,
        };
        for(int i = 0; i < level_1; i++){
            ImageView im = findViewById(x[i]);
            im.setImageResource(R.drawable.btn_star_big_on);
        }

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Achievements.this, MainActivity.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });
    }
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(Achievements.this, MainActivity.class);
            startActivity(intent); finish();
        }catch (Exception e){

        }
    }
}