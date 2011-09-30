package com.gramercysoftware.utils;

import android.app.Activity;
import android.view.View;

public class ViewUtils {
	@SuppressWarnings("unchecked")
	public static <T extends View> T getViewObject(Activity activity, Class<T> foo, int id) {
		return (T) activity.findViewById(id);
	}

	@SuppressWarnings("unchecked")
	public static <T extends View> T getViewObject(View view, Class<T> foo, int id) {
		return (T) view.findViewById(id);
	}
}
