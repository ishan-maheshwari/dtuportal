package com.codingblocks.dtuportal;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageActivity extends AppCompatActivity {

    ArrayList<Messages.Message> messagedata = new ArrayList<>();
    ListView messagelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        messagelist = (ListView) findViewById(R.id.list_msg);
        messagedata = Messages.getData();

        final FragmentManager fragmentManager = getSupportFragmentManager();
        MessageAdapter messageAdapter = new MessageAdapter(messagedata);
        messagelist.setAdapter(messageAdapter);

        messagelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fragment frg = fragment.newInstance(position);
                FragmentTransaction fTxn = fragmentManager.beginTransaction();
                fTxn.replace(R.id.frag_container,frg);
                fTxn.commit();
            }
        });
    }

    class MessageAdapter extends BaseAdapter{

        ArrayList<Messages.Message> list = new ArrayList<>();

        class MessageViewHolder{
            TextView faculty_name;
            TextView subject_name;
        }

        MessageAdapter(ArrayList<Messages.Message> list){
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Messages.Message getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MessageViewHolder messageViewHolder = new MessageViewHolder();
            LayoutInflater li = getLayoutInflater();
            convertView = li.inflate(R.layout.message_list_item,null);

            messageViewHolder.faculty_name = (TextView) convertView.findViewById(R.id.sender_name);
            messageViewHolder.subject_name = (TextView) convertView.findViewById(R.id.message_subject);
            convertView.setTag(messageViewHolder);

            Messages.Message thisMessage = getItem(position);
            messageViewHolder.faculty_name.setText(thisMessage.facultyname);
            messageViewHolder.subject_name.setText(thisMessage.subjectname);

            return convertView;
        }
    }
}
