package com.example.android.bluetoothlegatt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ToggleButton;

import java.util.function.ToIntBiFunction;

public class LightCtrlActivity extends Activity {
    private final static String TAG = DeviceControlActivity.class.getSimpleName();
    public final String PREFERENCE = "com.example.android.bluetoothlegatt";
    private BluetoothLeService mBluetoothLeService;
    private BluetoothGattCharacteristic mWriteCharacteristic;

    private Button btn_center;
    private Button btn_wall;
    private Button btn_galaxy;

    private ToggleButton btn_roof;
    private ToggleButton btn_partition;

    private Button btn_down;
    private Button btn_up;
    private Button btn_power;

    private Button btn_color1;
    private Button btn_color2;
    private Button btn_color3;
    private Button btn_color4;
    private Button btn_color5;
    private Button btn_color6;
    private Button btn_color7;
    private Button btn_color8;
    private Button btn_color9;
    private Button btn_color10;
    private Button btn_color11;
    private Button btn_color12;
    private Button btn_color13;
    private Button btn_color14;
    private Button btn_color15;
    private Button btn_color16;
    private Button btn_color17;
    private Button btn_color18;
    private Button btn_color19;
    private Button btn_color20;
    private int [] arrayColorlayout = new int[40];

    private Button btn_nav_tv;
    //private Button btn_nav_lig;
    private Button btn_nav_win;
    private Button btn_nav_table;
    private Button btn_nav_set;

    private int nCheckedDev;
    private String send_string;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBluetoothLeService = ((DeviceScanActivity)DeviceScanActivity.mainThis).mBluetoothLeService;
        mWriteCharacteristic = ((DeviceScanActivity)DeviceScanActivity.mainThis).mWriteCharacteristic;

        //<!-- No Title Bar-->
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //<!-- No Title Bar-->
        setContentView(R.layout.activity_light_ctrl);




        // 레이아웃에서 버튼 id 가져오기.
        btn_center = (Button) findViewById(R.id.btn_center);
        btn_wall = (Button) findViewById(R.id.btn_wall);
        btn_galaxy = (Button) findViewById(R.id.btn_galaxy);
        btn_roof = (ToggleButton) findViewById(R.id.btn_roof);
        btn_partition = (ToggleButton) findViewById(R.id.btn_partition);

        btn_down = (Button) findViewById(R.id.btn_down);
        btn_up = (Button) findViewById(R.id.btn_up);
        btn_power = (Button) findViewById(R.id.btn_power);

        btn_color1  = (Button) findViewById(R.id.btn_color1 );
        btn_color2  = (Button) findViewById(R.id.btn_color2 );
        btn_color3  = (Button) findViewById(R.id.btn_color3 );
        btn_color4  = (Button) findViewById(R.id.btn_color4 );
        btn_color5  = (Button) findViewById(R.id.btn_color5 );
        btn_color6  = (Button) findViewById(R.id.btn_color6 );
        btn_color7  = (Button) findViewById(R.id.btn_color7 );
        btn_color8  = (Button) findViewById(R.id.btn_color8 );
        btn_color9  = (Button) findViewById(R.id.btn_color9 );
        btn_color10 = (Button) findViewById(R.id.btn_color10);
        btn_color11 = (Button) findViewById(R.id.btn_color11);
        btn_color12 = (Button) findViewById(R.id.btn_color12);
        btn_color13 = (Button) findViewById(R.id.btn_color13);
        btn_color14 = (Button) findViewById(R.id.btn_color14);
        btn_color15 = (Button) findViewById(R.id.btn_color15);
        btn_color16 = (Button) findViewById(R.id.btn_color16);
        btn_color17 = (Button) findViewById(R.id.btn_color17);
        btn_color18 = (Button) findViewById(R.id.btn_color18);
        btn_color19 = (Button) findViewById(R.id.btn_color19);
        btn_color20 = (Button) findViewById(R.id.btn_color20);

        btn_nav_tv = (Button) findViewById(R.id.btn_nav_tv);
        btn_nav_win = (Button) findViewById(R.id.btn_nav_win);
        btn_nav_table = (Button) findViewById(R.id.btn_nav_table);
        btn_nav_set = (Button) findViewById(R.id.btn_nav_set);

        // 해당 버튼에 레이아웃 설정하기.
        btn_center.setBackgroundResource(R.layout.btn_center);
        btn_wall.setBackgroundResource(R.layout.btn_wall);
        btn_galaxy.setBackgroundResource(R.layout.btn_galaxy);
        btn_roof.setBackgroundResource(R.layout.btn_roof);
        btn_partition.setBackgroundResource(R.layout.btn_partition);

        btn_down.setBackgroundResource(R.layout.btn_down);
        btn_up.setBackgroundResource(R.layout.btn_up);
        btn_power.setBackgroundResource(R.layout.btn_power);

        arrayColorlayout[0 ] = R.layout.btn_color0 ;
        arrayColorlayout[1 ] = R.layout.btn_color1 ;
        arrayColorlayout[2 ] = R.layout.btn_color2 ;
        arrayColorlayout[3 ] = R.layout.btn_color3 ;
        arrayColorlayout[4 ] = R.layout.btn_color4 ;
        arrayColorlayout[5 ] = R.layout.btn_color5 ;
        arrayColorlayout[6 ] = R.layout.btn_color6 ;
        arrayColorlayout[7 ] = R.layout.btn_color7 ;
        arrayColorlayout[8 ] = R.layout.btn_color8 ;
        arrayColorlayout[9 ] = R.layout.btn_color9 ;
        arrayColorlayout[10] = R.layout.btn_color10;
        arrayColorlayout[11] = R.layout.btn_color11;
        arrayColorlayout[12] = R.layout.btn_color12;
        arrayColorlayout[13] = R.layout.btn_color13;
        arrayColorlayout[14] = R.layout.btn_color14;
        arrayColorlayout[15] = R.layout.btn_color15;
        arrayColorlayout[16] = R.layout.btn_color16;
        arrayColorlayout[17] = R.layout.btn_color17;
        arrayColorlayout[18] = R.layout.btn_color18;
        arrayColorlayout[19] = R.layout.btn_color19;
        arrayColorlayout[20] = R.layout.btn_color20;
        arrayColorlayout[21] = R.layout.btn_color21;
        arrayColorlayout[22] = R.layout.btn_color22;
        arrayColorlayout[23] = R.layout.btn_color23;
        arrayColorlayout[24] = R.layout.btn_color24;
        arrayColorlayout[25] = R.layout.btn_color25;
        arrayColorlayout[26] = R.layout.btn_color26;
        arrayColorlayout[27] = R.layout.btn_color27;
        arrayColorlayout[28] = R.layout.btn_color28;
        arrayColorlayout[29] = R.layout.btn_color29;
        arrayColorlayout[30] = R.layout.btn_color30;
        arrayColorlayout[31] = R.layout.btn_color31;
        arrayColorlayout[32] = R.layout.btn_color32;
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        arrayColorlayout[35] = arrayColorlayout[pref.getInt ("sub_color_index1", 0)];
        arrayColorlayout[36] = arrayColorlayout[pref.getInt ("sub_color_index2", 0)];
        arrayColorlayout[37] = arrayColorlayout[pref.getInt ("sub_color_index3", 0)];
        arrayColorlayout[38] = arrayColorlayout[pref.getInt ("sub_color_index4", 0)];

        btn_color1 .setBackgroundResource(arrayColorlayout[1 ]); // red
        btn_color2 .setBackgroundResource(arrayColorlayout[11]); // light green
        btn_color3 .setBackgroundResource(arrayColorlayout[21]); // blue
        btn_color4 .setBackgroundResource(arrayColorlayout[31]); // snow
        btn_color5 .setBackgroundResource(arrayColorlayout[3 ]); // tomato
        btn_color6 .setBackgroundResource(arrayColorlayout[13]); // aquamarine
        btn_color7 .setBackgroundResource(arrayColorlayout[22]); // medium blue
        btn_color8 .setBackgroundResource(arrayColorlayout[35]); ///////////////
        btn_color9 .setBackgroundResource(arrayColorlayout[5 ]); // orange
        btn_color10.setBackgroundResource(arrayColorlayout[15]); // aqua
        btn_color11.setBackgroundResource(arrayColorlayout[25]); // dark violet
        btn_color12.setBackgroundResource(arrayColorlayout[36]); ///////////////
        btn_color13.setBackgroundResource(arrayColorlayout[7 ]); // gold
        btn_color14.setBackgroundResource(arrayColorlayout[17]); // deep sky blue
        btn_color15.setBackgroundResource(arrayColorlayout[26]); // blue violet
        btn_color16.setBackgroundResource(arrayColorlayout[37]); ///////////////
        btn_color17.setBackgroundResource(arrayColorlayout[9 ]); // green yellow
        btn_color18.setBackgroundResource(arrayColorlayout[19]); // dodger blue
        btn_color19.setBackgroundResource(arrayColorlayout[28]); // magenta
        btn_color20.setBackgroundResource(arrayColorlayout[38]); ///////////////


        btn_nav_tv.setBackgroundResource(R.layout.btn_nav_tv);
        btn_nav_win.setBackgroundResource(R.layout.btn_nav_win);
        btn_nav_table.setBackgroundResource(R.layout.btn_nav_table);
        btn_nav_set.setBackgroundResource(R.layout.btn_nav_set);


        // 해당 버튼에 클릭이벤트 설정하기.
        btn_center.setOnClickListener(mClickButtonListener);
        btn_wall.setOnClickListener(mClickButtonListener);
        btn_galaxy.setOnClickListener(mClickButtonListener);
        btn_roof.setOnClickListener(mClickButtonListener);
        btn_partition.setOnClickListener(mClickButtonListener);

        btn_down.setOnClickListener(mClickButtonListener);
        btn_up.setOnClickListener(mClickButtonListener);
        btn_power.setOnClickListener(mClickButtonListener);

        btn_color1 .setOnClickListener(mClickButtonListener);
        btn_color2 .setOnClickListener(mClickButtonListener);
        btn_color3 .setOnClickListener(mClickButtonListener);
        btn_color4 .setOnClickListener(mClickButtonListener);
        btn_color5 .setOnClickListener(mClickButtonListener);
        btn_color6 .setOnClickListener(mClickButtonListener);
        btn_color7 .setOnClickListener(mClickButtonListener);
        btn_color8 .setOnClickListener(mClickButtonListener);
        btn_color9 .setOnClickListener(mClickButtonListener);
        btn_color10.setOnClickListener(mClickButtonListener);
        btn_color11.setOnClickListener(mClickButtonListener);
        btn_color12.setOnClickListener(mClickButtonListener);
        btn_color13.setOnClickListener(mClickButtonListener);
        btn_color14.setOnClickListener(mClickButtonListener);
        btn_color15.setOnClickListener(mClickButtonListener);
        btn_color16.setOnClickListener(mClickButtonListener);
        btn_color13.setOnClickListener(mClickButtonListener);
        btn_color14.setOnClickListener(mClickButtonListener);
        btn_color15.setOnClickListener(mClickButtonListener);
        btn_color16.setOnClickListener(mClickButtonListener);
        btn_color17.setOnClickListener(mClickButtonListener);
        btn_color18.setOnClickListener(mClickButtonListener);
        btn_color19.setOnClickListener(mClickButtonListener);
        btn_color20.setOnClickListener(mClickButtonListener);

        btn_nav_tv.setOnClickListener(mClickButtonListener);
        btn_nav_win.setOnClickListener(mClickButtonListener);
        btn_nav_table.setOnClickListener(mClickButtonListener);
        btn_nav_set.setOnClickListener(mClickButtonListener);

        btn_color8.setOnLongClickListener(mLongClickButtonListener);
        btn_color12.setOnLongClickListener(mLongClickButtonListener);
        btn_color16.setOnLongClickListener(mLongClickButtonListener);
        btn_color20.setOnLongClickListener(mLongClickButtonListener);

        // 버전 보네기
        ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData("CA  0201");
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

            case R.id.btn_color1:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "FF0000" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color2:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "90EE90" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color3:

                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "0000FF" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color4:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "FFFAFA" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color5:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "FF6347" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color6:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "7FFFD4" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color7:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "0000CD" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color8:

                break;
            case R.id.btn_color9:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "FFA500" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color10:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "00FFFF" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color11:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "9400D3" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color12:

                break;
            case R.id.btn_color13:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "FFD700" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color14:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "00BFFF" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color15:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "8A2BE2" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color16:
                break;
            case R.id.btn_color17:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "ADFF2F" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color18:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "1E90FF" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color19:
                nCheckedDev = 0;
                send_string = "";
                if(btn_roof.isChecked())
                    nCheckedDev += 1;
                if(btn_partition.isChecked())
                    nCheckedDev += 2;
                if(nCheckedDev>0){
                    send_string = String.format( "%s%02d%s" , "CCCC08", nCheckedDev, "FF00FF" );
                    ((DeviceScanActivity)DeviceScanActivity.mainThis).SendStringData(send_string);
                }
                break;
            case R.id.btn_color20:
                break;
        }
        }
    };

    Button.OnLongClickListener mLongClickButtonListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            if( view.getId() == R.id.btn_color8 ) {
                Intent intent_color = new Intent();
                intent_color.putExtra("next_activity", "color");
                intent_color.putExtra("btn_color_index", "1");
                setResult(Activity.RESULT_OK, intent_color);
                finish();
            } else if( view.getId() == R.id.btn_color12 ) {
                Intent intent_color = new Intent();
                intent_color.putExtra("next_activity", "color");
                intent_color.putExtra("btn_color_index", "2");
                setResult(Activity.RESULT_OK, intent_color);
                finish();
            } else if( view.getId() == R.id.btn_color16 ) {
                Intent intent_color = new Intent();
                intent_color.putExtra("next_activity", "color");
                intent_color.putExtra("btn_color_index", "3");
                setResult(Activity.RESULT_OK, intent_color);
                finish();
            } else if( view.getId() == R.id.btn_color20 ) {
                Intent intent_color = new Intent();
                intent_color.putExtra("next_activity", "color");
                intent_color.putExtra("btn_color_index", "4");
                setResult(Activity.RESULT_OK, intent_color);
                finish();
            }
            return false;
        }
    };

    @Override public void onBackPressed()
    {
        //super.onBackPressed();
        //finish();
    }
}


