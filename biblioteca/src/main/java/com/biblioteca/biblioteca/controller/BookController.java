package com.biblioteca.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.model.Book;
import com.biblioteca.biblioteca.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	
	@Autowired
    private BookService bookService;
	
	//Obtienes todos los libros 
	@GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }
	
	//Devuelve el libro si existe y un not Found si no existe 
	@GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable String id) {
		Book book = bookService.getById(id);
		
		if (book != null) {
	        return ResponseEntity.ok(book);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
    }
	
	//Crear un libro nuevo
	@PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable String id, @RequestBody Book data) {
        Book updatedBook = bookService.update(id, data);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	//Modifica solo el campo de isRead, cambia el true --> false  ||  false --> true
	@PatchMapping("/{id}/read")
	public ResponseEntity<Book> toggleRead(@PathVariable String id) {
	    
	    Book patchedBook = bookService.toggleRead(id);
	    
	    if (patchedBook != null) {
	        return ResponseEntity.ok(patchedBook);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	//Coge el id y borra el libro, si lo hace devuelve un no content, si no existe el id  un not found
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
	    boolean removed = bookService.delete(id);
	    
	    if (removed) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
