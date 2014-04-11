/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wangxvdong.unit2;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

/**
 *
 * @author XD
 */
public class NotificationView extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.notification);
       // NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
       // nm.cancel(getIntent().getExtras().getInt("notificationID"));
        ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).cancel(getIntent().getExtras().getInt("notificationID"));
        // ToDo add your GUI initialization code here        
    }
    
}
