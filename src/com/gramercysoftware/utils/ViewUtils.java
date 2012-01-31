package com.gramercysoftware.utils;

import android.app.Activity;
import android.view.View;

/*
 * ViewUtils
 * Copyright (C) 2011 David Harcombe
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
