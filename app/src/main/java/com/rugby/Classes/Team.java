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
import com.rugby.Connections.API;
import com.rugby.Connections.Calling;
import com.rugby.Connections.Retrofit;
import com.rugby.ListModels.ListNews;
import com.rugby.ListModels.ListTeam;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Team extends AppCompatActivity {

    private RecyclerView rView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;
    private List<ListTeam> llt;
    private ProgressDialog pdLoading;
    private BottomNavigationView bottomNavigationView;
    String apikey;
    Calling calls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        getSupportActionBar().setTitle("Team");
        declare();
        navBottom();
        getTeam();
    }

    private void declare()
    {
        calls = new Calling(Team.this);
        pdLoading = new ProgressDialog(this);
        pdLoading.setMessage("\tPlease Wait ..");
        pdLoading.setCancelable(false);
        pdLoading.show();
        rView = findViewById(R.id.tView);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.team);
        rView.setHasFixedSize(true);
        rvLayout = new LinearLayoutManager(this);
        rView.setLayoutManager(rvLayout);
    }

    public void getTeam(){
        List<ListTeam> teamModel = calls.loadListTeam();
        rvAdapter = new TeamAdapter(Team.this, teamModel);
        rView.setAdapter(rvAdapter);
        pdLoading.dismiss();
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
                        return true;
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
                }
                return true;
            }
        });
    }

    public void getTeamCall()
    {

      Retrofit rfit = new Retrofit();
        rfit.retrofitBuilder();
        apikey = String.valueOf(API.APIKEY);

        Call <List<ListTeam>> call = rfit.retrofitBuilder().getTeam(apikey);
        call.enqueue(new Callback<List<ListTeam>>() {
            @Override
            public void onResponse(Call<List<ListTeam>> call, Response<List<ListTeam>> response) {
                List<ListTeam> teamList = response.body();

                String[] team = new String[teamList.size()];
                llt =  new ArrayList<>();

                for(int i=0; i<teamList.size(); i++){
                   // team[i] = teamList.get(i).getName();
                    llt.add(new ListTeam(teamList.get(i).getKey()
                                        ,teamList.get(i).getName()
                                        ,teamList.get(i).getConference()
                                        ,teamList.get(i).getDivision()
                                        ,teamList.get(i).getFullName()
                                        ,teamList.get(i).getWikipediaLogoUrl()
                                        ,teamList.get(i).getWikipediaWordMarkUrl()));
                    //String city, String name, String conference, String division, String fullName, String wikipediaLogoUrl, String wikipediaWordMarkUrl, StadiumDetails stadiumDetails
                    rvAdapter = new TeamAdapter(Team.this, llt);
                    rView.setAdapter(rvAdapter);
                    pdLoading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<ListTeam>> call, Throwable t) {

            }
        });
    }
}