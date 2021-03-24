package com.ibm.library.service;

import java.util.Collection;
import org.springframework.http.ResponseEntity;

import com.ibm.library.model.BookData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LibraryService {

	Collection<BookData> getBooks();

	BookData getBook(String isbn);

	BookData sayHello();

	ResponseEntity<?> createBook(BookData book);

	void deleteBook(String isbn);

	void updateOneBookData(BookData bookData);

	// Methods to be used for generic search with pagination
	Collection<BookData> findBooksByProperties(String bookType, String isbn, String title, String author, int pageNo,
			int pageSize);

	Mono<BookData> getBookByIsbn(String isbn);
	
	Flux<BookData> getBooksRetrieve();
	
	Flux<BookData> getBooksExchange();
	
	Mono<BookData> createBookWebClient(BookData book);
	
	Mono<BookData> updateBookWebClient(BookData book);
	 
	Mono<Void> deleteBookWebClient(String isbn);

}
