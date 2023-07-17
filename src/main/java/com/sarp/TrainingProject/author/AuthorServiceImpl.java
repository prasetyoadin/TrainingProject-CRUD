package com.sarp.TrainingProject.author;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarp.TrainingProject.common.AppProperties;
import com.sarp.TrainingProject.common.ResErrorDto;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	AppProperties appProperties;

	@Override
	public Author postAuthor(Author model) throws Exception {
		
		Author entity = new Author();
		ResErrorDto errorDto = new ResErrorDto();
		List<String> errorList = new ArrayList<>();
		String name = model.getName();
		String address = model.getAddress();
		String url = model.getUrl();
		
		// ====== Validation Name ====== //
		if (name.isEmpty()) {
			errorList.add("Nama Tidak Boleh Kosong");
		} else if (name.length() < 2) {
			errorList.add("Nama Harus Lebih dari 2 Karakter");
		} else {
			
		}
		
		if (url.isEmpty()) {
			url = appProperties.getNamaApps() + ".com";
		}
		
		
		if (errorList.isEmpty()) {
			entity.setName(name);
			entity.setAddress(address);
			entity.setUrl(url);
			//entity = authorRepository.save(entity);
			return entity;
		} else {
			errorDto.setListError(errorList);
			throw new Exception(errorDto.toString());
		}
	}

	@Override
	public Author updateAuthor(int id, Author model) {
		
		Author entity = new Author();
		
		entity = authorRepository.findById(id).orElse(entity);
		
		entity.setName(model.getName());
		entity.setAddress(model.getAddress());
		entity.setUrl(model.getUrl());
		entity = authorRepository.save(entity);
		
		return entity;
	}

	
	@Override
	public Author getAuthorById(int id) {
		
		Author entity = new Author();

		entity = authorRepository.findById(id).orElse(entity);
		
		return entity;
	}

	@Override
	public List<Author> getAllAuthor() {

		List<Author> entityList = new ArrayList<Author>();

		entityList = authorRepository.findAll();
		
		return entityList;
	}

	
}
