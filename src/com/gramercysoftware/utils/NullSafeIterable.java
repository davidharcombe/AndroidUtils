package com.gramercysoftware.utils;

import java.util.Collections;

/**
 * NullSafeIterable
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
 *
 * A simple helper to ensure that you can safely iterate over any
 * <i>Iterable</i> without many nasty null-checks before your loops.
 * 
 * @author dharcombe
 */
public class NullSafeIterable {
	/**
	 * This will return either the iterable or a validly typed empty version of
	 * the iterable. It ensures that <b>for(Foo foo : foos) {}</b> will always
	 * function correctly, even if the iterable 'foos' is null.
	 * 
	 * @param <T>
	 * @param iterable
	 * @return
	 */
	public static <T> Iterable<T> safe(Iterable<T> iterable) {
		return iterable == null ? Collections.<T> emptyList() : iterable;
	}
}
