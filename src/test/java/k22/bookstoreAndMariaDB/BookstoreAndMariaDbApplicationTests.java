package k22.bookstoreAndMariaDB;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import k22.bookstoreAndMariaDB.web.BookstoreController;

@SpringBootTest
class BookstoreAndMariaDbApplicationTests {


	@Autowired
	private BookstoreController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
