package com.rugby.ListModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListBet {

        @SerializedName("BettingEventID")
        private Integer bettingEventID;

        @SerializedName("Name")
        private String name;

        @SerializedName("Season")
        private Integer season;

        @SerializedName("BettingEventTypeID")
        private Integer bettingEventTypeID;

        @SerializedName("BettingEventType")
        private String bettingEventType;

        @SerializedName("StartDate")
        private String startDate;

        @SerializedName("Created")
        private String created;

        @SerializedName("Updated")
        private String updated;

        @SerializedName("ScoreID")
        private Integer scoreID;

        @SerializedName("GlobalScoreID")
        private Object globalScoreID;

        @SerializedName("GameStatus")
        private String gameStatus;

        @SerializedName("Quarter")
        private String quarter;

        @SerializedName("AwayTeam")
        private String awayTeam;

        @SerializedName("HomeTeam")
        private String homeTeam;

        @SerializedName("AwayTeamID")
        private Integer awayTeamID;

        @SerializedName("HomeTeamID")
        private Integer homeTeamID;

        @SerializedName("GlobalAwayTeamID")
        private Integer globalAwayTeamID;

        @SerializedName("GlobalHomeTeamID")
        private Integer globalHomeTeamID;

        @SerializedName("AwayTeamScore")
        private Integer awayTeamScore;

        @SerializedName("HomeTeamScore")
        private Integer homeTeamScore;

        @SerializedName("TotalScore")
        private Integer totalScore;

        @SerializedName("AwayRotationNumber")
        private Integer awayRotationNumber;

        @SerializedName("HomeRotationNumber")
        private Integer homeRotationNumber;

        @SerializedName("BettingMarkets")

        private List<Object> bettingMarkets = null;

        public ListBet(Integer bettingEventID, String name, Integer season, Integer bettingEventTypeID, String bettingEventType, String startDate, String created, String updated, Integer scoreID, Object globalScoreID, String gameStatus, String quarter, String awayTeam, String homeTeam, Integer awayTeamID, Integer homeTeamID, Integer globalAwayTeamID, Integer globalHomeTeamID, Integer awayTeamScore, Integer homeTeamScore, Integer totalScore, Integer awayRotationNumber, Integer homeRotationNumber, List<Object> bettingMarkets) {
            super();
            this.bettingEventID = bettingEventID;
            this.name = name;
            this.season = season;
            this.bettingEventTypeID = bettingEventTypeID;
            this.bettingEventType = bettingEventType;
            this.startDate = startDate;
            this.created = created;
            this.updated = updated;
            this.scoreID = scoreID;
            this.globalScoreID = globalScoreID;
            this.gameStatus = gameStatus;
            this.quarter = quarter;
            this.awayTeam = awayTeam;
            this.homeTeam = homeTeam;
            this.awayTeamID = awayTeamID;
            this.homeTeamID = homeTeamID;
            this.globalAwayTeamID = globalAwayTeamID;
            this.globalHomeTeamID = globalHomeTeamID;
            this.awayTeamScore = awayTeamScore;
            this.homeTeamScore = homeTeamScore;
            this.totalScore = totalScore;
            this.awayRotationNumber = awayRotationNumber;
            this.homeRotationNumber = homeRotationNumber;
            this.bettingMarkets = bettingMarkets;
        }

            public ListBet(String name, Integer season, String bettingEventType, String startDate, String gameStatus) {
                this.name = name;
                this.season = season;
                this.bettingEventType = bettingEventType;
                this.startDate = startDate;
                this.gameStatus = gameStatus;
            }

        public Integer getBettingEventID() {
            return bettingEventID;
        }

        public void setBettingEventID(Integer bettingEventID) {
            this.bettingEventID = bettingEventID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSeason() {
            return season;
        }

        public void setSeason(Integer season) {
            this.season = season;
        }

        public Integer getBettingEventTypeID() {
            return bettingEventTypeID;
        }

        public void setBettingEventTypeID(Integer bettingEventTypeID) {
            this.bettingEventTypeID = bettingEventTypeID;
        }

        public String getBettingEventType() {
            return bettingEventType;
        }

        public void setBettingEventType(String bettingEventType) {
            this.bettingEventType = bettingEventType;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public Integer getScoreID() {
            return scoreID;
        }

        public void setScoreID(Integer scoreID) {
            this.scoreID = scoreID;
        }

        public Object getGlobalScoreID() {
            return globalScoreID;
        }

        public void setGlobalScoreID(Object globalScoreID) {
            this.globalScoreID = globalScoreID;
        }

        public String getGameStatus() {
            return gameStatus;
        }

        public void setGameStatus(String gameStatus) {
            this.gameStatus = gameStatus;
        }

        public String getQuarter() {
            return quarter;
        }

        public void setQuarter(String quarter) {
            this.quarter = quarter;
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

        public Integer getAwayTeamID() {
            return awayTeamID;
        }

        public void setAwayTeamID(Integer awayTeamID) {
            this.awayTeamID = awayTeamID;
        }

        public Integer getHomeTeamID() {
            return homeTeamID;
        }

        public void setHomeTeamID(Integer homeTeamID) {
            this.homeTeamID = homeTeamID;
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

        public Integer getAwayTeamScore() {
            return awayTeamScore;
        }

        public void setAwayTeamScore(Integer awayTeamScore) {
            this.awayTeamScore = awayTeamScore;
        }

        public Integer getHomeTeamScore() {
            return homeTeamScore;
        }

        public void setHomeTeamScore(Integer homeTeamScore) {
            this.homeTeamScore = homeTeamScore;
        }

        public Integer getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(Integer totalScore) {
            this.totalScore = totalScore;
        }

        public Integer getAwayRotationNumber() {
            return awayRotationNumber;
        }

        public void setAwayRotationNumber(Integer awayRotationNumber) {
            this.awayRotationNumber = awayRotationNumber;
        }

        public Integer getHomeRotationNumber() {
            return homeRotationNumber;
        }

        public void setHomeRotationNumber(Integer homeRotationNumber) {
            this.homeRotationNumber = homeRotationNumber;
        }

        public List<Object> getBettingMarkets() {
            return bettingMarkets;
        }

        public void setBettingMarkets(List<Object> bettingMarkets) {
            this.bettingMarkets = bettingMarkets;
        }
}
