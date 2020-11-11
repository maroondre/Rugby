package com.rugby.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rugby.R;
import com.rugby.ListModels.ListPlayers;
import com.squareup.picasso.Picasso;

import java.util.List;

public class tpAdapter extends RecyclerView.Adapter<tpAdapter.ViewHolder> {

    private Context context;
    private List<ListPlayers> llp;
    private ListPlayers lp;

    public tpAdapter(Context context, List llp)
    {
        this.context = context;
        this.llp = llp;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tplayers, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    public String getPositions(String position1)
    {
        String position = position1;
        switch (position){
            case "DL":
                position = "Defensive Line";
                break;
            case "TE":
                position = "Tight End";
                break;
            case "LS":
                position = "Long Snapper";
                break;
            case "WR":
                position = "Wide Receivers";
                break;
            case "OL":
                position = "Offensive Line";
                break;
            case "LB":
                position = "Line Breaker";
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

        public ViewHolder( View itemView) {
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
