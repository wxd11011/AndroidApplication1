/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wangxvdong.unit2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 *
 * @author XD
 */
public class Activity3 extends Activity {

    /**
     * Called when the activity is first created.
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity3) ;// ToDo add your GUI initialization code here   
        ((TextView)findViewById(R.id.activity3_label1)).setText("Sqrt("+getIntent().getIntExtra("arg1", MODE_PRIVATE)+"*10)");
        EditText et1=(EditText)findViewById(R.id.act3_edittxt1);
        et1.setText(Double.toString(Math.sqrt(getIntent().getIntExtra("arg1", MODE_PRIVATE)*10)));
        
    }
    
    public void OK_onClick(View v)
    {
//        Intent data=new Intent();
//        EditText et1=(EditText)findViewById(R.id.act3_edittxt1);
//        data.setData(Uri.parse(et1.getText().toString()));
//        setResult(RESULT_OK,data);
        
        finish();
        
    }
  
    @Override
    public void finish()
    {
        Intent data=new Intent();
        EditText et1=(EditText)findViewById(R.id.act3_edittxt1);
        data.setData(Uri.parse(et1.getText().toString()));
        setResult(RESULT_OK,data);
        super.finish();
    }
}
