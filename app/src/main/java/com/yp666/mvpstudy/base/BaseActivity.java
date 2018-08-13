package com.yp666.mvpstudy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * V层的基类
 * 创建Presenter ,但是不知道是哪一个Presenter，所以需要使用泛型
 * 另外，这个Presenter应该交给子类去创建
 */
public abstract class BaseActivity<T extends BasePrenster>  extends AppCompatActivity implements BaseView{
    private T mPresneter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        mPresneter = createPresenter();
        //在P中绑定V
        mPresneter.attach(this);
        initView();
        initData();
    }

    public T getmPresneter() {
        return mPresneter;
    }

    protected abstract T createPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void setContentView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //有绑定就有解绑
        mPresneter.detach();
    }
}
