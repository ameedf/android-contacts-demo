package com.ameed.contacts.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.ameed.contacts.model.Contact.AGE;
import static com.ameed.contacts.model.Contact.CONTACTS;
import static com.ameed.contacts.model.Contact.EMAIL;
import static com.ameed.contacts.model.Contact.ID;
import static com.ameed.contacts.model.Contact.NAME;
import static com.ameed.contacts.model.Contact.PHONE;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, "contacts_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE %s (" +
                " %s INTEGER PRIMARY KEY," + // ID
                " %s TEXT," + // NAME
                " %s TEXT, " +// PHONE
                " %s TEXT, " +// EMAIL
                " %s INTEGER" + // AGE
                ")";
        db.execSQL(String.format(createQuery,
                CONTACTS,
                ID,
                NAME,
                PHONE,
                EMAIL,
                AGE));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
