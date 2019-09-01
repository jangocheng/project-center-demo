package com.lytongxue.exception.common;

import com.lytongxue.constant.BizCode;
import com.lytongxue.exception.BizErrorResponseStatus;

@BizErrorResponseStatus(BizCode.DATA_EXIST_ERROR)
public class DataExistException extends RuntimeException {

    public DataExistException(String message) {
        super(message);
    }

}
