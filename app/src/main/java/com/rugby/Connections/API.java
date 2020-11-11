package com.rugby.Connections;

import com.rugby.ListModels.ListAPlayers;
import com.rugby.ListModels.ListBet;
import com.rugby.ListModels.ListNews;
import com.rugby.ListModels.ListPlayers;
import com.rugby.ListModels.ListSchedules;
import com.rugby.ListModels.ListStandings;
import com.rugby.ListModels.ListTeam;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface API {

    String APIKEY = "31d4cdf3e1ae40a5b3ca680e30cc99a1";
    String SportsIO = "https://api.sportsdata.io/v3/nfl/scores/json/";
    String Betting = "https://api.sportsdata.io/v3/nfl/odds/json/BettingEvents/";
    //String standings = "https://api.sportsdata.io/v3/nfl/scores/json/TeamSeasonStats/2020?key=40b83b78200242818b5077cf6e5d7992";

  //  @Headers("Ocp-Apim-Subscription-Key: 40b83b78200242818b5077cf6e5d7992")

    @GET("Players?")
    Call<List<ListAPlayers>> getPlayers(@Query("key") String key);

    @GET("Players/{team}?")
    Call<List<ListPlayers>> getTeamPlayers(@Path("team") String teamPlayer, @Query("key") String key);

    @GET("Teams?")
    Call<List<ListTeam>> getTeam(@Query("key") String key);

    @GET("News?")
    Call<List<ListNews>> getNews(@Query("key") String key);

    @GET("Schedules/{season}?")
    Call<List<ListSchedules>> getSchedules(@Path("season")String season, @Query("key") String key);

    @GET("2020POST?")
    Call<List<ListBet>> getBet(@Query("key") String key);

    @GET("TeamSeasonStats/{year}?")
    Call<List<ListStandings>> getStandings(@Path("year") String year, @Query("key") String key);
}
