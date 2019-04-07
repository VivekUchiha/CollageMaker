package com.example.collagemaker;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        List<String> supplierNames = Arrays.asList("", "", "");
        ViewPager viewPager;
        viewPager = (ViewPager) findViewById(R.id.horiViewPager);
        viewPager.setAdapter(new HorizontalAdapter(supplierNames,getApplicationContext()));
    }
}
