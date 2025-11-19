package com.alibou.book.book;

import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book toBook(BookRequest request) {
        return Book.builder()
                .id(request.id())
                .title(request.title())
                .authorName(request.authorName())
                .synopsis(request.synopsis())
                .archived(false)
                .sharable(request.shareable())
                .build();
    }

    public BookResponse toBookReponse(Book book) {
       return BookResponse.builder()
               .id(book.getId())
               .title(book.getTitle())
               .authorName(book.getAuthorName())
               .isbn(book.getIsbn())
               .rate(book.getRate())
               .archived(book.isArchived())
               .shareable(book.isSharable())
               .owner(book.getOwner().fullName())
               .build();

    }
}
