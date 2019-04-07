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
    List<String> supplierNames;
    HorizontalAdapter horizontalAdapter;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        supplierNames = Arrays.asList("", "", "");

        viewPager = (ViewPager) findViewById(R.id.horiViewPager);
        horizontalAdapter = new HorizontalAdapter(supplierNames,this);
        viewPager.setAdapter(horizontalAdapter);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        supplierNames=horizontalAdapter.mResources;
       update();
    }
    void update(){
        horizontalAdapter = new HorizontalAdapter(supplierNames,this);
        viewPager.setAdapter(horizontalAdapter);

    }



    }

