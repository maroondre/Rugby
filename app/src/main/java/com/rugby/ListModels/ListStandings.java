package com.rugby.ListModels;

import com.google.gson.annotations.SerializedName;

public class ListStandings {

        @SerializedName("Season")

        private String season;
        @SerializedName("Team")

        private String team;
        @SerializedName("Score")

        private String score;
        @SerializedName("OpponentScore")

        private String opponentScore;
        @SerializedName("FirstDowns")

        private String firstDowns;
        @SerializedName("OffensivePlays")

        private String offensivePlays;
        @SerializedName("Touchdowns")

        private String touchdowns;
        @SerializedName("TeamName")

        private String teamName;
        private String teamLogo;

        public ListStandings(String season, String team, String score, String opponentScore, String firstDowns, String offensivePlays, String touchdowns, String teamName) {
            super();
            this.season = season;
            this.team = team;
            this.score = score;
            this.opponentScore = opponentScore;
            this.firstDowns = firstDowns;
            this.offensivePlays = offensivePlays;
            this.touchdowns = touchdowns;
            this.teamName = teamName;
        }

    public ListStandings(String season, String team, String score, String opponentScore, String firstDowns, String offensivePlays, String touchdowns, String teamName, String teamLogo) {
        super();
        this.season = season;
        this.team = team;
        this.score = score;
        this.opponentScore = opponentScore;
        this.firstDowns = firstDowns;
        this.offensivePlays = offensivePlays;
        this.touchdowns = touchdowns;
        this.teamName = teamName;
        this.teamLogo = teamLogo;
    }

        public String getSeason() {
            return season;
        }

        public void setSeason(String season) {
            this.season = season;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getOpponentScore() {
            return opponentScore;
        }

        public void setOpponentScore(String opponentScore) {
            this.opponentScore = opponentScore;
        }

        public String getFirstDowns() {
            return firstDowns;
        }

        public void setFirstDowns(String firstDowns) {
            this.firstDowns = firstDowns;
        }

        public String getOffensivePlays() {
            return offensivePlays;
        }

        public void setOffensivePlays(String offensivePlays) {
            this.offensivePlays = offensivePlays;
        }

        public String getTouchdowns() {
            return touchdowns;
        }

        public void setTouchdowns(String touchdowns) {
            this.touchdowns = touchdowns;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

    public String getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }
}
