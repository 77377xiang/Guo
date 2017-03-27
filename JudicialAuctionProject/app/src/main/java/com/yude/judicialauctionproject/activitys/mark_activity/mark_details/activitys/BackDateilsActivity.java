package com.yude.judicialauctionproject.activitys.mark_activity.mark_details.activitys;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.adapter.RecycleHolder;
import com.yude.judicialauctionproject.adapter.markadapter.CheckBoxRecyclerAdapter;
import com.yude.judicialauctionproject.adapter.markadapter.Pull_Mark_releaseComplteRecyclerAdapter;
import com.yude.judicialauctionproject.base.BaseActivity;
import com.yude.judicialauctionproject.entity.CheckBoxData;
import com.yude.judicialauctionproject.utils.LineDecoration;
import com.yude.judicialauctionproject.views.voice.AudioRecordButton;
import com.yude.judicialauctionproject.views.voice.MediaManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 回退理由
 */
public class BackDateilsActivity extends BaseActivity implements View.OnClickListener {
    EditText text_new_et;
    TextView tile_tv;
    ImageView l_title_iv, r_title_iv;

    RecyclerView checkbox_lv;
    Button ok_back_btn; //回退的按键
    List<CheckBoxData> checkboxDates;
    AudioRecordButton recordButton;  //录音按钮
    String filePath; //音频路径
    CheckBoxRecyclerAdapter adapter;
    // 存放录入
    private List<Recorder> mDatas = new ArrayList<BackDateilsActivity.Recorder>();

    @Override
    public int getContentViewId() {
        return R.layout.activity_dateils_back;
    }


    @Override
    protected void initViews(Bundle bundle) {
        checkbox_lv = (RecyclerView) findViewById(R.id.checkbox_lv);
        recordButton = (AudioRecordButton) findViewById(R.id.recordButton);
        ok_back_btn = (Button) findViewById(R.id.ok_back_btn);
        text_new_et = (EditText) findViewById(R.id.text_new_et);
        initTitle();
        initDate();
        checkbox_lv.setLayoutManager(new LinearLayoutManager(this));
        checkbox_lv.addItemDecoration(new LineDecoration(this, LineDecoration.VERTICAL_LIST));
        adapter = new CheckBoxRecyclerAdapter(checkboxDates, this);
        checkbox_lv.setAdapter(adapter);


        recordButton.setAudioFinishRecorderListener(new AudioRecordButton.AudioFinishRecorderListener() {
            @Override
            public void onFinished(float seconds, String filePath) {
                // this.filePath  = filePath;
                Recorder recorder = new Recorder(seconds, filePath);
                mDatas.add(recorder);

                //  mAdapter.notifyDataSetChanged();
                // mlistview.setSelection(mDatas.size() - 1);

                Log.e("filePath", filePath);

            }
        });


        ok_back_btn.setOnClickListener(this);
        l_title_iv.setOnClickListener(this);

        /*ok_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BackDateilsActivity.this, " 回退", Toast.LENGTH_LONG).show();
                playVoice();
                getCheckBoxData();
                getTextRemarks();
            }


        });*/


    }

    // 获取输入备注文字
    private String getTextRemarks() {

        String getTextRemarks = null;
        getTextRemarks = text_new_et.getText().toString().toString();

        if (getTextRemarks == null) {
            return null;
        } else {
            return getTextRemarks;
        }
    }


    // 播放语音
    private void playVoice() {

        if (mDatas.size() == 0) {

            Toast.makeText(BackDateilsActivity.this, "没有语音播报", Toast.LENGTH_LONG).show();

        } else {
            Log.e("filePath", "SSSSSSSSSSS");
            for (int i = 0; i < mDatas.size(); i++) {
                mDatas.get(i);
            }

            // 播放音频
            MediaManager.playSound(getApplicationContext(), mDatas.get(0).filePathString,
                    new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            //viewanim.setBackgroundResource(R.id.id_recorder_anim);
                            mDatas.clear();
                        }
                    });

        }

    }

    //  用来装选中CheckBox对应数据
    private List<String> getCheckBoxData = new ArrayList<>();

    //获取CheckBox对应数据
    private List<String> getCheckBoxData() {

        for (Map.Entry<Integer, Boolean> entry : (adapter.getMap()).entrySet()) {

            Log.e("Key Value", "Key =" + " + entry.getKey() + " + "Value = " + entry.getValue());

            if (entry.getValue() == true) {
                Log.e("Key", "Key =" + entry.getKey());
                // 获取到checkbox对应的文字
                checkboxDates.get(entry.getKey()).getTitle();
                Log.e("entry.getKey()", "" + checkboxDates.get(entry.getKey()).getTitle());

                getCheckBoxData.add(checkboxDates.get(entry.getKey()).getTitle());
            }
        }

        if (getCheckBoxData.size() == 0) {
            Toast.makeText(BackDateilsActivity.this, "请选择回退原因", Toast.LENGTH_LONG).show();
            return  null;
        }else {
            return getCheckBoxData;
        }

    }




    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        MediaManager.pause();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        MediaManager.resume();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        MediaManager.release();
    }


    @Override
    protected void initData() {

    }

    // 初始化title
    private void initTitle() {
        tile_tv = (TextView) findViewById(R.id.tile_tv);
        l_title_iv = (ImageView) findViewById(R.id.l_title_iv);
        r_title_iv = (ImageView) findViewById(R.id.r_title_iv);
        tile_tv.setText("回退");
        l_title_iv.setImageResource(R.mipmap.h_fanhui);
        l_title_iv.setVisibility(View.VISIBLE);
        // r_title_iv.setImageResource(R.mipmap.h_guanzhu_t);
        r_title_iv.setVisibility(View.INVISIBLE);

        /*l_title_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });*/
    }





    // 原因列表数据源
    private void initDate() {
        checkboxDates = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            CheckBoxData checkBoxData = new CheckBoxData();
            checkBoxData.setTitle(" 房产不符");
            checkBoxData.setPicture(R.mipmap.h_guanzhu_t);
            checkBoxData.setChecked(false);
            checkboxDates.add(checkBoxData);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //标的
            case R.id.l_title_iv :
                finish();
            break;

            case  R.id.ok_back_btn :
                Toast.makeText(BackDateilsActivity.this, " 回退", Toast.LENGTH_LONG).show();
                playVoice();
                getCheckBoxData();
                getTextRemarks();
            break;

        }


    }


    class Recorder {
        float time;
        String filePathString;

        public Recorder(float time, String filePathString) {
            super();
            this.time = time;
            this.filePathString = filePathString;
        }

        public float getTime() {
            return time;
        }

        public void setTime(float time) {
            this.time = time;
        }

        public String getFilePathString() {
            return filePathString;
        }

        public void setFilePathString(String filePathString) {
            this.filePathString = filePathString;
        }
    }




}



