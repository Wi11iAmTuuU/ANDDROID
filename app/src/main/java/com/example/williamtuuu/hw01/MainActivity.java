package com.example.williamtuuu.hw01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner SpinSex;
    private String sSex;
    private Button mBtnOK;
    private TextView mTxtR;
    private RadioGroup RadGrpAge;
    private RadioButton RadBtnAgeRange1, RadBtnAgeRange2, RadBtnAgeRange3;
    private TextView mTxtNumFamily;
    private NumberPicker mNumPkrFamily;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpinSex = (Spinner) findViewById(R.id.spnSex);
        mBtnOK = (Button) findViewById(R.id.btnOK);
        mTxtR = (TextView) findViewById(R.id.txtR);
        RadGrpAge = (RadioGroup) findViewById(R.id.radGrpAge);
        RadBtnAgeRange1 = (RadioButton) findViewById(R.id.radBtnAgeRange1);
        RadBtnAgeRange2 = (RadioButton) findViewById(R.id.radBtnAgeRange2);
        RadBtnAgeRange3 = (RadioButton) findViewById(R.id.radBtnAgeRange3);
        mTxtNumFamily = (TextView) findViewById(R.id.txtNumFamily);
        mNumPkrFamily = (NumberPicker) findViewById(R.id.numPkrFamply);
        mNumPkrFamily.setMinValue(0);
        mNumPkrFamily.setMaxValue(20);
        mNumPkrFamily.setValue(3);

        SpinSex.setOnItemSelectedListener(spnOnItemSelect);
        mNumPkrFamily.setOnValueChangedListener(numPkrFamilyOnValueChange);
        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private AdapterView.OnItemSelectedListener spnOnItemSelect = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sSex = parent.getSelectedItem().toString();

            switch (sSex) {
                case "male":
                    RadBtnAgeRange1.setText(getString(R.string.maleAgeS));
                    RadBtnAgeRange2.setText(getString(R.string.maleAgeM));
                    RadBtnAgeRange3.setText(getString(R.string.maleAgeL));
                    break;
                case "female":
                    RadBtnAgeRange1.setText(getString(R.string.femaleAgeS));
                    RadBtnAgeRange2.setText(getString(R.string.femaleAgeM));
                    RadBtnAgeRange3.setText(getString(R.string.femaleAgeL));
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private NumberPicker.OnValueChangeListener numPkrFamilyOnValueChange = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            mTxtNumFamily.setText(String.valueOf(newVal));
        }
    };

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            String strSex = SpinSex.getSelectedItem().toString();
            int iAgeRange = 0;

            switch (RadGrpAge.getCheckedRadioButtonId()) {
                case R.id.radBtnAgeRange1:
                    iAgeRange = 1;
                    break;
                case R.id.radBtnAgeRange2:
                    iAgeRange = 2;
                    break;
                case R.id.radBtnAgeRange3:
                    iAgeRange = 3;
                    break;
            }
            int numFamily = mNumPkrFamily.getValue();

            String strSug = "建議：";

            if (strSex.equals("male")) {
                switch (iAgeRange) {
                    case 1:
                        if ((numFamily < 4) || (numFamily >= 4 && numFamily <= 10))
                            strSug += "趕快結婚";
                        else
                            strSug += "還不急";
                        break;
                    case 2:
                        if (numFamily < 4)
                            strSug += "趕快結婚";
                        else if (numFamily >= 4 && numFamily <= 10)
                            strSug += "開始找對象";
                        else
                            strSug += "還不急";
                        break;
                    case 3:
                        if (numFamily >= 4 && numFamily <= 10)
                            strSug += "趕快結婚";
                        else
                            strSug += "開始找對象";
                        break;
                }
            } else {
                switch (iAgeRange) {
                    case 1:
                        if ((numFamily < 4) || (numFamily >= 4 && numFamily <= 10))
                            strSug += "趕快結婚";
                        else
                            strSug += "還不急";
                        break;
                    case 2:
                        if (numFamily < 4)
                            strSug += "趕快結婚";
                        else if (numFamily >= 4 && numFamily <= 10)
                            strSug += "開始找對象";
                        else
                            strSug += "還不急";
                        break;
                    case 3:
                        if (numFamily >= 4 && numFamily <= 10)
                            strSug += "趕快結婚";
                        else
                            strSug += "開始找對象";
                        break;
                }

                mTxtR.setText(strSug);
            }
        }
    };
}

