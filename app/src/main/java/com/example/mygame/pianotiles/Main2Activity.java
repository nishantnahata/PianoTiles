package com.example.mygame.pianotiles;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    public static final String TRUE="true";
    public static final String TAG="Main2ctivity";
    Intent i=null;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        Log.d(TAG, "onCreate: has been called");
        i=new Intent(this,MainActivity.class);
        final Intent in=getIntent();
        final String score=in.getStringExtra("SCORE");
        final String tiles=in.getStringExtra(MainActivity.MAXTILES);
        TextView tvs=(TextView)findViewById(R.id.tvs);
        b1=(Button)findViewById(R.id.btnnwgme);
        b2=(Button)findViewById(R.id.btnqt);
        b3=(Button)findViewById(R.id.btnshare);
        if(score.equals("FAILED"))
        {
            ((TextView)findViewById(R.id.tvs)).setText(score);
            ((LinearLayout)findViewById(R.id.linear2)).setBackgroundResource(R.color.Red);
            b1.setBackgroundResource(R.color.Red);
            b2.setBackgroundResource(R.color.Red);
            b3.setBackgroundResource(R.color.Red);
        }
        else
        {
            ((TextView)findViewById(R.id.tvscore)).setText(score + "s");
        }
        final Intent i2=new Intent(this,Main4Activity.class);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i2);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(score.equals("FAILED"))
                {
                    Toast.makeText(Main2Activity.this, "You have failed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,"Hey I just completed "+String.valueOf(tiles)+" tiles in "+ score+"seconds!!\nTry my new app and download it...");
                    intent.putExtra(Intent.EXTRA_SUBJECT,"My Score!!");
                    startActivity(Intent.createChooser(intent,"Share..."));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i2=new Intent(this,Main5Activity.class);
        i2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i2.putExtra("EXIT", true);
        startActivity(i2);
//            super.onBackPressed();
    }

}
