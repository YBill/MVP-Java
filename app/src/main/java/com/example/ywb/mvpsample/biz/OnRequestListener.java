package com.example.ywb.mvpsample.biz;

import java.util.List;

/**
 * Created by YWB on 2016/5/29.
 */
public interface OnRequestListener {

    void OnSuccess(List<?> list);

    void OnFaild();
}
