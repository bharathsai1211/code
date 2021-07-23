package com.stackroute.watchlistservice.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.stackroute.watchlistservice.model.WatchList;
import com.stackroute.watchlistservice.repository.WatchListRepository;

@ExtendWith(MockitoExtension.class)
class WatchListServiceTest {
	@Mock
	private WatchListRepository watchListRepository;
	@InjectMocks
	private WatchListServiceImpl watchListService;
	private WatchList watchList;

	@Test
	public void addWatchList() {
		WatchList watchList = new WatchList();
		watchList.setId(1);
		watchList.setCity("Hyd");
		watchList.setTotalDeaths(10);
		watchList.setTotalInfections(1000);
		when(watchListRepository.save(any())).thenReturn(watchList);
		watchListService.addWatchList(watchList);
		verify(watchListRepository, times(1)).save(any());
	}
	@Test
	public void deleteWatchList()
	{
		WatchList w=mock(WatchList.class);
		Optional<WatchList> optional=Optional.of(w);
		when(watchListRepository.findById(w.getId())).thenReturn(optional);
		watchListService.deleteWatchList(w.getId());
		verify(watchListRepository, times(1)).deleteById(w.getId());
	}

}