package com.theironyard.contactmanager2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.theironyard.contactmanager2.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayAdapter<String> items;

    EditText name;
    EditText phone;
    EditText email;
    Button addButton;
    ListView list;
    View.OnClickListener onClickListener;
    String contact;
    boolean onItemLongClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.editText);
        phone = (EditText) findViewById(R.id.editText3);
        email = (EditText) findViewById(R.id.editText2);
        addButton = (Button) findViewById(R.id.button);


        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        list.setAdapter(items);

        addButton.setOnClickListener(this);
    }


    public void onClick(View v) {
        String item = name.getText().toString() + phone.getText().toString() + email.getText().toString();
        items.add(item);
        items.remove("");
        name.setText("");
        phone.setText("");
        email.setText("");
    }

    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        return true;

    }
}


