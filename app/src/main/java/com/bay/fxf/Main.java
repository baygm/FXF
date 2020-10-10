package com.bay.fxf;

import androidx.appcompat.app.*;
import android.os.*;
import android.widget.*;

import com.bay.lib.Decryptor;
import com.bay.lib.UI;
import com.bay.lib.UI;
import android.view.*;
import android.widget.RelativeLayout.*;
import android.graphics.*;
import com.bay.lib.Strings;
import com.bay.lib.*;
import android.graphics.drawable.*;
import android.graphics.drawable.shapes.*;
import com.google.firebase.analytics.*;
import android.view.animation.*;
public class Main extends AppCompatActivity implements View.OnClickListener
{
	private int BtnId1 = 0x001;
	private int BtnId2 = 0x002;
	private int BtnId3 = 0x003;
	private int ImgId = 0x103;
	private Api mApi;
	Utils mUtils;
	private FirebaseAnalytics mFirebaseAnalytics;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		initLayout();
		mUtils = new Utils(this);
		mUtils.isStoragePermissionGranted();
		mApi = new Api(this);
		mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
	}	
	@Override
	public void onClick(View view)
	{
		switch(view.getId()){
			case 0x001:
				mApi.injectAntena(Decryptor.Run(Strings.UriAHD),Decryptor.Run(Strings.AntenaHead)+" "+Decryptor.Run(Strings.ON));
				break;
			case 0x002:
				mApi.injectAntena(Decryptor.Run(Strings.UriAHN),Decryptor.Run(Strings.AntenaHand)+" "+Decryptor.Run(Strings.ON));
				break;
			case 0x003:
				mApi.injectAntena(Decryptor.Run(Strings.UriABP),Decryptor.Run(Strings.Antena)+" "+Decryptor.Run(Strings.OFF));
				break;
		}
	}
	
	private void initLayout(){

		UI lay = new UI(this);	
		lay.setBackgroundResource(R.color.colorPrimaryDark);
		
		
		/*BEGIN LAYOUT BUTTON*/
		
		LayoutParams layoutbtnparams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		layoutbtnparams.addRule(RelativeLayout.CENTER_IN_PARENT);
		layoutbtnparams.setMargins(30,30,30,30);

		LinearLayout linearBtn = new LinearLayout(this);
		linearBtn.setOrientation(LinearLayout.VERTICAL);
		linearBtn.setGravity(Gravity.CENTER);
		linearBtn.setPadding(0,100,0,100);
		ShapeDrawable shapedrawable = new ShapeDrawable();
		shapedrawable.setShape(new RectShape());
		shapedrawable.getPaint().setColor(Color.WHITE);
		shapedrawable.getPaint().setStrokeWidth(10f);
		shapedrawable.getPaint().setStyle(Paint.Style.STROKE);
		linearBtn.setBackground(shapedrawable);
		linearBtn.setLayoutParams(layoutbtnparams);

		lay.addView(linearBtn);

		
		/*BEGIN BUTTON*/
		
		LayoutParams btnparam = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		btnparam.setMargins(30,30,30,30);

		View btn1 = lay.Btn(this,Decryptor.Run(Strings.AntenaHead),Color.WHITE);
		btn1.setLayoutParams(btnparam);
		btn1.setId(BtnId1);

		linearBtn.addView(btn1);

		View btn2 = lay.Btn(this,Decryptor.Run(Strings.AntenaHand),Color.WHITE);
		btn2.setLayoutParams(btnparam);
		btn2.setId(BtnId2);

		linearBtn.addView(btn2);

		View btn3 = lay.Btn(this,Decryptor.Run(Strings.DeleteAntena),Color.RED );
		btn3.setLayoutParams(btnparam);
		btn3.setId(BtnId3);

		linearBtn.addView(btn3);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		
		/*BEGIN APPICON & APPNAME*/
		float scale = getResources().getDisplayMetrics().density;
		int paddingImg = (int) (50*scale + 0.5f);
		LinearLayout appiconContainer = new LinearLayout(this);
		appiconContainer.setOrientation(LinearLayout.VERTICAL);
		appiconContainer.setGravity(Gravity.CENTER);
		LayoutParams containerparam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		appiconContainer.setPadding(0,paddingImg,0,0);
		appiconContainer.setLayoutParams(containerparam);
		
		ImageView imgIcon = new ImageView(this);
		LayoutParams imgParam = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		imgIcon.setLayoutParams(imgParam);
		imgIcon.setBackgroundResource(R.mipmap.ic_launcher_round);
		imgIcon.setId(ImgId);
		appiconContainer.addView(imgIcon);
		
		TextView appTextName = new TextView(this);
		LayoutParams appTextParam = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		appTextName.setLayoutParams(appTextParam);
		appTextName.setText(Decryptor.Run("fqpxoItkMaf7uNXYiNr4LdYdm6MisNESNK3HAm6GE18tR/LXhclvTFCWbiH3g97U"));
		appTextName.setTextColor(Color.WHITE);
		appTextName.setPadding(0,25,0,0);
		appiconContainer.addView(appTextName);
		
		lay.addView(appiconContainer);
		
		/*BEGIN COPYRIGHT*/
		
		TextView txt = new TextView(this);
		txt.setText(Decryptor.Run(Strings.Copyright));
		txt.setPadding(0,50,0,50);
		txt.setBackgroundColor(Color.BLACK);
		RelativeLayout.LayoutParams Txtparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
		Txtparams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		txt.setGravity(Gravity.CENTER_HORIZONTAL);
		txt.setTextColor(Color.WHITE);
		txt.setLayoutParams(Txtparams);

		lay.addView(txt);

		/*ALL DONE*/
		AnimationSet set = new AnimationSet(true); 
		Animation fadeIn = new AlphaAnimation(0.0f, 1.0f); 
		fadeIn.setDuration(500); 
		fadeIn.setFillAfter(true); 
		set.addAnimation(fadeIn); 
		LayoutAnimationController controller = new LayoutAnimationController(set, 0.2f); 
		lay.setLayoutAnimation(controller); 
		setContentView(lay);
		
	}
	
}
