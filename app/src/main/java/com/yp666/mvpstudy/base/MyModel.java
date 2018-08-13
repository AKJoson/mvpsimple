package com.yp666.mvpstudy.base;

import android.util.Log;

public class MyModel implements IInterface.ModelPrenster{
    @Override
    public void getData(String url) {
        /**
         * 可以使用Rxjava retrofit Okhttp 返回一个Fllowable,在p层里面来链式调用
         */
        try{
            Log.v("TAG","正在进行联网访问，请求数据");
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
