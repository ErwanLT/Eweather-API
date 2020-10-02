package fr.eletutour.eweather.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class LocationData {
    @SerializedName("place_id")
    private String placeId;
    @SerializedName("licence")
    private String license;
    @SerializedName("osm_type")
    private String osmType;
    @SerializedName("osm_id")
    private String osmId;
    @SerializedName("boundingbox")
    private ArrayList<String> geoLocation;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lon")
    private String lon;
    @SerializedName("display_name")
    private String displayName;
    @SerializedName("class")
    private String classType;
    @SerializedName("type")
    private String type;
    @SerializedName("importance")
    private String importance;
    @SerializedName("icon")
    private String icon;
}
