package com.wiggins.jsonanalysis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wiggins.jsonanalysis.base.BaseActivity;
import com.wiggins.jsonanalysis.bean.PersonBean;
import com.wiggins.jsonanalysis.bean.UserBean;
import com.wiggins.jsonanalysis.entity.Common;
import com.wiggins.jsonanalysis.entity.CommonList;
import com.wiggins.jsonanalysis.entity.DataUtil;
import com.wiggins.jsonanalysis.listener.DataCallback;
import com.wiggins.jsonanalysis.listener.ListCallback;
import com.wiggins.jsonanalysis.utils.Constant;
import com.wiggins.jsonanalysis.utils.LogUtil;
import com.wiggins.jsonanalysis.utils.UIUtils;
import com.wiggins.jsonanalysis.widget.TitleView;

/**
 * @Description 使用GSON和泛型解析约定格式的JSON字符串
 * @Author 一花一世界
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TitleView titleView;
    private TextView tv_data_format;//JSON数据格式
    private TextView tv_raw_data;//原始数据
    private TextView tv_parsing_data;//解析数据
    private Button btn_json1;
    private Button btn_json2;
    private Button btn_json3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
        initData();
    }

    private void initView() {
        titleView = (TitleView) findViewById(R.id.titleView);
        titleView.setAppTitle(UIUtils.getString(R.string.title));
        titleView.setLeftImageVisibility(View.GONE);
        tv_data_format = (TextView) findViewById(R.id.tv_data_format);
        tv_raw_data = (TextView) findViewById(R.id.tv_raw_data);
        tv_parsing_data = (TextView) findViewById(R.id.tv_parsing_data);
        btn_json1 = (Button) findViewById(R.id.btn_json1);
        btn_json2 = (Button) findViewById(R.id.btn_json2);
        btn_json3 = (Button) findViewById(R.id.btn_json3);
    }

    private void setListener() {
        btn_json1.setOnClickListener(this);
        btn_json2.setOnClickListener(this);
        btn_json3.setOnClickListener(this);
    }

    private void initData() {
        tv_data_format.setText(String.format(UIUtils.getString(R.string.data), "一") + "\n" + Constant.json1 + "\n" +
                String.format(UIUtils.getString(R.string.data), "二") + "\n" + Constant.json2 + "\n" +
                String.format(UIUtils.getString(R.string.data), "三") + "\n" + Constant.json3);
        Common<UserBean> user = Common.fromJson(Constant.json1, UserBean.class);
        LogUtil.e(Constant.LOG_TAG, user.toString());
        Common<PersonBean> person = Common.fromJson(Constant.json2, PersonBean.class);
        LogUtil.e(Constant.LOG_TAG, person.toString());
        CommonList<UserBean> users = CommonList.fromJson(Constant.json3, UserBean.class);
        LogUtil.e(Constant.LOG_TAG, users.toString());
    }

    private void setText(int type, String str) {
        if (type == 0) {
            tv_raw_data.setText("");
            tv_raw_data.setText(UIUtils.getString(R.string.raw_data) + "\n" + str);
        } else {
            tv_parsing_data.setText("");
            tv_parsing_data.setText(UIUtils.getString(R.string.parsing_data) + "\n" + str);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_json1:
                setText(0, Constant.json1);
                DataUtil.getData(Constant.json1, new DataCallback<UserBean>() {

                    @Override
                    public void onSuccess(Common<UserBean> userCommon) {
                        setText(1, userCommon.toString());
                    }
                });
                break;
            case R.id.btn_json2:
                setText(0, Constant.json2);
                DataUtil.getData(Constant.json2, new DataCallback<PersonBean>() {

                    @Override
                    public void onSuccess(Common<PersonBean> userCommon) {
                        setText(1, userCommon.toString());
                    }
                });
                break;
            case R.id.btn_json3:
                setText(0, Constant.json3);
                DataUtil.getData(Constant.json3, new ListCallback<UserBean>() {

                    @Override
                    public void onSuccess(CommonList<UserBean> userCommonList) {
                        setText(1, userCommonList.toString());
                    }
                });
                break;
        }
    }
}
