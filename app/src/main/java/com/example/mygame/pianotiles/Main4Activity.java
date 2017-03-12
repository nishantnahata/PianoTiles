package com.example.mygame.pianotiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    public static final String TILES="Tiles";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main4);
        final Intent intent=new Intent(this,MainActivity.class);
        final ArrayList<String>tilelist=new ArrayList<>(10);
        tilelist.add("50 TILES");
        tilelist.add("100 TILES");
        tilelist.add("150 TILES");
        tilelist.add("200 TILES");
        tilelist.add("250 TILES");
        tilelist.add("300 TILES");
        tilelist.add("350 TILES");
        tilelist.add("400 TILES");
        tilelist.add("450 TILES");
        tilelist.add("500 TILES");
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tilelist);
        ListView lv=(ListView)findViewById(R.id.lv1);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent.putExtra(TILES,(position + 1)*50);
                startActivity(intent);
            }
        });
    }
}
