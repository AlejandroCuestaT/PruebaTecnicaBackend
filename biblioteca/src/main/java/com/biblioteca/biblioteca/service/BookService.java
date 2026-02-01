package com.biblioteca.biblioteca.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.model.Book;

@Service
public class BookService {
	
	private List<Book> books = new ArrayList<>();
	
	public BookService() {
        //Libro de ejemplo al iniciarse
		books.add(new Book("1", "Don Quijote", "Miguel de Cervantes", false, LocalDateTime.now()));
	    books.add(new Book("2", "Cien años de soledad", "Gabriel García Márquez", true, LocalDateTime.now()));
	    books.add(new Book("3", "El Principito", "Antoine de Saint-Exupéry", false, LocalDateTime.now()));
	    books.add(new Book("4", "1984", "George Orwell", true, LocalDateTime.now()));
	    books.add(new Book("5", "Harry Potter y la piedra filosofal", "J.K. Rowling", false, LocalDateTime.now()));    }
	
	//Devolvemos todos los libros guardados
    public List<Book> getAll() {
        return books;
    }
    
    public Book getById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null; 
    }
    
    //Crear un libro nuevo
    public Book create(Book book) {
    	//Crea un id unico
        book.setId(UUID.randomUUID().toString()); 
        //Ponemos la fecha actual
        book.setLdt(LocalDateTime.now());
        book.setIsRead(false);
        books.add(book);
        return book;
    }
    
    //Recogemos el id y actualizamos ese libro en concreto con los nuevos datos
    //Si no existe ese id devuelve null
    public Book update(String id, Book data) {
        Book book = getById(id);

        if (book != null) {
        	book.setTitle(data.getTitle());
        	book.setAuthor(data.getAuthor());
            
            return book;
        }
        
        return null;
    }
    
    //Recoge la id y le cambia el atributo isRead que es  booleano. true --> false  ||  false --> true
    public Book toggleRead(String id) {
        Book book = getById(id);
        if (book != null) {
        	book.setIsRead( !book.getIsRead() ); 
            return book;
        }
        return null;
    }
    
    //Si existe el id lo borra y devuelve un true, si no existe un false
    public boolean delete(String id) {
        Book book = getById(id);
        
        if (book != null) {
            books.remove(book);
            return true;
        }
        
        return false; 
    }
    
    

}
