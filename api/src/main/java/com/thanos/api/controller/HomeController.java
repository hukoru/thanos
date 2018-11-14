package com.thanos.api.controller;

import com.thanos.api.common.constant.ResponseCode;
import com.thanos.api.domain.Home;
import com.thanos.api.result.ResultBody;
import com.thanos.api.service.CodeService;
import com.thanos.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;


@RestController
public class HomeController {

    private static final String template = "Hello, %s!";

    @Autowired
    private CodeService codeService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    public Home index(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Home(1, ResponseCode.OK.getMessage());
    }

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
     public ResultBody healthCheck() throws UnknownHostException {

        codeService.createBy();
        userService.createBy();

        return new ResultBody();

    }

    @RequestMapping(value = "/healthcheck2", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    public ResultBody healthcheck2() throws UnknownHostException {

        codeService.modifyBy();

        return new ResultBody();

    }

}












































