package com.ameed.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.ameed.contacts.db.ContactsDao;
import com.ameed.contacts.model.ContactsAdapter;

public class ContactsListActivity extends AppCompatActivity {


    private ContactsDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        dao = new ContactsDao(this);
        final ContactsAdapter adapter = new ContactsAdapter(this, dao.getAll());
        final Button deleteButton = findViewById(R.id.deleteAllButton);
        deleteButton.setOnClickListener(
                v -> {
                    dao.deleteAll();
                    adapter.clear();
                }
        );

        final ListView contacts = findViewById(R.id.contactsList);
        contacts.setAdapter(adapter);
    }
}
