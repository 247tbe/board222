package com.nhnacademy.nhnboard.domain;

import lombok.Data;

@Data
public class JoinUser implements User {
    String id;
    String password;
    String name;
    String profileFileName;
}
