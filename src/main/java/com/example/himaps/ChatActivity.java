package com.example.himaps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ChatActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        editText = findViewById(R.id.editText);
    }
    public void sendMessage(View view) {
        String message = editText.getText().toString();
        if (message.length() > 0) {
            //TODO sendmessage
            editText.getText().clear();
        }
    }
}