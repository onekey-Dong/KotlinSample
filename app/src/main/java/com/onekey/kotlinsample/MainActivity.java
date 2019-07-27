package com.onekey.kotlinsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.onekey.kotlinsample.base.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends BaseActivity {

    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btnToKotlin:
                toAct(KotlinActivity.class);
                break;
            case R.id.btnToOne:
                Bundle bundle = new Bundle();
                bundle.putInt("index", 1);
                toAct(KotlinActivity.class, bundle);
                break;
        }
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
