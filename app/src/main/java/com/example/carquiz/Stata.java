package com.example.carquiz;

import static com.example.carquiz.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Stata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_stata);

        Button button_start = (Button)findViewById(R.id.btn_bck);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);
        int k = 0;
        TextView tw = (TextView)findViewById(R.id.tw);
        tw.setText(tw.getText()+" "+(((level-1)*100)/40)+"%");


        final int[] level_1 = {
                save.getInt("Level1True", 0),
                save.getInt("Level2True", 0),
                save.getInt("Level3True", 0),
                save.getInt("Level4True", 0),
                save.getInt("Level5True", 0),
                save.getInt("Level6True", 0),
                save.getInt("Level7True", 0),
                save.getInt("Level8True", 0),
                save.getInt("Level9True", 0),
                save.getInt("Level10True", 0),
                save.getInt("Level11True", 0),
                save.getInt("Level12True", 0),
                save.getInt("Level13True", 0),
                save.getInt("Level14True", 0),
                save.getInt("Level15True", 0),
                save.getInt("Level16True", 0),
                save.getInt("Level17True", 0),
                save.getInt("Level18True", 0),
                save.getInt("Level19True", 0),
                save.getInt("Level20True", 0),
                save.getInt("Level21True", 0),
                save.getInt("Level22True", 0),
                save.getInt("Level23True", 0),
                save.getInt("Level24True", 0),
                save.getInt("Level25True", 0),
                save.getInt("Level26True", 0),
                save.getInt("Level27True", 0),
                save.getInt("Level28True", 0),
                save.getInt("Level29True", 0),
                save.getInt("Level30True", 0),
                save.getInt("Level31True", 0),
                save.getInt("Level32True", 0),
                save.getInt("Level33True", 0),
                save.getInt("Level34True", 0),
                save.getInt("Level35True", 0),
                save.getInt("Level36True", 0),
                save.getInt("Level37True", 0),
                save.getInt("Level38True", 0),
                save.getInt("Level39True", 0),
                save.getInt("Level40True", 0),
        };
        final int[] level_2 = {
                save.getInt("Level1False", 0),
                save.getInt("Level2False", 0),
                save.getInt("Level3False", 0),
                save.getInt("Level4False", 0),
                save.getInt("Level5False", 0),
                save.getInt("Level6False", 0),
                save.getInt("Level7False", 0),
                save.getInt("Level8False", 0),
                save.getInt("Level9False", 0),
                save.getInt("Level10False", 0),
                save.getInt("Level11False", 0),
                save.getInt("Level12False", 0),
                save.getInt("Level13False", 0),
                save.getInt("Level14False", 0),
                save.getInt("Level15False", 0),
                save.getInt("Level16False", 0),
                save.getInt("Level17False", 0),
                save.getInt("Level18False", 0),
                save.getInt("Level19False", 0),
                save.getInt("Level20False", 0),
                save.getInt("Level21False", 0),
                save.getInt("Level22False", 0),
                save.getInt("Level23False", 0),
                save.getInt("Level24False", 0),
                save.getInt("Level25False", 0),
                save.getInt("Level26False", 0),
                save.getInt("Level27False", 0),
                save.getInt("Level28False", 0),
                save.getInt("Level29False", 0),
                save.getInt("Level30False", 0),
                save.getInt("Level31False", 0),
                save.getInt("Level32False", 0),
                save.getInt("Level33False", 0),
                save.getInt("Level34False", 0),
                save.getInt("Level35False", 0),
                save.getInt("Level36False", 0),
                save.getInt("Level37False", 0),
                save.getInt("Level38False", 0),
                save.getInt("Level39False", 0),
                save.getInt("Level40False", 0),
        };

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Stata.this, MainActivity.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });

        final int [] x = {
                R.id.lv1,
                R.id.lv2,
                R.id.lv3,
                R.id.lv4,
                R.id.lv5,
                R.id.lv6,
                R.id.lv7,
                R.id.lv8,
                R.id.lv9,
                R.id.lv10,
                R.id.lv11,
                R.id.lv12,
                R.id.lv13,
                R.id.lv14,
                R.id.lv15,
                R.id.lv16,
                R.id.lv17,
                R.id.lv18,
                R.id.lv19,
                R.id.lv20,
                R.id.lv21,
                R.id.lv22,
                R.id.lv23,
                R.id.lv24,
                R.id.lv25,
                R.id.lv26,
                R.id.lv27,
                R.id.lv28,
                R.id.lv29,
                R.id.lv30,
                R.id.lv31,
                R.id.lv32,
                R.id.lv33,
                R.id.lv34,
                R.id.lv35,
                R.id.lv36,
                R.id.lv37,
                R.id.lv38,
                R.id.lv39,
                R.id.lv40,
        };

        final int [] y = {
                string.level1,
                string.level2,
                string.level3,
                string.level4,
                string.level5,
                string.level6,
                string.level7,
                string.level8,
                string.level9,
                string.level10,
                string.level11,
                string.level12,
                string.level13,
                string.level14,
                string.level15,
                string.level16,
                string.level17,
                string.level18,
                string.level19,
                string.level20,
                string.level21,
                string.level22,
                string.level23,
                string.level24,
                string.level25,
                string.level26,
                string.level27,
                string.level28,
                string.level29,
                string.level30,
                string.level31,
                string.level32,
                string.level33,
                string.level34,
                string.level35,
                string.level36,
                string.level37,
                string.level38,
                string.level39,
                string.level40,
        };

        for(int i = 0; i < 40; i++){
            if(i >= level-1) {
                TextView tv = findViewById(x[i]);
                tv.setText(tv.getText() + ": 0/0");
            }
        }

        for(int i = 0; i < level-1; i++){
            TextView tv = findViewById(x[i]);
            tv.setText( tv.getText() + ":    " +level_1[i] + "/" + level_2[i] );
        }

    }
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(Stata.this, MainActivity.class);
            startActivity(intent); finish();
        }catch (Exception e){

        }
    }
}