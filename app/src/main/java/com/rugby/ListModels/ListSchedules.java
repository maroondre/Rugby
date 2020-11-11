package com.rugby.ListModels;

import com.google.gson.annotations.SerializedName;

public class ListSchedules {

    @SerializedName("GameKey")
    private String gameKey;

    @SerializedName("SeasonType")
    private Integer seasonType;

    @SerializedName("Season")
    private Integer season;

    @SerializedName("Week")
    private Integer week;

    @SerializedName("Date")
    private String date;

    @SerializedName("AwayTeam")
    private String awayTeam;

    @SerializedName("HomeTeam")
    private String homeTeam;

    @SerializedName("Channel")
    private String channel;

    @SerializedName("PointSpread")
    private Float pointSpread;

    @SerializedName("OverUnder")
    private Float overUnder;

    @SerializedName("StadiumID")
    private Integer stadiumID;

    @SerializedName("Canceled")
    private Boolean canceled;

    @SerializedName("GeoLat")
    private Object geoLat;

    @SerializedName("GeoLong")
    private Object geoLong;

    @SerializedName("ForecastTempLow")
    private Integer forecastTempLow;

    @SerializedName("ForecastTempHigh")
    private Integer forecastTempHigh;

    @SerializedName("ForecastDescription")
    private String forecastDescription;

    @SerializedName("ForecastWindChill")
    private Integer forecastWindChill;

    @SerializedName("ForecastWindSpeed")
    private Integer forecastWindSpeed;

    @SerializedName("AwayTeamMoneyLine")
    private Integer awayTeamMoneyLine;

    @SerializedName("HomeTeamMoneyLine")
    private Integer homeTeamMoneyLine;

    @SerializedName("Day")
    private String day;

    @SerializedName("DateTime")
    private String dateTime;

    @SerializedName("GlobalGameID")
    private Integer globalGameID;

    @SerializedName("GlobalAwayTeamID")
    private Integer globalAwayTeamID;

    @SerializedName("GlobalHomeTeamID")
    private Integer globalHomeTeamID;

    @SerializedName("ScoreID")
    private Integer scoreID;

    @SerializedName("Status")
    private String status;

    @SerializedName("StadiumDetails")
    private StadiumDetails stadiumDetails;

    public ListSchedules(String gameKey, Integer seasonType, Integer season, Integer week, String date, String awayTeam, String homeTeam, String channel, Float pointSpread, Float overUnder, Integer stadiumID, Boolean canceled, Object geoLat, Object geoLong, Integer forecastTempLow, Integer forecastTempHigh, String forecastDescription, Integer forecastWindChill, Integer forecastWindSpeed, Integer awayTeamMoneyLine, Integer homeTeamMoneyLine, String day, String dateTime, Integer globalGameID, Integer globalAwayTeamID, Integer globalHomeTeamID, Integer scoreID, String status, StadiumDetails stadiumDetails) {
        super();
        this.gameKey = gameKey;
        this.seasonType = seasonType;
        this.season = season;
        this.week = week;
        this.date = date;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.channel = channel;
        this.pointSpread = pointSpread;
        this.overUnder = overUnder;
        this.stadiumID = stadiumID;
        this.canceled = canceled;
        this.geoLat = geoLat;
        this.geoLong = geoLong;
        this.forecastTempLow = forecastTempLow;
        this.forecastTempHigh = forecastTempHigh;
        this.forecastDescription = forecastDescription;
        this.forecastWindChill = forecastWindChill;
        this.forecastWindSpeed = forecastWindSpeed;
        this.awayTeamMoneyLine = awayTeamMoneyLine;
        this.homeTeamMoneyLine = homeTeamMoneyLine;
        this.day = day;
        this.dateTime = dateTime;
        this.globalGameID = globalGameID;
        this.globalAwayTeamID = globalAwayTeamID;
        this.globalHomeTeamID = globalHomeTeamID;
        this.scoreID = scoreID;
        this.status = status;
        this.stadiumDetails = stadiumDetails;
    }

    public String getGameKey() {
        return gameKey;
    }

    public void setGameKey(String gameKey) {
        this.gameKey = gameKey;
    }

    public Integer getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(Integer seasonType) {
        this.seasonType = seasonType;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Float getPointSpread() {
        return pointSpread;
    }

    public void setPointSpread(Float pointSpread) {
        this.pointSpread = pointSpread;
    }

    public Float getOverUnder() {
        return overUnder;
    }

    public void setOverUnder(Float overUnder) {
        this.overUnder = overUnder;
    }

    public Integer getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(Integer stadiumID) {
        this.stadiumID = stadiumID;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    public Object getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(Object geoLat) {
        this.geoLat = geoLat;
    }

    public Object getGeoLong() {
        return geoLong;
    }

    public void setGeoLong(Object geoLong) {
        this.geoLong = geoLong;
    }

    public Integer getForecastTempLow() {
        return forecastTempLow;
    }

    public void setForecastTempLow(Integer forecastTempLow) {
        this.forecastTempLow = forecastTempLow;
    }

    public Integer getForecastTempHigh() {
        return forecastTempHigh;
    }

    public void setForecastTempHigh(Integer forecastTempHigh) {
        this.forecastTempHigh = forecastTempHigh;
    }

    public String getForecastDescription() {
        return forecastDescription;
    }

    public void setForecastDescription(String forecastDescription) {
        this.forecastDescription = forecastDescription;
    }

    public Integer getForecastWindChill() {
        return forecastWindChill;
    }

    public void setForecastWindChill(Integer forecastWindChill) {
        this.forecastWindChill = forecastWindChill;
    }

    public Integer getForecastWindSpeed() {
        return forecastWindSpeed;
    }

    public void setForecastWindSpeed(Integer forecastWindSpeed) {
        this.forecastWindSpeed = forecastWindSpeed;
    }

    public Integer getAwayTeamMoneyLine() {
        return awayTeamMoneyLine;
    }

    public void setAwayTeamMoneyLine(Integer awayTeamMoneyLine) {
        this.awayTeamMoneyLine = awayTeamMoneyLine;
    }

    public Integer getHomeTeamMoneyLine() {
        return homeTeamMoneyLine;
    }

    public void setHomeTeamMoneyLine(Integer homeTeamMoneyLine) {
        this.homeTeamMoneyLine = homeTeamMoneyLine;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getGlobalGameID() {
        return globalGameID;
    }

    public void setGlobalGameID(Integer globalGameID) {
        this.globalGameID = globalGameID;
    }

    public Integer getGlobalAwayTeamID() {
        return globalAwayTeamID;
    }

    public void setGlobalAwayTeamID(Integer globalAwayTeamID) {
        this.globalAwayTeamID = globalAwayTeamID;
    }

    public Integer getGlobalHomeTeamID() {
        return globalHomeTeamID;
    }

    public void setGlobalHomeTeamID(Integer globalHomeTeamID) {
        this.globalHomeTeamID = globalHomeTeamID;
    }

    public Integer getScoreID() {
        return scoreID;
    }

    public void setScoreID(Integer scoreID) {
        this.scoreID = scoreID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StadiumDetails getStadiumDetails() {
        return stadiumDetails;
    }

    public void setStadiumDetails(StadiumDetails stadiumDetails) {
        this.stadiumDetails = stadiumDetails;
    }

}
