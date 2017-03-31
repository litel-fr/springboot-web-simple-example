package com.ltl;

import com.ltl.echo.EchoConf;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {EchoConf.class})
public class SpringbootWebSimpleExampleApplication implements CommandLineRunner {

    private static final Logger LOGGER = Logger.getLogger(CommandLineRunner.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebSimpleExampleApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("app started");
    }

}
