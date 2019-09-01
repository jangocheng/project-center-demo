package com.lytongxue.exception.common;

import com.lytongxue.constant.BizCode;
import com.lytongxue.exception.BizErrorResponseStatus;

@BizErrorResponseStatus(BizCode.DATA_NOT_EXIST_ERROR)
public class DataNotExistException extends RuntimeException {

    public DataNotExistException(String message) {
        super(message);
    }

}
