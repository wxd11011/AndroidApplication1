/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wangxvdong.unit2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 *
 * @author XD
 */
public class Activity2 extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceStats)
    {
        super.onCreate(savedInstanceStats);
        setContentView(R.layout.activity2);
        
    }
    public void onClick(View v)
    {
        setResult(RESULT_OK);
        finish();
    }
  
}
