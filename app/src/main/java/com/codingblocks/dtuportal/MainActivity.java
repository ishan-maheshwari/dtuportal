package com.codingblocks.dtuportal;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivedIntent = getIntent();
        String roll = receivedIntent.getStringExtra(IntroActivity.KEY_NAME);

        TextView rollNumber = (TextView) findViewById(R.id.roll);
        rollNumber.setText(roll);
    }

    public void goToAttendanceActivity(View V){
        Intent i = new Intent(this,AttendanceActivity.class);
        startActivity(i);
    }

    public void goToMessageActivity(View V){
        Intent i = new Intent(this, MessageActivity.class);
        startActivity(i);
    }

    public void showToast(View V){
        Toast.makeText(this,"No Assignments Pending",Toast.LENGTH_SHORT).show();
    }
}
