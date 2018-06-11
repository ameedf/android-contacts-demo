package com.ameed.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ameed.contacts.db.ContactsDao;
import com.ameed.contacts.model.Contact;

public class ContactActivity extends AppCompatActivity {

    private ContactsDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        dao = new ContactsDao(this);

        final Button createNewButton = findViewById(R.id.createNewButton);
        createNewButton.setOnClickListener(
                v -> {
                    String name = extractText(R.id.nameInput);
                    String phone = extractText(R.id.phoneInput);
                    String age = extractText(R.id.ageInput);
                    String email = extractText(R.id.emailInput);
                    Contact contact = new Contact();
                    contact.setPhone(phone);
                    contact.setEmail(email);
                    contact.setName(name);
                    contact.setAge(Integer.parseInt(age));
                    dao.addContact(contact);

                    Toast.makeText(this, "Added a new user !", Toast.LENGTH_LONG)
                            .show();
                }
        );
    }

    private String extractText(int id) {
        final EditText editText = findViewById(id);
        final String value = editText.getText().toString();
        editText.setText("");
        return value;
    }
}
