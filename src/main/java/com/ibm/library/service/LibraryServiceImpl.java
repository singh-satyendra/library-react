package com.ibm.library.service;

import java.util.Collection;

import com.ibm.library.model.BookData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ibm.library.endpoint.BookInventoryEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LibraryServiceImpl implements LibraryService {

	private final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);

	@Autowired
	private BookInventoryEndpoint bookInventoryEndpoint;
	
	public LibraryServiceImpl() {
	}

	@Override
	public BookData getBook(String isbn) {
		logger.info("Entered LibraryServiceImpl.getBook().  isbn=" + isbn);
		BookData book = this.bookInventoryEndpoint.getBook(isbn);
		logger.info("Leaving LibraryServiceImpl.getBook().  isbn=" + isbn);
		return book;
	}

	@Override
	public Collection<BookData> getBooks() {
		logger.info("Entered LibraryServiceImpl.getBooks()");
		Collection<BookData> books = this.bookInventoryEndpoint.getBooks();
		logger.info("Leaving LibraryServiceImpl.getBooks()");
		return books;
	}

	@Override
	public ResponseEntity<?> createBook(BookData book) {
		ResponseEntity<?> bookres = this.bookInventoryEndpoint.createBook(book);
		return bookres;
	}

	@Override
	public void updateOneBookData(BookData book) {
		this.bookInventoryEndpoint.updateOneBookData(book);
	}

	@Override
	public void deleteBook(String isbn) {
		this.bookInventoryEndpoint.deleteBook(isbn);
	}

	@Override
	public Collection<BookData> findBooksByProperties(String bookType, String isbn, String title, String author,
			int pageNo, int pageSize) {
		return this.bookInventoryEndpoint.findBooksByProperties(bookType, isbn, title, author, pageNo, pageSize);
	}

	@Override
	public BookData sayHello() {
		logger.info("Entered LibraryServiceImpl.sayHello()");
		BookData book = this.bookInventoryEndpoint.sayHello();
		logger.info("Leaving LibraryServiceImpl.sayHello()");
		return book;
	}


	//WebClient
	@Override
	public Flux<BookData> getBooksRetrieve(){
		logger.info("Entered LibraryServiceImpl.getBooksRetrieve()");
		Flux<BookData> books =this.bookInventoryEndpoint.getBooksRetrieve();
		logger.info("Entered LibraryServiceImpl.getBooksRetrieve()");
		return books;
	}
	
	//using retrieve 
	@Override
	public Mono<BookData> getBookByIsbn(String isbn){
		logger.info("Entered LibraryServiceImpl.getBookByIsbn()");
		Mono<BookData> book =this.bookInventoryEndpoint.getBookByIsbn(isbn);
		logger.info("Entered LibraryServiceImpl.getBookByIsbn()");
		return book;
		
	}
	
	//using exchange
	@Override
	public Flux<BookData> getBooksExchange(){
		logger.info("Entered LibraryServiceImpl.getBookByIsbn()");
		Flux<BookData> books =this.bookInventoryEndpoint.getBooksExchange();
		logger.info("Entered LibraryServiceImpl.getBookByIsbn()");
		return books;
	}
	
	//create book
	@Override
	public Mono<BookData> createBookWebClient(BookData books){
		Mono<BookData> book = this.bookInventoryEndpoint.createBookWebClient(books);
		return book;
	}
	
	//update book
	@Override
	public Mono<BookData> updateBookWebClient(BookData books){
		Mono<BookData> book = this.bookInventoryEndpoint.updateBookWebClient(books);
		return book;
	}
	
	//delete book
	@Override
	public Mono<Void> deleteBookWebClient(String isbn){
		return this.bookInventoryEndpoint.deleteBookWebClient(isbn);
		
	}
}
