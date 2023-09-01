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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carquiz.ui.main.Array;

import java.util.Random;

public class Level35 extends AppCompatActivity {


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
        setContentView(R.layout.universal_three);

        //создаем переменную тексвью
        TextView text_level = findViewById(R.id.num_level);
        text_level.setText(R.string.level35);

        final ImageView img_one = (ImageView)findViewById(R.id.img_one);
        //код для скругления углов
        img_one.setClipToOutline(true);

        final ImageView img_two = (ImageView)findViewById(R.id.img_two);
        //код для скругления углов
        img_two.setClipToOutline(true);

        final ImageView img_three = (ImageView)findViewById(R.id.img_three);
        //код для скругления углов
        img_three.setClipToOutline(true);

        final ImageView img_four = (ImageView)findViewById(R.id.img_four);
        //код для скругления углов
        img_four.setClipToOutline(true);


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
        prviewimg.setImageResource(R.drawable.yupon);
        TextView textpriew = (TextView)dialog.findViewById(R.id.description);
        textpriew.setText(R.string.level35_text);

        //кнопка которая закрывает диалоговая окно
        TextView btn_clos = (TextView)dialog.findViewById(R.id.btnclose);
        btn_clos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level35.this, ActivityChoiceLevel.class);
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
        textEnd.setText(R.string.level35_text_end);
        //кнопка которая закрывает диалоговая окно
        TextView btn_clos_end = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btn_clos_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level35.this, ActivityChoiceLevel.class);
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
                Intent intent = new Intent(Level35.this, Level36.class);
                startActivity(intent); finish();
            }
        });



        Button button_back = (Button)findViewById(R.id.button_back_menu_level);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //возравшение в главное меню
                try{
                    Intent intent = new Intent(Level35.this, ActivityChoiceLevel.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });



        //подключаем анимацию
        final Animation animation = AnimationUtils.loadAnimation(Level35.this, R.anim.alpha);

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
        win_qwest = random.nextInt(4);//генирируем случайное число
        switch (win_qwest){
            case 0:
                numleft = random.nextInt(10);
                img_one.setImageResource(array.img_yupon[numleft]);
                numleft = random.nextInt(10);
                img_two.setImageResource(array.img_franz[numleft]);
                numleft = random.nextInt(10);
                img_three.setImageResource(array.img_ital[numleft]);
                numleft = random.nextInt(10);
                img_four.setImageResource(array.img_germani[numleft]);
                break;
            case 1:
                numleft = random.nextInt(10);
                img_two.setImageResource(array.img_yupon[numleft]);
                numleft = random.nextInt(10);
                img_one.setImageResource(array.img_franz[numleft]);
                numleft = random.nextInt(10);
                img_three.setImageResource(array.img_ital[numleft]);
                numleft = random.nextInt(10);
                img_four.setImageResource(array.img_germani[numleft]);
                break;
            case 2:
                numleft = random.nextInt(10);
                img_three.setImageResource(array.img_yupon[numleft]);
                numleft = random.nextInt(10);
                img_one.setImageResource(array.img_franz[numleft]);
                numleft = random.nextInt(10);
                img_two.setImageResource(array.img_ital[numleft]);
                numleft = random.nextInt(10);
                img_four.setImageResource(array.img_germani[numleft]);
                break;
            case 3:
                numleft = random.nextInt(10);
                img_four.setImageResource(array.img_yupon[numleft]);
                numleft = random.nextInt(10);
                img_one.setImageResource(array.img_franz[numleft]);
                numleft = random.nextInt(10);
                img_two.setImageResource(array.img_ital[numleft]);
                numleft = random.nextInt(10);
                img_three.setImageResource(array.img_germani[numleft]);
                break;
        }

        //обработка 1-ой картинки
        img_one.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public  boolean onTouch(View v, MotionEvent event){
                //условия касания картинки
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //нажал картинку
                    img_two.setEnabled(false);//блокируем правильную картинку
                    img_three.setEnabled(false);//блокируем правильную картинку
                    img_four.setEnabled(false);//блокируем правильную картинку
                    if(win_qwest == 0){
                        col_true+=1;
                        img_one.setImageResource(R.drawable.ok);
                    }else{
                        col_false+=1;
                        img_one.setImageResource(R.drawable.crest);
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
                        if(level > 35){

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 36);
                            editor.commit();
                        }
                        final int true_col = save.getInt("Level35True",0);
                        if(true_col == 0) {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level35True", col_true);
                            SharedPreferences.Editor editor2 = save.edit();
                            editor2.putInt("Level35False", col_false);
                            editor.commit();
                            editor2.commit();
                        }else {
                            if (true_col > col_true){
                                SharedPreferences.Editor editor = save.edit();
                                editor.putInt("Level35True", col_true);
                                SharedPreferences.Editor editor2 = save.edit();
                                editor2.putInt("Level35False", col_false);
                                editor.commit();
                                editor2.commit();
                            }
                        }
                        final int level_1 = save.getInt("LevelAchiv", 0);
                        if(level_1 <5) {
                            Toast toast = Toast.makeText(Level35.this,"Открыто достижение знаток японских авто", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.TOP,0,0);
                            toast.show();
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("LevelAchiv", 5);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else {
                        //выбор картинок для викторины
                        win_qwest = random.nextInt(2);//генирируем случайное число
                        numleft = random.nextInt(10);
                        while (true) {
                            int flag = 0;
                            for (int i = 0; i < num_col_test; i++) {
                                if (numleft == num_test[i]) {
                                    flag = 1;
                                }
                            }
                            if (flag == 0) {
                                num_test[num_col_test] = numleft;
                                num_col_test = num_col_test + 1;
                                break;
                            } else {
                                numleft = random.nextInt(10);
                            }
                        }
                        if (num_col_test >= 9) {
                            for (int i = 0; i < num_col_test; i++) {
                                num_test[i] = -1;
                            }
                            num_col_test = 0;
                        }
                        switch (win_qwest){
                            case 0:
                                img_one.setImageResource(array.img_yupon[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_two.setImageResource(array.img_franz[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_three.setImageResource(array.img_ital[numleft]);
                                img_three.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_four.setImageResource(array.img_germani[numleft]);
                                img_four.startAnimation(animation);
                                break;
                            case 1:
                                img_two.setImageResource(array.img_yupon[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_one.setImageResource(array.img_franz[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_three.setImageResource(array.img_ital[numleft]);
                                img_three.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_four.setImageResource(array.img_germani[numleft]);
                                img_four.startAnimation(animation);
                                break;
                            case 2:
                                img_three.setImageResource(array.img_yupon[numleft]);
                                img_three.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_one.setImageResource(array.img_franz[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_two.setImageResource(array.img_ital[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_four.setImageResource(array.img_germani[numleft]);
                                img_four.startAnimation(animation);
                                break;
                            case 3:
                                img_four.setImageResource(array.img_yupon[numleft]);
                                img_four.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_one.setImageResource(array.img_franz[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_two.setImageResource(array.img_ital[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_three.setImageResource(array.img_germani[numleft]);
                                img_three.startAnimation(animation);
                                break;
                        }

                    }
                    img_two.setEnabled(true);
                    img_three.setEnabled(true);
                    img_four.setEnabled(true);
                }
                return true;
            }
        });

        //обработка 2-ой картинки
        img_two.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public  boolean onTouch(View v, MotionEvent event){
                //условия касания картинки
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //нажал картинку
                    img_one.setEnabled(false);//блокируем правильную картинку
                    img_three.setEnabled(false);//блокируем правильную картинку
                    img_four.setEnabled(false);//блокируем правильную картинку
                    if(win_qwest == 1){
                        col_true+=1;
                        img_two.setImageResource(R.drawable.ok);
                    }else{
                        col_false+=1;
                        img_two.setImageResource(R.drawable.crest);
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
                        if(level > 35){

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 36);
                            editor.commit();
                        }
                        final int true_col = save.getInt("Level35True",0);
                        if(true_col == 0) {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level35True", col_true);
                            SharedPreferences.Editor editor2 = save.edit();
                            editor2.putInt("Level35False", col_false);
                            editor.commit();
                            editor2.commit();
                        }else {
                            if (true_col > col_true){
                                SharedPreferences.Editor editor = save.edit();
                                editor.putInt("Level35True", col_true);
                                SharedPreferences.Editor editor2 = save.edit();
                                editor2.putInt("Level35False", col_false);
                                editor.commit();
                                editor2.commit();
                            }
                        }
                        final int level_1 = save.getInt("LevelAchiv", 0);
                        if(level_1 <5) {
                            Toast toast = Toast.makeText(Level35.this,"Открыто достижение знаток японских авто", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.TOP,0,0);
                            toast.show();
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("LevelAchiv", 5);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else {
                        //выбор картинок для викторины
                        win_qwest = random.nextInt(2);//генирируем случайное число
                        numleft = random.nextInt(10);
                        while (true) {
                            int flag = 0;
                            for (int i = 0; i < num_col_test; i++) {
                                if (numleft == num_test[i]) {
                                    flag = 1;
                                }
                            }
                            if (flag == 0) {
                                num_test[num_col_test] = numleft;
                                num_col_test = num_col_test + 1;
                                break;
                            } else {
                                numleft = random.nextInt(10);
                            }
                        }
                        if (num_col_test >= 9) {
                            for (int i = 0; i < num_col_test; i++) {
                                num_test[i] = -1;
                            }
                            num_col_test = 0;
                        }
                        switch (win_qwest){
                            case 0:
                                img_one.setImageResource(array.img_yupon[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_two.setImageResource(array.img_franz[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_three.setImageResource(array.img_ital[numleft]);
                                img_three.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_four.setImageResource(array.img_germani[numleft]);
                                img_four.startAnimation(animation);
                                break;
                            case 1:
                                img_two.setImageResource(array.img_yupon[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_one.setImageResource(array.img_franz[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_three.setImageResource(array.img_ital[numleft]);
                                img_three.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_four.setImageResource(array.img_germani[numleft]);
                                img_four.startAnimation(animation);
                                break;
                            case 2:
                                img_three.setImageResource(array.img_yupon[numleft]);
                                img_three.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_one.setImageResource(array.img_franz[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_two.setImageResource(array.img_ital[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_four.setImageResource(array.img_germani[numleft]);
                                img_four.startAnimation(animation);
                                break;
                            case 3:
                                img_four.setImageResource(array.img_yupon[numleft]);
                                img_four.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_one.setImageResource(array.img_franz[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_two.setImageResource(array.img_ital[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_three.setImageResource(array.img_germani[numleft]);
                                img_three.startAnimation(animation);
                                break;
                        }

                    }
                    img_one.setEnabled(true);
                    img_three.setEnabled(true);
                    img_four.setEnabled(true);
                }
                return true;
            }
        });

        //обработка 3-ой картинки
        img_three.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public  boolean onTouch(View v, MotionEvent event){
                //условия касания картинки
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //нажал картинку
                    img_one.setEnabled(false);//блокируем правильную картинку
                    img_two.setEnabled(false);//блокируем правильную картинку
                    img_four.setEnabled(false);//блокируем правильную картинку
                    if(win_qwest == 2){
                        col_true+=1;
                        img_three.setImageResource(R.drawable.ok);
                    }else{
                        col_false+=1;
                        img_three.setImageResource(R.drawable.crest);
                    }
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    //опустил картинку
                    if(win_qwest == 2){
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
                        if(level > 35){

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 36);
                            editor.commit();
                        }
                        final int true_col = save.getInt("Level35True",0);
                        if(true_col == 0) {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level35True", col_true);
                            SharedPreferences.Editor editor2 = save.edit();
                            editor2.putInt("Level35False", col_false);
                            editor.commit();
                            editor2.commit();
                        }else {
                            if (true_col > col_true){
                                SharedPreferences.Editor editor = save.edit();
                                editor.putInt("Level35True", col_true);
                                SharedPreferences.Editor editor2 = save.edit();
                                editor2.putInt("Level35False", col_false);
                                editor.commit();
                                editor2.commit();
                            }
                        }
                        final int level_1 = save.getInt("LevelAchiv", 0);
                        if(level_1 <5) {
                            Toast toast = Toast.makeText(Level35.this,"Открыто достижение знаток японских авто", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.TOP,0,0);
                            toast.show();
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("LevelAchiv", 5);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else {
                        //выбор картинок для викторины
                        win_qwest = random.nextInt(2);//генирируем случайное число
                        numleft = random.nextInt(10);
                        while (true) {
                            int flag = 0;
                            for (int i = 0; i < num_col_test; i++) {
                                if (numleft == num_test[i]) {
                                    flag = 1;
                                }
                            }
                            if (flag == 0) {
                                num_test[num_col_test] = numleft;
                                num_col_test = num_col_test + 1;
                                break;
                            } else {
                                numleft = random.nextInt(10);
                            }
                        }
                        if (num_col_test >= 9) {
                            for (int i = 0; i < num_col_test; i++) {
                                num_test[i] = -1;
                            }
                            num_col_test = 0;
                        }
                        switch (win_qwest){
                            case 0:
                                img_one.setImageResource(array.img_yupon[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_two.setImageResource(array.img_franz[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_three.setImageResource(array.img_ital[numleft]);
                                img_three.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_four.setImageResource(array.img_germani[numleft]);
                                img_four.startAnimation(animation);
                                break;
                            case 1:
                                img_two.setImageResource(array.img_yupon[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_one.setImageResource(array.img_franz[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_three.setImageResource(array.img_ital[numleft]);
                                img_three.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_four.setImageResource(array.img_germani[numleft]);
                                img_four.startAnimation(animation);
                                break;
                            case 2:
                                img_three.setImageResource(array.img_yupon[numleft]);
                                img_three.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_one.setImageResource(array.img_franz[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_two.setImageResource(array.img_ital[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_four.setImageResource(array.img_germani[numleft]);
                                img_four.startAnimation(animation);
                                break;
                            case 3:
                                img_four.setImageResource(array.img_yupon[numleft]);
                                img_four.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_one.setImageResource(array.img_franz[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_two.setImageResource(array.img_ital[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_three.setImageResource(array.img_germani[numleft]);
                                img_three.startAnimation(animation);
                                break;
                        }

                    }
                    img_one.setEnabled(true);
                    img_two.setEnabled(true);
                    img_four.setEnabled(true);
                }
                return true;
            }
        });

        //обработка 4-ой картинки
        img_four.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public  boolean onTouch(View v, MotionEvent event){
                //условия касания картинки
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //нажал картинку
                    img_one.setEnabled(false);//блокируем правильную картинку
                    img_three.setEnabled(false);//блокируем правильную картинку
                    img_two.setEnabled(false);//блокируем правильную картинку
                    if(win_qwest == 3){
                        col_true+=1;
                        img_four.setImageResource(R.drawable.ok);
                    }else{
                        col_false+=1;
                        img_four.setImageResource(R.drawable.crest);
                    }
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    //опустил картинку
                    if(win_qwest == 3){
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
                        if(level > 35){

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 36);
                            editor.commit();
                        }
                        final int true_col = save.getInt("Level35True",0);
                        if(true_col == 0) {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level35True", col_true);
                            SharedPreferences.Editor editor2 = save.edit();
                            editor2.putInt("Level35False", col_false);
                            editor.commit();
                            editor2.commit();
                        }else {
                            if (true_col > col_true){
                                SharedPreferences.Editor editor = save.edit();
                                editor.putInt("Level35True", col_true);
                                SharedPreferences.Editor editor2 = save.edit();
                                editor2.putInt("Level35False", col_false);
                                editor.commit();
                                editor2.commit();
                            }
                        }
                        final int level_1 = save.getInt("LevelAchiv", 0);
                        if(level_1 <5) {
                            Toast toast = Toast.makeText(Level35.this,"Открыто достижение знаток японских авто", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.TOP,0,0);
                            toast.show();
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("LevelAchiv", 5);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else {
                        //выбор картинок для викторины
                        win_qwest = random.nextInt(2);//генирируем случайное число
                        numleft = random.nextInt(10);
                        while (true) {
                            int flag = 0;
                            for (int i = 0; i < num_col_test; i++) {
                                if (numleft == num_test[i]) {
                                    flag = 1;
                                }
                            }
                            if (flag == 0) {
                                num_test[num_col_test] = numleft;
                                num_col_test = num_col_test + 1;
                                break;
                            } else {
                                numleft = random.nextInt(10);
                            }
                        }
                        if (num_col_test >= 9) {
                            for (int i = 0; i < num_col_test; i++) {
                                num_test[i] = -1;
                            }
                            num_col_test = 0;
                        }
                        switch (win_qwest){
                            case 0:
                                img_one.setImageResource(array.img_yupon[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_two.setImageResource(array.img_franz[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_three.setImageResource(array.img_ital[numleft]);
                                img_three.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_four.setImageResource(array.img_germani[numleft]);
                                img_four.startAnimation(animation);
                                break;
                            case 1:
                                img_two.setImageResource(array.img_yupon[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_one.setImageResource(array.img_franz[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_three.setImageResource(array.img_ital[numleft]);
                                img_three.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_four.setImageResource(array.img_germani[numleft]);
                                img_four.startAnimation(animation);
                                break;
                            case 2:
                                img_three.setImageResource(array.img_yupon[numleft]);
                                img_three.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_one.setImageResource(array.img_franz[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_two.setImageResource(array.img_ital[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_four.setImageResource(array.img_germani[numleft]);
                                img_four.startAnimation(animation);
                                break;
                            case 3:
                                img_four.setImageResource(array.img_yupon[numleft]);
                                img_four.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_one.setImageResource(array.img_franz[numleft]);
                                img_one.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_two.setImageResource(array.img_ital[numleft]);
                                img_two.startAnimation(animation);
                                numleft = random.nextInt(10);
                                img_three.setImageResource(array.img_germani[numleft]);
                                img_three.startAnimation(animation);
                                break;
                        }

                    }
                    img_one.setEnabled(true);
                    img_three.setEnabled(true);
                    img_two.setEnabled(true);
                }
                return true;
            }
        });



    }

    //системная кнопка назад
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(Level35.this, ActivityChoiceLevel.class);
            startActivity(intent); finish();
        }catch (Exception e){

        }
    }

}