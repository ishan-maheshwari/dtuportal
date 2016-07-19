package com.codingblocks.dtuportal;

import java.util.ArrayList;

/**
 * Created by Ishan Maheshwari on 07-07-2016.
 */
public class Messages {


    static class Message{
        String facultyname;
        String textmessage;
        String date;
        String subjectname;

        public Message(String facultyname, String subjectname, String date, String textmessage) {
            this.facultyname = facultyname;
            this.subjectname = subjectname;
            this.date = date;
            this.textmessage = textmessage;
        }


    }

    static ArrayList<Message> getData(){
        ArrayList<Message> messagedata = new ArrayList<>();

        messagedata.add(new Message("Rakesh Sharma","MA-101","23/05/2016","Last date to submit Assignment 3 is 25/05/16. No assignments will be accepted after that."));
        messagedata.add(new Message("Manisha Joshi","EN-101","22/05/2016","The students whose attendance is less than 75% report to me immediately."));
        messagedata.add(new Message("Narendra Singh","CO-101","20/05/2016","The students must submit their project files latest by 23/05/2016."));
        return messagedata;
    }
}
