package com.rugby.Connections;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rugby.ListModels.ListAPlayers;
import com.rugby.ListModels.ListBet;
import com.rugby.ListModels.ListNews;
import com.rugby.ListModels.ListPlayers;
import com.rugby.ListModels.ListSchedules;
import com.rugby.ListModels.ListStandings;
import com.rugby.ListModels.ListTeam;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Calling {

    public static final String pref = "sharedPreference";
    public static final String bet = "Betting Events";
    public static final String news = "News";
    public static final String players = "Players";
    public static final String schedule = "Schedules";
    public static final String standings = "Standings";
    public static final String tPlayer = "Team Players";
    public static final String teams = "Team";
    public static final String stadium = "Stadium";

    SharedPreferences spref;
    SharedPreferences.Editor spEditor;
    Context context;
    Activity activity;
    Retrofit rfit;
    int flag = 0;

    public Calling(Context context){
        this.context = context;
        spref = context.getSharedPreferences(pref, Context.MODE_PRIVATE);
        spEditor= spref.edit();
        this.activity = (Activity) this.context;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private SharedPreferences.Editor Editor() {
        return spEditor;
    }

    private SharedPreferences Shared(){
        return spref;
    }

    public <T> void saveData(String call, List<T> model)
    {
        Gson gson = new Gson();
        String jsonString = gson.toJson(model);
        Editor().putString(call,jsonString);
        Editor().apply();
    }

    public List<ListBet> loadListBet(){
        Gson gson = new Gson();
        String json = Shared().getString(bet,"");
        Type type = new TypeToken<List<ListBet>>(){}.getType();
        List<ListBet> model = gson.fromJson(json,type);
        return model;
    }

    public List<ListNews> loadListNews(){
        Gson gson = new Gson();
        String json = Shared().getString(news,"");
        Type type = new TypeToken<List<ListNews>>(){}.getType();
        List<ListNews> model = gson.fromJson(json,type);
        return model;
    }

    public List<ListPlayers> loadListPlayers(){
        Gson gson = new Gson();
        String json = Shared().getString(players,"");
        Type type = new TypeToken<List<ListPlayers>>(){}.getType();
        List<ListPlayers> model = gson.fromJson(json,type);
        return model;
    }

    public List<ListSchedules> loadListSchedule(){
        Gson gson = new Gson();
        String json = Shared().getString(schedule,"");
        Type type = new TypeToken<List<ListSchedules>>(){}.getType();
        List<ListSchedules> model = gson.fromJson(json,type);
        return model;
    }

    public List<ListStandings> loadLisStandings(){
        Gson gson = new Gson();
        String json = Shared().getString(standings,"");
        Type type = new TypeToken<List<ListStandings>>(){}.getType();
        List<ListStandings> model = gson.fromJson(json,type);
        return model;
    }

    public List<ListTeam> loadListTeam(){
        Gson gson = new Gson();
        String json = Shared().getString(teams,"");
        Type type = new TypeToken<List<ListTeam>>(){}.getType();
        List<ListTeam> model = gson.fromJson(json,type);
        return model;
    }

            public void loadTeam()
            {
                rfit =  new Retrofit();
                Call<List<ListTeam>> call = rfit.retrofitBuilder().getTeam(Retrofit.APIKEY);
                call.enqueue(new Callback<List<ListTeam>>() {
                    @Override
                    public void onResponse(Call<List<ListTeam>> call, Response<List<ListTeam>> response) {
                        List<ListTeam> teamlist = response.body();
                        saveData(teams,teamlist);
                        //       Toast.makeText(activity,teams,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<List<ListTeam>> call, Throwable t) {
                        Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }

            public void loadBet()
            {
                rfit =  new Retrofit();
                Call<List<ListBet>> call = rfit.retrofitBuilder2().getBet(Retrofit.APIKEY);
                call.enqueue(new Callback<List<ListBet>>() {
                    @Override
                    public void onResponse(Call<List<ListBet>> call, Response<List<ListBet>> response) {
                        List<ListBet> betList = response.body();
                        saveData(bet,betList);
               //         Toast.makeText(activity,bet,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<List<ListBet>> call, Throwable t) {
                        Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }

            public void loadNews()
            {
                rfit =  new Retrofit();
                Call<List<ListNews>> call = rfit.retrofitBuilder().getNews(Retrofit.APIKEY);
                call.enqueue(new Callback<List<ListNews>>() {
                    @Override
                    public void onResponse(Call<List<ListNews>> call, Response<List<ListNews>> response) {
                        List<ListNews> newsList = response.body();
                        saveData(news,newsList);
//                        Toast.makeText(activity,news,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<List<ListNews>> call, Throwable t) {
                        Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }

            public void loadPlayers()
            {
                rfit =  new Retrofit();
                Call<List<ListAPlayers>> call = rfit.retrofitBuilder().getPlayers(Retrofit.APIKEY);
                call.enqueue(new Callback<List<ListAPlayers>>() {
                    @Override
                    public void onResponse(Call<List<ListAPlayers>> call, Response<List<ListAPlayers>> response) {
                        List<ListAPlayers> playerList = response.body();
                        saveData(players,playerList);
                       // Toast.makeText(activity,players,Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<List<ListAPlayers>> call, Throwable t) {
                        Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }

            public void loadTeamPlayers()
            {
                rfit =  new Retrofit();
                Call<List<ListAPlayers>> call = rfit.retrofitBuilder().getPlayers(Retrofit.APIKEY);
                call.enqueue(new Callback<List<ListAPlayers>>() {
                    @Override
                    public void onResponse(Call<List<ListAPlayers>> call, Response<List<ListAPlayers>> response) {
                        List<ListAPlayers> teamList = response.body();
                        saveData(tPlayer,teamList);
//                        Toast.makeText(activity,tPlayer,Toast.LENGTH_LONG).show();

                    }


                    @Override
                    public void onFailure(Call<List<ListAPlayers>> call, Throwable t) {
                        Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }

            public void loadSchedules()
            {
                rfit =  new Retrofit();
                Call<List<ListSchedules>> call = rfit.retrofitBuilder().getSchedules("2020", Retrofit.APIKEY);
                call.enqueue(new Callback<List<ListSchedules>>() {
                    @Override
                    public void onResponse(Call<List<ListSchedules>> call, Response<List<ListSchedules>> response) {
                        List<ListSchedules> schedules = response.body();
                        saveData(schedule,schedules);
//                        Toast.makeText(activity,schedule,Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<List<ListSchedules>> call, Throwable t) {
                        Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }

            public void loadStandings()
            {
                rfit =  new Retrofit();
                Call<List<ListStandings>> call = rfit.retrofitBuilder().getStandings("2020",Retrofit.APIKEY);
                call.enqueue(new Callback<List<ListStandings>>() {
                    @Override
                    public void onResponse(Call<List<ListStandings>> call, Response<List<ListStandings>> response) {
                        List<ListStandings> standingss = response.body();
                        saveData(standings,standingss);
//                        Toast.makeText(activity,standings,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<List<ListStandings>> call, Throwable t) {
                        Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }


    public void clearData()
    {
        spref.edit().clear().apply();
        spref.edit().apply();
    }
}
