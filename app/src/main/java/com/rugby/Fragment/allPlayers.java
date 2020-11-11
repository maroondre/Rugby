package com.rugby.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rugby.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rugby.Adapters.apAdapter;
import com.rugby.Classes.PlayerTab;
import com.rugby.Connections.Calling;
import com.rugby.Connections.Retrofit;
import com.rugby.ListModels.ListAPlayers;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.rugby.Classes.PlayerTab.sllp;

public class allPlayers extends Fragment {

    private RecyclerView rView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;
    private List<ListAPlayers> llp;
    private apAdapter apTer;
    private ProgressDialog pdLoading;
    private BottomNavigationView bottomNavigationView;
    private View view;
    public String status;
    Calling calls;
    teamPlayers TP;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.all_player, container, false);
        declare();
        getPlayers();

        return view;
    }

    private void declare()
    {
        pdLoading = new ProgressDialog(getActivity());
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(true);
        rView = (RecyclerView) view.findViewById(R.id.apView);
        rView.setHasFixedSize(true);
        rvLayout = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(rvLayout);
    }


    public void getPlayrs(){
        rvAdapter = new apAdapter(getActivity(), sllp);
        rView.setAdapter(rvAdapter);
        pdLoading.dismiss();
    }

    public void getPlayers()
    {

        Retrofit rfit = new Retrofit();
        rfit.retrofitBuilder();

        Call<List<ListAPlayers>> call = rfit.retrofitBuilder().getPlayers(Retrofit.APIKEY);
        call.enqueue(new Callback<List<ListAPlayers>>() {
            @Override
            public void onResponse(Call<List<ListAPlayers>> call, Response<List<ListAPlayers>> response) {
                List<ListAPlayers> teamList = response.body();

                String[] team = new String[teamList.size()];
                llp =  new ArrayList<ListAPlayers>();

                for(int i=0; i<100; i++){

                    if(teamList.get(i).getStatus().equals("Active")){
                        llp.add(new ListAPlayers(teamList.get(i).getPlayerID()
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
                        rvAdapter = new apAdapter(getActivity(), llp);
                        rView.setAdapter(rvAdapter);
                        pdLoading.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ListAPlayers>> call, Throwable t) {

            }
        });
    }
}
