package com.projectjava.song.repository;

import com.projectjava.song.entity.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends MongoRepository<Song, String> {
    List<Song> findSongsByUserId(@Param("userid") Integer userid);
}
