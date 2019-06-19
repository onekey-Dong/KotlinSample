package com.onekey.kotlinsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.onekey.kotlinsample.entity.Book;
import com.onekey.kotlinsample.entity.InitOrderEntity;
import com.onekey.kotlinsample.entity.PrimaryStudent;
import com.onekey.kotlinsample.entity.Student;
import com.onekey.kotlinsample.tools.MathTool;
import com.onekey.kotlinsample.tools.Tlog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tlog.Companion.e(" >> " + MathTool.Companion.reduce(10, 8));

        //Student student = new PrimaryStudent("jack", 10);
        //student.eat("breakfast");
        //student.read(new Book("long long age"));


        new InitOrderEntity("Tony");
    }

    public void onBtnClick(View view) {
        switch (view.getId()) {

            case R.id.btnToKotlin:
                toAct(KotlinActivity.class);
                break;
        }
    }

    public void toAct(Class cls) {
        Intent intent = new Intent(this, KotlinActivity.class);
        startActivity(intent);
    }
}
