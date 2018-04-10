package com.example.williamtuuu.hw01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner SpinAgeMale,SpinAgeFemale;
    private String sSex, sAge;
    private Button mBtnOK;
    private TextView mTxtR;
    private RadioGroup RadGrpSex;
    private RadioButton RadBtnSexMale,RadBtnSexFemale;
    private int iAgeRange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpinAgeMale = (Spinner) findViewById(R.id.spnAgeMale);
        SpinAgeFemale = (Spinner) findViewById(R.id.spnAgeFemale);
        mBtnOK = (Button) findViewById(R.id.btnOK);
        mTxtR = (TextView) findViewById(R.id.txtR);
        RadGrpSex = (RadioGroup) findViewById(R.id.radGrpSex);
        RadBtnSexMale = (RadioButton) findViewById(R.id.radBtnSexMale);
        RadBtnSexFemale = (RadioButton) findViewById(R.id.radBtnSexFemale);
        SpinAgeMale.setOnItemSelectedListener(spnOnItemSelect);
        SpinAgeFemale.setOnItemSelectedListener(spnOnItemSelect);
        mBtnOK.setOnClickListener(btnOKOnClick);
        RadGrpSex.setOnCheckedChangeListener(radGrpSexonCheckedChange);
    }

    private AdapterView.OnItemSelectedListener spnOnItemSelect = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sAge = parent.getSelectedItem().toString();

            if(sSex.equals("男性")){
                switch (sAge) {
                    case "小於30歲":
                        iAgeRange=1;
                        break;
                    case "30~40歲":
                        iAgeRange=2;
                        break;
                    case "大於40歲":
                        iAgeRange=3;
                        break;
                }
            }
            else{
                switch (sAge) {
                    case "小於28歲":
                        iAgeRange=1;
                        break;
                    case "28~35歲":
                        iAgeRange=2;
                        break;
                    case "大於35歲":
                        iAgeRange=3;
                        break;
                }
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private RadioGroup.OnCheckedChangeListener radGrpSexonCheckedChange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == R.id.radBtnSexMale) {
                sSex="男性";
            } else{
                sSex="女性";
            }
        }
    };

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            String strSug = "建議：";

            if (sSex.equals("男性")) {
                switch (iAgeRange) {
                    case 1:
                        strSug += "還不急";
                        break;
                    case 2:
                        strSug += "趕快結婚";
                        break;
                    case 3:
                        strSug += "開始找對象";
                        break;
                }
            } else {
                switch (iAgeRange) {
                    case 1:
                        strSug += "還不急";
                        break;
                    case 2:
                        strSug += "趕快結婚";
                        break;
                    case 3:
                        strSug += "開始找對象";
                        break;
                }

                mTxtR.setText(strSug);
            }
        }
    };
}

