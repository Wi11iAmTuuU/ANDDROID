package com.example.williamtuuu.hw7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Statistics  extends AppCompatActivity {
    private EditText ETCountSet,
            ETCountPlayerWin,
            ETCountComWin,
            ETCountDraw;

    private Button mBtnBack;


    private Intent mIntent = new Intent();
    private Bundle mBundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_statistics);

        ETCountSet = (EditText) findViewById(R.id.edtCountSet);
        ETCountPlayerWin = (EditText) findViewById(R.id.edtCountPlayerWin);
        ETCountComWin = (EditText) findViewById(R.id.edtCountComWin);
        ETCountDraw = (EditText) findViewById(R.id.edtCountDraw);
        mBtnBack = (Button) findViewById(R.id.BtnBack);
        mIntent = getIntent();
        mBundle = mIntent.getExtras();

        ShowResult();
        mBtnBack.setOnClickListener(btnOnClick);
    }

    private void ShowResult() {

        int roll = mBundle.getInt("Set") - mBundle.getInt("PlayerWin") -mBundle.getInt("ComWin");

        ETCountSet.setText(String.valueOf(mBundle.getInt("Set")));
        ETCountPlayerWin.setText(String.valueOf(mBundle.getInt("PlayerWin")));
        ETCountComWin.setText(String.valueOf(mBundle.getInt("ComWin")));
        ETCountDraw.setText(String.valueOf(roll));
    }

    private View.OnClickListener btnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //返回
            Log.v("countSet:", String.valueOf(mBundle.getInt("countSet")));
            Log.v("countPlayerWin:", String.valueOf(mBundle.getInt("countPlayerWin")));
            Log.v("countComWin", String.valueOf(mBundle.getInt("countComWin")));
            Log.v("countDraw", String.valueOf(mBundle.getInt("countDraw")));
            finish();
        }
    };
}
