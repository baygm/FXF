package com.bay.lib;
import android.widget.*;
import android.content.*;
import android.view.*;
import android.widget.RelativeLayout.*;
import android.util.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.graphics.drawable.shapes.*;

public class UI extends RelativeLayout
{
	
	public UI(Context context) {
		super(context);		
	}

	public UI(Context context, AttributeSet attrs) {
		super(context, attrs);		
	}

	public UI(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs,defStyle);		
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b)
	{
		super.onLayout(changed, l, t, r, b);
	}

	
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		
	}
	public int setColor(int color){
		return color;
	}
	public Button Btn(Context context,final String txt,final int color){
		class Btn extends Button{
			public Btn(Context context) {
				super(context);		
			}
			public Btn(Context context, AttributeSet attrs) {
				super(context, attrs);		
			}

			public Btn(Context context, AttributeSet attrs, int defStyle) {
				super(context, attrs,defStyle);		
			}

			@Override
			protected void onLayout(boolean changed, int l, int t, int r, int b)
			{
				super.onLayout(changed, l, t, r, b);
			}

			@Override
			protected void onDraw(Canvas canvas)
			{
				super.onDraw(canvas);
				ShapeDrawable shapedrawable = new ShapeDrawable();
				shapedrawable.setShape(new RectShape());
				shapedrawable.getPaint().setColor(setColor(color));
				shapedrawable.getPaint().setStrokeWidth(10f);
				shapedrawable.getPaint().setStyle(Paint.Style.STROKE);
				setText(txt);
				setTextColor(color);
				setBackground(shapedrawable);
				
			}

		}
		return new Btn(context);
	}
	
}
