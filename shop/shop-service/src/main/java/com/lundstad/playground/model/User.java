package com.lundstad.playground.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import lombok.Value;

import java.util.Date;

@NoArgsConstructor
//@Value
@ToString
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class User {
    private int code;
    private Object meta;
    private Data data;


//    @Value
    @NoArgsConstructor
    @ToString
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class Data {
        private   int id;
        private   String name;
        private   String email;
        private     String gender;
        private     String status;

        private    Date created_at;
        private    Date updated_at;
    }
}

