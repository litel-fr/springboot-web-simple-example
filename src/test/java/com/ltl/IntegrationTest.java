package com.ltl;

import com.ltl.echo.EchoConf;
import com.ltl.echo.EchoController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration test
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringbootWebSimpleExampleApplication.class})
public class IntegrationTest {

	@Autowired
	private EchoConf conf;
	@Autowired
	private EchoController controller;

	@Test
	public void echoController() {
		conf.setPrefix("prefix");
		ResponseEntity<String> result = controller.echo("foobar");
		Assert.assertEquals("prefix - 'foobar'", result.getBody());
	}

	@Test
	public void boot() {
		SpringbootWebSimpleExampleApplication.main(new String[0]);
	}


}
