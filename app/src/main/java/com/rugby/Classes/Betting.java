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
import com.rugby.Adapters.BetAdapter;
import com.rugby.Adapters.NewsAdapter;
import com.rugby.Connections.Calling;
import com.rugby.Connections.Retrofit;
import com.rugby.ListModels.ListBet;
import com.rugby.ListModels.ListBet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Betting extends AppCompatActivity {

    private RecyclerView rView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;
    private List<ListBet> llb;
    private ProgressDialog pdLoading;
    private BottomNavigationView bottomNavigationView;
    Calling calls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_betting);
        getSupportActionBar().setTitle("Events");
        declare();
        navBottom();
        getBet();
    }

    private void declare()
    {
        calls = new Calling(this);
        pdLoading = new ProgressDialog(this);
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        rView = findViewById(R.id.bView);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bet);
        rView.setHasFixedSize(true);
        rvLayout = new LinearLayoutManager(this);
        rView.setLayoutManager(rvLayout);
    }

    public void getBets(){
        List<ListBet> betModel = calls.loadListBet();
        rvAdapter = new BetAdapter(Betting.this, betModel);
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
                        return true;
                }
                return true;
            }
        });
    }

    private void getBet()
    {

        Retrofit rfit = new Retrofit();
        rfit.retrofitBuilder2();

        Call<List<ListBet>> call = rfit.retrofitBuilder2().getBet(Retrofit.APIKEY);
        call.enqueue(new Callback<List<ListBet>>() {
            @Override
            public void onResponse(Call<List<ListBet>> call, Response<List<ListBet>> response) {
                List<ListBet> teamList = response.body();

                llb =  new ArrayList<>();

                for(int i=0; i<teamList.size(); i++){
                    llb.add(new ListBet(teamList.get(i).getName()
                            ,teamList.get(i).getSeason()
                            ,teamList.get(i).getBettingEventType()
                            ,teamList.get(i).getStartDate()
                            ,teamList.get(i).getGameStatus()));
                    //String city, String name, String conference, String division, String fullName, String wikipediaLogoUrl, String wikipediaWordMarkUrl, StadiumDetails stadiumDetails
                    rvAdapter = new BetAdapter(Betting.this, teamList);
                    rView.setAdapter(rvAdapter);
                    pdLoading.dismiss();

                }
            }

            @Override
            public void onFailure(Call<List<ListBet>> call, Throwable t) {

            }
        });
    }
    
}