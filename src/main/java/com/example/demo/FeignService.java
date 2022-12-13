package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notes", url = "http://localhost:8083")
public interface FeignService {
	@GetMapping("/notes")
	String getAllNotes();

	@GetMapping("/notes/{id}")
	String getNotesById(@PathVariable("id") int id);

	@PostMapping("/create")
	String save(Notes notes);

	@DeleteMapping("/notes/{id}")
	String deleteNotesById(@PathVariable("id") int id);
}
