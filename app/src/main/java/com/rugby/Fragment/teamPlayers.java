package com.rugby.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rugby.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rugby.Adapters.TeamAdapter;
import com.rugby.Adapters.apAdapter;
import com.rugby.Adapters.tpAdapter;
import com.rugby.Classes.PlayerTab;
import com.rugby.Classes.Team;
import com.rugby.Connections.Calling;
import com.rugby.Connections.Retrofit;
import com.rugby.ListModels.ListPlayers;
import com.rugby.ListModels.ListTeam;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class teamPlayers extends Fragment {

    private RecyclerView rView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;
    private List<ListPlayers> llp;
    public static List<ListPlayers> ssllp;
    public static ProgressDialog pdLoading;
    private BottomNavigationView bottomNavigationView;
    private View view;
    TeamAdapter ta;
    String nameTeam;
    Calling calls;
    List<ListPlayers> llt;
    
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.allmain, container, false);

        declare();
        getTeamPlayers();
       //getPlayers();
        //ewan();
        return view;
    }

    private void declare()
    {
        calls = new Calling(getActivity());
        llt = new ArrayList<>();
        nameTeam = getActivity().getIntent().getStringExtra("team");
        pdLoading = new ProgressDialog(getActivity());
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        rView = (RecyclerView) view.findViewById(R.id.tpView);
        rView.setHasFixedSize(true);
        rvLayout = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(rvLayout);
        llt = new ArrayList<>();
    }

    public void getTeamPlay(){
        List<ListPlayers> tpModel = calls.loadListPlayers();
        rvAdapter = new apAdapter(getActivity(), tpModel);
        rView.setAdapter(rvAdapter);
        pdLoading.dismiss();
    }

    public void getTeamPlayers()
    {

        Retrofit rfit = new Retrofit();
        rfit.retrofitBuilder();

        Call<List<ListPlayers>> call = rfit.retrofitBuilder().getTeamPlayers(nameTeam,Retrofit.APIKEY);
        call.enqueue(new Callback<List<ListPlayers>>() {
            @Override
            public void onResponse(Call<List<ListPlayers>> call, Response<List<ListPlayers>> response) {
                List<ListPlayers> teamList = response.body();

                String[] team = new String[teamList.size()];
                llp =  new ArrayList<>();

                for(int i=0; i<teamList.size(); i++){
                    // team[i] = teamList.get(i).getName();
                    llp.add(new ListPlayers(teamList.get(i).getPlayerID()
                            ,teamList.get(i).getTeam()
                            ,teamList.get(i).getNumber()
                            ,teamList.get(i).getPosition()
                            ,teamList.get(i).getStatus()
                            ,teamList.get(i).getHeight()
                            ,teamList.get(i).getWeight()
                            ,teamList.get(i).getCollege()
                            ,teamList.get(i).getExperience()
                            ,teamList.get(i).getFantasyPosition()
                            ,teamList.get(i).getActive()
                            ,teamList.get(i).getPositionCategory()
                            ,teamList.get(i).getName()
                            ,teamList.get(i).getAge()
                            ,teamList.get(i).getExperienceString()
                            ,teamList.get(i).getBirthDateString()
                            ,teamList.get(i).getPhotoUrl()));
                    //String city, String name, String conference, String division, String fullName, String wikipediaLogoUrl, String wikipediaWordMarkUrl, StadiumDetails stadiumDetails
                    rvAdapter = new tpAdapter(getActivity(), llp);
                    rView.setAdapter(rvAdapter);
                    pdLoading.dismiss();

                }
            }

            @Override
            public void onFailure(Call<List<ListPlayers>> call, Throwable t) {

            }
        });
    }

    
}
