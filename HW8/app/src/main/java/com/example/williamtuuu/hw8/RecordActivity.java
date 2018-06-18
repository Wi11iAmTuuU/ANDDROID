package com.example.williamtuuu.hw8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by user on 2018/5/15.
 */

public class RecordActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_record);

        Intent intent = getIntent();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        adapter.addAll(intent.getStringArrayListExtra("itemList"));
        ((ListView) findViewById(R.id.RecordList)).setAdapter(adapter);
    }
}
