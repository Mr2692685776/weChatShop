package com.newheart.common.api;

import com.newheart.constants.BaseApiConstants;

import java.util.HashMap;
import java.util.Map;

public class BaseApiService {

    public Map<String,Object> setResult(Integer code,String msg,Object data){
        HashMap<String, Object> rs = new HashMap<String, Object>();
        rs.put(BaseApiConstants.HTTP_CODE_NAME,code);
        rs.put(BaseApiConstants.HTTP_MSG_NAME,msg);
        if (null!=data) {
            rs.put(BaseApiConstants.HTTP_DATA_NAME, data);
        }
        return rs;
    }

    public  Map<String,Object> setResultSuccess(){
        return setResult(BaseApiConstants.HTTP_200_CODE,BaseApiConstants.HTTP_MSG_SUCCESS,null);
    }

    public Map<String,Object> setResultError(){
        return setResult(BaseApiConstants.HTTP_500_CODE,BaseApiConstants.HTTP_MSG_ERROR,null);
    }

    public Map<String,Object> setResultSuccessData(Object data){
        return setResult(BaseApiConstants.HTTP_200_CODE,BaseApiConstants.HTTP_MSG_SUCCESS,data);
    }

    public Map<String,Object> setResultErrorData(Object data){
        return setResult(BaseApiConstants.HTTP_500_CODE,BaseApiConstants.HTTP_MSG_ERROR,data);
    }
}
