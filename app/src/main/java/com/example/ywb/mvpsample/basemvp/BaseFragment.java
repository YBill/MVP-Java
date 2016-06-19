package com.example.ywb.mvpsample.basemvp;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by YWB on 2016/6/19.
 */
public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {

    protected T presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        presenter.attach((V) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }

    protected abstract T initPresenter();
}
