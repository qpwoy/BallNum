package com.ljh2017.ballnum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    int com1,com2,com3;
    int ch1,ch2,ch3;

    int cnt=0;

    EditText num1, num2, num3;
    ImageView imgNum1, imgNum2, imgNum3;

    RecyclerView recyclerView;
    ArrayList<item> items = new ArrayList<>();
    GameAdapter gameAdapter;
    RecyclerView.LayoutManager manager;
    int s = 0;
    int b = 0;

    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        rndMager();

        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);
        num3 = (EditText)findViewById(R.id.num3);
        imgNum1 = (ImageView)findViewById(R.id.img_num1);
        imgNum2 = (ImageView)findViewById(R.id.img_num2);
        imgNum3 = (ImageView)findViewById(R.id.img_num3);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);

        gameAdapter = new GameAdapter(items,this);


        manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);

        num1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                num2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable edit) {
                if (edit.toString().length()==0) {
                    imgNum1.startAnimation(animation);
                    imgNum1.setImageResource(R.drawable.c_empty);
                }
                if (edit.toString().length()==1) {
                    for(int i = 0; i<10;i++) {
                        if(Integer.parseInt(edit.toString()) == i ) {
                            imgNum1.startAnimation(animation);
                            imgNum1.setImageResource(R.drawable.c0+i);
                        }
                    }
                }
            }
        });
        num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                num3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable edit) {
                if (edit.toString().length()==0) {
                    imgNum2.startAnimation(animation);
                    imgNum2.setImageResource(R.drawable.c_empty);
                }
                if (edit.toString().length()==1) {
                    for(int i = 0; i<10;i++) {
                        if(Integer.parseInt(edit.toString()) == i ) {
                            imgNum2.startAnimation(animation);
                            imgNum2.setImageResource(R.drawable.c0+i);
                        }
                    }
                }
            }
        });
        num3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable edit) {
                if (edit.toString().length()==0) {
                    imgNum3.startAnimation(animation);
                    imgNum3.setImageResource(R.drawable.c_empty);
                }
                if (edit.toString().length()==1) {
                    for(int i = 0; i<10;i++) {
                        if(Integer.parseInt(edit.toString()) == i ) {
                            imgNum3.startAnimation(animation);
                            imgNum3.setImageResource(R.drawable.c0+i);
                        }
                    }
                }
            }
        });

        animation = new AlphaAnimation(0,1);
        animation.setDuration(500);

    }

    public void clickCheck(View v) {

        try {

            ch1 = Integer.parseInt(num1.getText().toString());
            ch2 = Integer.parseInt(num2.getText().toString());
            ch3 = Integer.parseInt(num3.getText().toString());

            if (ch1 == com1) {
                s++;
            }
            if (ch1 == com2 || ch1 == com3) {
                b++;
            }
            if (ch2 == com2) {
                s++;
            }
            if (ch2 == com1 || ch2 == com3) {
                b++;
            }
            if (ch3 == com3) {
                s++;
            }
            if (ch3 == com2 || ch3 == com1) {
                b++;
            }
            String sT = s+"";
            String bT = b+"";

            cnt++;
            String cntT = cnt+"";

            items.add(new item(cntT, ch1, ch2, ch3, sT , bT));
            recyclerView.setAdapter(gameAdapter);

            if(s==3) {
                Intent intent = new Intent(this, SuccessActivity.class);
                startActivity(intent);
                finish();
            }
            if(cnt == 10) {
                Intent intent = new Intent(this,FailActivity.class);
                startActivity(intent);
                finish();
            }

            //Toast.makeText(this, ch1+""+ch2+""+ch3+""+ s +""+b, Toast.LENGTH_SHORT).show();

            num1.setText("");
            num2.setText("");
            num3.setText("");

            num1.requestFocus();

            s = 0;
            b = 0;

        }catch (Exception e){
            Toast.makeText(this, "숫자를 잘못입력했습니다.", Toast.LENGTH_SHORT).show();

        }
    }

    void rndMager() {
        Random rnd = new Random();

        com1 = rnd.nextInt(10);
        com2 = rnd.nextInt(10);
        com3 = rnd.nextInt(10);

        while (true) {
            if ( com1 != com2 && com2 != com3 && com1 != com3 ) {
                Log.e("랜덤",com1+" "+com2+" "+com3);
                break;
            }
            else {
                com1 = rnd.nextInt(10);
                com2 = rnd.nextInt(10);
                com3 = rnd.nextInt(10);
            }
        }

    }
}
