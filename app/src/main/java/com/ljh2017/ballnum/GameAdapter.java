package com.ljh2017.ballnum;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alfo06-15 on 2017-09-07.
 */

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    ArrayList<item> items;
    Context context;

    public GameAdapter(ArrayList<item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public GameAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        ViewHolder holder = new ViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(GameAdapter.ViewHolder holder, int position) {

        holder.cnt.setText(items.get(position).cnt+" 회");

        for(int i=0;i<10;i++) {
            if ( items.get(position).num1 == i ){
                holder.num1.setImageResource(R.drawable.c0+i);
                //Glide.with(context).load(R.drawable.c0+i).into(holder.num1);
            }
            if ( items.get(position).num2 == i ){
                holder.num2.setImageResource(R.drawable.c0+i);
                //Glide.with(context).load(R.drawable.c0+i).into(holder.num2);
            }
            if ( items.get(position).num3 == i ){
                holder.num3.setImageResource(R.drawable.c0+i);
                //Glide.with(context).load(R.drawable.c0+i).into(holder.num3);
            }
        }

        holder.s.setText(items.get(position).s);
        holder.b.setText(items.get(position).b);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView cnt;
        ImageView num1,num2,num3;
        TextView s;
        TextView b;

        public ViewHolder(View itemView) {
            super(itemView);

            cnt = (TextView) itemView.findViewById(R.id.cnt);
            num1 = (ImageView) itemView.findViewById(R.id.num1);
            num2 = (ImageView) itemView.findViewById(R.id.num2);
            num3 = (ImageView) itemView.findViewById(R.id.num3);
            s = (TextView) itemView.findViewById(R.id.num_s);
            b = (TextView) itemView.findViewById(R.id.num_b);

        }
    }
}
