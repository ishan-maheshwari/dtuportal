package com.codingblocks.dtuportal;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity {
        ArrayList<Subjects.Subject> data = new ArrayList<>();
        ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        data = Subjects.getData();
        list = (ListView) findViewById(R.id.list_view);

        SubjectAdapter subjectAdapter = new SubjectAdapter(data);
        list.setAdapter(subjectAdapter);

    }

    class SubjectAdapter  extends BaseAdapter{

        ArrayList<Subjects.Subject> data = new ArrayList<>();

        class SubjectViewHolder{
            TextView subject;
            TextView score;
            TextView perc;
        }

        SubjectAdapter(ArrayList<Subjects.Subject> data){
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Subjects.Subject getItem(int position) {
            return data.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SubjectViewHolder subjectViewHolder = new SubjectViewHolder();
            LayoutInflater li = getLayoutInflater();

            convertView = li.inflate(R.layout.list_item,null);
            subjectViewHolder.subject = (TextView) convertView.findViewById(R.id.subject_name);
            subjectViewHolder.score = (TextView) convertView.findViewById(R.id.score);
            subjectViewHolder.perc = (TextView) convertView.findViewById(R.id.perc);

            convertView.setTag(subjectViewHolder);

            Subjects.Subject thisSubject = getItem(position);

            subjectViewHolder.subject.setText(thisSubject.name);
            subjectViewHolder.score.setText(thisSubject.classes_attended + "/" + thisSubject.classes_total + " Attended");

            thisSubject.attendance_perc = ((float)thisSubject.classes_attended/(float)thisSubject.classes_total)*100;

            subjectViewHolder.perc.setText(Float.toString(thisSubject.attendance_perc) + "%");
            if(thisSubject.attendance_perc<75){
                subjectViewHolder.perc.setTextColor(Color.RED);
            } else {
                subjectViewHolder.perc.setTextColor(Color.GREEN);
            }


            return convertView;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
}
