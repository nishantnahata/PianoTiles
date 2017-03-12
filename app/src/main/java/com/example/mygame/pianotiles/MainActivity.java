package com.example.mygame.pianotiles;

import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public static final String MAXTILES="MaxTiles";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Intent get=getIntent();
        final int maxtiles=get.getIntExtra(Main4Activity.TILES,0);
        System.out.println(maxtiles);
//        Intent i = new Intent(this,Main2Activity.class);
//        startActivity(i);
        Random r = new Random(SystemClock.uptimeMillis());
        final int a1 = r.nextInt(10000000) % 4;
        final int a2 = r.nextInt(10000000) % 4;
        final int a3 = r.nextInt(10000000) % 4;
        final int a4 = r.nextInt(10000000) % 4;
        final Button b1, b2, b3, b4, b6, b7, b8, b9, b11, b12, b13, b14, b16, b17, b18, b19;
        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        b6 = (Button) findViewById(R.id.btn6);
        b7 = (Button) findViewById(R.id.btn7);
        b8 = (Button) findViewById(R.id.btn8);
        b9 = (Button) findViewById(R.id.btn9);
        b11 = (Button) findViewById(R.id.btn11);
        b12 = (Button) findViewById(R.id.btn12);
        b13 = (Button) findViewById(R.id.btn13);
        b14 = (Button) findViewById(R.id.btn14);
        b16 = (Button) findViewById(R.id.btn16);
        b17 = (Button) findViewById(R.id.btn17);
        b18 = (Button) findViewById(R.id.btn18);
        b19 = (Button) findViewById(R.id.btn19);
        switch (a1) {
            case 0:
                b1.setBackgroundResource(R.color.Black);
                break;
            case 1:
                b2.setBackgroundResource(R.color.Black);
                break;
            case 2:
                b3.setBackgroundResource(R.color.Black);
                break;
            case 3:
                b4.setBackgroundResource(R.color.Black);
                break;
        }
        switch (a2) {
            case 0:
                b6.setBackgroundResource(R.color.Black);
                break;
            case 1:
                b7.setBackgroundResource(R.color.Black);
                break;
            case 2:
                b8.setBackgroundResource(R.color.Black);
                break;
            case 3:
                b9.setBackgroundResource(R.color.Black);
                break;
        }
        switch (a3) {
            case 0:
                b11.setBackgroundResource(R.color.Black);
                b11.setText("START");
                break;
            case 1:
                b12.setBackgroundResource(R.color.Black);
                b12.setText("START");
                break;
            case 2:
                b13.setBackgroundResource(R.color.Black);
                b13.setText("START");
                break;
            case 3:
                b14.setBackgroundResource(R.color.Black);
                b14.setText("START");
                break;
        }
        final Intent i = new Intent(this, Main2Activity.class);
        View.OnClickListener clickListener = new View.OnClickListener() {
            int c1 = a1, c2 = a2, c3 = a3, c4 = a4;
            Random r = new Random(SystemClock.uptimeMillis());
            Double score;
            int tiles=-1;
            double startTime=0;
            @Override
            public void onClick(View v) {

                if (tiles == -1) {
                    ((Button) v).setText("");
                    startTime = SystemClock.uptimeMillis();
                }
                score=(SystemClock.uptimeMillis()-startTime)/1000;
                tiles++;
                if(tiles==maxtiles)
                {
                    i.putExtra("SCORE",String.valueOf(score));
                    i.putExtra(MAXTILES,String.valueOf(maxtiles));
                    startActivity(i);
                }
                //Log.d(TAG, "onClick: has been called");
                    switch (v.getId()) {
                        case R.id.btn11:
                            switch (c3) {
                                case 0:
                                    v.setBackgroundResource(R.color.Grey);
                                    c4 = c3;
                                    c3 = c2;
                                    c2 = c1;
                                    if(tiles<=maxtiles-2) {
                                    c1 = r.nextInt((int) SystemClock.uptimeMillis()) % 4;
                                }
                                    else
                                    {
                                        c1=4;
                                    }
                                    switch (c1) {
                                        case 0:
                                            b1.setBackgroundResource(R.color.Black);
                                            b2.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b4.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b2.setBackgroundResource(R.color.Black);
                                            b1.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b4.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b3.setBackgroundResource(R.color.Black);
                                            b2.setBackgroundResource(R.color.White);
                                            b1.setBackgroundResource(R.color.White);
                                            b4.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b4.setBackgroundResource(R.color.Black);
                                            b2.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b1.setBackgroundResource(R.color.White);
                                            break;
                                        case 4:
                                            b4.setBackgroundResource(R.color.White);
                                            b2.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b1.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    switch (c2) {
                                        case 0:
                                            b6.setBackgroundResource(R.color.Black);
                                            b7.setBackgroundResource(R.color.White);
                                            b8.setBackgroundResource(R.color.White);
                                            b9.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b7.setBackgroundResource(R.color.Black);
                                            b8.setBackgroundResource(R.color.White);
                                            b9.setBackgroundResource(R.color.White);
                                            b6.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b8.setBackgroundResource(R.color.Black);
                                            b9.setBackgroundResource(R.color.White);
                                            b6.setBackgroundResource(R.color.White);
                                            b7.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b9.setBackgroundResource(R.color.Black);
                                            b6.setBackgroundResource(R.color.White);
                                            b7.setBackgroundResource(R.color.White);
                                            b8.setBackgroundResource(R.color.White);
                                            break;
                                        case 4:
                                            b9.setBackgroundResource(R.color.White);
                                            b6.setBackgroundResource(R.color.White);
                                            b7.setBackgroundResource(R.color.White);
                                            b8.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    switch (c3) {
                                        case 0:
                                            b11.setBackgroundResource(R.color.Black);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.Black);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.Black);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.Black);
                                            break;
                                        case 4:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    switch (c4) {
                                        case 0:
                                            b16.setBackgroundResource(R.color.Grey);
                                            b17.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            b19.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b17.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            b19.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b18.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b17.setBackgroundResource(R.color.White);
                                            b19.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b19.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b17.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            break;
                                        case 4:
                                            b19.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b17.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                                case 1:
                                    i.putExtra("SCORE", "FAILED");
                                    startActivity(i);
                                    break;
                                case 2:
                                    i.putExtra("SCORE", "FAILED");
                                    startActivity(i);
                                    break;
                                case 3:
                                    i.putExtra("SCORE", "FAILED");
                                    startActivity(i);
                                    break;
                            }
                            break;
                        case R.id.btn12:
                            switch (c3) {
                                case 1:
                                    c4 = c3;
                                    c3 = c2;
                                    c2 = c1;
                                    if(tiles<=maxtiles-2) {
                                        c1 = r.nextInt((int) SystemClock.uptimeMillis()) % 4;
                                    }
                                    else
                                    {
                                        c1=4;
                                    }
                                    switch (c1) {
                                        case 0:
                                            b1.setBackgroundResource(R.color.Black);
                                            b2.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b4.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b2.setBackgroundResource(R.color.Black);
                                            b1.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b4.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b3.setBackgroundResource(R.color.Black);
                                            b2.setBackgroundResource(R.color.White);
                                            b1.setBackgroundResource(R.color.White);
                                            b4.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b4.setBackgroundResource(R.color.Black);
                                            b2.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b1.setBackgroundResource(R.color.White);
                                            break;
                                        case 4:
                                            b4.setBackgroundResource(R.color.White);
                                            b2.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b1.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    switch (c2) {
                                        case 0:
                                            b6.setBackgroundResource(R.color.Black);
                                            b7.setBackgroundResource(R.color.White);
                                            b8.setBackgroundResource(R.color.White);
                                            b9.setBackgroundResource(R.color.White);

                                            break;
                                        case 1:
                                            b7.setBackgroundResource(R.color.Black);
                                            b8.setBackgroundResource(R.color.White);
                                            b9.setBackgroundResource(R.color.White);
                                            b6.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b8.setBackgroundResource(R.color.Black);
                                            b9.setBackgroundResource(R.color.White);
                                            b6.setBackgroundResource(R.color.White);
                                            b7.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b9.setBackgroundResource(R.color.Black);
                                            b6.setBackgroundResource(R.color.White);
                                            b7.setBackgroundResource(R.color.White);
                                            b8.setBackgroundResource(R.color.White);
                                            break;
                                        case 4:
                                            b9.setBackgroundResource(R.color.White);
                                            b6.setBackgroundResource(R.color.White);
                                            b7.setBackgroundResource(R.color.White);
                                            b8.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    switch (c3) {
                                        case 0:
                                            b11.setBackgroundResource(R.color.Black);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.Black);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.Black);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.Black);
                                            break;
                                        case 4:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    switch (c4) {
                                        case 0:
                                            b16.setBackgroundResource(R.color.Grey);
                                            b17.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            b19.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b17.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            b19.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b18.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b17.setBackgroundResource(R.color.White);
                                            b19.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b19.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b17.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                                case 0:
                                    i.putExtra("SCORE", "FAILED");
                                    startActivity(i);
                                    break;
                                case 2:
                                    i.putExtra("SCORE", "FAILED");
                                    startActivity(i);
                                    break;
                                case 3:
                                    i.putExtra("SCORE", "FAILED");
                                    startActivity(i);
                                    break;
                            }
                            break;
                        case R.id.btn13:
                            switch (c3) {
                                case 2:
                                    c4 = c3;
                                    c3 = c2;
                                    c2 = c1;
                                    if(tiles<=maxtiles-2) {
                                        c1 = r.nextInt((int) SystemClock.uptimeMillis()) % 4;
                                    }
                                    else
                                    {
                                        c1=4;
                                    }
                                    switch (c1) {
                                        case 0:
                                            b1.setBackgroundResource(R.color.Black);
                                            b2.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b4.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b2.setBackgroundResource(R.color.Black);
                                            b1.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b4.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b3.setBackgroundResource(R.color.Black);
                                            b2.setBackgroundResource(R.color.White);
                                            b1.setBackgroundResource(R.color.White);
                                            b4.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b4.setBackgroundResource(R.color.Black);
                                            b2.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b1.setBackgroundResource(R.color.White);
                                            break;
                                        case 4:
                                            b4.setBackgroundResource(R.color.White);
                                            b2.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b1.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    switch (c2) {
                                        case 0:
                                            b6.setBackgroundResource(R.color.Black);
                                            b7.setBackgroundResource(R.color.White);
                                            b8.setBackgroundResource(R.color.White);
                                            b9.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b7.setBackgroundResource(R.color.Black);
                                            b8.setBackgroundResource(R.color.White);
                                            b9.setBackgroundResource(R.color.White);
                                            b6.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b8.setBackgroundResource(R.color.Black);
                                            b9.setBackgroundResource(R.color.White);
                                            b6.setBackgroundResource(R.color.White);
                                            b7.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b9.setBackgroundResource(R.color.Black);
                                            b6.setBackgroundResource(R.color.White);
                                            b7.setBackgroundResource(R.color.White);
                                            b8.setBackgroundResource(R.color.White);
                                            break;
                                        case 4:
                                            b9.setBackgroundResource(R.color.White);
                                            b6.setBackgroundResource(R.color.White);
                                            b7.setBackgroundResource(R.color.White);
                                            b8.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    switch (c3) {
                                        case 0:
                                            b11.setBackgroundResource(R.color.Black);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.Black);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.Black);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.Black);
                                            break;
                                        case 4:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    switch (c4) {
                                        case 0:
                                            b16.setBackgroundResource(R.color.Grey);
                                            b17.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            b19.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b17.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            b19.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b18.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b17.setBackgroundResource(R.color.White);
                                            b19.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b19.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b17.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                                case 1:
                                    i.putExtra("SCORE", "FAILED");
                                    startActivity(i);
                                    break;
                                case 0:
                                    i.putExtra("SCORE", "FAILED");
                                    startActivity(i);
                                    break;
                                case 3:
                                    i.putExtra("SCORE", "FAILED");
                                    startActivity(i);
                                    break;
                            }
                            break;
                        case R.id.btn14:
                            switch (c3) {
                                case 3:
                                    c4 = c3;
                                    c3 = c2;
                                    c2 = c1;
                                    if(tiles<=maxtiles-2) {
                                        c1 = r.nextInt((int) SystemClock.uptimeMillis()) % 4;
                                    }
                                    else
                                    {
                                        c1=4;
                                    }
                                    switch (c1) {
                                        case 0:
                                            b1.setBackgroundResource(R.color.Black);
                                            b2.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b4.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b2.setBackgroundResource(R.color.Black);
                                            b1.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b4.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b3.setBackgroundResource(R.color.Black);
                                            b2.setBackgroundResource(R.color.White);
                                            b1.setBackgroundResource(R.color.White);
                                            b4.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b4.setBackgroundResource(R.color.Black);
                                            b2.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b1.setBackgroundResource(R.color.White);
                                            break;
                                        case 4:
                                            b4.setBackgroundResource(R.color.White);
                                            b2.setBackgroundResource(R.color.White);
                                            b3.setBackgroundResource(R.color.White);
                                            b1.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    switch (c2) {
                                        case 0:
                                            b6.setBackgroundResource(R.color.Black);
                                            b7.setBackgroundResource(R.color.White);
                                            b8.setBackgroundResource(R.color.White);
                                            b9.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b7.setBackgroundResource(R.color.Black);
                                            b8.setBackgroundResource(R.color.White);
                                            b9.setBackgroundResource(R.color.White);
                                            b6.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b8.setBackgroundResource(R.color.Black);
                                            b9.setBackgroundResource(R.color.White);
                                            b6.setBackgroundResource(R.color.White);
                                            b7.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b9.setBackgroundResource(R.color.Black);
                                            b6.setBackgroundResource(R.color.White);
                                            b7.setBackgroundResource(R.color.White);
                                            b8.setBackgroundResource(R.color.White);
                                            break;
                                        case 4:
                                            b9.setBackgroundResource(R.color.White);
                                            b6.setBackgroundResource(R.color.White);
                                            b7.setBackgroundResource(R.color.White);
                                            b8.setBackgroundResource(R.color.White);
                                            break;
                                        default:
                                            break;
                                    }
                                    switch (c3) {
                                        case 0:
                                            b11.setBackgroundResource(R.color.Black);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.Black);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.Black);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.Black);
                                            break;
                                        case 4:
                                            b11.setBackgroundResource(R.color.White);
                                            b12.setBackgroundResource(R.color.White);
                                            b13.setBackgroundResource(R.color.White);
                                            b14.setBackgroundResource(R.color.White);
                                            break;
                                        default:
                                            break;
                                    }
                                    switch (c4) {
                                        case 0:
                                            b16.setBackgroundResource(R.color.Grey);
                                            b17.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            b19.setBackgroundResource(R.color.White);
                                            break;
                                        case 1:
                                            b17.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            b19.setBackgroundResource(R.color.White);
                                            break;
                                        case 2:
                                            b18.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b17.setBackgroundResource(R.color.White);
                                            b19.setBackgroundResource(R.color.White);
                                            break;
                                        case 3:
                                            b19.setBackgroundResource(R.color.Grey);
                                            b16.setBackgroundResource(R.color.White);
                                            b17.setBackgroundResource(R.color.White);
                                            b18.setBackgroundResource(R.color.White);
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                                case 1:
                                    i.putExtra("SCORE", "FAILED");
                                    startActivity(i);
                                    break;
                                case 2:
                                    i.putExtra("SCORE", "FAILED");
                                    startActivity(i);
                                    break;
                                case 0:
                                    i.putExtra("SCORE", "FAILED");
                                    startActivity(i);
                                    break;
                            }
                            break;
                    }
                }
        };
        b11.setOnClickListener(clickListener);
        b12.setOnClickListener(clickListener);
        b13.setOnClickListener(clickListener);
        b14.setOnClickListener(clickListener);
    }
}

