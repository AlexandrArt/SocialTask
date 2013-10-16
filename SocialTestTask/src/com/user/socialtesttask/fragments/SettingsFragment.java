package com.user.socialtesttask.fragments;

import com.user.socialtesttask.MainActivity;
import com.user.socialtesttask.R;



import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;




public class SettingsFragment extends Fragment implements OnClickListener {
	String LOG = "Click settings : ";
    TextView textView;
  

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        
     // Font path
	    String fontPath = "fonts/Roboto_Light.ttf";
	    
	    // text view label
	    Button btnN = (Button)view. findViewById(R.id.textNoifications);
	    Button btnT = (Button)view. findViewById(R.id.textTerms);
	    Button btnP = (Button)view. findViewById(R.id.textPrivacy);
	    Button btnS = (Button)view. findViewById(R.id.textSupport);
	    Button logout = (Button)view. findViewById(R.id.logout);
	    
	 // Loading Font Face
	    Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), fontPath);

	 // Applying font
	    btnN.setTypeface(tf);
	    btnT.setTypeface(tf);
	    btnP.setTypeface(tf);
	    btnS.setTypeface(tf);
	    
	    
	   //Click listening 
	    btnN.setOnClickListener(this);
	    btnT.setOnClickListener(this);
	    btnP.setOnClickListener(this);
	    btnS.setOnClickListener(this);
	    logout.setOnClickListener(this);
	    
	    String a ="Privacy "+ "&" + " Safety";
	    btnP.setText(a);
	    
	    ToggleButton toggle = (ToggleButton)view. findViewById(R.id.checkButton);
	    toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
	        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	            if (isChecked) {
	            	Log.d(LOG, "true");
	            } else {
	            	Log.d(LOG, "false");
	            }
	        }
	    });

        return view;
    }

   

	@Override
	public void onClick(View v) {
		 switch (v.getId()) {
		    case R.id.textNoifications:
		        Log.d(LOG, "Noifications");
		      break;
		    case R.id.textTerms:
		        Log.d(LOG, "Terms");
		      break;
		    case R.id.textPrivacy:
		    	Log.d(LOG, "Privacy");
		      break;
		    case R.id.textSupport:
		    	Log.d(LOG, "Support");
			      break;
		    case R.id.logout:
		    	Log.d(LOG, "logout");
		    	((MainActivity) getActivity()).replaceFragments();
			      break;
		    
		    default:
		      break;
		    }
		
	}
}