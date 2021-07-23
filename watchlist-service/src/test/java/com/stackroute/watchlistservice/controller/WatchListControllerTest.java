package com.stackroute.watchlistservice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.watchlistservice.model.WatchList;
import com.stackroute.watchlistservice.service.WatchListServiceImpl;
@ExtendWith(MockitoExtension.class)
class WatchListControllerTest {
	@Autowired
    private MockMvc mockMvc;
    @Mock
    private WatchListServiceImpl watchListService;
    @InjectMocks
    private WatchListController watchController;
    
    private WatchList watchList;
    @BeforeEach
    public void setUp(){
    	 watchList = new WatchList();
		watchList.setId(1);
		watchList.setCity("Hyd");
		watchList.setTotalDeaths(10);
		watchList.setTotalInfections(1000);
        mockMvc = MockMvcBuilders.standaloneSetup(watchController).build();
    }
    @Test
    public void addWatchList() throws Exception
    {
    	when(watchListService.addWatchList(any())).thenReturn(watchList);
    	mockMvc.perform(post("/api/v1/addWatchList")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(watchList)))
                .andExpect(status().isCreated());
        verify(watchListService,times(1)).addWatchList(any());
    }
    @Test
    public void deleteWatchList() throws Exception
    {
    	int id=1;
    	when(watchListService.deleteWatchList(1)).thenReturn(watchList);
    	mockMvc.perform(delete("/api/v1/deleteWatchList/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(watchList)))
                .andExpect(status().isOk());
        verify(watchListService,times(1)).deleteWatchList(1);
    }
    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}