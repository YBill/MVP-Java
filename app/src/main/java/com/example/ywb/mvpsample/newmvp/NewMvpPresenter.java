package com.example.ywb.mvpsample.newmvp;

import android.os.Handler;

import com.example.ywb.mvpsample.basemvp.BasePresenter;
import com.example.ywb.mvpsample.biz.OnRequestListener;
import com.example.ywb.mvpsample.biz.RequestBiz;
import com.example.ywb.mvpsample.biz.RequestBizImpl;

import java.util.List;

/**
 * Created by YWB on 2016/5/30.
 */
public class NewMvpPresenter extends NewMvpContract.Presenter {

    private RequestBiz requestBiz;
    private Handler handler;

    public NewMvpPresenter() {
        requestBiz = new RequestBizImpl();
        handler = new Handler();
    }

    @Override
    public void requestData() {
        if (mView != null)
            mView.showLoading();
        requestBiz.requestData(new OnRequestListener() {
            @Override
            public void OnSuccess(final List<?> list) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mView != null) {
                            mView.hideLoading();
                            mView.showData(list);
                        }
                    }
                });
            }

            @Override
            public void OnFaild() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mView != null) {
                            mView.hideLoading();
                            mView.showMessage("请求失败");
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        if (mView != null)
            mView.showMessage("点击了item " + (position + 1));
    }
}
