/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wangxvdong.unit2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * @author XD
 */
public class Fragment2 extends Fragment {

    /**
     * Called when the activity is first created.
     * @return 
     */
   @Override
   public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
   {
       return inflater.inflate(R.layout.fragment2, container,false);
       
   }
//   @Override
//  public void onStart()
//  {
//      super.onStart();
//      ((Button)(getActivity().findViewById(R.id.btnGetText))).setOnClickListener(new View.OnClickListener() {
//           public void onClick(View v) {
//               TextView lbl=(TextView)(getActivity().findViewById(R.id.lblFragment1));
//       Toast.makeText(getActivity(), lbl.getText(), Toast.LENGTH_LONG).show();
//           }
//       });
//  }
    
}
