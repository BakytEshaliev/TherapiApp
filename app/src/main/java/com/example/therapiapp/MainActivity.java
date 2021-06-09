package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.therapiapp.model.User;
import com.example.therapiapp.util.DButil;

public class MainActivity extends BaseActivity {
    DButil dButil = DButil.getInstance();
    private EditText password;
    private EditText email;
    private static boolean anmeldungErfolgreich = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anmeldung_1);
        initToolbar();
        email = findViewById(R.id.mainEmailEditText);
        email.setText("test@gmail.com");
        password = findViewById(R.id.mainPasswordEditText);
        password.setText("qwe123");
    }

    public void toStartseite(View v) {
        if (verifyUser()) {
            if (!anmeldungErfolgreich){
                Intent intent = new Intent(this, AnmeldingErfolgreich.class);
                this.startActivity(intent);
            }else {
                Intent intent = new Intent(this, Startseite.class);
                this.startActivity(intent);
            }
        }else Toast.makeText(this,"There is no user with this password or email!",Toast.LENGTH_SHORT).show();
    }

    private boolean verifyUser(){
//        EditText email = findViewById(R.id.mainEmailEditText);
        Log.i("Info",email.getText().toString());
//        EditText password = findViewById(R.id.mainPasswordEditText);
        Log.i("Info",password.getText().toString());
        User user = dButil.getDefaultUser();
        return user.getPassword().equals(password.getText().toString()) &&
                user.getEmail().equals(email.getText().toString());
    }
    public void toRegister(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        this.startActivity(intent);
    }

    public static void setAnmeldungErfolgreich(boolean anmeldungErfolgreich) {
        MainActivity.anmeldungErfolgreich = anmeldungErfolgreich;
    }
}