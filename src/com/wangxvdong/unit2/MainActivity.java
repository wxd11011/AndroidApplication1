package com.wangxvdong.unit2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    final String tag = "@string/app_name";
    CharSequence[] items = {"Baidu", "Google", "Bing"};
    boolean[] itemsChecked = new boolean[items.length];
    int index;
    ProgressDialog progressDialog;
    final int ACT2 = 2;
    final int ACT3 = 3;
    final int ACT_FRAGMENT = 4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_LEFT_ICON);
        setContentView(R.layout.main);
        Log.d(tag, "onCreate()");

//        findViewById(R.id.btn_2).setOnClickListener(new OnClickListener(){
//
//            public void onClick(View v) {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                final ProgressDialog dialog=ProgressDialog.show(getBaseContext().getApplicationContext(), "DOING...", "Please wait...", true);
//                new Thread(new Runnable(){
//
//                    public void run() {
//                   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                        try
//                        {
//                            Thread.sleep(5000);
//                            dialog.dismiss();
//                        }catch(InterruptedException e)
//                        {
//                            e.printStackTrace();
//                        }
//                    }
//
//                }).start();
//            }
//
//        });
    }

    public void btn1_onClick(View v) {
        showDialog(0);
        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notif=new Notification(R.drawable.ic_launcher,"First Activity Started!",System.currentTimeMillis());
        Intent i=new Intent(this,NotificationView.class);
        i.putExtra("notificationID", 258);
        PendingIntent pendingIntent=PendingIntent.getActivity(this, 0, i, 0);
        notif.setLatestEventInfo(this, "UNIT2", "Activity 1", pendingIntent);
        notif.vibrate=new long[]{100,250,100,250};
        nm.notify(258, notif);
        
    }

    public void onClick2(final View v) {
        final ProgressDialog dialog = ProgressDialog.show(this, "DOING......", "Please Wait...", true);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    dialog.dismiss();

                } catch (InterruptedException iex) {
                    iex.printStackTrace();
                }
            }
        }).start();
    }

    public void onClick3(View v) {
        showDialog(1);
        progressDialog.setProgress(0);
        new Thread(new Runnable() {

            public void run() {
                for (int i = 1; i <= 100; i++) {
                    try {
                        Thread.sleep(100);
                        progressDialog.incrementProgressBy(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                progressDialog.dismiss();
            }

        }).start();
    }

    public void onClick4(View v) {
        startActivityForResult(new Intent("com.wangxvdong.unit2.Activity2"), R.layout.activity2);//startActivity(new Intent(this,Activity2.class));
    }

    public void onClick5(View v) {
        Intent iact3 = new Intent("com.wangxvdong.unit2.Activity3");
        iact3.putExtra("arg1", 567);
        Toast.makeText(this, Integer.toString(iact3.getIntExtra("arg1", MODE_PRIVATE)), index).show();
        startActivityForResult(iact3, R.layout.activity3);
    }

    public void onClick6(View v) {
        showDialog(2);
//        Toast.makeText(this, v.toString(), Toast.LENGTH_SHORT).show();
//        finish();
    }

    public void onClickFragment(View v) {
        Intent iact = new Intent("com.wangxvodng.unit2.FragmentMain");
        iact.putExtra("argv1", 2.5);
        startActivityForResult(iact, R.layout.fragmentmain);
//        startActivity(iact);
    }

    public void onClickIntentsActivity(View v) {

        Intent iact=new Intent("com.wangxvdong.unit2.IntentsActivity");
        iact.putExtra("url","xiaomi.COM");
        startActivity(iact);
//        showDialog(3);
    }
    public void onClickNotification(View v)
    {
        Intent iact=new Intent("com.wangxvdong.unit2.NotificationsActivity");
        startActivity(iact);
    }
    @Override
    public void onActivityResult(int which_act, int rlc, Intent data) {
        switch (which_act) {
            case R.layout.activity3:
                if (rlc == RESULT_OK) {
                    Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.layout.activity2:
                if (rlc == RESULT_OK) {
                    Toast.makeText(this, "THIS IS ACT2", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.layout.fragmentmain:
                if (rlc == RESULT_OK) {
                    Toast.makeText(this, data.getStringExtra("rt1"), Toast.LENGTH_SHORT).show();
                }
                break;

        }
//        if (rc == 1 && rlc == RESULT_OK) {
//            Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        Builder dg = null;
        switch (id) {
            case 0:
                dg = new AlertDialog.Builder(this);
                dg.setIcon(R.drawable.ic_launcher);
                dg.setTitle("This is a dialog***");
                dg.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        //  Toast.makeText(getBaseContext(), Integer.toString(index), Toast.LENGTH_LONG).show();
                        ((TextView) findViewById(R.id.label_1)).setText(items[index]);
                    }

                });
                dg.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancel " + tag, Toast.LENGTH_LONG).show();
                    }
                });
                dg.setSingleChoiceItems(items, index, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        index = which;
                        Toast.makeText(getBaseContext(), items[which].toString() + " is selected!", Toast.LENGTH_SHORT).show();
                    }
                }
                );
//                dg.setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                        index = which;
//                        Toast.makeText(getBaseContext(), items[which].toString() + (isChecked ? "checked" : "unchecked"), Toast.LENGTH_LONG).show();
//                    }
//                });
               return dg.create();
            case 1:
                progressDialog = new ProgressDialog(this);
                progressDialog.setIcon(R.drawable.ic_launcher);
                progressDialog.setTitle("shows....");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "ok clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                return progressDialog;
            case 2:
                dg = new AlertDialog.Builder(this);
                dg.setMessage("Exit ?");
                dg.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dg.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                return dg.create();
//            case 3:
//
//                dg = new AlertDialog.Builder(this);
//                dg.setView(getLayoutInflater().inflate(R.layout.inputdialog, (ViewGroup) findViewById(R.id.inputbox)));
//
//                dg.setPositiveButton("GO", new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which) {
//                        LayoutInflater li = LayoutInflater.from(getBaseContext());
//                        View vie = li.inflate(R.layout.inputdialog, null);
//                        Intent iact = new Intent("com.wangxvdong.unit2.IntentsActivity");
//                        String et = ((EditText) (vie.findViewById(R.id.txt_urldialog))).getText().toString();
//                        Toast.makeText(getBaseContext(), et, Toast.LENGTH_LONG);
//                        iact.putExtra("url", et);
//                        startActivity(iact);
//
//                    }
//                });
//                return dg.create();
        }
        return null;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(tag, "onStart()");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(tag, "onResume()");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(tag, "onRestart()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(tag, "onPause()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, " onDestroy()", Toast.LENGTH_LONG).show();
        Log.d(tag, "onDestroy()");
    }

    @Override
    public void onStop() {
        Toast.makeText(this, tag + " onStop()", Toast.LENGTH_LONG).show();
        super.onStop();
        Log.d(tag, "onStop()");

    }

//    public void onClick(View v)
//    {
//        Toast.makeText(this, "@string/btn1_title", Toast.LENGTH_LONG).show();
//    }
}
