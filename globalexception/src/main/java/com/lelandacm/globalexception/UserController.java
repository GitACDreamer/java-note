package com.lelandacm.globalexception;

import cn.hutool.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    private final JSONGenerator jsonGenerator;

    public UserController(JSONGenerator jsonGenerator) {
        this.jsonGenerator = jsonGenerator;
    }

    @PostMapping("/add")
    public String userAdd(@Valid UserEntity entity) {
        return jsonGenerator.create().setStatus(HttpStatus.HTTP_OK).setMsg("调用成功").setData(entity).asJson();
    }

}
