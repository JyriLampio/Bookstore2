package k22.bookstoreAndMariaDB.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	//title, author, year, isbn, price
	private String title, author, isbn;
	private int year, ranking;
	private double price;

	@ManyToOne
	//JsonIgnore helps to prevent endless loop
	@JsonIgnore
	@JoinColumn(name="categoryid")
	private Category category;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Book(String title, String author, Integer year, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.category = category;
	}
	
	


	public Book(String title, String author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
	}


	public Book(String title, String author, int year, int ranking, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.ranking = ranking;
		this.price = price;
		this.category = category;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	

	public int getRanking() {
		return ranking;
	}


	public void setRanking(int ranking) {
		this.ranking = ranking;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year
				+ ", ranking=" + ranking + ", price=" + price + ", category=" + category + "]";
	}



	
}
