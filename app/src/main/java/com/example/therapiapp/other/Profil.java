package com.example.therapiapp.other;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.MainActivity;
import com.example.therapiapp.R;
import com.example.therapiapp.model.User;
import com.example.therapiapp.util.DButil;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Profil extends BaseActivity {
    DButil dButil = DButil.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(BaseActivity.TAG,"create Profile");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        initToolbar("Profil");

        setUserInfo();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(BaseActivity.TAG,"destroy Profile");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem item = menu.findItem(R.id.profileButtonToolBar);
        item.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void handleProfileBearbeiten(View view) {
        Intent intent = new Intent(this, ProfileBearbeiten.class);
        intent.putExtra("user",dButil.getDefaultUser());
        startActivityForResult(intent,0);
    }
    public void setUserInfo(){
        TextView email = findViewById(R.id.profileEmailTextView);
        TextView name = findViewById(R.id.profileNameTextView);
        TextView password = findViewById(R.id.profilePasswordTextView);
        TextView language = findViewById(R.id.profileLanguageTextView);

        User user = dButil.getDefaultUser();

        email.setText(user.getEmail());
        language.setText(user.getLanguage().toString());
        //hide password
        password.setText(getHiddenPassword(user.getPassword()));
        name.setText(user.getName());
    }

    private String getHiddenPassword(String password){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0){
            if (resultCode == RESULT_OK) {
                User updatedUser = (User) data.getExtras().getSerializable("updatedUser");
                dButil.setUser(updatedUser);
                setUserInfo();
                Log.i("------UpdatedUser",updatedUser.toString());
            }
        }
    }

    public void deleteAccount(View view){

        dButil.setUser(null);
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}