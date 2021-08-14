package com.ynon.couponation.exceptions;

import com.ynon.couponation.enums.ErrType;

import javax.lang.model.type.ErrorType;

/**
 * Created by Ynon on  14-Aug-21
 */
public class ApplicationException extends Exception{

//    private ErrType errType;

    public ApplicationException(ErrType errType) {
        super(errType.getMassage());
    }

    public ApplicationException(Exception e, ErrType errType) {
        super(errType.getMassage(), e);
    }
}
