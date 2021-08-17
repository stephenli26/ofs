package com.stephen.ofs.utils;

import com.stephen.ofs.constant.ErrorCode;
import com.stephen.ofs.entity.model.CommonResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonResultTemplate {

    public static CommonResult execute(Callback callback) {
        CommonResult result;

        try {
            result = new CommonResult();
            result.setData(callback.execute());

        } catch (Exception e) {
            result = new CommonResult(ErrorCode.FAILED);
        }

        return result;
    }

    public interface Callback {
        Object execute();
    }
}
