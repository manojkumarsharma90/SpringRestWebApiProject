package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Track;

@Repository
public interface TrackRepo extends JpaRepository<Track, Integer> {
	
	public List<Track> findByTrackTitle(String title);

}
