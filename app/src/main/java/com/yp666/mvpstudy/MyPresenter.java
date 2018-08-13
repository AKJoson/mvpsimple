package com.yp666.mvpstudy;

import com.yp666.mvpstudy.base.BasePrenster;
import com.yp666.mvpstudy.base.IInterface;
import com.yp666.mvpstudy.base.MyModel;
import com.yp666.mvpstudy.base.RespenseData;

/**
 * 实现具体的P与V和M的交互
 */
public class MyPresenter extends BasePrenster<IInterface.ViewPrenster<RespenseData>> implements  IInterface.InterfacePrenster {

    private final MyModel mModel;

    public MyPresenter(){
        mModel = new MyModel();
    }

    @Override
    public void getData(String url) {
        //直接使用getView拿到代理对象，根本不用判断是否为空，直接掉就可以了。代理对象里面进行了判断，我们一行代码搞定
        getView().onLoading();
        mModel.getData(url);
        //假设上面获取数据成功了
        RespenseData respenseData = new RespenseData();
        getView().onSuccess(respenseData);
    }
}
