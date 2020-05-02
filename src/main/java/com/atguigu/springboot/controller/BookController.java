package com.atguigu.springboot.controller;

import com.atguigu.springboot.entities.Book;
import com.atguigu.springboot.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
public class BookController {
    @Resource
    private BookService bookService;


    @GetMapping("/books")
    public String list(Model model, HttpSession session) {
        Integer store = (Integer) session.getAttribute("store");
        Collection<Book> books = bookService.getBookByStore(store);
        model.addAttribute("books", books);

        //thymeleaf默认拼接字符串
        //return "emp/list";
        return "emp/list";
    }

    @GetMapping("/book")
    public String toAddPage() {
        return "emp/add";
    }

    @PostMapping("/book")
    public String addEmp(Book book, HttpSession session) {
        Integer store = (Integer) session.getAttribute("store");
        book.setStore(store);
        bookService.insertBook(book);
        return "redirect:/books";
    }

    @GetMapping("/book/{bid}")
    public String toEditPage(@PathVariable("bid") Integer bid, Model model) {
        Book book = bookService.getBookById(bid);
        model.addAttribute("book", book);
        return "emp/add";
    }

    @PostMapping("/findBookByName")
    public String findByName(@RequestParam("bName") String bName, Model model, HttpSession session) {
        Integer store = (Integer) session.getAttribute("store");
        Collection<Book> books = bookService.getBookByName(store, bName);
        model.addAttribute("books", books);
        return "emp/list";
    }

    @PutMapping("/book")
    public String updateEmplogee(Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }

    @DeleteMapping("/book/{bid}")
    public String deleteEmployee(@PathVariable("bid") Integer bid) {
        bookService.deleteBook(bid);
        return "redirect:/books";
    }
}
