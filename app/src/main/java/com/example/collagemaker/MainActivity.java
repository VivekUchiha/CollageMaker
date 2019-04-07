package com.example.collagemaker;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> supplierNames,suppliernames2;
    VerticalViewPager verticalViewPager;
    VerticalAdapter verticalAdapter;
    Button generatebutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        supplierNames = Arrays.asList("", "", "");
        suppliernames2 = Arrays.asList("", "", "");
        generatebutton=(Button)findViewById(R.id.generatebutton);
        generatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateimage();
            }
        });
        verticalViewPager = (VerticalViewPager)findViewById(R.id.verti) ;


        verticalAdapter = new VerticalAdapter(supplierNames,suppliernames2,this);
        verticalViewPager.setAdapter(verticalAdapter);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        supplierNames=verticalAdapter.horizontalAdapter1.mResources;
        suppliernames2=verticalAdapter.horizontalAdapter2.mResources;
       update();
    }
    void update(){
        verticalAdapter = new VerticalAdapter(supplierNames,suppliernames2,this);
        verticalViewPager.setAdapter(verticalAdapter);

    }

    void generateimage(){
        Intent intent = new Intent(this, CanvasActivity.class);
        intent.putExtra("11",supplierNames.get(0));
        intent.putExtra("12",supplierNames.get(1));
        intent.putExtra("13",supplierNames.get(2));
        intent.putExtra("21",suppliernames2.get(0));
        intent.putExtra("22",suppliernames2.get(1));
        intent.putExtra("23",suppliernames2.get(2));
        startActivity(intent);



    }





    }

