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
import android.widget.Button;
import android.widget.Toast;

/**
 *
 * @author XD
 */
public class IntentsActivity extends Activity {
   
    int request_Code=1;
    String url1;
    
    /**
     * Called when the activity is first created.
     */
    @Override   
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.intentsactivity);
        url1=getIntent().getStringExtra("url");
        ((Button)findViewById(R.id.btn_webbrowser)).setText("Go to "+url1);
        Toast.makeText(this, url1, Toast.LENGTH_SHORT).show();
    }
    public void onClickWebBrowser(View v)
    {
        startActivity(new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("http://"+getIntent().getStringExtra("url"))));//ubuntuservervm/mysql")));
    }
    public void onClickMakeCalls(View v)
    {
        startActivity(new Intent(android.content.Intent.ACTION_CALL,Uri.parse("tel:+861082746338")));
    }
    public void onClickShowMap(View v)
    {
        startActivity(new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("geo:37,-122")));
    }
    public void onClickLaunchMyBrowser(View v)
    {
        Intent i=new Intent(android.content.Intent.ACTION_VIEW);//Intent("com.wangxvdong.unit2.wxdbrowser");
        i.setData(Uri.parse("http://www.baidu.com"));
     //   i.addCategory("com.wangxvdong.unit2.Webapp");
        startActivity(Intent.createChooser(i, "Open Activity using..."));
    }
}
