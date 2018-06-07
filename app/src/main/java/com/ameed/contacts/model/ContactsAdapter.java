package com.ameed.contacts.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

public class ContactsAdapter extends ArrayAdapter<Contact> {

    public ContactsAdapter(@NonNull Context context, List<Contact> contacts) {
        super(context, android.R.layout.simple_list_item_1, contacts);
    }
}
