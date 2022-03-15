package k22.bookstoreAndMariaDB.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import k22.bookstoreAndMariaDB.domain.Book;
import k22.bookstoreAndMariaDB.domain.BookRepository;
import k22.bookstoreAndMariaDB.domain.CategoryRepository;

@Controller
public class BookstoreController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	private BookRepository bookRepository;

	public String username = "cannot be updated";

	@Autowired
	private CategoryRepository categoryRepository;

	//@RequestMapping(value = { "/booklist" })
	@GetMapping("booklist")
	//@RequestMapping(value = { "booklist" }) //heroku test
	public String bookList(Model model) {
		username = request.getUserPrincipal().getName();
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("username", username);
		return "bookList";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/addBook")
	public String newBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "newBook";
	}

	@PostMapping("saveBook")
	public String saveBook(@Valid Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("some validation error happened");
			return "/newBook";
		}
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepository.deleteById(id);
		return "redirect:/booklist";
	}

//	Pähkinä: Miksi edit ei toimi, jos syötän editointisivulla (editBook)
//	kirjan nimeksi yhden merkin mittaisen nimen?
	@PreAuthorize("hasAuthority('ADMIN')")	
	@GetMapping("edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookRepository.findById(id));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editBook";
	}
}
