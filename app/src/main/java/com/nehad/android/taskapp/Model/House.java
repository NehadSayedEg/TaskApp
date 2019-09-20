package com.nehad.android.taskapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class House {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("housingType")
    @Expose
    private String housingType;
    @SerializedName("housingTime")
    @Expose
    private String housingTime;
    @SerializedName("housingSystem")
    @Expose
    private String housingSystem;
    @SerializedName("image")
    @Expose
    private String image;

    public House(Integer id, String name, String housingType, String housingTime, String housingSystem, String image) {
        this.id = id;
        this.name = name;
        this.housingType = housingType;
        this.housingTime = housingTime;
        this.housingSystem = housingSystem;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHousingType() {
        return housingType;
    }

    public void setHousingType(String housingType) {
        this.housingType = housingType;
    }

    public String getHousingTime() {
        return housingTime;
    }

    public void setHousingTime(String housingTime) {
        this.housingTime = housingTime;
    }

    public String getHousingSystem() {
        return housingSystem;
    }

    public void setHousingSystem(String housingSystem) {
        this.housingSystem = housingSystem;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

