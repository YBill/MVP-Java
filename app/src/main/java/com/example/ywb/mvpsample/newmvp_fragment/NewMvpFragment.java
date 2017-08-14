package com.example.ywb.mvpsample.newmvp_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ywb.mvpsample.R;
import com.example.ywb.mvpsample.basemvp.BaseFragment;
import com.example.ywb.mvpsample.newmvp.NewMvpPresenter;

import java.util.List;

/**
 * Created by YWB on 2016/6/19.
 */
public class NewMvpFragment extends BaseFragment<NewMvpView,NewMvpPresenter> implements NewMvpView, AdapterView.OnItemClickListener{

    private ListView listView;
    private ArrayAdapter adapter;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_mvc, null);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.requestData();
    }

    private void showList(List list){
        if(adapter == null){
            adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
        }
    }

    @Override
    protected NewMvpPresenter initPresenter() {
        return new NewMvpPresenter();
    }

    @Override
    public void showData(List list) {
        showList(list);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getActivity(), msg,Toast.LENGTH_SHORT).show();
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClick(position);
    }
}
