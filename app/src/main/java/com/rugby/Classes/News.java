package com.rugby.Classes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.rugby.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rugby.Adapters.BetAdapter;
import com.rugby.Adapters.NewsAdapter;
import com.rugby.Adapters.apAdapter;
import com.rugby.Connections.API;
import com.rugby.Connections.Calling;
import com.rugby.Connections.Retrofit;
import com.rugby.ListModels.ListBet;
import com.rugby.ListModels.ListNews;
import com.rugby.ListModels.ListPlayers;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class News extends AppCompatActivity {

    private RecyclerView rView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;
    private List<ListNews> llt;
    public static List<ListPlayers> llp;
    private ProgressDialog pdLoading;
    private BottomNavigationView bottomNavigationView;
    private TextView content;
    CountDownTimer cdt;
    Calling calls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        getSupportActionBar().setTitle("Daily NFL News");
        declare();
        navBottom();
        //hideText();
         //getPlayers();
         getTeamCall();

    }

    private void declare()
    {
        calls = new Calling(this);
        //calls.loadPlayers();
        pdLoading = new ProgressDialog(this);
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        rView = findViewById(R.id.nView);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.news);
        rView.setHasFixedSize(true);
        rvLayout = new LinearLayoutManager(this);
        rView.setLayoutManager(rvLayout);
    }

    public void getNews(){
        List<ListNews> newsModel = calls.loadListNews();
        rvAdapter = new NewsAdapter(News.this, newsModel);
        rView.setAdapter(rvAdapter);
        pdLoading.dismiss();
    }

    private void navBottom()
    {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.team:
                        Intent team = new Intent(getApplicationContext(), Team.class);
                        startActivity(team);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.schedule:
                        Intent fragment = new Intent(getApplicationContext(), Standings.class);
                        startActivity(fragment);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.bet:
                        Intent bet = new Intent(getApplicationContext(), Betting.class);
                        startActivity(bet);
                        overridePendingTransition(0,0);
                        break;
                        case R.id.news:
                        return true;
                }
                return true;
            }
        });
    }

    private void getTeamCall()
    {

      Retrofit rfit = new Retrofit();
        rfit.retrofitBuilder();

        Call<List<ListNews>> call = rfit.retrofitBuilder().getNews(Retrofit.APIKEY);
        call.enqueue(new Callback<List<ListNews>>() {
            @Override
            public void onResponse(Call<List<ListNews>> call, Response<List<ListNews>> response) {
                List<ListNews> teamList = response.body();

              //  String[] team = new String[teamList.size()];
                llt =  new ArrayList<>();

                for(int i=0; i<teamList.size(); i++){
                                    // team[i] = teamList.get(i).getName();
                    llt.add(new ListNews(teamList.get(i).getSource()
                            ,teamList.get(i).getUpdated()
                            ,teamList.get(i).getTitle()
                            ,teamList.get(i).getContent()
                            ,teamList.get(i).getUrl()
                            ,teamList.get(i).getTermsOfUse()
                            ,teamList.get(i).getOriginalSource()));
                    //String city, String name, String conference, String division, String fullName, String wikipediaLogoUrl, String wikipediaWordMarkUrl, StadiumDetails stadiumDetails
                    rvAdapter = new NewsAdapter(News.this, teamList);
                    rView.setAdapter(rvAdapter);
                     pdLoading.dismiss();

                }
            }

            @Override
            public void onFailure(Call<List<ListNews>> call, Throwable t) {

            }
        });
    }
}