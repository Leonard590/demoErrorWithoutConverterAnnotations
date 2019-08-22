package com.example.demo.configuration;

import com.example.demo.DemoDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DemoRepository extends MongoRepository<DemoDto, ObjectId>
{
}
