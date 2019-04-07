package com.example.collagemaker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class CanvasActivity extends AppCompatActivity {

    String r11,r12,r13,r21,r22,r23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        ImageView imageView = (ImageView)findViewById(R.id.finalimage);

        Intent intent = getIntent();
        r11= intent.getStringExtra("11");
        r12= intent.getStringExtra("12");
        r13= intent.getStringExtra("13");
        r21= intent.getStringExtra("21");
        r22= intent.getStringExtra("22");
        r23= intent.getStringExtra("23");
        Bitmap b1,b2,b3,b4,b5,b6;

        b1=loadss(r11);
        b2=loadss(r12);
        b3=loadss(r13);
        b4=loadss(r21);
        b5=loadss(r22);
        b6=loadss(r23);

        Bitmap dstBitmap = Bitmap.createBitmap(
                b1.getWidth()*3, b1.getHeight()*2, // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        Canvas canvas = new Canvas(dstBitmap);
        canvas.drawColor(Color.LTGRAY);
        canvas.drawBitmap(
                b1, // Bitmap
                0, // Left
                0, // Top
                null // Paint
        );
        canvas.drawBitmap(
                b2, // Bitmap
                b1.getWidth(), // Left
                0, // Top
                null // Paint
        );
        canvas.drawBitmap(
                b3, // Bitmap
                b1.getWidth()*2, // Left
                0, // Top
                null // Paint
        );
        canvas.drawBitmap(
                b4, // Bitmap
                0, // Left
                b1.getHeight(), // Top
                null // Paint
        );
        canvas.drawBitmap(
                b5, // Bitmap
                b1.getWidth(), // Left
                b1.getHeight(), // Top
                null // Paint
        );
        canvas.drawBitmap(
                b6, // Bitmap
                b1.getWidth()*2, // Left
                b1.getHeight(), // Top
                null // Paint
        );

        imageView.setImageBitmap(dstBitmap);



    }

    Bitmap loadss(String path){


        Bitmap bitmap = null;
        File f = new File(path);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            bitmap = BitmapFactory.decodeStream(new FileInputStream(f), null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int h = 400; // height in pixels
        int w = 300; // width in pixels
        Bitmap scaled;
        if(bitmap==null) {
            bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.addimage);
        }
        else{bitmap=rotateImage(bitmap,90);

        }
        scaled = Bitmap.createScaledBitmap(bitmap, w, h, true);

        return scaled;
    }
    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(),
                matrix, true);
    }

}
