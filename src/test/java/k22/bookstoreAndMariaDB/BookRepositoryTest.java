package k22.bookstoreAndMariaDB;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import k22.bookstoreAndMariaDB.domain.Book;
import k22.bookstoreAndMariaDB.domain.BookRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class BookRepositoryTest {

	@Autowired 
	BookRepository bookRepository;
	
	@Test
	public void findByAuthorShouldReturnAuthor() {
		List<Book> books = bookRepository.findByAuthor("Hennig Mankell");
		assertThat(books.get(0).getAuthor()).isEqualTo("Hennig Mankell");
	}
	
	@Test
	public void findByAuthorShouldReturnSize() {
		List<Book> books = bookRepository.findByAuthor("Hennig Mankell");
		assertThat(books).hasSize(3);
		
	}
	@Test 
	public void insertNewBook() {
		//public Book(String title, String author, int year) 
		Book book = new Book("KauhuKakara", "SuperNanny", 2020);
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}

}
