package com.qimiaowa.test_mvp2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements MvpView {

    //进度条
    ProgressDialog progressDialog;
    TextView text;

    MvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();

    }

    private void initview() {
        text = (TextView)findViewById(R.id.text);
        // 初始化进度条
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");
        //初始化Presenter
        presenter = new MvpPresenter();
        presenter.attachView(this);


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        
    }

    @Override
    public void showLoading() {
        progressDialog.show();

    }

    @Override
    public void hideLoading() {
        progressDialog.hide();
    }

    @Override
    public void showData(String data) {
        text.setText(data);
    }


    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        text.setText(msg);
    }


    public void showErrorMessage() {
        Toast.makeText(this, "网络请求数据出现异常", Toast.LENGTH_SHORT).show();
        text.setText("网络请求数据出现异常");

    }


    // button 点击事件调用方法
    public void getData(View view){
        presenter.getData("normal");
    }

    // button 点击事件调用方法
    public void getDataForFailure(View view){
        presenter.getData("failure");
    }

    // button 点击事件调用方法
    public void getDataForError(View view){
        presenter.getData("error");
    }

}
