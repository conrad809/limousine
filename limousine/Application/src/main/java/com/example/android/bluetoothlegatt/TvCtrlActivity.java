package com.example.android.bluetoothlegatt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class TvCtrlActivity extends Activity {
    private Button btn_tv_cha;
    private Button btn_tv_jtbc;
    private Button btn_tv_kbs1;
    private Button btn_tv_kbs2;
    private Button btn_tv_mbc;
    private Button btn_tv_mnet;
    private Button btn_tv_n;
    private Button btn_tv_ocn;
    private Button btn_tv_sbs;
    private Button btn_tv_tvzo;
    private Button btn_tv_ytn;
    private Button btn_tv_yun;

    private Button btn_tv_out;
    private Button btn_tv_power;
    private Button btn_tv_settop;

    private Button btn_tv_re;
    private Button btn_tv_play;
    private Button btn_tv_for;
    private Button btn_tv_vol_plus;
    private Button btn_tv_vol_down;
    private Button btn_tv_ch_up;
    private Button btn_tv_ch_down;
    private Button btn_tv_home;
    private Button btn_tv_mute;
    private Button btn_tv_channel_list;
    private Button btn_tv_back; //  [이전으로 가기] 버튼
    private Button btn_tv_preference; //선호채널
    private Button btn_tv_quit; //나가기 버튼
    private Button btn_tv_up;
    private Button btn_tv_down;
    private Button btn_tv_left;
    private Button btn_tv_right;
    private Button btn_tv_ok;

    private Button btn_tv_01;
    private Button btn_tv_02;
    private Button btn_tv_03;
    private Button btn_tv_04;
    private Button btn_tv_05;
    private Button btn_tv_06;
    private Button btn_tv_07;
    private Button btn_tv_08;
    private Button btn_tv_09;
    private Button btn_tv_asterisk;
    private Button btn_tv_00;
    private Button btn_tv_sharp;

    //private Button btn_nav_tv;
    private Button btn_nav_lig;
    private Button btn_nav_win;
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
        setContentView(R.layout.activity_tv_ctrl);

        // 레이아웃에서 버튼 id 가져오기.
        btn_tv_kbs1 = (Button) findViewById(R.id.btn_tv_kbs1);
        btn_tv_kbs2 = (Button) findViewById(R.id.btn_tv_kbs2);
        btn_tv_mbc = (Button) findViewById(R.id.btn_tv_mbc);
        btn_tv_sbs = (Button) findViewById(R.id.btn_tv_sbs);
        btn_tv_ytn = (Button) findViewById(R.id.btn_tv_ytn);
        btn_tv_jtbc = (Button) findViewById(R.id.btn_tv_jtbc);
        btn_tv_yun = (Button) findViewById(R.id.btn_tv_yun);
        btn_tv_cha = (Button) findViewById(R.id.btn_tv_cha);
        btn_tv_n = (Button) findViewById(R.id.btn_tv_n);
        btn_tv_tvzo = (Button) findViewById(R.id.btn_tv_tvzo);
        btn_tv_mnet = (Button) findViewById(R.id.btn_tv_mnet);
        btn_tv_ocn = (Button) findViewById(R.id.btn_tv_ocn);

        btn_tv_out = (Button) findViewById(R.id.btn_tv_out);
        btn_tv_power = (Button) findViewById(R.id.btn_tv_power);
        btn_tv_settop = (Button) findViewById(R.id.btn_tv_settop);
        btn_tv_re = (Button) findViewById(R.id.btn_tv_re);
        btn_tv_play = (Button) findViewById(R.id.btn_tv_play);
        btn_tv_for = (Button) findViewById(R.id.btn_tv_for);
        btn_tv_vol_plus = (Button) findViewById(R.id.btn_tv_vol_plus);
        btn_tv_vol_down = (Button) findViewById(R.id.btn_tv_vol_down);
        btn_tv_ch_up = (Button) findViewById(R.id.btn_tv_ch_up);
        btn_tv_ch_down = (Button) findViewById(R.id.btn_tv_ch_down);
        btn_tv_home = (Button) findViewById(R.id.btn_tv_home);
        btn_tv_mute = (Button) findViewById(R.id.btn_tv_mute);
        btn_tv_channel_list = (Button) findViewById(R.id.btn_tv_channel_list);
        btn_tv_back = (Button) findViewById(R.id.btn_tv_back);
        btn_tv_preference = (Button) findViewById(R.id.btn_tv_preference);
        btn_tv_quit = (Button) findViewById(R.id.btn_tv_quit);
        btn_tv_up = (Button) findViewById(R.id.btn_tv_up);
        btn_tv_down = (Button) findViewById(R.id.btn_tv_down);
        btn_tv_left = (Button) findViewById(R.id.btn_tv_left);
        btn_tv_right = (Button) findViewById(R.id.btn_tv_right);
        btn_tv_ok = (Button) findViewById(R.id.btn_tv_ok);

        btn_tv_01 = (Button) findViewById(R.id.btn_tv_01);
        btn_tv_02 = (Button) findViewById(R.id.btn_tv_02);
        btn_tv_03 = (Button) findViewById(R.id.btn_tv_03);
        btn_tv_04 = (Button) findViewById(R.id.btn_tv_04);
        btn_tv_05 = (Button) findViewById(R.id.btn_tv_05);
        btn_tv_06 = (Button) findViewById(R.id.btn_tv_06);
        btn_tv_07 = (Button) findViewById(R.id.btn_tv_07);
        btn_tv_08 = (Button) findViewById(R.id.btn_tv_08);
        btn_tv_09 = (Button) findViewById(R.id.btn_tv_09);
        btn_tv_asterisk = (Button) findViewById(R.id.btn_tv_asterisk);
        btn_tv_00 = (Button) findViewById(R.id.btn_tv_00);
        btn_tv_sharp = (Button) findViewById(R.id.btn_tv_sharp);

        btn_nav_lig = (Button) findViewById(R.id.btn_nav_lig);
        btn_nav_win = (Button) findViewById(R.id.btn_nav_win);
        btn_nav_table = (Button) findViewById(R.id.btn_nav_table);
        btn_nav_set = (Button) findViewById(R.id.btn_nav_set);

        // 해당 버튼에 레이아웃 설정하기.
        btn_tv_kbs1.setBackgroundResource(R.layout.btn_tv_kbs1);
        btn_tv_kbs2.setBackgroundResource(R.layout.btn_tv_kbs2);
        btn_tv_mbc.setBackgroundResource(R.layout.btn_tv_mbc);
        btn_tv_sbs.setBackgroundResource(R.layout.btn_tv_sbs);
        btn_tv_ytn.setBackgroundResource(R.layout.btn_tv_ytn);
        btn_tv_jtbc.setBackgroundResource(R.layout.btn_tv_jtbc);
        btn_tv_yun.setBackgroundResource(R.layout.btn_tv_yun);
        btn_tv_cha.setBackgroundResource(R.layout.btn_tv_cha);
        btn_tv_n.setBackgroundResource(R.layout.btn_tv_n);
        btn_tv_tvzo.setBackgroundResource(R.layout.btn_tv_tvzo);
        btn_tv_mnet.setBackgroundResource(R.layout.btn_tv_mnet);
        btn_tv_ocn.setBackgroundResource(R.layout.btn_tv_ocn);

        btn_tv_out.setBackgroundResource(R.layout.btn_tv_out);
        btn_tv_power.setBackgroundResource(R.layout.btn_tv_power);
        btn_tv_settop.setBackgroundResource(R.layout.btn_tv_settop);
        btn_tv_re.setBackgroundResource(R.layout.btn_tv_re);
        btn_tv_play.setBackgroundResource(R.layout.btn_tv_play);
        btn_tv_for.setBackgroundResource(R.layout.btn_tv_for);
        btn_tv_vol_plus.setBackgroundResource(R.layout.btn_tv_vol_plus);
        btn_tv_vol_down.setBackgroundResource(R.layout.btn_tv_vol_down);
        btn_tv_ch_up.setBackgroundResource(R.layout.btn_tv_ch_up);
        btn_tv_ch_down.setBackgroundResource(R.layout.btn_tv_ch_down);
        btn_tv_home.setBackgroundResource(R.layout.btn_tv_home);
        btn_tv_mute.setBackgroundResource(R.layout.btn_tv_mute);
        btn_tv_channel_list.setBackgroundResource(R.layout.btn_tv_channel_list);
        btn_tv_back.setBackgroundResource(R.layout.btn_tv_back);
        btn_tv_preference.setBackgroundResource(R.layout.btn_tv_preference);
        btn_tv_quit.setBackgroundResource(R.layout.btn_tv_quit);
        btn_tv_up.setBackgroundResource(R.layout.btn_tv_up);
        btn_tv_down.setBackgroundResource(R.layout.btn_tv_down);
        btn_tv_left.setBackgroundResource(R.layout.btn_tv_left);
        btn_tv_right.setBackgroundResource(R.layout.btn_tv_right);
        btn_tv_ok.setBackgroundResource(R.layout.btn_tv_ok);

        btn_tv_01.setBackgroundResource(R.layout.btn_tv_01);
        btn_tv_02.setBackgroundResource(R.layout.btn_tv_02);
        btn_tv_03.setBackgroundResource(R.layout.btn_tv_03);
        btn_tv_04.setBackgroundResource(R.layout.btn_tv_04);
        btn_tv_05.setBackgroundResource(R.layout.btn_tv_05);
        btn_tv_06.setBackgroundResource(R.layout.btn_tv_06);
        btn_tv_07.setBackgroundResource(R.layout.btn_tv_07);
        btn_tv_08.setBackgroundResource(R.layout.btn_tv_08);
        btn_tv_09.setBackgroundResource(R.layout.btn_tv_09);
        btn_tv_asterisk.setBackgroundResource(R.layout.btn_tv_asterisk);
        btn_tv_00.setBackgroundResource(R.layout.btn_tv_00);
        btn_tv_sharp.setBackgroundResource(R.layout.btn_tv_sharp);

        btn_nav_lig.setBackgroundResource(R.layout.btn_nav_lig);
        btn_nav_win.setBackgroundResource(R.layout.btn_nav_win);
        btn_nav_table.setBackgroundResource(R.layout.btn_nav_table);
        btn_nav_set.setBackgroundResource(R.layout.btn_nav_set);

        btn_tv_kbs1.setOnClickListener(mClickButtonListener);
        btn_tv_kbs2.setOnClickListener(mClickButtonListener);
        btn_tv_mbc.setOnClickListener(mClickButtonListener);
        btn_tv_sbs.setOnClickListener(mClickButtonListener);
        btn_tv_ytn.setOnClickListener(mClickButtonListener);
        btn_tv_jtbc.setOnClickListener(mClickButtonListener);
        btn_tv_yun.setOnClickListener(mClickButtonListener);
        btn_tv_cha.setOnClickListener(mClickButtonListener);
        btn_tv_n.setOnClickListener(mClickButtonListener);
        btn_tv_tvzo.setOnClickListener(mClickButtonListener);
        btn_tv_mnet.setOnClickListener(mClickButtonListener);
        btn_tv_ocn.setOnClickListener(mClickButtonListener);

        btn_tv_out.setOnClickListener(mClickButtonListener);
        btn_tv_power.setOnClickListener(mClickButtonListener);
        btn_tv_settop.setOnClickListener(mClickButtonListener);
        btn_tv_re.setOnClickListener(mClickButtonListener);
        btn_tv_play.setOnClickListener(mClickButtonListener);
        btn_tv_for.setOnClickListener(mClickButtonListener);
        btn_tv_vol_plus.setOnClickListener(mClickButtonListener);
        btn_tv_vol_down.setOnClickListener(mClickButtonListener);
        btn_tv_ch_up.setOnClickListener(mClickButtonListener);
        btn_tv_ch_down.setOnClickListener(mClickButtonListener);
        btn_tv_home.setOnClickListener(mClickButtonListener);
        btn_tv_mute.setOnClickListener(mClickButtonListener);
        btn_tv_channel_list.setOnClickListener(mClickButtonListener);
        btn_tv_back.setOnClickListener(mClickButtonListener);
        btn_tv_preference.setOnClickListener(mClickButtonListener);
        btn_tv_quit.setOnClickListener(mClickButtonListener);
        btn_tv_up.setOnClickListener(mClickButtonListener);
        btn_tv_down.setOnClickListener(mClickButtonListener);
        btn_tv_left.setOnClickListener(mClickButtonListener);
        btn_tv_right.setOnClickListener(mClickButtonListener);
        btn_tv_ok.setOnClickListener(mClickButtonListener);

        btn_tv_01.setOnClickListener(mClickButtonListener);
        btn_tv_02.setOnClickListener(mClickButtonListener);
        btn_tv_03.setOnClickListener(mClickButtonListener);
        btn_tv_04.setOnClickListener(mClickButtonListener);
        btn_tv_05.setOnClickListener(mClickButtonListener);
        btn_tv_06.setOnClickListener(mClickButtonListener);
        btn_tv_07.setOnClickListener(mClickButtonListener);
        btn_tv_08.setOnClickListener(mClickButtonListener);
        btn_tv_09.setOnClickListener(mClickButtonListener);
        btn_tv_asterisk.setOnClickListener(mClickButtonListener);
        btn_tv_00.setOnClickListener(mClickButtonListener);
        btn_tv_sharp.setOnClickListener(mClickButtonListener);

        btn_nav_lig.setOnClickListener(mClickButtonListener);
        btn_nav_win.setOnClickListener(mClickButtonListener);
        btn_nav_table.setOnClickListener(mClickButtonListener);
        btn_nav_set.setOnClickListener(mClickButtonListener);

        // 버전 보네기
        ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData("BA  0201");
    }

    Button.OnClickListener mClickButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.btn_nav_lig:
                    Intent intent_light = new Intent();
                    intent_light.putExtra("next_activity", "light");
                    setResult(Activity.RESULT_OK, intent_light);
                    finish();
                    break;
                case R.id.btn_nav_win:
                    Intent intent_win = new Intent();
                    intent_win.putExtra("next_activity", "window");
                    setResult(Activity.RESULT_OK, intent_win);
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

                case R.id.btn_tv_kbs1:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendChannelAlias("kbs1");
                    break;
                case R.id.btn_tv_kbs2:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendChannelAlias("kbs2");
                    break;
                case R.id.btn_tv_mbc:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendChannelAlias("mbc");
                    break;
                case R.id.btn_tv_sbs:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendChannelAlias("sbs");
                    break;
                case R.id.btn_tv_ytn:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendChannelAlias("ytn");
                    break;
                case R.id.btn_tv_jtbc:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendChannelAlias("jtbc");
                    break;
                case R.id.btn_tv_yun:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendChannelAlias("yun");
                    break;
                case R.id.btn_tv_cha:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendChannelAlias("cha");
                    break;
                case R.id.btn_tv_n:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendChannelAlias("tvn");
                    break;
                case R.id.btn_tv_tvzo:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendChannelAlias("tvzo");
                    break;
                case R.id.btn_tv_mnet:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendChannelAlias("mnet");
                    break;
                case R.id.btn_tv_ocn:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendChannelAlias("ocn");
                    break;
                case R.id.btn_tv_out:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("B");
                    break;
                case R.id.btn_tv_power:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("C");
                    break;
                case R.id.btn_tv_settop:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("D");
                    break;
                case R.id.btn_tv_re:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("E");
                    break;
                case R.id.btn_tv_play:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("F");
                    break;
                case R.id.btn_tv_for:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("G");
                    break;
                case R.id.btn_tv_vol_plus:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("H");
                    break;
                case R.id.btn_tv_vol_down:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("I");
                    break;
                case R.id.btn_tv_ch_up:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("J");
                    break;
                case R.id.btn_tv_ch_down:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("K");
                    break;
                case R.id.btn_tv_home:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("L");
                    break;
                case R.id.btn_tv_mute:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("M");
                    break;
                case R.id.btn_tv_channel_list:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("N");
                    break;
                case R.id.btn_tv_back:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("O");
                    break;
                case R.id.btn_tv_preference:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("P");
                    break;
                case R.id.btn_tv_quit:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("Q");
                    break;
                case R.id.btn_tv_up:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("R");
                    break;
                case R.id.btn_tv_down:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("S");
                    break;
                case R.id.btn_tv_left:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("T");
                    break;
                case R.id.btn_tv_right:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("U");
                    break;
                case R.id.btn_tv_ok:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("X");
                    break;
                case R.id.btn_tv_01:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("1");
                    break;
                case R.id.btn_tv_02:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("2");
                    break;
                case R.id.btn_tv_03:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("3");
                    break;
                case R.id.btn_tv_04:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("4");
                    break;
                case R.id.btn_tv_05:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("5");
                    break;
                case R.id.btn_tv_06:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("6");
                    break;
                case R.id.btn_tv_07:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("7");
                    break;
                case R.id.btn_tv_08:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("8");
                    break;
                case R.id.btn_tv_09:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("9");
                    break;
                case R.id.btn_tv_00:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("0");
                    break;
                case R.id.btn_tv_asterisk:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("V");
                    break;
                case R.id.btn_tv_sharp:
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendKeyValue("W");
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


