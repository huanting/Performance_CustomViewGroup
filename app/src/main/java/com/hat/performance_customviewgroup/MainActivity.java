package com.hat.performance_customviewgroup;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /**
     * activity_main5:  test normal layout
     * activity_main6:  the optimalized layout.
     * activity_main:   test custom viewGroup
     * activity_main2:  test custom viewGroup
     * activity_main3:  test custom viewGroup
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }
}
