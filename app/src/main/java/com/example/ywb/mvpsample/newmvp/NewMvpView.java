package com.example.ywb.mvpsample.newmvp;

import com.example.ywb.mvpsample.basemvp.BaseView;

import java.util.List;

/**
 * Created by YWB on 2016/5/30.
 */
public interface NewMvpView extends BaseView {

    void showData(List list);

    void showMessage(String msg);
}
