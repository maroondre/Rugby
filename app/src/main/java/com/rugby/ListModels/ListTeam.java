package com.rugby.ListModels;

import com.google.gson.annotations.SerializedName;

public class ListTeam {

    @SerializedName("Key")
    private String key;

    @SerializedName("Name")
    private String name;

    @SerializedName("Conference")
    private String conference;

    @SerializedName("Division")
    private String division;

    @SerializedName("FullName")
    private String fullName;

    @SerializedName("WikipediaLogoUrl")
    private String wikipediaLogoUrl;

    @SerializedName("WikipediaWordMarkUrl")
    private String wikipediaWordMarkUrl;

    public ListTeam(String key, String name, String conference, String division, String fullName, String wikipediaLogoUrl, String wikipediaWordMarkUrl) {
        super();

        this.key = key;
        this.name = name;
        this.conference = conference;
        this.division = division;
        this.fullName = fullName;
        this.wikipediaLogoUrl = wikipediaLogoUrl;
        this.wikipediaWordMarkUrl = wikipediaWordMarkUrl;
    }

    public ListTeam(String key, String wikipediaLogoUrl)
    {
        super();
        this.key = key;
        this.wikipediaLogoUrl = wikipediaLogoUrl;

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getWikipediaLogoUrl() {
        return wikipediaLogoUrl;
    }

    public void setWikipediaLogoUrl(String wikipediaLogoUrl) {
        this.wikipediaLogoUrl = wikipediaLogoUrl;
    }

    public String getWikipediaWordMarkUrl() {
        return wikipediaWordMarkUrl;
    }

    public void setWikipediaWordMarkUrl(String wikipediaWordMarkUrl) {
        this.wikipediaWordMarkUrl = wikipediaWordMarkUrl;
    }


}
