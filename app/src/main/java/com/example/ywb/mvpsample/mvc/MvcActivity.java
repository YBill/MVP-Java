package com.example.ywb.mvpsample.mvc;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ywb.mvpsample.R;
import com.example.ywb.mvpsample.biz.OnRequestListener;
import com.example.ywb.mvpsample.biz.RequestBiz;
import com.example.ywb.mvpsample.biz.RequestBizImpl;

import java.util.List;

public class MvcActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;
    private ArrayAdapter adapter;
    private ProgressBar progressBar;
    private RequestBiz requestBiz;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        requestBiz = new RequestBizImpl();
        requestData();

    }

    private void requestData() {
        progressBar.setVisibility(View.VISIBLE);
        requestBiz.requestData(new OnRequestListener() {
            @Override
            public void OnSuccess(final List<?> list) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        showList(list);
                    }
                });
            }

            @Override
            public void OnFaild() {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MvcActivity.this, "加载失败",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showList(List list){
        if(adapter == null){
            adapter = new ArrayAdapter(MvcActivity.this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MvcActivity.this, "点击了item " + (position + 1) ,Toast.LENGTH_SHORT).show();
    }
}
