package com.example.android.bluetoothlegatt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class WindowCtrlActivity extends Activity {

    private final static String TAG = DeviceControlActivity.class.getSimpleName();

    private Button btn_nav_tv;
    private Button btn_nav_lig;
    private Button btn_nav_table;
    private Button btn_nav_set;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //<!-- No Title Bar-->
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //<!-- No Title Bar-->
        setContentView(R.layout.activity_window_ctrl);

        // 레이아웃에서 버튼 id 가져오기.

        btn_nav_tv = (Button) findViewById(R.id.btn_nav_tv);
        btn_nav_lig = (Button) findViewById(R.id.btn_nav_lig);
        btn_nav_table = (Button) findViewById(R.id.btn_nav_table);
        btn_nav_set = (Button) findViewById(R.id.btn_nav_set);

        // 해당 버튼에 레이아웃 설정하기.
        btn_nav_tv.setBackgroundResource(R.layout.btn_nav_tv);
        btn_nav_lig.setBackgroundResource(R.layout.btn_nav_lig);
        btn_nav_table.setBackgroundResource(R.layout.btn_nav_table);
        btn_nav_set.setBackgroundResource(R.layout.btn_nav_set);

        btn_nav_tv.setOnClickListener(mClickButtonListener);
        btn_nav_lig.setOnClickListener(mClickButtonListener);
        btn_nav_table.setOnClickListener(mClickButtonListener);
        btn_nav_set.setOnClickListener(mClickButtonListener);
    }



    Button.OnClickListener mClickButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.btn_nav_tv:
                    Intent intent_tv = new Intent();
                    intent_tv.putExtra("next_activity", "tv");
                    setResult(Activity.RESULT_OK, intent_tv);
                    finish();
                    break;
                case R.id.btn_nav_lig:
                    Intent intent_lig = new Intent();
                    intent_lig.putExtra("next_activity", "light");
                    setResult(Activity.RESULT_OK, intent_lig);
                    finish();
                    break;
                case R.id.btn_nav_table:
                    Intent intent_table = new Intent();
                    intent_table.putExtra("next_activity", "table");
                    setResult(Activity.RESULT_OK, intent_table);
                    finish();
                    break;
                case R.id.btn_nav_set:
                    Intent intent_set = new Intent();
                    intent_set.putExtra("next_activity", "setting");
                    setResult(Activity.RESULT_OK, intent_set);
                    finish();
                    break;
            }
        }
    };

    @Override public void onBackPressed()
    {
        //super.onBackPressed();
        //finish();
    }
}


