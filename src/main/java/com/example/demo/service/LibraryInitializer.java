package com.example.demo.service;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.entities.Societe;
import com.example.demo.repository.IAuthorRepository;
import com.example.demo.repository.ILibraryRepo;
import com.example.demo.repository.ISocieteRepository;

@Component
public class LibraryInitializer implements CommandLineRunner{
	@Autowired
	private  ILibraryRepo repo;
	@Autowired
	private IAuthorRepository repoAutho;
	@Autowired
	private ISocieteRepository repoSociete;
	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {
		Book b1= new Book("la péste", new Author("Albert Camus", new Date(07, 11, 1913)));
		Book b2 = new Book("les mésirable", new Author("Victor Hugos", new Date(26, 02, 1802)));
		Book b3 = new Book("le prince", new Author("Machiavel", new Date(03, 05, 1469)));
		Book b4 = new Book("Hamlete", new Author("william shakespeare", new Date(01, 04, 1564)));
		
		Stream.of(b1,b2,b3,b4).forEach(b -> repo.save(b));
		
		Stream.of("abc","ded","KlK").forEach(s -> repoSociete.save(new Societe(s)));
		
		repo.findAll().forEach(b -> System.out.println(b.toString()));
		repoAutho.findAll().forEach(a -> System.out.println(a.getName()));
		repoSociete.findAll().forEach(s -> System.out.println(s.getNomSociete()));
		
	}

}
