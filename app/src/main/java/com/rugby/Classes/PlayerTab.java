package com.rugby.Classes;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.example.rugby.R;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.rugby.Adapters.ViewPageAdapter;
import com.rugby.Adapters.apAdapter;
import com.rugby.Connections.Retrofit;
import com.rugby.Fragment.allPlayers;
import com.rugby.Fragment.teamPlayers;
import com.rugby.ListModels.ListAPlayers;
import com.rugby.ListModels.ListAPlayers;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerTab extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    allPlayers ap;
    teamPlayers tp;
    apAdapter apTer;
    public static List<ListAPlayers> sllp;
    List<ListAPlayers> llps;
    public String nameTeam;
    SearchView srchView;
    private ProgressDialog pdLoading;

    @SuppressLint("RestrictedApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_tab);
        getSupportActionBar().setTitle("Rugby Player");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        nameTeam = getIntent().getStringExtra("team");
        pdLoading = new ProgressDialog(this);
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        ap = new allPlayers();
        ap.getPlayers();
        tp =  new teamPlayers();
        tp.getTeamPlayers();
        viewPager =findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(PlayerTab.this.getSupportFragmentManager(),0);
        viewPageAdapter.addFragment(tp, "Team Players");
        viewPageAdapter.addFragment(ap, "All Players");
        viewPager.setAdapter(viewPageAdapter);
        pdLoading.dismiss();
    }

    public void getPlayerss()
    {

        Retrofit rfit = new Retrofit();
        rfit.retrofitBuilder();

        Call<List<ListAPlayers>> call = rfit.retrofitBuilder().getPlayers(Retrofit.APIKEY);
        call.enqueue(new Callback<List<ListAPlayers>>() {
            @Override
            public void onResponse(Call<List<ListAPlayers>> call, Response<List<ListAPlayers>> response) {
                List<ListAPlayers> teamList = response.body();

                String[] team = new String[teamList.size()];
                sllp =  new ArrayList<>();

                for(int i=0; i<teamList.size(); i++){

                    if(teamList.get(i).getStatus().equals("Active")){
                        sllp.add(new ListAPlayers(teamList.get(i).getPlayerID()
                                , teamList.get(i).getTeam()
                                , teamList.get(i).getNumber()
                                , teamList.get(i).getPosition()
                                , teamList.get(i).getStatus()
                                , teamList.get(i).getHeight()
                                , teamList.get(i).getWeight()
                                , teamList.get(i).getCollege()
                                , teamList.get(i).getExperience()
                                , teamList.get(i).getFantasyPosition()
                                , teamList.get(i).getActive()
                                , teamList.get(i).getPositionCategory()
                                , teamList.get(i).getName()
                                , teamList.get(i).getAge()
                                , teamList.get(i).getExperienceString()
                                , teamList.get(i).getBirthDateString()
                                , teamList.get(i).getPhotoUrl()));
                        //String city, String name, String conference, String division, String fullName, String wikipediaLogoUrl, String wikipediaWordMarkUrl, StadiumDetails stadiumDetails
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ListAPlayers>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
