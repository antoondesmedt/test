package com.projectjava.edgeservice.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectjava.edgeservice.models.GenericResponseWrapper;
import com.projectjava.edgeservice.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("user/{userId}")
    public List<Song> getListingItemsByUserId(@PathVariable("userId") Integer userId) {

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://song-service/songs/search/findSongsByUserId?userid=" + userId, GenericResponseWrapper.class);

        List<Song> songs = objectMapper.convertValue(wrapper.get_embedded().get("songs"), new TypeReference<List<Song>>() { });


        return songs;
    }
}
