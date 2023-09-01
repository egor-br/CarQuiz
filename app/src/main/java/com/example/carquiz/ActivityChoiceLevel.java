package com.example.carquiz;

import android.accessibilityservice.GestureDescription;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.tv.AdRequest;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mobile.ads.banner.AdSize;
import com.yandex.mobile.ads.banner.BannerAdView;

public class ActivityChoiceLevel extends AppCompatActivity {

    private BannerAdView mBannerAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_level);


        // Создание экземпляра mAdView.
        mBannerAdView = (BannerAdView) findViewById(R.id.banner1);
        mBannerAdView.setAdUnitId("demo-banner-yandex");
        mBannerAdView.setAdSize(AdSize.stickySize(350));


        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button)findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //возравшение в главное меню
                try{
                    Intent intent = new Intent(ActivityChoiceLevel.this, MainActivity.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });


        //Переход на 1-ый уровень
        TextView  TextView1 = (TextView)findViewById(R.id.textView1);
        TextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 1) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level1.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 2-ый уровень
        TextView  TextView2 = (TextView)findViewById(R.id.textView2);
        TextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 2) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level2.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 3-ый уровень
        TextView  TextView3 = (TextView)findViewById(R.id.textView3);
        TextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 3) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level3.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

       ///Переход на 4-ый уровень
        TextView  TextView4 = (TextView)findViewById(R.id.textView4);
        TextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 4) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level4.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        ///Переход на 5-ый уровень
        TextView  TextView5 = (TextView)findViewById(R.id.textView5);
        TextView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 5) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level5.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        ///Переход на 6-ый уровень
        TextView  TextView6 = (TextView)findViewById(R.id.textView6);
        TextView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 6) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level6.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        ///Переход на 7-ый уровень
        TextView  TextView7 = (TextView)findViewById(R.id.textView7);
        TextView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 7) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level7.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 8-ый уровень
        TextView  TextView8 = (TextView)findViewById(R.id.textView8);
        TextView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 8) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level8.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });
        //Переход на 9-ый уровень
        TextView  TextView9 = (TextView)findViewById(R.id.textView9);
        TextView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 9) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level9.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });
        //Переход на 10-ый уровень
        TextView  TextView10 = (TextView)findViewById(R.id.textView10);
        TextView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 10) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level10.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });
        //Переход на 11-ый уровень
        TextView  TextView11 = (TextView)findViewById(R.id.textView11);
        TextView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 11) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level11.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });
        //Переход на 12-ый уровень
        TextView  TextView12 = (TextView)findViewById(R.id.textView12);
        TextView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 12) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level12.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 13-ый уровень
        TextView  TextView13 = (TextView)findViewById(R.id.textView13);
        TextView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 13) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level13.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 14-ый уровень
        TextView  TextView14 = (TextView)findViewById(R.id.textView14);
        TextView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 14) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level14.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });
        //Переход на 15-ый уровень
        TextView  TextView15 = (TextView)findViewById(R.id.textView15);
        TextView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 15) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level15.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 16-ый уровень
        TextView  TextView16 = (TextView)findViewById(R.id.textView16);
        TextView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 16) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level16.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 17-ый уровень
        TextView  TextView17 = (TextView)findViewById(R.id.textView17);
        TextView17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 17) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level17.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 18-ый уровень
        TextView  TextView18 = (TextView)findViewById(R.id.textView18);
        TextView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 18) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level18.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 19-ый уровень
        TextView  TextView19 = (TextView)findViewById(R.id.textView19);
        TextView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 19) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level19.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 20-ый уровень
        TextView  TextView20 = (TextView)findViewById(R.id.textView20);
        TextView20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 19) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level20.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 21-ый уровень
        TextView  TextView21 = (TextView)findViewById(R.id.textView21);
        TextView21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 21) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level21.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 22-ый уровень
        TextView  TextView22 = (TextView)findViewById(R.id.textView22);
        TextView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 22) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level22.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });


        //Переход на 23-ый уровень
        TextView  TextView23 = (TextView)findViewById(R.id.textView23);
        TextView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 23) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level23.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 24-ый уровень
        TextView  TextView24 = (TextView)findViewById(R.id.textView24);
        TextView24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 24) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level24.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 25-ый уровень
        TextView  TextView25 = (TextView)findViewById(R.id.textView25);
        TextView25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 25) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level25.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 26-ый уровень
        TextView  TextView26 = (TextView)findViewById(R.id.textView26);
        TextView26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 26) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level26.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 27-ый уровень
        TextView  TextView27 = (TextView)findViewById(R.id.textView27);
        TextView27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 27) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level27.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 28-ый уровень
        TextView  TextView28 = (TextView)findViewById(R.id.textView28);
        TextView28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 28) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level28.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 29-ый уровень
        TextView  TextView29 = (TextView)findViewById(R.id.textView29);
        TextView29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 29) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level29.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 30-ый уровень
        TextView  TextView30 = (TextView)findViewById(R.id.textView30);
        TextView30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 30) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level30.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 31-ый уровень
        TextView  TextView31 = (TextView)findViewById(R.id.textView31);
        TextView31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 31) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level31.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 32-ый уровень
        TextView  TextView32 = (TextView)findViewById(R.id.textView32);
        TextView32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 32) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level32.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 33-ый уровень
        TextView  TextView33 = (TextView)findViewById(R.id.textView33);
        TextView33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 33) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level33.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 34-ый уровень
        TextView  TextView34 = (TextView)findViewById(R.id.textView34);
        TextView34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 34) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level34.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 35-ый уровень
        TextView  TextView35 = (TextView)findViewById(R.id.textView35);
        TextView35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 35) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level35.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 36-ый уровень
        TextView  TextView36 = (TextView)findViewById(R.id.textView36);
        TextView36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 36) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level36.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 37-ый уровень
        TextView  TextView37 = (TextView)findViewById(R.id.textView37);
        TextView37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 37) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level37.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 38-ый уровень
        TextView  TextView38 = (TextView)findViewById(R.id.textView38);
        TextView38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 38) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level38.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 39-ый уровень
        TextView  TextView39 = (TextView)findViewById(R.id.textView39);
        TextView39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 39) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level39.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        //Переход на 40-ый уровень
        TextView  TextView40 = (TextView)findViewById(R.id.textView40);
        TextView40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(level >= 40) {
                        Intent intent = new Intent(ActivityChoiceLevel.this, Level40.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){

                }
            }
        });

        final int [] x = {
                R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
                R.id.textView6,
                R.id.textView7,
                R.id.textView8,
                R.id.textView9,
                R.id.textView10,
                R.id.textView11,
                R.id.textView12,
                R.id.textView13,
                R.id.textView14,
                R.id.textView15,
                R.id.textView16,
                R.id.textView17,
                R.id.textView18,
                R.id.textView19,
                R.id.textView20,
                R.id.textView21,
                R.id.textView22,
                R.id.textView23,
                R.id.textView24,
                R.id.textView25,
                R.id.textView26,
                R.id.textView27,
                R.id.textView28,
                R.id.textView29,
                R.id.textView30,
                R.id.textView31,
                R.id.textView32,
                R.id.textView33,
                R.id.textView34,
                R.id.textView35,
                R.id.textView36,
                R.id.textView37,
                R.id.textView38,
                R.id.textView39,
                R.id.textView40,
        };

        for(int i = 0; i < level; i++){
            TextView tv = findViewById(x[i]);
            tv.setText(""+(i+1));
        }
    }
    //системная кнопка назад
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(ActivityChoiceLevel.this, MainActivity.class);
            startActivity(intent); finish();
        }catch (Exception e){

        }
    }
}