package com.lytongxue.exception.common;

import com.lytongxue.constant.BizCode;
import com.lytongxue.exception.BizErrorResponseStatus;

@BizErrorResponseStatus(BizCode.DATA_REPETITION_ERROR)
public class DataRepetitionException extends RuntimeException {

    public DataRepetitionException(String message) {
        super(message);
    }

}
