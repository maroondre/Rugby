package com.rugby.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rugby.R;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.rugby.Classes.PlayerTab;
import com.rugby.ListModels.ListTeam;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    public String nameOfTeam,fullteamname;
    private Context context;
    public static List<ListTeam> llt;
    private ListTeam lt;

    public TeamAdapter(Context context, List llt)
    {
        this.context = context;
        this.llt = llt;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.team, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(llt.get(position));
        lt = llt.get(position);

        holder.teamName.setText(lt.getFullName());
        fullteamname = holder.teamName.getText().toString();
        holder.teamDiv.setText(lt.getDivision());
        holder.teamConf.setText(lt.getConference());
        holder.txtKey.setText(lt.getKey());
        //nameOfTeam = holder.txtKey.getText().toString();
        GlideToVectorYou.justLoadImage((Activity) context,Uri.parse(lt.getWikipediaLogoUrl()),holder.teamImage);


    }

    @Override
    public int getItemCount() {
        return llt.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView teamImage;
        TextView teamName, teamDiv, teamConf,txtKey;
        CardView tView;
        WebView web;
        public ViewHolder(final View itemView) {
            super(itemView);

            teamImage = itemView.findViewById(R.id.teamImage);
            teamName = itemView.findViewById(R.id.teamName);
            teamConf = itemView.findViewById(R.id.conference);
            teamDiv = itemView.findViewById(R.id.division);
            txtKey = itemView.findViewById(R.id.key);
            tView = itemView.findViewById(R.id.tView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i=0 ; i<llt.size();i++ ){
                        if(txtKey.getText() == llt.get(i).getKey()){
                            Intent players = new Intent(context, PlayerTab.class);
                            players.putExtra("team", txtKey.getText());
                            context.startActivity(players);
                            break;
                        }
                    }

                }
            });
        }
    }
}
