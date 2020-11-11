package com.rugby.Adapters;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rugby.R;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.rugby.ListModels.ListStandings;
import com.rugby.ListModels.ListTeam;

import java.util.List;

public class standingAdapter extends RecyclerView.Adapter<standingAdapter.ViewHolder> {

    public String nameOfTeam,fullteamname;
    private Context context;
    public static List<ListStandings> lls;
    private ListStandings ls;

    private static List<ListTeam> llt;
    private static ListTeam lt;

    public standingAdapter(Context context, List lls)
    {
        this.context = context;
        this.lls = lls;
    }

    @Override
    public standingAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.standings, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( standingAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(lls.get(position));
        ls=lls.get(position);

        holder.tName.setText(ls.getTeamName());
        holder.score.setText(ls.getScore());
        holder.oScore.setText(ls.getOpponentScore());
        holder.tDown.setText(ls.getTouchdowns());
        holder.fDown.setText(ls.getFirstDowns());
        holder.oPlays.setText(ls.getOffensivePlays());
        holder.year.setText(ls.getSeason());
        GlideToVectorYou.justLoadImage((Activity) context, Uri.parse(ls.getTeamLogo()),holder.img);

    }

    @Override
    public int getItemCount() {
        return lls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tName,score,oScore,tDown,fDown,oPlays,year;
        ImageView img;
        public ViewHolder( View itemView) {
            super(itemView);

            tName = itemView.findViewById(R.id.team_name);
            score = itemView.findViewById(R.id.score);
            oScore = itemView.findViewById(R.id.os);
            tDown = itemView.findViewById(R.id.td);
            fDown = itemView.findViewById(R.id.fd);
            oPlays = itemView.findViewById(R.id.offPlays);
            year = itemView.findViewById(R.id.year);
            img = itemView.findViewById(R.id.idlogo);

        }
    }
}
