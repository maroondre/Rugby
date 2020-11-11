package com.rugby.ListModels;

import com.google.gson.annotations.SerializedName;

public class StadiumDetails {
    
        @SerializedName("StadiumID")
        private Integer stadiumID;

        @SerializedName("Name")
        private String name;

        @SerializedName("City")
        private String city;

        @SerializedName("State")
        private String state;

        @SerializedName("Country")
        private String country;

        @SerializedName("Capacity")
        private Integer capacity;

        @SerializedName("PlayingSurface")
        private String playingSurface;

        @SerializedName("GeoLat")
        private Float geoLat;

        @SerializedName("GeoLong")
        private Float geoLong;

        @SerializedName("Type")
        private String type;

        public StadiumDetails(Integer stadiumID, String name, String city, String state, String country, Integer capacity, String playingSurface, Float geoLat, Float geoLong, String type) {
            super();
            this.stadiumID = stadiumID;
            this.name = name;
            this.city = city;
            this.state = state;
            this.country = country;
            this.capacity = capacity;
            this.playingSurface = playingSurface;
            this.geoLat = geoLat;
            this.geoLong = geoLong;
            this.type = type;
        }

        public Integer getStadiumID() {
            return stadiumID;
        }

        public void setStadiumID(Integer stadiumID) {
            this.stadiumID = stadiumID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }

        public String getPlayingSurface() {
            return playingSurface;
        }

        public void setPlayingSurface(String playingSurface) {
            this.playingSurface = playingSurface;
        }

        public Float getGeoLat() {
            return geoLat;
        }

        public void setGeoLat(Float geoLat) {
            this.geoLat = geoLat;
        }

        public Float getGeoLong() {
            return geoLong;
        }

        public void setGeoLong(Float geoLong) {
            this.geoLong = geoLong;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
}
