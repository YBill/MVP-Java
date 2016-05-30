package com.example.ywb.mvpsample.basemvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by YWB on 2016/5/29.
 */
public abstract class BaseMvpActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    protected T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        presenter.attach((V) this);
    }

    protected abstract T initPresenter();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }
}
