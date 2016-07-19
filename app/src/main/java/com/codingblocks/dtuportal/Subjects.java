package com.codingblocks.dtuportal;

import java.util.ArrayList;

/**
 * Created by Ishan Maheshwari on 06-07-2016.
 */
public class Subjects {

   static class Subject{
        String name;
        int classes_attended;
        int classes_total;
        float attendance_perc;
        String faculty;

        public Subject(String name, int classes_attended, int classes_total, String faculty) {
            this.name = name;
            this.classes_attended = classes_attended;
            this.classes_total = classes_total;
            this.faculty = faculty;
            attendance_perc = (classes_attended/classes_total)*100;
        }
    }

   static ArrayList<Subject> getData(){
        ArrayList<Subject> data = new ArrayList<>();

        data.add(new Subject("MA-101",9,11,"Rakesh Sharma"));
        data.add(new Subject("AP-101",10,13,"Neeraj Kumar"));
        data.add(new Subject("CO-101",12,16,"Narendra Singh"));
        data.add(new Subject("EN-101",7,11,"Manisha Joshi"));
        data.add(new Subject("ME-101",8,13,"Naveen Singh"));

        return data;
    }

}
