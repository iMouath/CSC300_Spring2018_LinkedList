package com.example.awesomefat.csc300_spring2018_linkedlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedList ll = new LinkedList();

        ll.addFront(1);
        ll.addFront(2);
        ll.addFront(3);
        
        ll.display();
    }
}
