package com.stackroute.watchlistservice.watchList.service;

import com.stackroute.watchlistservice.watchList.model.WatchList;
import com.stackroute.watchlistservice.watchList.repository.WatchListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;


import java.time.LocalDateTime;
import java.util.*;


import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*@ExtendWith is a repeatable annotation that is used to register extensions for the annotated test class or test method.
 *add @Extendwith annotation
 */

@ExtendWith(MockitoExtension.class)
class WatchListServiceTest {
    /*
     * Add @Mock annotation It create a mock object to perform test Add @InjectMocks
     * This tell where to inject the mock
     */
    @Mock
    private WatchListRepository watchListRepository;
    @InjectMocks
    private WatchListServiceImpl watchListService;

    /*
     * @Test Annotation to set it as individual test case This the Function which
     * test the return object after save
     */
    @Test
    public void afterSavingTheWatchListItShouldReturnWholeWatchListObject() {
        WatchList watchList = new WatchList();
        watchList.setUserName("kavya");
        watchList.setCreatedAt(LocalDateTime.now());
        List<Map> list = new ArrayList<Map>();
        Map items = new HashMap();
        items.put("city", "chennai");
        items.put("totalInfections", 17828);
        items.put("totalDeaths", 536);
        list.add(items);
        watchList.setWatchListArray(list);

        when(watchListRepository.save(any())).thenReturn(watchList);
        watchListService.createWatchList("kavya","chennai",17828,536);
        verify(watchListRepository, times(1)).save(any());

    }

}