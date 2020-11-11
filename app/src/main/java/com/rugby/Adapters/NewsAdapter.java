package com.rugby.Adapters;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rugby.R;
import com.rugby.Classes.Webview;
import com.rugby.ListModels.ListNews;
import com.rugby.ListModels.ListTeam;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<ListNews> lln;
    private ListNews ln;
    public static String teamWeb;

    public NewsAdapter(Context context, List lln)
    {
        this.context = context;
        this.lln = lln;
    }
    
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setTag(lln.get(position));
        ln = lln.get(position);

        holder.title.setText(ln.getTitle());
        holder.date.setText(ln.getUpdated());
        holder.content.setText(ln.getContent());
        holder.source.setText("Source: "+ln.getOriginalSource());

        /*SpannableString customText = new SpannableString(ln.getTitle());
        customText.setSpan(new RelativeSizeSpan(.1f), 0, 3, 0);
        holder.content.setText(customText);*/

        holder.web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0 ; i<lln.size();i++ ){
                    if(holder.title.getText() == lln.get(i).getTitle()){
                        teamWeb = lln.get(i).getUrl().toString();
                        break;
                    }
                }
                Intent web = new Intent(v.getContext(), Webview.class);
                web.putExtra("link", teamWeb);
                context.startActivity(web);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lln.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,date,content;
        TextView web,source;

        public ViewHolder( View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            content = itemView.findViewById(R.id.content);
            web = itemView.findViewById(R.id.news);
            source = itemView.findViewById(R.id.source);
        }
    }
}
