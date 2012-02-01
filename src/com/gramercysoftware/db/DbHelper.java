/**
 * 
 */
package com.gramercysoftware.db;

import android.database.sqlite.SQLiteDatabase;

public interface DbHelper {
	void forceRecreateDatabase(SQLiteDatabase db);
}