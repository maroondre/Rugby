package com.rugby.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rugby.R;
import com.rugby.ListModels.ListAPlayers;
import com.rugby.ListModels.ListPlayers;
import com.rugby.ListModels.ListTeam;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class apAdapter extends RecyclerView.Adapter<apAdapter.ViewHolder>  {

    private Context context;
    private List<ListAPlayers> llp;
    private ListAPlayers lp;

    public apAdapter(Context context, List llp)
    {
        this.context = context;
        this.llp = llp;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.allplayers, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    public String getPositions(String position1)
    {
        String position = position1;
        switch (position){
            case "DL":
            case "DT":
            case "DE":
                position = "Defensive Line";
                break;
            case "TE":
                position = "Tight End";
                break;
            case "LS":
                position = "Long Snapper";
                break;
            case "WR":
                position = "Wide Receiver";
                break;
            case "OL":
                position = "Offensive Line";
                break;
            case "LB":
            case "OLB":
            case "ILB":
            case "MLB":
                position = "Line Backer";
                break;
            case "RB":
                position = "Running Back";
                break;
            case "FB":
                position = "Full Back";
                break;
            case "DB":
                position = "Quarter Back";
                break;
            case "CB":
                position = "Corner Back";
                break;
            case "K":
                position = "Kicker";
                break;
            case "P":
                position = "Punter";
                break;
            case "S":
                position = "Safety";
                break;
            case "QB":
                position = "QuarterBack";
                break;
            case "C":
                position = "Center";
                break;
        }
        return position;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.itemView.setTag(llp.get(position));
        lp = llp.get(position);

        holder.txtName.setText(lp.getName());
        holder.txtNum.setText("#"+lp.getNumber());
        holder.txtTeam.setText(lp.getTeam());
        holder.txtPos.setText(getPositions(lp.getPosition()));
        holder.txtWeight.setText(lp.getWeight());
        holder.txtHeight.setText(lp.getHeight());
        Picasso.get().load(llp.get(position).getPhotoUrl()).into(holder.imgPlayer);


    }

    @Override
    public int getItemCount() {
        return llp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPlayer;
        TextView txtName, txtNum, txtTeam, txtPos, txtWeight, txtHeight;

        public ViewHolder(final View itemView) {
            super(itemView);

            imgPlayer = itemView.findViewById(R.id.imgID);
            txtName = itemView.findViewById(R.id.name);
            txtNum = itemView.findViewById(R.id.num);
            txtTeam = itemView.findViewById(R.id.team);
            txtPos = itemView.findViewById(R.id.pos);
            txtWeight = itemView.findViewById(R.id.weight);
            txtHeight = itemView.findViewById(R.id.height);
        }
    }
}
