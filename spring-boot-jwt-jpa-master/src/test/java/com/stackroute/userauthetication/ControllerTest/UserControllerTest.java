package com.stackroute.userauthetication.ControllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import com.stackroute.userauthentication.controller.JwtAuthenticationController;
import com.stackroute.userauthentication.model.UserDao;
import com.stackroute.userauthentication.service.JwtUserDetailsService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	@Autowired
    private MockMvc mockMvc;
    @Mock
    private JwtUserDetailsService service;
    @InjectMocks
    private JwtAuthenticationController controller;
    private UserDao userdto;
    @BeforeEach
    public void setUp(){
    	 userdto=new UserDao();
    	 userdto.setEmail("sai@gmail.com");
    	 userdto.setPassword("ksjd");
    	 userdto.setUsername("sai");
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    @Test
    public void addUser() throws Exception
    {
    	when(service.save(any())).thenReturn(userdto);
    	mockMvc.perform(post("/register")
              .contentType(MediaType.APPLICATION_JSON)
              .content(asJsonString(userdto)))
              .andExpect(status().isOk());
      verify(service,times(1)).save(any());
    }

//    @Test
//    public void authenticate() throws Exception
//    {
//    	String name="sai";
//    	UserDetails userDetails=new org.springframework.security.core.userdetails.User(userdto.getUsername(), userdto.getPassword(),
//				new ArrayList<>());
//    	
//    	when(service.loadUserByUsername(any())).thenReturn(any());
//    	mockMvc.perform(post("/authenticate")
//              .contentType(MediaType.APPLICATION_JSON)
//              .content(asJsonString(any())))
//              .andExpect(status().isOk());
//      verify(service,times(1)).loadUserByUsername(any());
//    	
//    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
