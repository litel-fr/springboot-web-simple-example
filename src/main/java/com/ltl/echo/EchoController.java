package com.ltl.echo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EchoController {

    @Autowired
    public EchoService service;

    @RequestMapping(value = "/echo", method = RequestMethod.POST)
    public ResponseEntity<String> echo(
            @RequestBody String body
    ){
        if(body == null || body.isEmpty()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(service.echo(body));
    }

}
