package com.example.ywb.mvpsample.basemvp;

/**
 * Created by YWB on 2016/5/29.
 */
public abstract class BasePresenter<T> {

    protected T mView;

    protected void attach(T mView){
        this.mView = mView;
    }

    protected void dettach(){
        mView = null;
    }
}
