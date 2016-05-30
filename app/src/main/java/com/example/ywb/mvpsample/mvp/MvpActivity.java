package com.example.ywb.mvpsample.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ywb.mvpsample.R;
import com.example.ywb.mvpsample.mvp.presenter.MvpPresenter;
import com.example.ywb.mvpsample.mvp.view.MvpView;

import java.util.List;

public class MvpActivity extends AppCompatActivity implements MvpView, AdapterView.OnItemClickListener{

    private ListView listView;
    private ArrayAdapter adapter;
    private ProgressBar progressBar;
    private MvpPresenter mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        mvpPresenter = new MvpPresenter(this);
        mvpPresenter.requestData();
    }

    private void showList(List list){
        if(adapter == null){
            adapter = new ArrayAdapter(MvpActivity.this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public void showLodding() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLodding() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showData(List list) {
        showList(list);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(MvpActivity.this, msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mvpPresenter.onItemClick(position);
    }
}
