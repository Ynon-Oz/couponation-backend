package com.ynon.couponation.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Ynon on  14-Aug-21
 */


public enum ErrType {

    USER_NOT_EXIST(604,"User ID is not exists",false);


    private int number;
    private String massage;
    private boolean isPrintToStackTrace;


    ErrType(int number, String massage, boolean isPrintToStackTrace) {
        this.number = number;
        this.massage = massage;
        this.isPrintToStackTrace = isPrintToStackTrace;
    }

    public int getNumber() {
        return number;
    }

    public String getMassage() {
        return massage;
    }

    public boolean isPrintToStackTrace() {
        return isPrintToStackTrace;
    }
}
