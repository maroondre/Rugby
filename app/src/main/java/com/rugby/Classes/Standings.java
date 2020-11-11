package com.rugby.Classes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.rugby.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rugby.Adapters.NewsAdapter;
import com.rugby.Adapters.TeamAdapter;
import com.rugby.Adapters.standingAdapter;
import com.rugby.Connections.Calling;
import com.rugby.Connections.Retrofit;
import com.rugby.ListModels.ListNews;
import com.rugby.ListModels.ListStandings;
import com.rugby.ListModels.ListStandings;
import com.rugby.ListModels.ListTeam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Standings extends AppCompatActivity {

    private RecyclerView rView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;
    private List<ListStandings> lls;
    private ProgressDialog pdLoading;
    private BottomNavigationView bottomNavigationView;
    Team teams;
    HashMap<String,String> llt;
    Calling calls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);
        getSupportActionBar().setTitle("Team Stats");
        declare();
        navBottom();
        Logo();
        getStandings();

    }

    private void declare()
    {
        calls = new Calling(Standings.this);
        teams = new Team();
        pdLoading = new ProgressDialog(this);
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        rView = findViewById(R.id.sView);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.schedule);
        llt = new HashMap<>();
        rView.setHasFixedSize(true);
        rvLayout = new LinearLayoutManager(this);
        rView.setLayoutManager(rvLayout);
    }

    private void navBottom()
    {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.news:
                        Intent news = new Intent(getApplicationContext(), News.class);
                        startActivity(news);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.team:
                        Intent team = new Intent(getApplicationContext(), Team.class);
                        startActivity(team);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.schedule:
                        return true;
                    case R.id.bet:
                        Intent bet = new Intent(getApplicationContext(), Betting.class);
                        startActivity(bet);
                        overridePendingTransition(0,0);
                        break;
                }
                return true;
            }
        });
    }

    public HashMap<String, String> getLlt() {
        return llt;
    }

    public void setLlt(String key, String logo) {
        this.llt.put(key, logo);
    }

    public void getStats()
    {
        List<ListStandings> statsModel = calls.loadLisStandings();
        rvAdapter = new standingAdapter(Standings.this, statsModel);
        rView.setAdapter(rvAdapter);
        pdLoading.dismiss();
    }

    public void Logo()
    {
        List<ListTeam> statsModel = calls.loadListTeam();
        for(int i=0; i<statsModel.size(); i++){
            // team[i] = teamList.get(i).getName();
            setLlt(statsModel.get(i).getKey()
                    ,statsModel.get(i).getWikipediaLogoUrl());

        }
        getStandings();
    }

    private void getStandings()
    {
        Retrofit rfit = new Retrofit();
        rfit.retrofitBuilder();

        Call<List<ListStandings>> call = rfit.retrofitBuilder().getStandings("2020",Retrofit.APIKEY);
        call.enqueue(new Callback<List<ListStandings>>() {
            @Override
            public void onResponse(Call<List<ListStandings>> call, Response<List<ListStandings>> response) {
                List<ListStandings> teamList = response.body();

                lls =  new ArrayList<>();

                for(int i=0; i<teamList.size(); i++){
                    lls.add(new ListStandings(teamList.get(i).getSeason()
                            ,teamList.get(i).getTeam()
                            ,teamList.get(i).getScore()
                            ,teamList.get(i).getOpponentScore()
                            ,teamList.get(i).getFirstDowns()
                            ,teamList.get(i).getOffensivePlays()
                            ,teamList.get(i).getTouchdowns()
                            ,teamList.get(i).getTeamName()
                            ,getLlt().get(teamList.get(i).getTeam())));
                    //String city, String name, String conference, String division, String fullName, String wikipediaLogoUrl, String wikipediaWordMarkUrl, StadiumDetails stadiumDetails
                    rvAdapter = new standingAdapter(Standings.this, lls);
                    rView.setAdapter(rvAdapter);
                    pdLoading.dismiss();

                }
            }

            @Override
            public void onFailure(Call<List<ListStandings>> call, Throwable t) {

            }
        });
    }

    private void getLogo()
    {

        Retrofit rfit = new Retrofit();
        rfit.retrofitBuilder();

        Call <List<ListTeam>> call = rfit.retrofitBuilder().getTeam(Retrofit.APIKEY);
        call.enqueue(new Callback<List<ListTeam>>() {
            @Override
            public void onResponse(Call<List<ListTeam>> call, Response<List<ListTeam>> response) {
                List<ListTeam> teamList = response.body();

                for(int i=0; i<response.body().size(); i++){
                    // team[i] = teamList.get(i).getName();
                    setLlt(response.body().get(i).getKey()
                            ,response.body().get(i).getWikipediaLogoUrl());

                }
                getStandings();
            }

            @Override
            public void onFailure(Call<List<ListTeam>> call, Throwable t) {

            }
        });
    }

}