package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.Date;

@Document(collection = "demo")
public class DemoDto
{
    @Id
    private ObjectId id;

    private Date date;

    private ZonedDateTime zonedDateTime;

    @PersistenceConstructor
    public DemoDto()
    {
    }

    public ObjectId getId()
    {
        return id;
    }

    public void setId(ObjectId id)
    {
        this.id = id;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public ZonedDateTime getZonedDateTime()
    {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime)
    {
        this.zonedDateTime = zonedDateTime;
    }
}
