package com.ameed.contacts.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ameed.contacts.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactsDao {

    private final DatabaseHelper helper;

    public ContactsDao(Context context) {
        helper = new DatabaseHelper(context);
    }

    public void addContact(Contact contact) {
        final SQLiteDatabase db = helper.getWritableDatabase();
        try {
            ContentValues newContact = new ContentValues();
            newContact.put(Contact.AGE, contact.getAge());
            newContact.put(Contact.EMAIL, contact.getEmail());
            newContact.put(Contact.PHONE, contact.getPhone());
            newContact.put(Contact.NAME, contact.getName());
            final long id = db.insertOrThrow(Contact.CONTACTS, null, newContact);
            contact.setId(id);
        } catch (Exception e) {
            Log.e("DAO", "Error while inserting record", e);
        } finally {
            db.close();
        }
    }

    public List<Contact> getAll() {
        final SQLiteDatabase db = helper.getReadableDatabase();
        final Cursor cursor = db.query(Contact.CONTACTS,
                new String[]{Contact.ID, Contact.NAME, Contact.AGE, Contact.EMAIL, Contact.PHONE},
                null,
                null,
                null,
                null,
                null
        );
        List<Contact> contacts = new ArrayList<>();
        while (cursor.moveToNext()) {
            final long id = cursor.getLong(0);
            final String name = cursor.getString(1);
            final int age = cursor.getInt(2);
            final String email = cursor.getString(3);
            final String phone = cursor.getString(4);
            Contact contact = new Contact();
            contact.setId(id);
            contact.setAge(age);
            contact.setEmail(email);
            contact.setName(name);
            contact.setPhone(phone);
            contacts.add(contact);
        }
        cursor.close();
        db.close();
        return contacts;
    }

    public void deleteAll() {
        final SQLiteDatabase db = helper.getWritableDatabase();
        try {
            db.execSQL("delete from " + Contact.CONTACTS);
        } catch (Exception e) {
            Log.e("DAO", "Error deleting table", e);
        } finally {
            db.close();
        }
    }
}
