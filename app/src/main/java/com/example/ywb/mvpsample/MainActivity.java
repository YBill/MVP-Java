package com.example.ywb.mvpsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ywb.mvpsample.mvc.MvcActivity;
import com.example.ywb.mvpsample.mvp.MvpActivity;
import com.example.ywb.mvpsample.newmvp.NewMvpActivity;
import com.example.ywb.mvpsample.newmvp_fragment.NewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mvcBtn;
    private Button mvpBtn;
    private Button newMvpBtn;
    private Button newMvpFragmentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mvcBtn = (Button)findViewById(R.id.btn_mvc);
        mvcBtn.setOnClickListener(this);
        mvpBtn = (Button)findViewById(R.id.btn_mvp);
        mvpBtn.setOnClickListener(this);
        newMvpBtn = (Button)findViewById(R.id.btn_mvp_new);
        newMvpBtn.setOnClickListener(this);
        newMvpFragmentBtn = (Button) findViewById(R.id.btn_mvp_new_fragment);
        newMvpFragmentBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_mvc:
                toStartActivity(MvcActivity.class);
                break;
            case R.id.btn_mvp:
                toStartActivity(MvpActivity.class);
                break;
            case R.id.btn_mvp_new:
                toStartActivity(NewMvpActivity.class);
                break;
            case R.id.btn_mvp_new_fragment:
                toStartActivity(NewActivity.class);
                break;
        }
    }

    private void toStartActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
