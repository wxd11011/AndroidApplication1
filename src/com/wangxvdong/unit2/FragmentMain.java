/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wangxvdong.unit2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 *
 * @author XD
 */
public class FragmentMain extends Activity {

    /**
     * Called when the activity is first created.
     */
    String tag="Fragment";
    @Override
    
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.fragmentmain);
      /*  
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//      FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
       
        Point scrSize=new Point();//保存屏幕大小的Point对象
        WindowManager wm=getWindowManager();
        Display d=wm.getDefaultDisplay();
        d.getSize(scrSize);
//      getWindowManager().getDefaultDisplay().getSize(scrSize);//获得屏幕大小
        
        if (scrSize.x>scrSize.y)
        {
            Fragment1 fragment1=new Fragment1();
            fragmentTransaction.replace(android.R.id.content, fragment1);
        }
        else
        {
            fragmentTransaction.replace(android.R.id.content, new Fragment2());
        }
        fragmentTransaction.commit();*/
        this.setTitle(Double.toString(getIntent().getExtras().getDouble("argv1",0)));
        // ToDo add your GUI initialization code here        
    }
    public void onClick(View v)
    {
        ((TextView)findViewById(R.id.lblFragment2)).setText(((TextView)findViewById(R.id.lblFragment1)).getText());
    }
    @Override
    public void finish()
    {
        
      //  Toast.makeText(this, "FragmentMain", Toast.LENGTH_LONG).show();
        Intent rt=new Intent();
        rt.putExtra("rt1", "Come From FragmetnMain Activity.");
        setResult(RESULT_OK,rt);
        super.finish();   
    }
    @Override
    public void onStart()
    {
        Log.d(tag, "onStart()");
        super.onStart();
    }
    @Override
    public void onResume()
    {
        Log.d(tag, "onResume()");
        super.onResume();
    }
    @Override
    public void onRestart()
    {
        Log.d(tag, "onRestart()");
        super.onRestart();
    }
    @Override
    public void onPause()
    {
        Log.d(tag, "onPaue()");
        super.onPause();
    }
    @Override
    public void onDestroy()
    {
        Log.d(tag, "onDestroy()");
        super.onDestroy();
    }
    @Override
    public void onStop()
    {
        Log.d(tag, "onStop()");
        super.onStop();
    }
}
