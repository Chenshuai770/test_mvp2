package com.qimiaowa.test_mvp2;

/**
 * Created by Administrator on 2018/2/28/028.
 */

public interface  MvpView  extends BaseView{
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(String data);

}
