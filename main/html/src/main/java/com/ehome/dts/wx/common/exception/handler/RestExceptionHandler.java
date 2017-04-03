package com.ehome.dts.wx.common.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.alibaba.fastjson.JSON;
import com.ehome.dts.wx.common.exception.LogicException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value={LogicException.class})
	public final ResponseEntity<?> handleLogicException(LogicException ex,WebRequest request){
		HttpHeaders headers = new HttpHeaders();
		ErrMsg errMsg = new ErrMsg();
		errMsg.setMessage(ex.getMessage());
		return handleExceptionInternal(ex, JSON.toJSONString(errMsg), headers, ex.status, request);
	}
}
