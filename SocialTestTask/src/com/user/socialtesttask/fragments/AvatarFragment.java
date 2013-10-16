package com.user.socialtesttask.fragments;


import com.user.socialtesttask.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AvatarFragment extends Fragment implements OnClickListener {
	String LOG = "Click :";
	TextChangeListener listener;

	public interface TextChangeListener {
		public void onTextChange(CharSequence newText);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.fragment_avatar, container, false);

		Button call = (Button) view.findViewById(R.id.buttonCall);
		Button add = (Button) view.findViewById(R.id.buttonAdd);

		call.setOnClickListener(this);
		add.setOnClickListener(this);

		ImageView imgView = (ImageView) view.findViewById(R.id.imageAvatar);

		Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.avatar);
		imgView.setImageBitmap(ToolbarFragment.getCircularBitmap(bitmap));

		// Font path
		String fontPath = "fonts/Roboto_Light.ttf";

		// text view label
		TextView txtFont = (TextView) view.findViewById(R.id.textName);

		// Loading Font Face
		Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
				fontPath);

		// Applying font
		txtFont.setTypeface(tf);

		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonCall:
			Log.d(LOG, "CALL");
			break;
		case R.id.buttonAdd:
			Log.d(LOG, "ADD");
			break;

		default:
			break;
		}

	}

}