package com.rugby.ListModels;

import com.google.gson.annotations.SerializedName;

public class ListPlayers {


    @SerializedName("PlayerID")
    private String playerID;

    @SerializedName("Team")
    private String team;

    @SerializedName("Number")
    private String number;

    @SerializedName("Position")
    private String position;

    @SerializedName("Status")
    private String status;

    @SerializedName("Height")
    private String height;

    @SerializedName("Weight")
    private String weight;

    @SerializedName("College")
    private String college;

    @SerializedName("Experience")
    private String experience;

    @SerializedName("FantasyPosition")
    private String fantasyPosition;

    @SerializedName("Active")
    private String active;

    @SerializedName("PositionCategory")
    private String positionCategory;

    @SerializedName("Name")
    private String name;

    @SerializedName("Age")
    private String age;

    @SerializedName("ExperienceString")
    private String experienceString;

    @SerializedName("BirthDateString")
    private String birthDateString;

    @SerializedName("PhotoUrl")
    private String photoUrl;

    
    public ListPlayers(String playerID, String team, String number, String position, String status, String height, String weight, String college, String experience, String fantasyPosition, String active, String positionCategory, String name, String age, String experienceString, String birthDateString, String photoUrl) {
        super();
        this.playerID = playerID;
        this.team = team;
        this.number = number;
        this.position = position;
        this.status = status;
        this.height = height;
        this.weight = weight;
        this.college = college;
        this.experience = experience;
        this.fantasyPosition = fantasyPosition;
        this.active = active;
        this.positionCategory = positionCategory;
        this.name = name;
        this.age = age;
        this.experienceString = experienceString;
        this.birthDateString = birthDateString;
        this.photoUrl = photoUrl;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getFantasyPosition() {
        return fantasyPosition;
    }

    public void setFantasyPosition(String fantasyPosition) {
        this.fantasyPosition = fantasyPosition;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPositionCategory() {
        return positionCategory;
    }

    public void setPositionCategory(String positionCategory) {
        this.positionCategory = positionCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getExperienceString() {
        return experienceString;
    }

    public void setExperienceString(String experienceString) {
        this.experienceString = experienceString;
    }

    public String getBirthDateString() {
        return birthDateString;
    }

    public void setBirthDateString(String birthDateString) {
        this.birthDateString = birthDateString;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}
