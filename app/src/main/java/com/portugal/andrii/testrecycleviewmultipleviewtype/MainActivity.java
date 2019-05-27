package com.portugal.andrii.testrecycleviewmultipleviewtype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Message> list = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        list.add(new Message("MY MESSAGE", Message.MessageType.MY_MESSAGE));
        list.add(new Message("YOUR MESSAGE", Message.MessageType.YOUR_MESSAGE));
        list.add(new Message("Google admob Rewad video", Message.MessageType.RECLAM_MESSAGE));
        list.add(new Message("YOUR MESSAGE 1", Message.MessageType.YOUR_MESSAGE));
        list.add(new Message("MY MESSAGE 1", Message.MessageType.MY_MESSAGE));
        list.add(new Message("YOUR MESSAGE 2", Message.MessageType.YOUR_MESSAGE));
        list.add(new Message("Google admob Rewad video", Message.MessageType.RECLAM_MESSAGE));
        list.add(new Message("YOUR MESSAGE 3", Message.MessageType.YOUR_MESSAGE));
        list.add(new Message("MY MESSAGE 2", Message.MessageType.MY_MESSAGE));
        list.add(new Message("YOUR MESSAGE 4", Message.MessageType.YOUR_MESSAGE));
        list.add(new Message("Google admob Rewad video", Message.MessageType.RECLAM_MESSAGE));
        list.add(new Message("YOUR MESSAGE 5", Message.MessageType.YOUR_MESSAGE));
        AdapterMessage adapterMessage = new AdapterMessage(list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //подключили менеджер разметки
        recyclerView.setAdapter(adapterMessage);    //подключили адаптер
    }

}
