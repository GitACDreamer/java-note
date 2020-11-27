package com.lelandacm.globalexception;

import cn.hutool.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final JSONGenerator jsonGenerator;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public GlobalExceptionHandler(JSONGenerator jsonGenerator) {
        this.jsonGenerator = jsonGenerator;
    }

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest request, Exception e) {
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            return jsonGenerator.create().setMsg("页面未找到").setStatus(HttpStatus.HTTP_NOT_FOUND).asJson();
        } else {
            return jsonGenerator.create().setMsg("内部服务器错误").setStatus(HttpStatus.HTTP_INTERNAL_ERROR).asJson();
        }
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public String validatedException(ConstraintViolationException e) {
        log(e);
        return jsonGenerator.create().setStatus(HttpStatus.HTTP_BAD_REQUEST).setMsg(e
                .getMessage()).asJson();
    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public String indexOutOfException(IndexOutOfBoundsException e) {
        log(e);
        return jsonGenerator.create().setStatus(HttpStatus.HTTP_BAD_REQUEST).setMsg("参数不规范")
                .asJson();
    }

    @ExceptionHandler(value = NullPointerException.class)
    public String nullPointException(NullPointerException e) {
        log(e);
        return jsonGenerator.create().setStatus(HttpStatus.HTTP_BAD_REQUEST).setMsg("空值异常").asJson();
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public String methodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log(e);
        return jsonGenerator.create().setStatus(HttpStatus.HTTP_BAD_METHOD).setMsg("不支持的请求方法")
                .asJson();
    }

    @ExceptionHandler(value = RuntimeException.class)
    public String runtimeError(RuntimeException e) {
        log(e);
        return jsonGenerator.create().setStatus(HttpStatus.HTTP_INTERNAL_ERROR).setMsg(e.getMessage())
                .asJson();
    }

    @ExceptionHandler
    @ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
    public String requestHandlingNoHandlerFound(final NoHandlerFoundException ex) {
        return jsonGenerator.create().setStatus(HttpStatus.HTTP_NOT_FOUND).setMsg("页面未找到")
                .asJson();
    }

    private void log(Exception e) {
        StringBuilder log = new StringBuilder();
        log.append(e.getMessage() + "\n");
        for (StackTraceElement s : e.getStackTrace()) {
            log.append(s.toString());
            log.append("\n");
        }
        logger.error(log.toString());
    }
}