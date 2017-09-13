package com.ljh2017.ballnum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class FailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fail);
    }
    public void clickRe(View v) {
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
        finish();

    }

    public void clickFin(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
