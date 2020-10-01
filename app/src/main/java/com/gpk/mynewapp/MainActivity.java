package com.gpk.mynewapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Application");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId())
       {
           case R.id.action_search:
               displayInfo("Search is Selected");
               return true;
           case R.id.action_share:
               displayInfo("Share Option is Selected");
               return true;
           default:
               return super.onOptionsItemSelected(item);

       }

    }
    public void displayInfo(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    public void sendMessage(View view)
    {
        EditText editText = findViewById(R.id.txt_message);
        String message = editText.getText().toString();
        Intent intent = new Intent(this,MessageActivity.class);
        intent.putExtra("message",message);
        startActivity(intent);
    }
}