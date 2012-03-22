package com.gramercysoftware.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.gramercysoftware.utils.R;

/**
 * <p>Adds a new element to the text view:
 * 
 * <ul><li>customFont</li></ul>
 * 
 * Which allows you to set the font of a TextView to any font you
 * have added in the assets.
 * 
 * <p>Usage:
 * <ol><li>Add the namespace to the layout xml file<br/>
 * xmlns:foo="http://schemas.android.com/apk/res/com.gramercysoftware.tobixi"</li>
 * <li>Add the TextViewPlus as a normal TextView</li>
 * <li>Add the tag<br/>foo:customFont="font.ttf"<br/>to your TextViewPlus</li>
 * </ol>
 * 
 * 
 * @author David Harcombe
 */
public class TextViewPlus extends TextView {
	private static final String TAG = "TextView";

	public TextViewPlus(Context context) {
		super(context);
	}

	public TextViewPlus(Context context, AttributeSet attrs) {
		super(context, attrs);
		setCustomFont(context, attrs);
	}

	public TextViewPlus(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setCustomFont(context, attrs);
	}

	private void setCustomFont(Context ctx, AttributeSet attrs) {
		TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.TextViewPlus);
		String customFont = a.getString(R.styleable.TextViewPlus_customFont);
		setCustomFont(ctx, customFont);
		a.recycle();
	}

	public boolean setCustomFont(Context ctx, String asset) {
		Typeface tf = null;
		try {
			tf = Typeface.createFromAsset(ctx.getAssets(), asset);
		} catch (Exception e) {
			Log.e(TAG, "Could not get typeface: " + e.getMessage());
			return false;
		}

		setTypeface(tf);
		return true;
	}
}
