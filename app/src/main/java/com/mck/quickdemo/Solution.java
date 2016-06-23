package com.mck.quickdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class Solution extends Activity {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solution);

        adapter = new ArrayAdapter(this, R.layout.list_item, R.id.list_item_text);
        ListView listView = (ListView) findViewById(R.id.solutionListView);
        if (listView != null) {
            listView.setAdapter(adapter);
        }

        View view = findViewById(R.id.button);
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        setListData(1);
                    }
                }
            );
        }
        view = findViewById(R.id.button2);
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setListData(2);
                }
            });
        }
    }

    private synchronized void setListData(int number) {
            List<String> data = getData(number);
            adapter.clear();
            for (String item: data){
                adapter.add(item);
            }
            adapter.notifyDataSetChanged();
    }

    public List<String> getData(int index) throws IndexOutOfBoundsException {
        switch(index){
            case 1:
                return Arrays.asList(getResources().getStringArray(R.array.list_one));
            case 2:
                return Arrays.asList(getResources().getStringArray(R.array.list_two));
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
}
