package com.example.esoukhanov.androidlab_1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends Activity {

    private ListView lv;
    private EditText ed;
    private Button bt;
    ChatAdapter messageAdapter;
    ArrayList<String> arrList_edit = new ArrayList<>();

    private class ChatAdapter extends ArrayAdapter<String>{
        //constructor for ChatAdapter that takes a Context parameter,
        // and passes it to the parent constructor (ArrayAdapter)
        ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        @Override
        public int getCount() {
            //returns the number of rows that
            // will be in the listView,the number of strings in the array list
            return arrList_edit.size();
        }

        @Override
        public String getItem(int position){
            //returns the item to show in the list at the specified position
            return arrList_edit.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null ;
            if(position%2 == 0)
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            else
                result = inflater.inflate(R.layout.chat_row_incoming, null);

            TextView message = (TextView)result.findViewById(R.id.message_text);
            message.setText(   getItem(position)  ); // get the string at position
            return result;//this returns the layout that will be positioned at the specified row in the list
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        lv = (ListView) findViewById(R.id.list_view);
        ed = (EditText) findViewById(R.id.edit_text);
        bt = (Button) findViewById(R.id.send_button);
        //“this” is the ChatWindow, which is-A Context object
        messageAdapter = new ChatAdapter(this);
        lv.setAdapter (messageAdapter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get text from the EditText field and put into array list
                String text_ed = ed.getText().toString();
                arrList_edit.add(text_ed);
                messageAdapter.notifyDataSetChanged(); //this restarts the process of getCount()/                getView()
                ed.setText("");
            }
        });
    }
}

