package com.bucom.boot.repository;

import com.bucom.boot.Enity.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpitRepository extends MongoRepository<Spit,String> {

}
