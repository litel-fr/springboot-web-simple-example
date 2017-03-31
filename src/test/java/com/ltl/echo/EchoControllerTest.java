package com.ltl.echo;

import com.ltl.echo.EchoController;
import com.ltl.echo.EchoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class EchoControllerTest {

    public static final String FOOBAR = "foobar";
    public static final String EXPECTED = "prefix - foobar";
    @Mock
    private EchoService service;
    @InjectMocks
    private EchoController controller;

    @Before
    public void before(){
        Mockito.when(service.echo(FOOBAR)).thenReturn(EXPECTED);
    }

    @Test
    public void echo() throws Exception {
        ResponseEntity<String> result = controller.echo(FOOBAR);
        Assert.assertNotNull(result);
        Assert.assertEquals(EXPECTED, result.getBody());
        Assert.assertEquals(200, result.getStatusCode().value());
        Mockito.verify(service, Mockito.times(1)).echo(FOOBAR);
    }

    @Test
    public void echoError() throws Exception {
        ResponseEntity<String> result = controller.echo(null);
        Assert.assertNotNull(result);
        Assert.assertEquals(422, result.getStatusCode().value());
        Mockito.verify(service, Mockito.times(0)).echo(FOOBAR);
    }

}