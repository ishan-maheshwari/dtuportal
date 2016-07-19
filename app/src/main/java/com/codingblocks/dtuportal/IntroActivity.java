package com.codingblocks.dtuportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity {

    public static final String KEY_NAME="RollNo";

    EditText roll;
    EditText pass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        btn = (Button) findViewById(R.id.button);


    }

    public void goToMainActivity(View V){

        roll = (EditText) findViewById(R.id.roll_number);
        pass = (EditText) findViewById(R.id.pass);
        if(roll.getText().toString().equals("DTU/2K15/B2/247") && pass.getText().toString().equals("hello123")) {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra(KEY_NAME, roll.getText().toString());
            startActivity(i);
        } else {
            Toast.makeText(this,"Roll Number and Password do not match.",Toast.LENGTH_SHORT).show();
        }
    }
}
