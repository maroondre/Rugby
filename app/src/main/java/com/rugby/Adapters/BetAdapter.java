package com.rugby.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rugby.R;
import com.rugby.ListModels.ListBet;

import java.util.List;

public class BetAdapter extends RecyclerView.Adapter<BetAdapter.ViewHolder> {

    private Context context;
    private List<ListBet> llb;
    ListBet lb;

    public BetAdapter(Context context, List llb)
    {
        this.context = context;
        this.llb = llb;
    }

    @Override
    public BetAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bet, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( BetAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(llb.get(position));
        lb = llb.get(position);

        holder.battle.setText(lb.getName());
        holder.season.setText("Season: "+lb.getSeason().toString());
        holder.betdate.setText(lb.getStartDate());
        holder.event.setText(lb.getBettingEventType());
        holder.status.setText(lb.getGameStatus());
    }

    @Override
    public int getItemCount() {
        return llb.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView event,status,betdate,battle,season;

        public ViewHolder( View itemView) {
            super(itemView);
            event = itemView.findViewById(R.id.event);
            status = itemView.findViewById(R.id.status);
            betdate = itemView.findViewById(R.id.betDate);
            battle = itemView.findViewById(R.id.battle);
            season =  itemView.findViewById(R.id.season);
        }
    }
}
