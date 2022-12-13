package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FeignController {
	@Autowired
	private FeignService feignService;

	@GetMapping("/user-notes")
	public String getusernotes() {
		return feignService.getAllNotes();
	}
	@GetMapping("/user-notes/{id}")
	public String getNotesById(@PathVariable("id")int id) {
		return feignService.getNotesById(id);
	}

	@PostMapping("/user-create")
	public String saveNotes(@RequestBody Notes notes) {
		return feignService.save(notes);
	}

	@DeleteMapping("/user-notes/{id}")
	public String deleteNotes(@PathVariable("id") int id) {
		return feignService.deleteNotesById(id);
	}

}
