package com.stackroute.watchlistservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.stackroute.watchlistservice.model.WatchList;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class WatchListRepositoryTest {
	@Autowired
	private WatchListRepository watchListRepository;

	@Test
	public void addWatchList() {
		WatchList watchList = new WatchList();
		//watchList.setId(1);
		watchList.setCity("Hyd");
		watchList.setTotalDeaths(10);
		watchList.setTotalInfections(1000);
		watchListRepository.save(watchList);
		WatchList returned = watchListRepository.findById(1).get();
		assertNotNull(returned);
		assertEquals(watchList.getCity(), returned.getCity());
		assertEquals(watchList.getTotalDeaths(), returned.getTotalDeaths());
		assertEquals(watchList.getTotalInfections(), returned.getTotalInfections());

	}
	@Test
	public void deleteWatchList()
	{
		WatchList watchList = new WatchList();
		//watchList.setId(1);
		watchList.setCity("Hyd");
		watchList.setTotalDeaths(10);
		watchList.setTotalInfections(1000);
		watchListRepository.save(watchList);
		watchListRepository.deleteById(1);
		List<WatchList> watchListed=watchListRepository.findAll();
		assertEquals(0,watchListed.size());
	}
}