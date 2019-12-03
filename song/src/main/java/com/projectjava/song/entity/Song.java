package com.projectjava.song.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@Document(collection = "Song")
public class Song {
    @Id
    private String id;
    private String title, artist, album, cover, duration, userId;


}
