package com.ltl.echo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EchoService {

    private final static Logger LOGGER = Logger.getLogger(EchoService.class);

    @Autowired
    private EchoConf conf;

    public String echo(final String toEcho){
        final String echoedString = String.format("%s - '%s'", conf.getPrefix(), toEcho);
        LOGGER.info("echo-ing : "+ echoedString);
        return echoedString;
    }

}
