package com.example.ywb.mvpsample.newmvp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ywb.mvpsample.R;
import com.example.ywb.mvpsample.basemvp.BaseMvpActivity;

import java.util.List;

/**
 * Created by YWB on 2016/5/30.
 */
public class NewMvpActivity extends BaseMvpActivity<NewMvpView, NewMvpPresenter> implements NewMvpView, AdapterView.OnItemClickListener{

    private ListView listView;
    private ArrayAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        presenter.requestData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void showList(List list){
        if(adapter == null){
            adapter = new ArrayAdapter(NewMvpActivity.this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
        }
    }

    @Override
    protected NewMvpPresenter initPresenter() {
        return new NewMvpPresenter();
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
        Toast.makeText(NewMvpActivity.this, msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClick(position);
    }
}
