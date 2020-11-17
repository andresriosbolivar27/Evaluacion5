package com.example.evaluacion5.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import org.apache.commons.lang3.StringUtils;

import com.example.evaluacion5.R;
import com.example.evaluacion5.mail.JavaMailAPI;
import com.example.evaluacion5.mail.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import javax.mail.MessagingException;

public class ActivityContacto extends AppCompatActivity {
    private Toolbar toolbar;
    public EditText mEmail;
    public EditText mSubject;
    public EditText mMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mEmail = (EditText)findViewById(R.id.mailID);
        mMessage = (EditText)findViewById(R.id.messageID);
        mSubject = (EditText)findViewById(R.id.subjectID);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        String toEmail = mEmail.getText().toString();;
        String subject = mSubject.getText().toString();
        String message = this.formatMessage();
        JavaMailAPI mail = new JavaMailAPI(this, toEmail, subject, message);
        mail.execute();
    }
    private String formatMessage(){
        String contactEmail = mEmail.getText().toString();
        String message = mMessage.getText().toString();
        return StringUtils.join(contactEmail, "\n", message);
    }


}