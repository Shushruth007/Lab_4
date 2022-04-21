package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();
        saveProfile();
    }

    public void onGoBackClicked(View view) {
        finish();
    }

    public void loadProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String name = preferences.getString("name", "");
        String status = preferences.getString("status", "");
        TextView name_textview = (TextView)findViewById(R.id.name_textView);
        name_textview.setText(name);
        TextView status_textview = (TextView)findViewById(R.id.status_textView);
        status_textview.setText(status);
    }

    public void saveProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        TextView name_textview = (TextView)findViewById(R.id.name_textView);
        editor.putString("name", name_textview.getText().toString());
        TextView status_textview = (TextView)findViewById(R.id.status_textView);
        editor.putString("status", status_textview.getText().toString());

        editor.apply();
    }
}