package com.lundstad.playground;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlaygroundApplicationTests {

    @Test
    void contextLoads() {
    }




//    @Test
//    public void givenBookClient_shouldFindOneBook() throws Exception {
//        Book book = bookClient.findByIsbn("0151072558").getBook();
//        assertThat(book.getAuthor(), containsString("Orwell"));
//    }
//
//    @Test
//    public void givenBookClient_shouldPostBook() throws Exception {
//        String isbn = UUID.randomUUID().toString();
//        Book book = new Book(isbn, "Me", "It's me!", null, null);
//        bookClient.create(book);
//        book = bookClient.findByIsbn(isbn).getBook();
//
//        assertThat(book.getAuthor(), is("Me"));
//    }


}
