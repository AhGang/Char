package com.example.wangpeijiang.testdemo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wangpeijiang.testdemo.Entity.Msg;
import com.example.wangpeijiang.testdemo.R;

import java.util.List;

/**
 * Created by wangpeijiang on 2018/3/14.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder>{
    private List<Msg>mMsgList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout leftLayout;
        RelativeLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        ImageView receivedImg;
        ImageView sentImg;

        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout = (RelativeLayout)itemView.findViewById(R.id.left_layout);
            rightLayout = (RelativeLayout)itemView.findViewById(R.id.right_layout);
            leftMsg = (TextView) itemView.findViewById(R.id.left_msg);
            rightMsg = (TextView)itemView.findViewById(R.id.right_msg);
            receivedImg = (ImageView)itemView.findViewById(R.id.received_img);
            sentImg = (ImageView)itemView.findViewById(R.id.sent_img);

        }
    }
    public MsgAdapter(List<Msg>msgList){
        mMsgList = msgList;
    }
    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(parent.getContext()).
                   inflate(R.layout.mgs_item,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if(msg.getType() ==Msg.TYPE_RECEIVER){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());

        }
        else if(msg.getType() ==Msg.TYPE_SENT){
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}
