package com.example.homework_1;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    public List<Notes> List = new ArrayList<>();


    ArrayList<String> datas = Init_data();

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int Item_id = item.getItemId();
        switch (Item_id){
            case R.id.rename_item:
                //写逻辑
                break;

            case R.id.delete_item:
                //
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FloatingActionButton add_button = findViewById(R.id.floatingActionButton);//实例化button


        ColorStateList colorStateList = ContextCompat.getColorStateList(getApplicationContext(),R.color.background);
        add_button.setBackgroundTintList(colorStateList);

        final RecyclerView recyclerView_1 = findViewById(R.id.recyclerView_1);//实体化recycler_view

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView_1.setLayoutManager(layoutManager);
        recyclerView_1.addItemDecoration(new RecyclerView.ItemDecoration() {       //修改recycler——view item的样式
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0, 10, 0, 10);
            }
        });
        final MyAdapter adapter = new MyAdapter(this,datas);
        recyclerView_1.setAdapter(adapter);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"按下了按钮",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
                startActivityForResult(intent, 1);;//输入按下的逻辑
            }

        }
        );

    }

    private ArrayList<String> Init_data() {
        ArrayList<String> datas = new ArrayList<>();
        for (int i=0;i < 1 ;i++){
            datas.add("content_"+i);
        }
        return datas;
    }
}
