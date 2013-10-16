package com.user.socialtesttask.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.user.socialtesttask.R;

public class ToolbarFragment extends Fragment implements OnClickListener {
	
	String LOG = "Click : ";

	TextChangeListener listener;

	public interface TextChangeListener {
		public void onTextChange(CharSequence newText);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_toolbar, container,
				false);
		
		Button buttonArrow = (Button) view.findViewById(R.id.buttonArrow);
		buttonArrow.setOnClickListener(this);
		
		ImageView imgUser1 = (ImageView) view.findViewById(R.id.icon_mask1);
		ImageView imgUser2 = (ImageView) view.findViewById(R.id.icon_mask2);
		ImageView imgUser3 = (ImageView) view.findViewById(R.id.icon_mask3);
		ImageView imgUser4 = (ImageView) view.findViewById(R.id.icon_mask4);
		ImageView imgUser5 = (ImageView) view.findViewById(R.id.icon_mask5);
		ImageView imgUser6 = (ImageView) view.findViewById(R.id.icon_mask6);
		
		Bitmap bitmap1 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.user);
		Bitmap bitmap2 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.user1);
		Bitmap bitmap3 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.user2);
		Bitmap bitmap4 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.user3);
		
		imgUser1.setImageBitmap(getCircularBitmap(bitmap1));
		imgUser2.setImageBitmap(getCircularBitmap(bitmap2));
		imgUser3.setImageBitmap(getCircularBitmap(bitmap3));
		imgUser4.setImageBitmap(getCircularBitmap(bitmap4));
		imgUser5.setImageBitmap(getCircularBitmap(bitmap1));
		imgUser6.setImageBitmap(getCircularBitmap(bitmap2));
		
		imgUser1.setOnClickListener(this);
		imgUser2.setOnClickListener(this);
		imgUser3.setOnClickListener(this);
		imgUser4.setOnClickListener(this);
		imgUser5.setOnClickListener(this);
		imgUser6.setOnClickListener(this);
		

		return view;
	}
	
	
	@Override
	public void onClick(View v) {
	    
	    switch (v.getId()) {
	    case R.id.icon_mask1:
	        Log.d(LOG, "item1");
	      break;
	    case R.id.icon_mask2:
	        Log.d(LOG, "item2");
	      break;
	    case R.id.icon_mask3:
	    	Log.d(LOG, "item3");
	      break;
	    case R.id.icon_mask4:
	    	Log.d(LOG, "item4");
		      break;
	    case R.id.icon_mask5:
	    	Log.d(LOG, "item5");
		      break;
	    case R.id.icon_mask6:
	    	Log.d(LOG, "item6");
		      break;
	    case R.id.buttonArrow:
	        Log.d(LOG, "arrow");
	      break;
	    default:
	      break;
	    }
	}

	/** Return circle crop image of source square image  */
	
	public static Bitmap getCircularBitmap(Bitmap bitmap) {
		Bitmap output;

		if (bitmap.getWidth() > bitmap.getHeight()) {
			output = Bitmap.createBitmap(bitmap.getHeight(),
					bitmap.getHeight(), Config.ARGB_8888);
		} else {
			output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getWidth(),
					Config.ARGB_8888);
		}

		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

		float r = 0;

		if (bitmap.getWidth() > bitmap.getHeight()) {
			r = bitmap.getHeight() / 2;
		} else {
			r = bitmap.getWidth() / 2;
		}

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawCircle(r, r, r, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;
	}

}
