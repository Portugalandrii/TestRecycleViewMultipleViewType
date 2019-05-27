package com.portugal.andrii.testrecycleviewmultipleviewtype;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class AdapterMessage extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static final int MY_MESSAGE = 1;
    static final int YOUR_MESSAGE = 2;
    static final int RECLAM_MESSAGE = 3;
    ArrayList<Message> list;

    Context context; // объявляем объект context для Toast

    public AdapterMessage(ArrayList<Message> list, Context context) {
        this.list = list;
        this.context = context; // инициализируем context для Toast
    }

    @Override
    public int getItemViewType(int position) {    //определяет, какую разметку использовать для строки
        Message message = list.get(position);
        if (message.getType() == Message.MessageType.MY_MESSAGE) {
            return MY_MESSAGE;
        } else if (message.getType() == Message.MessageType.YOUR_MESSAGE) {
            return YOUR_MESSAGE;
        } else return RECLAM_MESSAGE;
    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MY_MESSAGE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_message, parent, false);
            return new ViewHolderMyMessage(view);
        }
        else if (viewType == YOUR_MESSAGE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.your_message, parent, false);
            return new ViewHolderYourMessage(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reclam_message, parent, false);
            return new ViewHolderReclamMessage(view);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int listPosition) {
         switch (viewHolder.getItemViewType()){
             case MY_MESSAGE:
                 initViewHolderMyMessage((ViewHolderMyMessage) viewHolder, listPosition);
                 break;
             case YOUR_MESSAGE:
                 initViewHolderYourMessage((ViewHolderYourMessage) viewHolder, listPosition);
                 break;
             case RECLAM_MESSAGE:
                 initViewHolderReclamMessage((ViewHolderReclamMessage) viewHolder, listPosition);
                 break;
             default: break;
         }
    }
    // функции нужны для того, что бы создать видимым textView (обращаться к нему)

    private void initViewHolderMyMessage(ViewHolderMyMessage viewHolderMyMessage, int position){
        viewHolderMyMessage.textView.setText(list.get(position).getContext());
        viewHolderMyMessage.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "CALLBACK TO Activity", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initViewHolderYourMessage(ViewHolderYourMessage viewHolderYourMessage, int position){
        viewHolderYourMessage.textView.setText(list.get(position).getContext());
    }

    private void initViewHolderReclamMessage(ViewHolderReclamMessage viewHolderReclamMessage, int position){
        viewHolderReclamMessage.textView.setText(list.get(position).getContext());
        viewHolderReclamMessage.button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://admob.google.com"));
                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolderMyMessage extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView textView;
        public ViewHolderMyMessage(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.my_message);
            cardView = itemView.findViewById(R.id.card_my_message);
        }

    }
    class ViewHolderYourMessage extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolderYourMessage(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.your_message);
        }
    }
    class ViewHolderReclamMessage extends RecyclerView.ViewHolder {
        public Button button;
        public TextView textView;
        public ViewHolderReclamMessage(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.reclame_message);
            button = (Button) itemView.findViewById(R.id.button);
        }

    }

}
