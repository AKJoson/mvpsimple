package com.yp666.mvpstudy;

import android.util.Log;

import com.yp666.mvpstudy.base.BaseActivity;
import com.yp666.mvpstudy.base.IInterface;
import com.yp666.mvpstudy.base.RespenseData;

public class MainActivity extends BaseActivity<MyPresenter> implements IInterface.ViewPrenster<RespenseData> {



    @Override
    public void onLoading() {
        Log.v("TAG","正在加载,请等待");
    }

    @Override
    public void onSuccess(RespenseData data) {
        Log.v("TAG","数据获取成功，可以刷新视图了");
    }


    @Override
    public void onError() {

    }

    @Override
    protected MyPresenter createPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initData() {
        getmPresneter().getData("urlurlurl~~");
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }
}
