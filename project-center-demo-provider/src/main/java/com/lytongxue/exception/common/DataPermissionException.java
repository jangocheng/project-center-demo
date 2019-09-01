package com.lytongxue.exception.common;

import com.lytongxue.constant.BizCode;
import com.lytongxue.exception.BizErrorResponseStatus;

@BizErrorResponseStatus(BizCode.DATA_PERMISSION_ERROR)
public class DataPermissionException extends RuntimeException {

    public DataPermissionException(String message) {
        super(message);
    }

}
