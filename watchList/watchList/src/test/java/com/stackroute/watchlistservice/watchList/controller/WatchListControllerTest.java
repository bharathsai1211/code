package com.stackroute.watchlistservice.watchList.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.watchlistservice.watchList.model.WatchList;
import com.stackroute.watchlistservice.watchList.service.WatchListServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*@ExtendWith is a repeatable annotation that is used to register extensions for the annotated test class or test method.
 *add @Extendwith annotation
 */
@ExtendWith(MockitoExtension.class)
class WatchListControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private WatchListServiceImpl watchListService;
    private WatchList watchList;
    private List<WatchList> listOfWatchList;

    @InjectMocks
    private WatchListController watchListController;

    @BeforeEach
    public void setUp() {
        WatchList watchList = new WatchList();
        watchList.setUserName("vani");
        watchList.setCreatedAt(LocalDateTime.now());
        List<Map> list = new ArrayList<Map>();
        Map items = new HashMap();
        items.put("city", "Hdy");
        items.put("totalInfections", 67288);
        items.put("totalDeaths", 102);
        list.add(items);
        watchList.setWatchListArray(list);

        mockMvc = MockMvcBuilders.standaloneSetup(watchListController).build();

    }

    @Test
    public void getWatchListAllListShouldReturnTheListOfAllSavedWatchList() throws Exception {
        when(watchListService.getAllWatchList()).thenReturn(listOfWatchList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/WatchLists")
                .contentType(MediaType.APPLICATION_JSON).content(asJasonString(watchList)));

        verify(watchListService, times(1)).getAllWatchList();
    }

    public static String asJasonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}