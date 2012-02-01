package com.gramercysoftware.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class DbAdapter<T extends StorableItem> {
	public static final int DATABASE_VERSION = 1;
	public static final String KEY_ID = "id";
	public static final int COL_ID = 0;
	
	protected String DATABASE_NAME = "SplashScreen";
	protected String DATABASE_TABLE;

	protected SQLiteDatabase db;
	protected SQLiteOpenHelper dbHelper;

	public DbAdapter(SQLiteOpenHelper dbHelper) {
		this.dbHelper = dbHelper;
	}

	public DbAdapter<T> open() throws SQLException {
		db = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		if(db != null) {
			db.close();
		}
	}

	private boolean checkAndOpenDb() {
		if (db != null && db.isOpen()) {
			return false;
		} else {
			open();
			return true;
		}
	}

	private void close(boolean shouldClose) {
		if(shouldClose) {
			close();
		}
	}

	public List<T> getAll(String orderBy) {
		boolean shouldClose = checkAndOpenDb();
		List<T> objects = null;
		Cursor cursor = db.query(DATABASE_TABLE, null, null, null, null, null, orderBy);
		if (cursor.moveToFirst()) {
			objects = new ArrayList<T>();
			do {
				objects.add(createObject(cursor));
			} while (cursor.moveToNext());
		}
		cursor.close();
		
		close(shouldClose);
		return objects;
	}

	public boolean delete(long id) {
		boolean shouldClose = checkAndOpenDb();
		boolean deleted = db.delete(DATABASE_TABLE, (KEY_ID + "=?"), new String[] { Long.toString(id) }) > 0;
		close(shouldClose);
		return deleted;
	}

	public T fetchById(long id) {
		boolean shouldClose = checkAndOpenDb();
		T object = null;
		Cursor cursor = db.query(DATABASE_TABLE, null, KEY_ID + "=" + id, null, null, null, null);
		if (cursor.moveToFirst()) {
			object = createObject(cursor);
		}
		cursor.close();
		close(shouldClose);
		return object;
	}

	public void insert(T object) {
		ContentValues values = createValues(object);

		boolean shouldClose = checkAndOpenDb();
		long id = db.insert(DATABASE_TABLE, null, values);
		close(shouldClose);
		
		object.setId(id);
	}

	public boolean update(T object) {
		ContentValues values = createValues(object);

		boolean shouldClose = checkAndOpenDb();
		db.update(DATABASE_TABLE, values, KEY_ID + "=" + object.getId(), null);
		close(shouldClose);
		return true;
	}

	protected abstract ContentValues createValues(T object);

	protected abstract T createObject(Cursor cursor);

	protected abstract String getCreateStatement();

	/**
	 * JUnit only
	 */
	DbAdapter() {
	}

	void destroyDatabase() {
		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
	}

	DbHelper getDbHelper() {
		return (DbHelper) dbHelper;
	}
}
