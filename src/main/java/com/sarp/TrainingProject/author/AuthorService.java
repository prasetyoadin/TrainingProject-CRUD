package com.sarp.TrainingProject.author;

import java.util.List;

public interface AuthorService {

	public Author postAuthor(Author model) throws Exception;
	
	public Author updateAuthor(int id, Author model);
	
	public Author getAuthorById(int id);
	
	public List<Author> getAllAuthor();
	
}
