package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.therapiapp.model.Language;
import com.example.therapiapp.model.User;
import com.example.therapiapp.util.DButil;

public class ProfileBearbeiten extends AppCompatActivity {
    private Spinner spinner;
    private EditText password;
    private EditText name;
    private EditText email;
    private DButil dButil;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_bearbeiten);
        dButil = DButil.getInstance();
        user = (User) getIntent().getSerializableExtra("user");

        Log.i("Info",user.toString());


        email = findViewById(R.id.emailEditText);
        name = findViewById(R.id.nameEditText);
        password = findViewById(R.id.passwordEditText);
        spinner = findViewById(R.id.languageSpinner);

        setData();
    }

    public void handleOk(View view) {
        String emailUser = email.getText().toString();
        String nameUser = name.getText().toString();
        String passwordUser = password.getText().toString();
        boolean isValid = !emailUser.isEmpty() && !nameUser.isEmpty() && !passwordUser.isEmpty();
        if (isValid){
            String languageUser = spinner.getSelectedItem().toString();
            User updatedUser = new User(nameUser, emailUser, passwordUser, Language.valueOf(languageUser));
            Intent intent = new Intent();
            intent.putExtra("updatedUser",updatedUser);
            setResult(1,intent);
            finish();
        }
    }
    private void setData(){
        email.setText(user.getEmail());
        name.setText(user.getName());
        password.setText(user.getPassword());
    }
    public void handleBack(View view) {
        finish();
    }
}