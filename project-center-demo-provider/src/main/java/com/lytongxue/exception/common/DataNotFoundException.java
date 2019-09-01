package com.lytongxue.exception.common;

import com.lytongxue.constant.BizCode;
import com.lytongxue.exception.BizErrorResponseStatus;

@BizErrorResponseStatus(BizCode.DATA_NOT_FOUND)
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message) {
        super(message);
    }

}
