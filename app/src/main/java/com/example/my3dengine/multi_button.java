package com.example.my3dengine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.util.AttributeSet;

//操作ボタン用クラス
public class multi_button extends View {

    Paint zPaint = new Paint();
    Paint gPaint = new Paint();
    int disp_w,disp_h;
    float standard_size;
    int tX,tY;
    boolean start = true;

    int button[][] = {
            {2,0,2},
            {0,2,0},
            {2,0,2}
    };

    public multi_button(Context context, AttributeSet attrs){
        super(context,attrs);
        zPaint.setTextSize(30);
        gPaint.setColor(Color.GRAY);
    }

    public void set_up_this(int b[][]){
        button = b;
    }

    public void setXY(int x,int y){
        tX = x;
        tY = y;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        disp_w = this.getWidth();
        disp_h = this.getHeight();
        standard_size = (float) disp_w / (float)3;
    }

    public void onDraw(Canvas canvas){
        invalidate();

        canvas.drawColor(0);

        //位置設定
        if(start == true){
            setX(tX-disp_w/2);
            setY(tY-disp_h/2);
            start = false;
        }

        //描画
        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 3; j ++){
                if(button[i][j] == 0){
                    canvas.drawRect(j * standard_size,i*standard_size,j*standard_size+standard_size,i*standard_size+standard_size,zPaint);
                }
                if(button[i][j] == 1){
                    canvas.drawRect(j * standard_size,i*standard_size,j*standard_size+standard_size,i*standard_size+standard_size,gPaint);
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event){

        int EX = (int)(event.getX()/standard_size);
        int EY = (int)(event.getY()/standard_size);

        if(0 <= EX && EX < 3 && 0<= EY && EY < 3){
            //全てのボタンをオフにする
            for (int i = 0; i < 3; i ++){
                for (int j = 0; j < 3; j ++){
                    if(button[i][j] == 1){
                        button[i][j] = 0;
                    }
                }
            }
            //指の位置に合わせてどのボタンが押されているか判別しそのボタンをオンにする
            if(button[EY][EX] == 0){
                button[EY][EX] = 1;
            }
        }

        int action = event.getAction();

        //画面から指が離れた時全てのボタンをオフにする
        switch (action){
            case MotionEvent.ACTION_UP:
                for (int i = 0; i < 3; i ++){
                    for (int j = 0; j < 3; j ++){
                        if(button[i][j] == 1){
                            button[i][j] = 0;
                        }
                    }
                }
                break;
        }

        return true;
    }

}
