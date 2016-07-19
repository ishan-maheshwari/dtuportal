package com.codingblocks.dtuportal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Ishan Maheshwari on 06-07-2016.
 */
public class fragment extends Fragment {

    static TextView name;
    static TextView date;
    static TextView message;

    static View v;
    static int messageId;

    public fragment(){

    }

     public static fragment newInstance(int position) {



        fragment frg = new fragment();
        messageId = position;

        return frg;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        v=inflater.inflate(R.layout.frag,container,false);
        setLayout(messageId);
        return v;
    }

    public void setLayout(int position){
        name = (TextView) v.findViewById(R.id.faculty_name);
        date = (TextView) v.findViewById(R.id.date);
        message = (TextView) v.findViewById(R.id.message);

        Messages.Message thisMessage = Messages.getData().get(position);
        name.setText(thisMessage.facultyname);
        date.setText(thisMessage.date);
        message.setText(thisMessage.textmessage);
    }
}
