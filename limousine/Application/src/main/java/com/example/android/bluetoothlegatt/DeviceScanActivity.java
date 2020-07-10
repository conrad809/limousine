/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.bluetoothlegatt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Activity for scanning and displaying available Bluetooth LE devices.
 */
public class DeviceScanActivity extends ListActivity {
    private final static String TAG = BluetoothLeService.class.getSimpleName();
    public final String PREFERENCE = "com.example.android.bluetoothlegatt";


    private LeDeviceListAdapter mLeDeviceListAdapter;
    private BluetoothAdapter mBluetoothAdapter;
    private boolean mScanning;
    private Handler mHandler;
    public static Context mainThis;
    public BluetoothLeService mBluetoothLeService;
    public BluetoothGattCharacteristic mNotifyCharacteristic;
    public BluetoothGattCharacteristic mWriteCharacteristic;

    private static final int REQUEST_ENABLE_BT = 1;
    private static final int REQUEST_CONNECTION_BT = 2;
    private static final int REQUEST_ACTIVITY_SHOW = 3;

    // Stops scanning after 10 seconds.
    private static final long SCAN_PERIOD = 10000;

    private int mTimerCnt = 0;

    //private SharedPreferences preferences;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActionBar().setTitle(R.string.title_devices);
        mainThis = this;
        mHandler = new Handler();

        //<!-- No Title Bar-->
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //<!-- No Title Bar-->
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        //@SuppressLint("InvalidWakeLockTag") PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "DoNotDimScreen");

        //<!-- No Navigation Bar-->
        int newUiOptions = getWindow().getDecorView().getSystemUiVisibility();
//        int newUiOptions = uiOptions;
//        boolean isImmersiveModeEnabled = ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);
//        if (isImmersiveModeEnabled) {
//            Log.i("Is on?", "Turning immersive mode mode off. ");
//        } else {
//            Log.i("Is on?", "Turning immersive mode mode on.");
//        }
        // 몰입 모드를 꼭 적용해야 한다면 아래의 3가지 속성을 모두 적용시켜야 합니다
        newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
        //<!-- No Navigation Bar-->

        //setContentView(R.layout.listitem_device);

        //<!-- 기본 SharedPreferences 환경과 관련된 객체를 얻어옵니다. -->
        //preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //<!-- 기본 SharedPreferences 환경과 관련된 객체를 얻어옵니다. -->

        // Use this check to determine whether BLE is supported on the device.  Then you can
        // selectively disable BLE-related features.
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(this, R.string.ble_not_supported, Toast.LENGTH_SHORT).show();
            finish();
        }

        // Initializes a Bluetooth adapter.  For API level 18 and above, get a reference to
        // BluetoothAdapter through BluetoothManager.
        final BluetoothManager bluetoothManager =  (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();

        // Checks if Bluetooth is supported on the device.
        if (mBluetoothAdapter == null) {
            Toast.makeText(this, R.string.error_bluetooth_not_supported, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        Timer mTimer = new Timer();
        mTimer.schedule( time_task, 10*1000, 10*1000);
    }

    TimerTask time_task = new TimerTask() {
        @Override
        public void run() {
            scanLeDevice(true);

            if( mTimerCnt > 2 ) {
                time_task.cancel();
                Intent intentTvCtrl = new Intent(DeviceScanActivity.this, TvCtrlActivity.class);
                startActivityForResult(intentTvCtrl, REQUEST_ACTIVITY_SHOW);
            }
            ++mTimerCnt;
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        if (!mScanning) {
//            menu.findItem(R.id.menu_stop).setVisible(false);
//            menu.findItem(R.id.menu_scan).setVisible(true);
//            menu.findItem(R.id.menu_refresh).setActionView(null);
//        } else {
//            menu.findItem(R.id.menu_stop).setVisible(true);
//            menu.findItem(R.id.menu_scan).setVisible(false);
//            menu.findItem(R.id.menu_refresh).setActionView(R.layout.actionbar_indeterminate_progress);
//        }
//        return true;
        return false;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_scan:
//                mLeDeviceListAdapter.clear();
//                scanLeDevice(true);
//                break;
//            case R.id.menu_stop:
//                scanLeDevice(false);
//                break;
//        }
//        return true;
//    }

    @Override
    protected void onResume() {
        super.onResume();

        // Ensures Bluetooth is enabled on the device.  If Bluetooth is not currently enabled,
        // fire an intent to display a dialog asking the user to grant permission to enable it.
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

        // Initializes list view adapter.
        mLeDeviceListAdapter = new LeDeviceListAdapter();
        setListAdapter(mLeDeviceListAdapter);
        scanLeDevice(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // User chose not to enable Bluetooth.
        if (requestCode == REQUEST_ENABLE_BT && resultCode == Activity.RESULT_CANCELED) {
            finish();
            return;
        }
        if (requestCode == REQUEST_CONNECTION_BT && resultCode == Activity.RESULT_OK) {
            time_task.cancel();
            Intent intentTvCtrl=new Intent(DeviceScanActivity.this, TvCtrlActivity.class);
            startActivityForResult(intentTvCtrl, REQUEST_ACTIVITY_SHOW);
            //Intent intentLightCtrl=new Intent(DeviceScanActivity.this, LightCtrlActivity.class);
            //startActivityForResult(intentLightCtrl, REQUEST_ACTIVITY_TV);
            return;
        }

        if (requestCode == REQUEST_ACTIVITY_SHOW && resultCode == Activity.RESULT_OK) {

            if(data.getStringExtra("next_activity").equals("tv")) {
                Intent intentTvCtrl=new Intent(DeviceScanActivity.this, TvCtrlActivity.class);
                startActivityForResult(intentTvCtrl, REQUEST_ACTIVITY_SHOW);
            }
            if(data.getStringExtra("next_activity").equals("light")) {
                Intent intentLightCtrl=new Intent(DeviceScanActivity.this, LightCtrlActivity.class);
                startActivityForResult(intentLightCtrl, REQUEST_ACTIVITY_SHOW);
            }
            if(data.getStringExtra("next_activity").equals("window")) {
                Intent intentWindowCtrl=new Intent(DeviceScanActivity.this, WindowCtrlActivity.class);
                startActivityForResult(intentWindowCtrl, REQUEST_ACTIVITY_SHOW);
            }
            if(data.getStringExtra("next_activity").equals("table")) {
                Intent intentTableCtrl=new Intent(DeviceScanActivity.this, TableCtrlActivity.class);
                startActivityForResult(intentTableCtrl, REQUEST_ACTIVITY_SHOW);
            }
            if(data.getStringExtra("next_activity").equals("setting")) {
                Intent intentSettingCtrl=new Intent(DeviceScanActivity.this, SettingCtrlActivity.class);
                startActivityForResult(intentSettingCtrl, REQUEST_ACTIVITY_SHOW);
            }
            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPause() {
        super.onPause();
        scanLeDevice(false);
        mLeDeviceListAdapter.clear();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        final BluetoothDevice device = mLeDeviceListAdapter.getDevice(position);
        if (device == null) return;
        final Intent intent = new Intent(this, DeviceControlActivity.class);
        intent.putExtra(DeviceControlActivity.EXTRAS_DEVICE_NAME, device.getName());
        intent.putExtra(DeviceControlActivity.EXTRAS_DEVICE_ADDRESS, device.getAddress());

        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("dev_name", device.getName());
        editor.putString("dev_address", device.getAddress());
        //preferences.edit().apply();
        editor.commit();

        if (mScanning) {
            mBluetoothAdapter.stopLeScan(mLeScanCallback);
            mScanning = false;
        }
        startActivityForResult(intent, REQUEST_CONNECTION_BT);
    }

    private void scanLeDevice(final boolean enable) {
        if (enable) {
            // Stops scanning after a pre-defined scan period.
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mScanning = false;
                    mBluetoothAdapter.stopLeScan(mLeScanCallback);
                    //invalidateOptionsMenu();
                }
            }, SCAN_PERIOD);

            mScanning = true;
            mBluetoothAdapter.startLeScan(mLeScanCallback);
        } else {
            mScanning = false;
            mBluetoothAdapter.stopLeScan(mLeScanCallback);
        }
        //invalidateOptionsMenu();
    }

    // Adapter for holding devices found through scanning.
    private class LeDeviceListAdapter extends BaseAdapter {
        private ArrayList<BluetoothDevice> mLeDevices;
        private LayoutInflater mInflator;

        public LeDeviceListAdapter() {
            super();
            mLeDevices = new ArrayList<BluetoothDevice>();
            mInflator = DeviceScanActivity.this.getLayoutInflater();
        }

        public void addDevice(BluetoothDevice device) {
            if(!mLeDevices.contains(device)) {
                mLeDevices.add(device);
            }
        }

        public BluetoothDevice getDevice(int position) {
            return mLeDevices.get(position);
        }

        public void clear() {
            mLeDevices.clear();
        }

        @Override
        public int getCount() {
            return mLeDevices.size();
        }

        @Override
        public Object getItem(int i) {
            return mLeDevices.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            // General ListView optimization code.
            if (view == null) {
                view = mInflator.inflate(R.layout.listitem_device, null);
                viewHolder = new ViewHolder();
                viewHolder.deviceAddress = (TextView) view.findViewById(R.id.device_address);
                viewHolder.deviceName = (TextView) view.findViewById(R.id.device_name);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            BluetoothDevice device = mLeDevices.get(i);
            final String deviceName = device.getName();
            if (deviceName != null && deviceName.length() > 0)
                viewHolder.deviceName.setText(deviceName);
            else
                viewHolder.deviceName.setText(R.string.unknown_device);
            viewHolder.deviceAddress.setText(device.getAddress());

            return view;
        }
    }

    // Device scan callback.
    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {

        @Override
        public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLeDeviceListAdapter.addDevice(device);
                    mLeDeviceListAdapter.notifyDataSetChanged();

                    ////////////////////////////////////////////////////////////////////////////////////
                    SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
                    String dev_name = pref.getString("dev_name", "nothing");
                    Log.e(TAG, device.getName() + ":" + dev_name);

                    if( pref.contains("dev_name") == false ) return;
                    if (!dev_name.equals(device.getName())) return;


                    if (mScanning) {
                        mBluetoothAdapter.stopLeScan(mLeScanCallback);
                        mScanning = false;
                    }
                    Intent intent = new Intent(DeviceScanActivity.this, DeviceControlActivity.class);
                    intent.putExtra(DeviceControlActivity.EXTRAS_DEVICE_NAME, device.getName());
                    intent.putExtra(DeviceControlActivity.EXTRAS_DEVICE_ADDRESS, device.getAddress());
                    startActivityForResult(intent, REQUEST_CONNECTION_BT);
                    ////////////////////////////////////////////////////////////////////////////////////
                }
            });
        }
    };

    static class ViewHolder {
        TextView deviceName;
        TextView deviceAddress;
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static String byteArrayToHexString(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b&0xff));
        }
        return sb.toString();
    }

    // 문자열을 헥사 스트링으로 변환하는 메서드
    public static String stringToHex(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            result += String.format("%02X", (int) s.charAt(i));
        }

        return result;
    }


    // 헥사 접두사 "0x" 붙이는 버전
    public static String stringToHex0x(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            result += String.format("0x%02X", (int) s.charAt(i));
        }

        return result;
    }

    public static byte[] makeSendData(String s) {
        String hexString = "02" + stringToHex(s) + "03";
        return hexStringToByteArray(hexString);
    }

    public void SendStringData(String send_val) {
        try {
            Log.e(TAG, "SendStringData" + ":" + send_val);
            byte[] ByteArray = makeSendData(send_val);
            mWriteCharacteristic.setValue(ByteArray);
            mWriteCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
            mBluetoothLeService.writeCharacteristic(mWriteCharacteristic);
        } catch ( Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void SendChannelAlias(String channel_name) {
        try {
            SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
            String ch_number = pref.getString(channel_name, "0000");

            String strSendVer = "BB  05A" + ch_number;
            Log.e(TAG, "SendChannelAlias" + ":" + strSendVer);
            byte[] ByteArray = makeSendData(strSendVer);
            mWriteCharacteristic.setValue(ByteArray);
            mWriteCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
            mBluetoothLeService.writeCharacteristic(mWriteCharacteristic);
        } catch ( Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void SendKeyValue(String send_key) {
        try {
            String strSendVer = "BB  01" + send_key;
            Log.e(TAG, "SendKeyValue" + ":" + strSendVer);
            byte[] ByteArray = makeSendData(strSendVer);
            mWriteCharacteristic.setValue(ByteArray);
            mWriteCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
            mBluetoothLeService.writeCharacteristic(mWriteCharacteristic);
        } catch ( Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }
}
