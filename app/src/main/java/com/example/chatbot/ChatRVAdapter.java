package com.example.chatbot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatRVAdapter  extends RecyclerView.Adapter {

    private ArrayList<ChatsModal> chatsModalArrayList;
    private Context context;

    public ChatRVAdapter(ArrayList<ChatsModal> chatsModalArrayList, Context context) {
        this.chatsModalArrayList = chatsModalArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType==0){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg_rv_item,parent,false);
            return new UserViewHolder(view);
        } else if (viewType==1) {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg_rv_item,parent,false);
            return new BotViewHolder(view);
        }

//        switch (viewType){
//            case 0:
//                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg_rv_item,parent,false);
//                return new UserViewHolder(view);
//            case 1:
//                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg_rv_item,parent,false);
//                return new BotViewHolder(view);
//        }
         return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatsModal chatsModal=chatsModalArrayList.get(position);
        if(chatsModal.getSender()=="user"){
            ((UserViewHolder)holder).userTV.setText(chatsModal.getMessage());
        }else if(chatsModal.getSender()=="bot"){
            ((BotViewHolder)holder).botMsgTv.setText(chatsModal.getMessage());
        }
//        switch (chatsModal.getSender()){
//            case "user":
//                ((UserViewHolder)holder).userTV.setText(chatsModal.getMessage());
//                break;
//            case "bot":
//                ((BotViewHolder)holder).botMsgTv.setText(chatsModal.getMessage());
//                break;
//        }
    }

    @Override
    public int getItemViewType(int position) {
        if(chatsModalArrayList.get(position).getSender()=="user"){
            return 0;
        }else if(chatsModalArrayList.get(position).getSender()=="bot"){
            return 1;
        }else{
            return -1;
        }
//        switch (chatsModalArrayList.get(position).getSender()){
//            case "user":
//                return 0;
//            case "bot":
//                return 1;
//            default:
//                return -1;
//        }
    }

    @Override
    public int getItemCount() {
        return chatsModalArrayList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        TextView userTV;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userTV=itemView.findViewById(R.id.idTVUser);
        }

    }
    public static class BotViewHolder extends RecyclerView.ViewHolder{
        TextView botMsgTv;
        public BotViewHolder(@NonNull View itemView) {
            super(itemView);
            botMsgTv=itemView.findViewById(R.id.idTVBot);
        }
    }
}
