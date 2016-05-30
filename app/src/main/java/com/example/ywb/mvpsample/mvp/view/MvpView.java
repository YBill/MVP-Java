package com.example.ywb.mvpsample.mvp.view;

import java.util.List;

/**
 * Created by YWB on 2016/5/29.
 */
public interface MvpView {

    /**
     * 显示进度条
     */
    void showLodding();

    /**
     * 隐藏进度条
     */
    void hideLodding();

    /**
     * 显示数据
     * @param list
     */
    void showData(List list);

    /**
     * 提示数据
     * @param msg
     */
    void showMessage(String msg);

}
