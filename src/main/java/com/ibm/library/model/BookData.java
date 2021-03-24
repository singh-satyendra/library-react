package com.ibm.library.model;

public class BookData {
	
	private String bookType;
	private String isbn;
	private String title;
	private String author;
	
	public BookData() {
		super();
	}
	
	public BookData(String bookType, String isbn, String title, String author) {
		super();
		this.bookType = bookType;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookData other = (BookData) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookData [bookType=" + bookType + ", isbn=" + isbn + ", title=" + title + ", author=" + author + "]";
	}
}