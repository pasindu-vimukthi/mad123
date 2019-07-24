package com.example.mtrsliit.it17117388;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class AddBook extends AppCompatActivity {


    EditText bookname;
    Spinner sp;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        bookname = findViewById(R.id.bookname);
        sp = findViewById(R.id.spinner);
        sp = findViewById(R.id.spinner2);
        db = new DBHandler(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.book, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        sp.setAdapter(adapter);

    }

    public void add(View view)
    {
        String na = bookname.getText().toString().trim();
        String typ = sp.getSelectedItem().toString().trim();
        String typ = sp2.getSelectedItem().toString().trim();

        if(db.addBook(na,typ))
            {
                Toast.makeText(getApplicationContext(),"Successed !",Toast.LENGTH_LONG).show();
            }
           else
            {
                Toast.makeText(getApplicationContext(),"Error !",Toast.LENGTH_LONG).show();

            }
        }


    }

