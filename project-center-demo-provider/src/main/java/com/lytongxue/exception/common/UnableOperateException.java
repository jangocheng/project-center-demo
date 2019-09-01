package com.lytongxue.exception.common;

import com.lytongxue.constant.BizCode;
import com.lytongxue.exception.BizErrorResponseStatus;

@BizErrorResponseStatus(BizCode.UNABLE_OPERATE_ERROR)
public class UnableOperateException extends RuntimeException {

    public UnableOperateException(String message) {
        super(message);
    }

}
