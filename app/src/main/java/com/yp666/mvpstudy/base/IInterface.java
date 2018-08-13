package com.yp666.mvpstudy.base;

/**
 * 定义一套接口规范
 */
public class IInterface {
    /**
     * V层接口
     * @param <T>
     */
    public interface ViewPrenster<T> extends BaseView{
        void onLoading();
        void onSuccess(T data);
        void onError();
    }

    /**
     * M层接口
     */
    public interface ModelPrenster{
        void getData(String url);
    }

    /**
     * P层接口
     */
    public interface InterfacePrenster{
        void getData(String url);
    }
}
