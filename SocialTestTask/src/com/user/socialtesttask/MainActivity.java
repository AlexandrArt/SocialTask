package com.user.socialtesttask;

import com.user.socialtesttask.fragments.AvatarFragment;
import com.user.socialtesttask.fragments.SettingsFragment;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Window;


public class MainActivity extends FragmentActivity {
	/** fragments and tools for transaction/replacing fragments */
	AvatarFragment avatarFr;
	SettingsFragment settingsFr;
	AvatarFragment avatarFr1;
	SettingsFragment settingsFr1;
	android.app.FragmentTransaction fTrans;
	android.support.v4.app.FragmentTransaction fragmentTransaction;
	android.support.v4.app.FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/**Set only portret mode (if you want add landscape mode remove line below) */
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
       // set default fragments
		fragmentManager = getSupportFragmentManager();
		avatarFr = new AvatarFragment();
		settingsFr = new SettingsFragment();
		avatarFr1 = new AvatarFragment();
		settingsFr1 = new SettingsFragment();
		fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.replace(R.id.Fragmen1, avatarFr1);
		fragmentTransaction.replace(R.id.Fragmen2, settingsFr1);
		fragmentTransaction.commit();
		
		
		setContentView(R.layout.main);

	}
	
   //replace fragments by click logout
	public void replaceFragments(){
		 fragmentTransaction = fragmentManager
					.beginTransaction();

			 avatarFr1 = new AvatarFragment();
		     settingsFr1 = new SettingsFragment();

			fragmentTransaction.replace(R.id.Fragmen1, settingsFr);
			fragmentTransaction.replace(R.id.Fragmen2, avatarFr);
			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();
	}

	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK) {
	        finish();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}

}


