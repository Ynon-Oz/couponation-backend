package com.ynon.couponation.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Ynon on  14-Aug-21
 */


public enum ErrType {

    USER_NOT_EXIST("User ID is not exists"),
    COMPANY_NOT_EXIST("Company ID is not exist");


    private String description;

    ErrType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
