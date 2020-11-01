package com.lundstad.playground.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@Value
@ToString

@Getter
@Builder
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AirQuality {
    private String name;
    private String path;
    private String areacode;
    private String areaclass;
//
//    public String toString(){
//
//
//    }
}


