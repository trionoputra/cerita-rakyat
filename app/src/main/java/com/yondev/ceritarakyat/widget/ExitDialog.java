package com.yondev.ceritarakyat.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.yondev.ceritarakyat.R;

public class ExitDialog extends DialogFragment implements OnClickListener{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		 final Dialog dialog = new Dialog(getActivity());  
		  dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);  
		  dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
		    WindowManager.LayoutParams.FLAG_FULLSCREEN);  
		  dialog.setContentView(R.layout.exit_item);  
		  dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  
		  
		
		
	
		ImageButton ya = (ImageButton)dialog.findViewById(R.id.imageButton1);
		ImageButton tidak = (ImageButton)dialog.findViewById(R.id.ImageButton01);
	 
	    
	    ya.setOnClickListener(this);
	    tidak.setOnClickListener(this);
	    
	   

	    return dialog;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imageButton1:
			getActivity().finish();
			break;
		case R.id.ImageButton01:
			this.dismiss();
			break;
		default:
			break;
		}
	}



}
