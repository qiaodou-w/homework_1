package com.example.homework_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private List<list_item> menulist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        initList();
        listviewAdapter adapter = new listviewAdapter(FirstActivity.this,R.layout.list_item,menulist);
        ListView listView = findViewById(R.id.listview);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list_item list_item = menulist.get(position);
                switch (list_item.getName()){
                    case "我的一天":
                        Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                        startActivity(intent);
                }
            }
        });
    }
    private void initList(){
        for (int i= 0;i<1;i++){
            list_item first = new list_item("我的一天");
            menulist.add(first);
            list_item second = new list_item("重要");
            menulist.add(second);

        }

    }

}
