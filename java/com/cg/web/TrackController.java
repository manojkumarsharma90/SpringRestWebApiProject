package com.cg.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cg.entity.Track;
import com.cg.repo.TrackRepo;

@RestController
@RequestMapping("/music")
public class TrackController {

	@Autowired
  private	TrackRepo trackRepo;
	
  
  @PostMapping("/tracks")
	public ResponseEntity<String> addTrack(@RequestBody Track t){
		
		Track savedTrack=trackRepo.save(t);
		
		return new ResponseEntity<String>("Track added succesfully with id "+savedTrack.getTrackId(),HttpStatus.CREATED);
		
		
	}
  
  @GetMapping("/tracks")
  public ResponseEntity<List<Track>> getTracks(){
	  
	  List<Track>mlist=trackRepo.findAll();
	  
	  return new ResponseEntity<List<Track>>(mlist,HttpStatus.OK);
  }
  
  @GetMapping("/tracks/{bId}")
	public ResponseEntity<Object> viewById(@PathVariable Integer mId) {

		Optional<Track> optTrack = trackRepo.findById(mId);

		if (optTrack.isPresent()) {

			return new ResponseEntity<Object>(optTrack.get(), HttpStatus.OK);
		}

		else {
			return new ResponseEntity<Object>("Track Not found", HttpStatus.NOT_FOUND);
		}
	
	
	
}
  
  @GetMapping("/tracks/search")
	public ResponseEntity<List<Track>> viewMusicByTitle(@RequestParam("title") String title) {

		List<Track> mlist = trackRepo.findByTrackTitle(title);

		return new ResponseEntity<List<Track>>(mlist, HttpStatus.OK);

	}
  
  
  
}
