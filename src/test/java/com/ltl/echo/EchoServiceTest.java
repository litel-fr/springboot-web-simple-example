package com.ltl.echo;

import com.ltl.echo.EchoConf;
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

@RunWith(MockitoJUnitRunner.class)
public class EchoServiceTest {

    @Mock
    private EchoConf conf;
    @InjectMocks
    private EchoService service;

    @Before
    public void before() {
        Mockito.when(conf.getPrefix()).thenReturn("prefix");
    }

    @Test
    public void echo() throws Exception {
        String result = service.echo("foobar");
        Assert.assertNotNull(result);
        Assert.assertEquals(result, "prefix - 'foobar'");
    }

}