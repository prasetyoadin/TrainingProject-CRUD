package com.sarp.TrainingProject.author;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarp.TrainingProject.common.ResErrorDto;

@RestController
@RequestMapping("api/author")
public class AuthorController {

	private static final Logger LOG = LoggerFactory.getLogger(AuthorController.class); 
	
	@Autowired
	AuthorService authorService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addAuthor(@RequestBody Author model) {
		
		Author responseBody = new Author();
		
		try {
			responseBody = authorService.postAuthor(model);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			ResErrorDto error = new ResErrorDto(e.getMessage());
			return ResponseEntity.badRequest().body(error);
		}
		
		return ResponseEntity.ok(responseBody);
	}
	
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateAuthor(@PathVariable("id") int id, @RequestBody Author model){
		
		Author responseBody = new Author();
		
		try {
			responseBody = authorService.updateAuthor(id, model);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			ResErrorDto error = new ResErrorDto(e.getMessage());
			return ResponseEntity.badRequest().body(error);
		}
		
		return ResponseEntity.ok(responseBody);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAuthorById(@PathVariable("id") int id){
		
		Author responseBody = new Author();
		
		try {
			responseBody = authorService.getAuthorById(id);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			ResErrorDto error = new ResErrorDto(e.getMessage());
			return ResponseEntity.badRequest().body(error);
		}
		
		return ResponseEntity.ok(responseBody);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllAuthor() {
		
		List<Author> responseBody = new ArrayList<Author>();
		
		try {
			responseBody = authorService.getAllAuthor();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			ResErrorDto error = new ResErrorDto(e.getMessage());
			return ResponseEntity.badRequest().body(error);
		}
		
		return ResponseEntity.ok(responseBody);
	}
	
}
