package com.example.demo;

import com.example.demo.configuration.DemoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest
{
    @Autowired
    DemoRepository demoRepository;

    @Test
    public void testConverters() throws Exception
    {
        DemoDto demoDto = new DemoDto();
        demoDto.setDate(new Date());
        demoDto.setZonedDateTime(ZonedDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));

        DemoDto result = demoRepository.insert(demoDto);

        assertThat(result.getDate(), equalTo(demoDto.getDate()));
        assertThat(result.getZonedDateTime(), equalTo(demoDto.getZonedDateTime()));
    }
}
