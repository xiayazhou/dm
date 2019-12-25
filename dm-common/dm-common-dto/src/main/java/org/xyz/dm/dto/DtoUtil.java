package org.xyz.dm.dto;

//import org.hdax.dm.util.Constants;
import org.xyz.dm.utli.Constants;

public class DtoUtil {
    private static String success = "success";

    //成功响应
    public static CommonResponse returnSuccess(Object data){
        CommonResponse commonResponse = new CommonResponse(success, Constants.SUCCESS_CODE.CODE,data);
        return commonResponse;
    }

    //失败响应
    public static CommonResponse returnFail(String errorCode,String msg){
        CommonResponse commonResponse = new CommonResponse(errorCode,msg);
        return commonResponse;
    }
}
