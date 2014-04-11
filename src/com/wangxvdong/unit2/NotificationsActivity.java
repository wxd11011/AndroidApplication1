/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wangxvdong.unit2;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 *
 * @author XD
 */
public class NotificationsActivity extends Activity {
    int notificationID=1;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.notificationmain);
        // ToDo add your GUI initialization code here        
    }
   
    public void onClick(View view)
    {
        displayNotification();
    }
    
    public void displayNotification()
    {
        Intent i=new Intent(this,NotificationView.class);
        i.putExtra("notificationID", notificationID);
        
        PendingIntent pendintIntent=PendingIntent.getActivity(this,0,i,0);
        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
      
        Notification notif=new Notification(R.drawable.ic_launcher,"RE",System.currentTimeMillis());
        CharSequence from="System XMS";
        CharSequence message="Systme is rebooted";
        notif.setLatestEventInfo(this, from, message, pendintIntent);
        notif.vibrate=new long[]{100,250,100,500};
        nm.notify(notificationID,notif);
    }
    
}
