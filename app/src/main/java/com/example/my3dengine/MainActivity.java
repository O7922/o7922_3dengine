package com.example.my3dengine;

import android.os.Bundle;

import android.view.Display;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button mode;
    my3d_engine mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //画面サイズ取得
        Display disp = getWindow().getWindowManager().getDefaultDisplay();
        int disp_w = disp.getWidth();
        int disp_h = disp.getHeight();

        setContentView(R.layout.activity_main);

        mv = findViewById(R.id.mv);

        //左側の前後左右ボタンの設定
        multi_button mb1 = findViewById(R.id.mb1);
        int button1[][] = {
                {2,0,2},
                {0,2,0},
                {2,0,2}
        };
        String button_txt1[][] = {
                {"","前",""},
                {"左","","右"},
                {"","後",""}
        };
        mb1.setXY(0 + disp_w/6,disp_h/2);//位置
        mb1.set_up_this(button1,button_txt1);

        //右ペインの上下ボタンの設定
        multi_button mb2 = findViewById(R.id.mb2);
        int button2[][] = {
                {2,0,2},
                {2,2,2},
                {2,0,2}
        };
        String button_txt2[][] = {
                {"","上",""},
                {"","",""},
                {"","下",""}
        };
        mb2.setXY(disp_w - disp_w/6,disp_h/2);//位置
        mb2.set_up_this(button2,button_txt2);

        mv.set_up_this(mb1,mb2);

    }
}