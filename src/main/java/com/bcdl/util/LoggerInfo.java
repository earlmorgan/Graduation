package com.bcdl.util;

import org.slf4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

public class LoggerInfo {
    public static void info(BindingResult result, Logger log){
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("异常数据:\n");
        List<ObjectError> list = result.getAllErrors();
        //System.out.println("result.getErrorCount()"+result.getErrorCount());
        //System.out.println("result.getFieldErrorCount()"+result.getFieldErrorCount());
        for (ObjectError error : list) {
            //log.info(error.getCode() + "---" + error.getArguments() + "---" + error.getDefaultMessage());
            //System.out.println(error.toString());
            //System.out.println("error.getObjectName():"+error.getObjectName());
            //System.out.println("(FieldError)error.getField():"+((FieldError)error).getField());
            //System.out.println("(FieldError)error.getRejectedValue():"+((FieldError)error).getRejectedValue());
            //sBuilder.append("\n");
            sBuilder.append(error.getCode()+ "---" + error.getArguments() + "---" + error.getDefaultMessage());
            sBuilder.append("\n");
            sBuilder.append(error.toString());
            sBuilder.append("\n");
        }

        log.info(sBuilder.toString());
        //System.out.println("errors.hasErrors():"+errors.hasErrors());
    }
}
