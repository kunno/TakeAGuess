package com.vicadey.higherlower;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    int randomNumber = random.nextInt(100) + 1;


    public void randomClicked(View v) {


        randomNumber = random.nextInt(100) + 1;
    }

    public void showButton(View a){

        Toast.makeText(getApplicationContext(), randomNumber + " was the correct number. GG, Try agian!", Toast.LENGTH_SHORT).show();
        randomNumber = random.nextInt(100) + 1;
    }

    public void buttonClicked(View view) {
        EditText inputText = (EditText) findViewById(R.id.userInput);

        String text = inputText.getText().toString();


        try {
            int num = Integer.parseInt(text);

            if(num < randomNumber){
                Toast.makeText(getApplicationContext(), num + " is lower. Try again!", Toast.LENGTH_SHORT).show();
            }
            else if(num > randomNumber){
                Toast.makeText(getApplicationContext(), num + " is higher. Try again!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "You got it!", Toast.LENGTH_SHORT).show();

            }
        }
        catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), text + " is not a number. Please enter a valid number!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
