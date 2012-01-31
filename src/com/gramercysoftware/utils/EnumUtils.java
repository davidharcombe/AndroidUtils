package com.gramercysoftware.utils;

/*
 * EnumUtils
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
public class EnumUtils {
	public static <E extends Enum<E>> E fromValue(Class<E> enumClass, String enumValue) {
		for(E value : enumClass.getEnumConstants()) {
			if(value.toString().equals(enumValue)) {
				return value;
			}
		}
		return null;
	}

	public static <E extends Enum<E>> E fromValueIgnoreCase(Class<E> enumClass, String enumValue) {
		for(E value : enumClass.getEnumConstants()) {
			if(value.toString().equalsIgnoreCase(enumValue)) {
				return value;
			}
		}
		return null;
	}
}
