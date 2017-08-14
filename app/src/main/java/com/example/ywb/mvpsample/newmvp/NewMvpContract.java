package com.example.ywb.mvpsample.newmvp;

import com.example.ywb.mvpsample.basemvp.BasePresenter;
import com.example.ywb.mvpsample.basemvp.BaseView;

import java.util.List;

/**
 * Created by Bill on 2017/8/14.
 */

public interface NewMvpContract {
    interface View extends BaseView {
        void showData(List list);

        void showMessage(String msg);
    }

    abstract class Presenter extends BasePresenter<View> {
        abstract void requestData();

        abstract void onItemClick(int position);
    }
}
