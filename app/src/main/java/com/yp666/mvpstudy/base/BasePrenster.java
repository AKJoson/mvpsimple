package com.yp666.mvpstudy.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * P层的基类
 * 1.attach(),绑定V，V不确定，故需要使用泛型，和detach()
 */
public class BasePrenster<T extends BaseView> {
    private T mView,mProxyView;

    public T getView(){
        return mProxyView;
    }
    //attach,运用动态代理
    public void attach(final T mView){
        this.mView = mView;
        mProxyView = (T)Proxy.newProxyInstance(mView.getClass().getClassLoader(), mView.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if (mView == null){
                    return null;
                }
                return method.invoke(mView,objects);
            }
        });
    }
    //解绑View
    public void detach(){
        mView = null;
        mProxyView = null;
    }
}
