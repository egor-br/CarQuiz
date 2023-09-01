package com.example.carquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast BackToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_start = (Button)findViewById(R.id.Start_game_btn);
        ImageButton btn_stat = (ImageButton)findViewById(R.id.imageButton);
        ImageButton btn_achievements = (ImageButton)findViewById(R.id.imageButton3);

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(MainActivity.this, ActivityChoiceLevel.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        btn_stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(MainActivity.this, Stata.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        btn_achievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(MainActivity.this, Achievements.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

   //закрытие приложения при помощи командных кнопок/жестов
    @Override
    public void onBackPressed() {


        if(backPressedTime + 1500 > System.currentTimeMillis()){
            BackToast.cancel();
            super.onBackPressed();
            return;
        }else{
            BackToast = Toast.makeText(getBaseContext(), "Нажмите ещё раз, чтобы выйти", Toast.LENGTH_SHORT);
            BackToast.show();
        }
        backPressedTime = System.currentTimeMillis();

    }
}