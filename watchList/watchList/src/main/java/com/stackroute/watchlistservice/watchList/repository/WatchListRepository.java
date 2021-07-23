package com.stackroute.watchlistservice.watchList.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.stackroute.watchlistservice.watchList.model.WatchList;

/**
 * @Repository marks the specific class as a Data Access Object
 */
@Repository
public interface WatchListRepository extends MongoRepository<WatchList, String> {

}
