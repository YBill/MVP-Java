package com.example.ywb.mvpsample.biz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YWB on 2016/5/29.
 */
public class RequestBizImpl implements RequestBiz {

    @Override
    public void requestData(final OnRequestListener listener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List list = new ArrayList();
                for (int i = 1; i < 10; i++){
                    list.add("item " + i);
                }

                if(listener != null)
                    listener.OnSuccess(list);
            }
        }).start();

    }
}
