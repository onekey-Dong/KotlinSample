package com.onekey.kotlinsample;

import android.content.Intent;
import android.view.View;

import com.onekey.kotlinsample.base.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends BaseActivity {

    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btnToKotlin:
                toAct(KotlinActivity.class);
                break;
        }
    }

    public void toAct(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    @Override
    public int getContentViewID() {
        return R.layout.activity_main;
    }

    @NotNull
    @Override
    public String umengTitle() {
        return super.umengTitle();
    }
}
