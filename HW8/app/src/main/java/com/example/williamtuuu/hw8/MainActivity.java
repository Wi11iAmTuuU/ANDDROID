package com.example.williamtuuu.hw8;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner mTimeSpn;
    private Button mEnterBtn;
    private Button mRecordBtn;
    private EditText mDateTxt;
    private EditText mMoneyEdt;
    private DatePicker mDatepicker;

    private int timeNum;
    private  String date;

    private Intent Intent;
    private ArrayList<String> timeList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeSpn = (Spinner) findViewById(R.id.TimeSpinner);
        mEnterBtn = (Button) findViewById(R.id.BtnEnter);
        mRecordBtn = (Button) findViewById(R.id.BtnRecord);
        mDateTxt = (EditText) findViewById(R.id.EdtDate);
        mMoneyEdt = (EditText) findViewById(R.id.EdtMoney);
        mDatepicker= (DatePicker) findViewById(R.id.datePicker);

        mRecordBtn.setOnClickListener(RecordBtnOnclick);
        mEnterBtn.setOnClickListener(EnterBtnOnclick);
        mDatepicker.setOnDateChangedListener(onChanged);
    }

    private AdapterView.OnClickListener RecordBtnOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            Intent = new Intent(MainActivity.this, RecordActivity.class);
            Intent.putStringArrayListExtra("timeList", timeList);
            startActivity(Intent);
        }
    };
    private AdapterView.OnClickListener EnterBtnOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            String money = mMoneyEdt.getText().toString();
            if (money.matches("")) {
                Toast.makeText(MainActivity.this, "請輸入花費", Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                String timeNumStr = String.valueOf(timeNum);
                String item = "項目" + timeNumStr;
                Toast.makeText(MainActivity.this, money, Toast.LENGTH_SHORT).show();
                date = mDatepicker.getYear() + "/" + (mDatepicker.getMonth() + 1) + "/" + mDatepicker.getDayOfMonth();
                item += "            " + date + "           " + mTimeSpn.getSelectedItem().toString() + "           " + money;
                timeList.add(item);
                timeNum++;
            }
        }
    };
    private DatePicker.OnDateChangedListener onChanged = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String dateSelected = mDatepicker.getYear() + "/" + mDatepicker.getMonth() + "/" + mDatepicker.getDayOfMonth();
            mDateTxt.setText(dateSelected);
        }
    };
}
