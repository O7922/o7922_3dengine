package com.example.my3dengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MyView extends View {

    Paint zPaint = new Paint();
    Paint rPaint = new Paint();

    float siya = 200;

    float tX0=-919,tY0=1800,tZ0 = -800;
    double z_rad = 0;//プレイヤーの向き
    double rad;//プレイヤーの向き

    double s_z_rad = 0;//視点の向き
    double s_rad;//視点の向き

    boolean back_flg,front_flg,left_flg,right_flg,down_flg,up_flg;

    ArrayList<Polygon> Polygon_List = new ArrayList<Polygon>();

    //test tt;

    float centerX,centerY;

    float plX=0,plY=0,plZ=0;//プレイヤー座標

    float per_mode = 1;

    int uraomote = 1;

    multi_button mb1,mb2;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        zPaint.setTextSize(50);
        rPaint.setColor(Color.RED);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.tile0);
        Bitmap s_bmp = Bitmap.createScaledBitmap(bmp,1024,1024,true);
        Bitmap src_sky = BitmapFactory.decodeResource(getResources(),R.drawable.blue_sky01);
        Bitmap sky = Bitmap.createScaledBitmap(src_sky,869,597,true);
        Bitmap src_banmen = BitmapFactory.decodeResource(getResources(),R.drawable.banmen);
        Bitmap banmen = Bitmap.createScaledBitmap(src_banmen,360,360,true);
        Bitmap src_circle = BitmapFactory.decodeResource(getResources(),R.drawable.circle);
        Bitmap circle = Bitmap.createScaledBitmap(src_circle,120,120,true);
        Bitmap src_cross = BitmapFactory.decodeResource(getResources(),R.drawable.cross);
        Bitmap cross = Bitmap.createScaledBitmap(src_cross,120,120,true);




        //ポリゴンの配置

        Polygon_List.add(new Polygon(
                8000,8000,-8000,
                8001,-8000,-8000,
                8002,-8000,8000));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 8000;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 8000;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = 8000;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(Color.BLACK);
        Polygon_List.get(Polygon_List.size()-1).set_texture(s_bmp);

        Polygon_List.add(new Polygon(
                8000,8000,-8000,
                8001,-8000,-8000,
                8002,-8000,8000));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 8000;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 8000;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = 8000;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(Color.BLACK);
        Polygon_List.get(Polygon_List.size()-1).set_texture(s_bmp);

        Polygon_List.add(new Polygon(
                28000,46000,4000,
                38001,22000,4000,
                38002,22000,-12000));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 28000;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 46000;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = -12000;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(Color.BLACK);
        Polygon_List.get(Polygon_List.size()-1).set_texture(sky);

        Polygon_List.add(new Polygon(
                15000,25800,1800,
                15001,22200,1800,
                15002,22200,-1800));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 15000;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 25800;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = -1800;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(Color.BLACK);
        Polygon_List.get(Polygon_List.size()-1).set_texture(banmen);

        Polygon_List.add(new Polygon(
                15000,25800,600,
                15001,24600,600,
                15002,24600,-600));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 15000;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 25800;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = -600;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(Color.BLACK);
        Polygon_List.get(Polygon_List.size()-1).set_texture(cross);

        Polygon_List.add(new Polygon(
                15000,23400,-600,
                15001,22200,-600,
                15002,22200,-1800));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 15000;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 23400;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = -1800;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(Color.BLACK);
        Polygon_List.get(Polygon_List.size()-1).set_texture(cross);


        Polygon_List.add(new Polygon(
                15000,24600,600,
                15001,23400,600,
                15002,23400,-600));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 15000;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 24600;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = -600;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(Color.BLACK);
        Polygon_List.get(Polygon_List.size()-1).set_texture(circle);

        Polygon_List.add(new Polygon(
                15000,25800,1800,
                15001,24600,1800,
                15002,24600,600));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 15000;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 25800;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = 600;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(Color.BLACK);
        Polygon_List.get(Polygon_List.size()-1).set_texture(circle);

        Polygon_List.add(new Polygon(
                15000,23400,1800,
                15001,22200,1800,
                15002,22200,600));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 15000;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 23400;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = 600;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(Color.BLACK);
        Polygon_List.get(Polygon_List.size()-1).set_texture(circle);



        Polygon_List.add(new Polygon(
                6000,4000,-8000,
                6001,-8000,-8000,
                6002,-8000,-6000));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 6003;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 4000;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = -6000;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-5723992);
        Polygon_List.get(Polygon_List.size()-1).set_texture(s_bmp);

        Polygon_List.add(new Polygon(
                6000,4000,-8000,
                6001,2000,-8000,
                6002,2000,-6000));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 6003;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 4000;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = -6000;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-5723992);


        Polygon_List.add(new Polygon(
                6000,-8000,-8000,
                6001,-24000,-8000,
                6002,-24000,-6000));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 6003;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = -8000;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = -6000;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-5723992);
        Polygon_List.get(Polygon_List.size()-1).set_texture(s_bmp);

        Polygon_List.add(new Polygon(
                6000,8000,-8000,
                6001,6000,-8000,
                6002,6000,-6000));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = 6003;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 8000;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = -6000;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-5723992);

        Polygon_List.add(new Polygon(
                8001,80001,-8000,
                8000,-80001,-8001,
                -8001,-80000,-8002));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = -8000;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 80000;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = -8003;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-5723992);
        Polygon_List.get(Polygon_List.size()-1).set_texture(s_bmp);

        Polygon_List.add(new Polygon(
                -24000,8000,-8000,
                -24000,-8000,-8001,
                -8000,-8000,-8002));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = -8003;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 8000;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = -8000;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-5723992);
        Polygon_List.get(Polygon_List.size()-1).set_texture(s_bmp);



        Polygon_List.add(new Polygon(
                80001,8001,8000,
                80000,-8001,8001,
                -80001,-8000,8002));
        Polygon_List.get(Polygon_List.size()-1).ptX3 = -80000;
        Polygon_List.get(Polygon_List.size()-1).ptY3 = 8000;
        Polygon_List.get(Polygon_List.size()-1).ptZ3 = 8003;
        Polygon_List.get(Polygon_List.size()-1).to_Square();
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-5723992);
        Polygon_List.get(Polygon_List.size()-1).set_texture(s_bmp);



        Polygon_List.add(new Polygon(7000,10000,2000,6000,8000,-2000,5000,6000,2000));
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-14144);
        Polygon_List.add(new Polygon(1000,9000,2000,4000,8000,2000,2700,11000,-2000));
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-2172677);
        Polygon_List.add(new Polygon(1000,10000,-2000,5000,9000,-2000,3000,12000,-2000));
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-3671834);
        Polygon_List.add(new Polygon(1000,9000,-2000,4000,8000,-2000,2700,11000,-6000));
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-296);


        Polygon_List.add(new Polygon(0,2000,-6000,-2000,-2000,-6000,2000,-2000,-6000));
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-14144);
        Polygon_List.get(Polygon_List.size()-1).set_texture(s_bmp);
        Polygon_List.add(new Polygon(0,0,0,-2000,-2000,-6000,2000,-2000,-6000));
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-2172677);
        Polygon_List.get(Polygon_List.size()-1).set_texture(s_bmp);
        Polygon_List.add(new Polygon(0,2000,-6000,0,0,0,2000,-2000,-6000));
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-3671834);
        Polygon_List.get(Polygon_List.size()-1).set_texture(s_bmp);
        Polygon_List.add(new Polygon(0,2000,-6000,-2000,-2000,-6000,0,0,0));
        Polygon_List.get(Polygon_List.size()-1).pPaint.setColor(-296);
        Polygon_List.get(Polygon_List.size()-1).set_texture(s_bmp);


        for(int i = 0; i < 300; i++){
            Polygon_List.add(new Polygon(i*2000 +1000,10000,-2000,i*2000 +5000,9000,-2000,i*2000 +3000,12000,-2000));
            Polygon_List.get(Polygon_List.size()-1).set_texture(s_bmp);
        }

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        centerX = this.getWidth()/2;
        centerY = this.getHeight()/2;
    }

    public void set_up_this(multi_button mub1,multi_button mub2){
        mb1 = mub1;mb2 = mub2;
    }

    public void onDraw(Canvas canvas){

        invalidate();

        canvas.drawColor(Color.GRAY);

        if(mb1.button[0][1] == 1){//前進ボタン
            front_flg = true;
        }else {
            front_flg = false;
        }
        if(mb1.button[2][1] == 1){//後退ボタン
            back_flg = true;
        }else {
            back_flg = false;
        }
        if(mb1.button[1][0] == 1){//左ボタン
            left_flg = true;
        }else {
            left_flg = false;
        }
        if(mb1.button[1][2] == 1){//右ボタン
            right_flg = true;
        }else {
            right_flg = false;
        }

        if(mb2.button[0][1] == 1){//上昇ボタン
            up_flg = true;
        }else {
            up_flg = false;
        }
        if(mb2.button[2][1] == 1){//下降ボタン
            down_flg = true;
        }else {
            down_flg = false;
        }

        //視点座標操作
        if(back_flg == true){
            float xsp = (float)(160*Math.cos(rad));
            float ysp = (float)(160*Math.sin(rad));
            plX+=ysp*uraomote;
            plY+=xsp*uraomote;
        }
        if(front_flg == true){
            float xsp = (float)(160*Math.cos(rad));
            float ysp = (float)(160*Math.sin(rad));
            plX-=ysp*uraomote;
            plY-=xsp*uraomote;
        }
        if(left_flg == true){
            float xsp = (float)(160*Math.cos(rad));
            float ysp = (float)(160*Math.sin(rad));
            plX-=xsp*uraomote;
            plY+=ysp*uraomote;
        }
        if(right_flg == true){
            float xsp = (float)(160*Math.cos(rad));
            float ysp = (float)(160*Math.sin(rad));
            plX+=xsp*uraomote;
            plY-=ysp*uraomote;
        }
        if(down_flg == true){
            plZ -= 80;
        }
        if(up_flg == true){
            plZ += 80;
        }

        tX0 = plX;
        tY0 = plY;
        tZ0 = plZ;

        s_rad = rad;
        s_z_rad = z_rad;

        //draw_FLG(ソート用)の初期化と、ポリゴンのそれぞれの頂点と視点のユークリッド距離計算
        for(int i = 0; i < Polygon_List.size();i++){
            Polygon_List.get(i).get_AVG_Eu(tX0,tY0,tZ0);
            Polygon_List.get(i).draw_FLG = false;
        }
        //ポリゴンの描画処理。単に距離が遠いものからソートしつつ描画する。
        for(int i = 0; i < Polygon_List.size();i++){
            double max_AVG = 0;
            int draw_id = 0;
            for(int j = 0; j < Polygon_List.size();j++){
                if(Polygon_List.get(j).AVG_Eu > max_AVG && Polygon_List.get(j).draw_FLG == false){
                    max_AVG = Polygon_List.get(j).AVG_Eu;
                    draw_id = j;
                }
            }
            Polygon_List.get(draw_id).draw(canvas);//描画
            Polygon_List.get(draw_id).draw_FLG = true;//既に描画したものはdraw_FLGをtureに
        }

    }


    //ポリゴンクラス
    public class Polygon{
        boolean draw_FLG = false;

        Paint pPaint = new Paint();
        Bitmap texture;
        int bmp_width,bmp_height;

        float sa_rad1,sa_rad2,sa_rad3,sa_rad4;
        float zsa_rad1,zsa_rad2,zsa_rad3,zsa_rad4;
        double p_rad,true_p_rad;
        float kx,ky,kz;
        float data[][];
        float data2[][] = new float[6][3];
        int data_count = 0;
        int SquareOrTriangle = 1;//三角ポリゴンか四角ポリゴンか
        double AVG_Eu;//視点との距離
        float ptX0,ptY0,ptZ0,ptX1,ptY1,ptZ1,ptX2,ptY2,ptZ2,ptX3=0.1f,ptY3,ptZ3;    //頂点座標

        public Polygon(float OptX0,float OptY0,float OptZ0,float OptX1,float OptY1,float OptZ1,float OptX2,float OptY2,float OptZ2){
            ptX0 = OptX0; ptY0 = OptY0; ptZ0 = OptZ0;
            ptX1 = OptX1; ptY1 = OptY1; ptZ1 = OptZ1;
            ptX2 = OptX2; ptY2 = OptY2; ptZ2 = OptZ2;
        }

        public void draw(Canvas canvas){

            //境界線前の処理データ。三次元上で、全ての頂点を視線に合わせる
            data = new float[5][3];
            data_count = 0;
            //初期化
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 3; j ++){
                    data[i][j] = 0;
                }
            }
            //視点に頂点を揃える(回転)
            get_Data(ptX0,ptY0,ptZ0);
            data_count ++;
            get_Data(ptX1,ptY1,ptZ1);
            data_count ++;
            get_Data(ptX2,ptY2,ptZ2);
            if(ptX3 != 0.1f){
                data_count ++;
                get_Data(ptX3,ptY3,ptZ3);
            }

            //視点を中心に移動させることを考えるので、視点は0,0,0と考えればいいので移動する処理は不要。

            //境界線処理済みデータを生成。data2に入る
            int d_count = 0;
            data2 = new float[6][3];
            float border_wariai[][] = new float[4][2];
            for (int i =0; i <4;i++){
                border_wariai[i][0] = 1;
            }
            for(int i = 0; i <= data_count; i++){
                if(data[i][0] < 0){
                    for(int j = 0; j < 3; j ++){
                        data2[d_count][j] = data [i][j];
                    }
                    d_count ++;
                }
                float border[] = null;//境界線座標を格納する変数
                if(i < data_count){//0～末尾の線分はココで処理
                    border = get_border(data[i][0],data[i][1],data[i][2],data[i+1][0],data[i+1][1],data[i+1][2]);
                    if(border[0] != 99999){
                        for(int j = 0; j < 3; j ++){
                            data2[d_count][j] = border[j];
                        }
                        d_count ++ ;
                        border_wariai[i][0]=border[3];
                        border_wariai[i][1]=border[4];
                    }
                }else{//末尾-0の線分はココで処理
                    border = get_border(data[i][0],data[i][1],data[i][2],data[0][0],data[0][1],data[0][2]);
                    if(border[0] != 99999){
                        for(int j = 0; j < 3; j ++){
                            data2[d_count][j] = border[j];
                        }
                        d_count ++ ;
                        border_wariai[i][0]=border[3];
                        border_wariai[i][1]=border[4];
                    }
                }

            }

            //2次元座標に変換しpathクラスを使ってポリゴンを描画する
            float ans0[];
            Path path = new Path();
            for(int i = 0; i < d_count;i++){
                ans0 = get_2D_XY(data2[i][0],data2[i][1],data2[i][2]);
                if(i == 0){
                    path.moveTo((float)(centerX + ans0[0] * siya),(float)(centerY + ans0[1] * siya));
                    sa_rad1 = centerX + ans0[0] * siya;zsa_rad1=centerY + ans0[1] * siya;
                }else{
                    path.lineTo((float)(centerX + ans0[0] * siya),(float)(centerY + ans0[1] * siya));
                    if(i==1){
                        sa_rad2 = centerX + ans0[0] * siya;zsa_rad2=centerY + ans0[1] * siya;
                    }
                    if(i==2){
                        sa_rad3 = centerX + ans0[0] * siya;zsa_rad3=centerY + ans0[1] * siya;
                    }
                    if(i==3){
                        sa_rad4 = centerX + ans0[0] * siya;zsa_rad4=centerY + ans0[1] * siya;
                    }
                }
            }
            path.close();

            //テクスチャ貼り付け
            boolean rotate = false;//なぜか一方向から見た時だけ頂点を担当する変数がズレるのでその対策
            float sa_radw,zsa_radw;
            pPaint.setShader(null);
            if(texture != null && ((ptX3 != 0.1f && d_count == 4) || (ptX3 == 0.1f && d_count == 3))){
                float[] src = {
                        0,0,
                        bmp_width,0,
                        bmp_width,bmp_height,
                        0,bmp_height
                };
                //境界線の位置に合わせて元画像の切り取る位置を変更
                if(border_wariai[0][0] != 1){
                    if(border_wariai[0][1] == 0){
                        src[0] = bmp_width-bmp_width * border_wariai[0][0];
                    }
                    if(border_wariai[0][1] == 1){
                        src[2] = bmp_width * border_wariai[0][0];
                    }
                }
                if(border_wariai[1][0] != 1){
                    if(border_wariai[1][1] == 0){
                        src[3] = bmp_height-bmp_height * border_wariai[1][0];
                        rotate = true;
                    }
                    if(border_wariai[1][1] == 1){
                        src[5] = bmp_height * border_wariai[1][0];
                    }
                }
                if(border_wariai[2][0] != 1){
                    if(border_wariai[2][1] == 0){
                        src[4] = bmp_width * border_wariai[2][0];
                    }
                    if(border_wariai[2][1] == 1){
                        src[6] = bmp_width-bmp_width * border_wariai[2][0];
                    }
                }
                if(border_wariai[3][0] != 1){
                    if(border_wariai[3][1] == 0){
                        src[7] = bmp_height * border_wariai[3][0];
                    }
                    if(border_wariai[3][1] == 1){
                        src[1] = bmp_height-bmp_height * border_wariai[3][0];
                        rotate = true;
                    }
                }
                //一方向から見た時だけなぜかテクスチャが回転するからそれを正常に戻す
                if(rotate == true){
                    sa_radw = sa_rad4;zsa_radw = zsa_rad4;
                    sa_rad4 = sa_rad3;zsa_rad4 = zsa_rad3;
                    sa_rad3 = sa_rad2;zsa_rad3 = zsa_rad2;
                    sa_rad2 = sa_rad1;zsa_rad2 = zsa_rad1;
                    sa_rad1 = sa_radw;zsa_rad1 = zsa_radw;
                }
                //算出した座標をもとにシェーダー生成
                Matrix matrix = new Matrix();
                if(ptX3 != 0.1f){//4つの頂点を採用する場合
                    float[] dst = {
                            sa_rad1,zsa_rad1,
                            sa_rad2,zsa_rad2,
                            sa_rad3,zsa_rad3,
                            sa_rad4,zsa_rad4,
                    };
                    matrix.setPolyToPoly(src, 0, dst, 0, 4);
                }else{//3つの頂点を採用する場合
                    float[] dst = {
                            sa_rad1,zsa_rad1,
                            sa_rad2,zsa_rad2,
                            sa_rad3,zsa_rad3,
                    };
                    matrix.setPolyToPoly(src, 0, dst, 0, 3);
                }
                BitmapShader shader00 = new BitmapShader(texture, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
                shader00.setLocalMatrix(matrix);//paintに適用
                pPaint.setShader(shader00);
            }
            canvas.drawPath(path,pPaint);
        }

        //視点の裏側と表側の境界線に線分があれば検知し、境界線の場所でのxyz座標を算出する関数
        //視界の裏側の頂点をそのまま計算せず、位置を調整してから計算する
        public float[] get_border(float ptX1,float ptY1,float ptZ1,float ptX2,float ptY2,float ptZ2){
            float ans[] = new float[5];
            float wariai,sabun;
            float sX,sY,sZ;
            float kyoukai_wairai;
            if((ptX1 > 0 && 0 >= ptX2) || (ptX1 < 0 && 0 <= ptX2)){//任意の二点間の線分に境界線がある場合
                sabun = ptX2 - ptX1;
                wariai = ptX2 / sabun;
                sX = 0;
                sY = ptY2 - (ptY2 - ptY1) * wariai;
                sZ = ptZ2 - (ptZ2 - ptZ1) * wariai;
                ans[0] = sX;
                ans[1] = sY;
                ans[2] = sZ;
                ans[4] = 0;
                kyoukai_wairai = wariai;
                if(ptX1 < 0 && 0 <= ptX2){
                    kyoukai_wairai = -ptX1 / sabun;
                    ans[4]=1;//一つ目の頂点がマイナスにあれば1
                }
                ans[3] = kyoukai_wairai;
            }else{//任意の二点間の線分に境界線がない場合
                ans[0] = 99999;
                ans[1] = 99999;
                ans[2] = 99999;
                return ans;
            }
            return ans;
        }

        //三次元座標を二次元に投影する関数
        public float[] get_2D_XY(float ptX,float ptY,float ptZ){
            float ans[] = new float[2];
            float wariaiXY = ptY / (100-ptX);
            float drawX = 100 * -wariaiXY;
            float wariaiXZ = ptZ / (100-ptX);
            float drawY = 100 * wariaiXZ;

            ans[0] = drawX / 20;//Y座標
            ans[1] = drawY / 20;//X座標

            return ans;
        }


        //ポリゴンの頂点座標を視点を中心に回転させて、視線の向きに合わせる関数
        //[0]にXを、[1]にYを格納
        public void get_Data(float ptX,float ptY,float ptZ){
            float Eu;
            double zsa_radq;
            //まずはxy上の頂点の位置を視線の角度分引いて0に合わせる
            p_rad = Math.atan2(tX0 - ptX, tY0 - ptY);
            true_p_rad = p_rad - s_rad + 1.57;
            Eu = (float)Math.sqrt((tX0 - ptX)*(tX0 - ptX) + (tY0 - ptY)*(tY0 - ptY));
            kx = -(float)Math.sin(true_p_rad) * Eu;
            ky = -(float)Math.cos(true_p_rad) * Eu;
            //x軸に揃ったので、xとzで角度を出す
            zsa_radq = Math.atan2(tZ0 - ptZ , -kx) - s_z_rad;
            Eu = (float)Math.sqrt(kx * kx + (tZ0 - ptZ)*(tZ0 - ptZ));
            kx = -(float)Math.cos(zsa_radq) * Eu;//zを加味した場合のx。これがないと上下を向いたときにバグる
            kz = (float)Math.sin(zsa_radq) * Eu;//zを加味した場合のx。これがないと上下を向いたときにバグる
            data[data_count][0] = kx;
            data[data_count][1] = ky;
            data[data_count][2] = kz;
        }
        //ポリゴンと視点との平均距離を求める関数
        public void get_AVG_Eu(float tX,float tY,float tZ){
            double AVG = (
                    Math.sqrt((tX-ptX0)*(tX-ptX0)+(tY-ptY0)*(tY-ptY0)+(tZ-ptZ0)*(tZ-ptZ0)) +
                            Math.sqrt((tX-ptX1)*(tX-ptX1)+(tY-ptY1)*(tY-ptY1)+(tZ-ptZ1)*(tZ-ptZ1)) +
                            Math.sqrt((tX-ptX2)*(tX-ptX2)+(tY-ptY2)*(tY-ptY2)+(tZ-ptZ2)*(tZ-ptZ2))
            ) / 3;
            AVG_Eu = AVG;
        }
        //テクスチャを設定する関数
        public void set_texture(Bitmap bmp){
            texture = bmp;
            bmp_width = bmp.getWidth();
            bmp_height = bmp.getHeight();
        }
        //ポリゴンが四角であることを明示する
        public void to_Square(){
            SquareOrTriangle = 2;
        }
        //ポリゴンが三角であることを明示する
        public void to_Triangle(){
            SquareOrTriangle = 1;
        }

    }



    //視線操作用(首振り)
    float oldx,oldy;
    float dx,dy;
    public boolean onTouchEvent(MotionEvent event){
        dx = event.getX();
        dy = event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            oldx = dx;
            oldy = dy;
        }
        rad -= (dx-oldx)/10000;
        z_rad += (dy-oldy)/10000 * uraomote;
        if(rad>=Math.PI){
            rad=-(Math.PI-0.000001);
        }
        if(rad<=-Math.PI){
            rad=Math.PI-0.000001;
        }
        if(z_rad >= Math.PI/2-0.1){
            z_rad = Math.PI/2-0.1;
        }
        if(z_rad <= -Math.PI/2+0.1){
            z_rad = -Math.PI/2+0.1;
        }

        return  true;
    }



}