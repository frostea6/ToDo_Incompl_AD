package com.example.todolist;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.ui.AppBarConfiguration;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private  ArrayList<String> items;
   private  ListView list;
   private  Button button;
   private ArrayAdapter<String> itemsAdapter;


    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addition(view);
            }
                                  });

             items = new ArrayList<>();
             itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
             list.setAdapter(itemsAdapter);

    }

    private void addition(View view) {
        EditText input = findViewById(R.id.edit_text);
        String itemText = input.getText().toString();

        if(!(itemText.equals(""))){
            itemsAdapter.add(itemText);
            input.setText("");

        }
        else{
            Toast.makeText(getApplicationContext(),"Please Enter Text..", Toast.LENGTH_LONG).show();
        }
        }

}