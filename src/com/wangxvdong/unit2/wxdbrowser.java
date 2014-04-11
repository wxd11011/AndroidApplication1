/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wangxvdong.unit2;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 *
 * @author XD
 */
public class wxdbrowser extends Activity {

    /**
     * Called when the activity is first created.
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
       setContentView(R.layout.wxdbrowser);
       Uri url=getIntent().getData();
       WebView webView=(WebView)findViewById(R.id.wxdweb1);
       webView.setWebViewClient(new Callback());
       webView.loadUrl(url.toString());
    }
    private class Callback extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url)
        {
            return false;
        }
                }
    
}
