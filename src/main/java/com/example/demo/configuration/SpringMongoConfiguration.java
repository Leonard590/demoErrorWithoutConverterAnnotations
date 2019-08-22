package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class SpringMongoConfiguration
{
    @Bean
    public MongoCustomConversions customConversions()
    {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new ZonedDateTimeToDateConverter());
        converters.add(new DateToZonedDateTimeConverter());
        return new MongoCustomConversions(converters);
    }

//    @WritingConverter
    private class ZonedDateTimeToDateConverter implements Converter<ZonedDateTime, Date>
    {
        @Override
        public Date convert(ZonedDateTime source)
        {
            return source == null ? null : new Date(source.toInstant().toEpochMilli());
        }
    }

//    @ReadingConverter
    private class DateToZonedDateTimeConverter implements Converter<Date, ZonedDateTime>
    {
        @Override
        public ZonedDateTime convert(Date source)
        {
            return source == null ? null : ZonedDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
        }
    }
}
