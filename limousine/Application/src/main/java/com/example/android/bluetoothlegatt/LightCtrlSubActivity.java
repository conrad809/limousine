package com.example.android.bluetoothlegatt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ToggleButton;

import java.util.function.ToIntBiFunction;

public class LightCtrlSubActivity extends Activity {
    private final static String TAG = DeviceControlActivity.class.getSimpleName();

    private Button btn_li_sub_col1;
    private Button btn_li_sub_col2;
    private Button btn_li_sub_col3;
    private Button btn_li_sub_col4;
    private Button btn_li_sub_col5;
    private Button btn_li_sub_col6;
    private Button btn_li_sub_col7;
    private Button btn_li_sub_col8;
    private Button btn_li_sub_col9;
    private Button btn_li_sub_col10;
    private Button btn_li_sub_col11;
    private Button btn_li_sub_col12;
    private Button btn_li_sub_col13;
    private Button btn_li_sub_col14;
    private Button btn_li_sub_col15;
    private Button btn_li_sub_col16;
    private Button btn_li_sub_col17;
    private Button btn_li_sub_col18;
    private Button btn_li_sub_col19;
    private Button btn_li_sub_col20;
    private Button btn_li_sub_col21;
    private Button btn_li_sub_col22;
    private Button btn_li_sub_col23;
    private Button btn_li_sub_col24;
    private Button btn_li_sub_col25;
    private Button btn_li_sub_col26;
    private Button btn_li_sub_col27;
    private Button btn_li_sub_col28;
    private Button btn_li_sub_col29;
    private Button btn_li_sub_col30;
    private Button btn_li_sub_col31;
    private Button btn_li_sub_col32;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //<!-- No Title Bar-->
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //<!-- No Title Bar-->
        setContentView(R.layout.activity_light_ctrl_sub);

        btn_li_sub_col1 =  (Button) findViewById(R.id.btn_li_sub_col1 );
        btn_li_sub_col2 =  (Button) findViewById(R.id.btn_li_sub_col2 );
        btn_li_sub_col3 =  (Button) findViewById(R.id.btn_li_sub_col3 );
        btn_li_sub_col4 =  (Button) findViewById(R.id.btn_li_sub_col4 );
        btn_li_sub_col5 =  (Button) findViewById(R.id.btn_li_sub_col5 );
        btn_li_sub_col6 =  (Button) findViewById(R.id.btn_li_sub_col6 );
        btn_li_sub_col7 =  (Button) findViewById(R.id.btn_li_sub_col7 );
        btn_li_sub_col8 =  (Button) findViewById(R.id.btn_li_sub_col8 );
        btn_li_sub_col9 =  (Button) findViewById(R.id.btn_li_sub_col9 );
        btn_li_sub_col10 = (Button) findViewById(R.id.btn_li_sub_col10);
        btn_li_sub_col11 = (Button) findViewById(R.id.btn_li_sub_col11);
        btn_li_sub_col12 = (Button) findViewById(R.id.btn_li_sub_col12);
        btn_li_sub_col13 = (Button) findViewById(R.id.btn_li_sub_col13);
        btn_li_sub_col14 = (Button) findViewById(R.id.btn_li_sub_col14);
        btn_li_sub_col15 = (Button) findViewById(R.id.btn_li_sub_col15);
        btn_li_sub_col16 = (Button) findViewById(R.id.btn_li_sub_col16);
        btn_li_sub_col17 = (Button) findViewById(R.id.btn_li_sub_col17);
        btn_li_sub_col18 = (Button) findViewById(R.id.btn_li_sub_col18);
        btn_li_sub_col19 = (Button) findViewById(R.id.btn_li_sub_col19);
        btn_li_sub_col20 = (Button) findViewById(R.id.btn_li_sub_col20);
        btn_li_sub_col21 = (Button) findViewById(R.id.btn_li_sub_col21);
        btn_li_sub_col22 = (Button) findViewById(R.id.btn_li_sub_col22);
        btn_li_sub_col23 = (Button) findViewById(R.id.btn_li_sub_col23);
        btn_li_sub_col24 = (Button) findViewById(R.id.btn_li_sub_col24);
        btn_li_sub_col25 = (Button) findViewById(R.id.btn_li_sub_col25);
        btn_li_sub_col26 = (Button) findViewById(R.id.btn_li_sub_col26);
        btn_li_sub_col27 = (Button) findViewById(R.id.btn_li_sub_col27);
        btn_li_sub_col28 = (Button) findViewById(R.id.btn_li_sub_col28);
        btn_li_sub_col29 = (Button) findViewById(R.id.btn_li_sub_col29);
        btn_li_sub_col30 = (Button) findViewById(R.id.btn_li_sub_col30);
        btn_li_sub_col31 = (Button) findViewById(R.id.btn_li_sub_col31);
        btn_li_sub_col32 = (Button) findViewById(R.id.btn_li_sub_col32);


        // 해당 버튼에 레이아웃 설정하기.
        btn_li_sub_col1 .setBackgroundResource(R.layout.btn_color1 );
        btn_li_sub_col2 .setBackgroundResource(R.layout.btn_color2 );
        btn_li_sub_col3 .setBackgroundResource(R.layout.btn_color3 );
        btn_li_sub_col4 .setBackgroundResource(R.layout.btn_color4 );
        btn_li_sub_col5 .setBackgroundResource(R.layout.btn_color5 );
        btn_li_sub_col6 .setBackgroundResource(R.layout.btn_color6 );
        btn_li_sub_col7 .setBackgroundResource(R.layout.btn_color7 );
        btn_li_sub_col8 .setBackgroundResource(R.layout.btn_color8 );
        btn_li_sub_col9 .setBackgroundResource(R.layout.btn_color9 );
        btn_li_sub_col10.setBackgroundResource(R.layout.btn_color10);
        btn_li_sub_col11.setBackgroundResource(R.layout.btn_color11);
        btn_li_sub_col12.setBackgroundResource(R.layout.btn_color12);
        btn_li_sub_col13.setBackgroundResource(R.layout.btn_color13);
        btn_li_sub_col14.setBackgroundResource(R.layout.btn_color14);
        btn_li_sub_col15.setBackgroundResource(R.layout.btn_color15);
        btn_li_sub_col16.setBackgroundResource(R.layout.btn_color16);
        btn_li_sub_col17.setBackgroundResource(R.layout.btn_color17);
        btn_li_sub_col18.setBackgroundResource(R.layout.btn_color18);
        btn_li_sub_col19.setBackgroundResource(R.layout.btn_color19);
        btn_li_sub_col20.setBackgroundResource(R.layout.btn_color20);
        btn_li_sub_col21.setBackgroundResource(R.layout.btn_color21);
        btn_li_sub_col22.setBackgroundResource(R.layout.btn_color22);
        btn_li_sub_col23.setBackgroundResource(R.layout.btn_color23);
        btn_li_sub_col24.setBackgroundResource(R.layout.btn_color24);
        btn_li_sub_col25.setBackgroundResource(R.layout.btn_color25);
        btn_li_sub_col26.setBackgroundResource(R.layout.btn_color26);
        btn_li_sub_col27.setBackgroundResource(R.layout.btn_color27);
        btn_li_sub_col28.setBackgroundResource(R.layout.btn_color28);
        btn_li_sub_col29.setBackgroundResource(R.layout.btn_color29);
        btn_li_sub_col30.setBackgroundResource(R.layout.btn_color30);
        btn_li_sub_col31.setBackgroundResource(R.layout.btn_color31);
        btn_li_sub_col32.setBackgroundResource(R.layout.btn_color32);


        // 해당 버튼에 클릭이벤트 설정하기.
        btn_li_sub_col1 .setOnClickListener(mClickButtonListener);
        btn_li_sub_col2 .setOnClickListener(mClickButtonListener);
        btn_li_sub_col3 .setOnClickListener(mClickButtonListener);
        btn_li_sub_col4 .setOnClickListener(mClickButtonListener);
        btn_li_sub_col5 .setOnClickListener(mClickButtonListener);
        btn_li_sub_col6 .setOnClickListener(mClickButtonListener);
        btn_li_sub_col7 .setOnClickListener(mClickButtonListener);
        btn_li_sub_col8 .setOnClickListener(mClickButtonListener);
        btn_li_sub_col9 .setOnClickListener(mClickButtonListener);
        btn_li_sub_col10.setOnClickListener(mClickButtonListener);
        btn_li_sub_col11.setOnClickListener(mClickButtonListener);
        btn_li_sub_col12.setOnClickListener(mClickButtonListener);
        btn_li_sub_col13.setOnClickListener(mClickButtonListener);
        btn_li_sub_col14.setOnClickListener(mClickButtonListener);
        btn_li_sub_col15.setOnClickListener(mClickButtonListener);
        btn_li_sub_col16.setOnClickListener(mClickButtonListener);
        btn_li_sub_col17.setOnClickListener(mClickButtonListener);
        btn_li_sub_col18.setOnClickListener(mClickButtonListener);
        btn_li_sub_col19.setOnClickListener(mClickButtonListener);
        btn_li_sub_col20.setOnClickListener(mClickButtonListener);
        btn_li_sub_col21.setOnClickListener(mClickButtonListener);
        btn_li_sub_col22.setOnClickListener(mClickButtonListener);
        btn_li_sub_col23.setOnClickListener(mClickButtonListener);
        btn_li_sub_col24.setOnClickListener(mClickButtonListener);
        btn_li_sub_col25.setOnClickListener(mClickButtonListener);
        btn_li_sub_col26.setOnClickListener(mClickButtonListener);
        btn_li_sub_col27.setOnClickListener(mClickButtonListener);
        btn_li_sub_col28.setOnClickListener(mClickButtonListener);
        btn_li_sub_col29.setOnClickListener(mClickButtonListener);
        btn_li_sub_col30.setOnClickListener(mClickButtonListener);
        btn_li_sub_col31.setOnClickListener(mClickButtonListener);
        btn_li_sub_col32.setOnClickListener(mClickButtonListener);
    }
    Button.OnClickListener mClickButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            int sub_color_index = 0;
        switch(v.getId())
        {
            case R.id.btn_li_sub_col1 : sub_color_index = 1 ; break;
            case R.id.btn_li_sub_col2 : sub_color_index = 2 ; break;
            case R.id.btn_li_sub_col3 : sub_color_index = 3 ; break;
            case R.id.btn_li_sub_col4 : sub_color_index = 4 ; break;
            case R.id.btn_li_sub_col5 : sub_color_index = 5 ; break;
            case R.id.btn_li_sub_col6 : sub_color_index = 6 ; break;
            case R.id.btn_li_sub_col7 : sub_color_index = 7 ; break;
            case R.id.btn_li_sub_col8 : sub_color_index = 8 ; break;
            case R.id.btn_li_sub_col9 : sub_color_index = 9 ; break;
            case R.id.btn_li_sub_col10: sub_color_index = 10; break;
            case R.id.btn_li_sub_col11: sub_color_index = 11; break;
            case R.id.btn_li_sub_col12: sub_color_index = 12; break;
            case R.id.btn_li_sub_col13: sub_color_index = 13; break;
            case R.id.btn_li_sub_col14: sub_color_index = 14; break;
            case R.id.btn_li_sub_col15: sub_color_index = 15; break;
            case R.id.btn_li_sub_col16: sub_color_index = 16; break;
            case R.id.btn_li_sub_col17: sub_color_index = 17; break;
            case R.id.btn_li_sub_col18: sub_color_index = 18; break;
            case R.id.btn_li_sub_col19: sub_color_index = 19; break;
            case R.id.btn_li_sub_col20: sub_color_index = 20; break;
            case R.id.btn_li_sub_col21: sub_color_index = 21; break;
            case R.id.btn_li_sub_col22: sub_color_index = 22; break;
            case R.id.btn_li_sub_col23: sub_color_index = 23; break;
            case R.id.btn_li_sub_col24: sub_color_index = 24; break;
            case R.id.btn_li_sub_col25: sub_color_index = 25; break;
            case R.id.btn_li_sub_col26: sub_color_index = 26; break;
            case R.id.btn_li_sub_col27: sub_color_index = 27; break;
            case R.id.btn_li_sub_col28: sub_color_index = 28; break;
            case R.id.btn_li_sub_col29: sub_color_index = 29; break;
            case R.id.btn_li_sub_col30: sub_color_index = 30; break;
            case R.id.btn_li_sub_col31: sub_color_index = 31; break;
            case R.id.btn_li_sub_col32: sub_color_index = 32; break;
            default: break;
        }

        Intent intent_li_sub = new Intent();
        intent_li_sub.putExtra("sub_color_index", sub_color_index);
        setResult(Activity.RESULT_OK, intent_li_sub);
        finish();
        }
    };

    @Override public void onBackPressed()
    {
        //super.onBackPressed();
        //finish();
    }
}


