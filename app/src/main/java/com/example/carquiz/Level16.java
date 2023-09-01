package com.example.carquiz;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carquiz.ui.main.Array;

import java.util.Random;

public class Level16 extends AppCompatActivity {


    Dialog dialog;
    Dialog dialogEnd;

    public int numleft;//для верха
    public int win_qwest;//для определения где будет правльный ответ
    public int numright;//для низа

    public int count = 0;//счётчик

    public int[] num_test = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};;
    public int num_col_test = 0, col_true = 0, col_false = 0;

    Array array = new Array();
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //создаем переменную тексвью
        TextView text_level = findViewById(R.id.num_level);
        text_level.setText(R.string.level16);

        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        //код для скругления углов
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        //код для скругления углов
        img_right.setClipToOutline(true);


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Вызов диалогового окна
        dialog = new Dialog(this);//создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовое
        dialog.setContentView(R.layout.preview_dialog);//путь к диалоговому окну
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setCancelable(false);//окно ннельзя закрыть кнопкой назад

        //устанавливаем картинку в диалоговое окно
        ImageView prviewimg = (ImageView)dialog.findViewById(R.id.prewiewimg);
        prviewimg.setImageResource(R.drawable.lamba);
        TextView textpriew = (TextView)dialog.findViewById(R.id.description);
        textpriew.setText(R.string.level16_text);

        //кнопка которая закрывает диалоговая окно
        TextView btn_clos = (TextView)dialog.findViewById(R.id.btnclose);
        btn_clos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level16.this, ActivityChoiceLevel.class);
                    startActivity(intent); finish();//возврат к уровня
                }catch (Exception e){

                }
                dialog.dismiss();
            }
        });

        Button btn_contin = (Button)dialog.findViewById(R.id.btn_continue);
        btn_contin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();//показать даилогое окно

        //диалоговвое окно в конце уровня
        //Вызов диалогового окна
        dialogEnd = new Dialog(this);//создаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовое
        dialogEnd.setContentView(R.layout.preview_dialog_end);//путь к диалоговому окну
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);//окно ннельзя закрыть кнопкой назад
        TextView textEnd = (TextView)dialogEnd.findViewById(R.id.description_end);
        textEnd.setText(R.string.level16_text_end);
        //кнопка которая закрывает диалоговая окно
        TextView btn_clos_end = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btn_clos_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level16.this, ActivityChoiceLevel.class);
                    startActivity(intent); finish();//возврат к уровня
                }catch (Exception e){

                }
                dialog.dismiss();
            }
        });

        Button btn_contin_end = (Button)dialogEnd.findViewById(R.id.btn_continue);
        btn_contin_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level16.this, Level17.class);
                startActivity(intent); finish();
            }
        });



        Button button_back = (Button)findViewById(R.id.button_back_menu_level);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //возравшение в главное меню
                try{
                    Intent intent = new Intent(Level16.this, ActivityChoiceLevel.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });



        //подключаем анимацию
        final Animation animation = AnimationUtils.loadAnimation(Level16.this, R.anim.alpha);

        //массив для прогресса

        final int[] progress = {
                R.id.point1,
                R.id.point2,
                R.id.point3,
                R.id.point4,
                R.id.point5,
                R.id.point6,
                R.id.point7,
                R.id.point8,
                R.id.point9,
                R.id.point10
        };

        //выбор картинок для викторины
        win_qwest = random.nextInt(2);//генирируем случайное число
        if(win_qwest == 0) {
            numleft = random.nextInt(10);
            num_test[num_col_test] = numleft;
            num_col_test = num_col_test + 1;
            img_left.setImageResource(array.images_lamba[numleft]);
            numright = random.nextInt(26);
            img_right.setImageResource(array.images_anti_lamba[numright]);
        }else{
            numright = random.nextInt(10);
            num_test[num_col_test] = numright;
            num_col_test = num_col_test + 1;
            img_right.setImageResource(array.images_lamba[numright]);
            numleft = random.nextInt(26);
            img_left.setImageResource(array.images_anti_lamba[numleft]);
        }
        //обработка верхней картинки
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public  boolean onTouch(View v, MotionEvent event){
                //условия касания картинки
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //нажал картинку
                    img_right.setEnabled(false);//блокируем правильную картинку
                    if(win_qwest == 0){
                        col_true+=1;
                        img_left.setImageResource(R.drawable.ok);
                    }else{
                        col_false+=1;
                        img_left.setImageResource(R.drawable.crest);
                    }
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    //опустил картинку
                    if(win_qwest == 0){
                        if(count < 10){
                            count = count + 1;
                        }
                        //закрышиваем прогесс
                        for(int i = 0; i < 10; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.sryle_points);
                        }

                        for(int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_true);
                        }

                    }else{
                        if(count > 0){
                            count = count - 1;
                        }
                        //закрышиваем прогесс
                        for(int i = 0; i < 9; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.sryle_points);
                        }

                        for(int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_true);
                        }
                    }
                    if(count >= 10){//выход из уровня
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level",1);
                        if(level > 16){

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 17);
                            editor.commit();
                        }
                        final int true_col = save.getInt("Level16True",0);
                        if(true_col == 0) {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level16True", col_true);
                            SharedPreferences.Editor editor2 = save.edit();
                            editor2.putInt("Level16False", col_false);
                            editor.commit();
                            editor2.commit();
                        }else {
                            if (true_col > col_true){
                                SharedPreferences.Editor editor = save.edit();
                                editor.putInt("Level16True", col_true);
                                SharedPreferences.Editor editor2 = save.edit();
                                editor2.putInt("Level16False", col_false);
                                editor.commit();
                                editor2.commit();
                            }
                        }
                        final int level_1 = save.getInt("LevelAchiv", 0);
                        if(level_1 <1) {
                            Toast toast = Toast.makeText(Level16.this,"Открыто достижение знаток авто", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.TOP,0,0);

                            toast.show();
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("LevelAchiv", 1);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else{
                        //выбор картинок для викторины
                        win_qwest = random.nextInt(2);//генирируем случайное число
                        if(win_qwest == 0) {
                            numleft = random.nextInt(10);
                            while(true){
                                int flag = 0;
                                for(int i = 0; i < num_col_test; i++){
                                    if(numleft == num_test[i]){
                                        flag = 1;
                                    }
                                }
                                if(flag == 0){
                                    num_test[num_col_test] = numleft;
                                    num_col_test = num_col_test + 1;
                                    break;
                                }else{
                                    numleft = random.nextInt(10);
                                }
                            }
                            if(num_col_test >= 9){
                                for(int i = 0; i < num_col_test; i++){
                                    num_test[i] = -1;
                                }
                                num_col_test = 0;
                            }
                            img_left.setImageResource(array.images_lamba[numleft]);
                            img_left.startAnimation(animation);
                            numright = random.nextInt(26);
                            img_right.setImageResource(array.images_anti_lamba[numright]);
                            img_right.startAnimation(animation);
                        }else{
                            numright = random.nextInt(10);
                            while(true){
                                int flag = 0;
                                for(int i = 0; i < num_col_test; i++){
                                    if(numright == num_test[i]){
                                        flag = 1;
                                    }
                                }
                                if(flag == 0){
                                    num_test[num_col_test] = numright;
                                    num_col_test = num_col_test + 1;
                                    break;
                                }else{
                                    numright = random.nextInt(10);
                                }
                            }
                            if(num_col_test >= 9){
                                for(int i = 0; i < num_col_test; i++){
                                    num_test[i] = -1;
                                }
                                num_col_test = 0;
                            }
                            img_right.setImageResource(array.images_lamba[numright]);
                            img_right.startAnimation(animation);
                            numleft = random.nextInt(26);
                            img_left.setImageResource(array.images_anti_lamba[numleft]);
                            img_left.startAnimation(animation);
                        }
                        img_right.setEnabled(true);
                    }
                }
                return true;
            }
        });


        //нижняя кнопка
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public  boolean onTouch(View v, MotionEvent event){
                //условия касания картинки
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //нажал картинку
                    img_left.setEnabled(false);//блокируем правильную картинку
                    if(win_qwest == 1){
                        col_true+=1;
                        img_right.setImageResource(R.drawable.ok);
                    }else{
                        col_false+=1;
                        img_right.setImageResource(R.drawable.crest);
                    }
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    //опустил картинку
                    if(win_qwest == 1){
                        if(count < 10){
                            count = count + 1;
                        }
                        //закрышиваем прогесс
                        for(int i = 0; i < 10; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.sryle_points);
                        }

                        for(int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_true);
                        }

                    }else{
                        if(count > 0){
                            count = count - 1;
                        }
                        //закрышиваем прогесс
                        for(int i = 0; i < 9; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.sryle_points);
                        }

                        for(int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_true);
                        }
                    }
                    if(count >= 10){//выход из уровня
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level",1);
                        if(level > 16){

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 17);
                            editor.commit();
                        }
                        final int true_col = save.getInt("Level16True",0);
                        if(true_col == 0) {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level16True", col_true);
                            SharedPreferences.Editor editor2 = save.edit();
                            editor2.putInt("Level16False", col_false);
                            editor.commit();
                            editor2.commit();
                        }else {
                            if (true_col > col_true){
                                SharedPreferences.Editor editor = save.edit();
                                editor.putInt("Level16True", col_true);
                                SharedPreferences.Editor editor2 = save.edit();
                                editor2.putInt("Level16False", col_false);
                                editor.commit();
                                editor2.commit();
                            }
                        }
                        final int level_1 = save.getInt("LevelAchiv", 0);
                        if(level_1 <1) {
                            Toast toast = Toast.makeText(Level16.this,"Открыто достижение знаток авто", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.TOP,0,0);
                            toast.show();
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("LevelAchiv", 1);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else{
                        //выбор картинок для викторины
                        win_qwest = random.nextInt(2);//генирируем случайное число
                        if(win_qwest == 0) {
                            numleft = random.nextInt(10);
                            while(true){
                                int flag = 0;
                                for(int i = 0; i < num_col_test; i++){
                                    if(numleft == num_test[i]){
                                        flag = 1;
                                    }
                                }
                                if(flag == 0){
                                    num_test[num_col_test] = numleft;
                                    num_col_test = num_col_test + 1;
                                    break;
                                }else{
                                    numleft = random.nextInt(10);
                                }
                            }
                            if(num_col_test >= 9){
                                for(int i = 0; i < num_col_test; i++){
                                    num_test[i] = -1;
                                }
                                num_col_test = 0;
                            }
                            img_left.setImageResource(array.images_lamba[numleft]);
                            img_left.startAnimation(animation);
                            numright = random.nextInt(26);
                            img_right.setImageResource(array.images_anti_lamba[numright]);
                            img_right.startAnimation(animation);
                        }else{
                            numright = random.nextInt(10);
                            while(true){
                                int flag = 0;
                                for(int i = 0; i < num_col_test; i++){
                                    if(numright == num_test[i]){
                                        flag = 1;
                                    }
                                }
                                if(flag == 0){
                                    num_test[num_col_test] = numright;
                                    num_col_test = num_col_test + 1;
                                    break;
                                }else{
                                    numright = random.nextInt(10);
                                }
                            }
                            if(num_col_test >= 9){
                                for(int i = 0; i < num_col_test; i++){
                                    num_test[i] = -1;
                                }
                                num_col_test = 0;
                            }
                            img_right.setImageResource(array.images_lamba[numright]);
                            img_right.startAnimation(animation);
                            numleft = random.nextInt(26);
                            img_left.setImageResource(array.images_anti_lamba[numleft]);
                            img_left.startAnimation(animation);
                        }
                        img_left.setEnabled(true);
                    }
                }
                return true;
            }
        });


    }

    //системная кнопка назад
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(Level16.this, ActivityChoiceLevel.class);
            startActivity(intent); finish();
        }catch (Exception e){

        }
    }

}