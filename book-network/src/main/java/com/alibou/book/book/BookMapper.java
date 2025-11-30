package com.alibou.book.book;

import com.alibou.book.file.FileUtils;
import com.alibou.book.history.BookTransactionHistory;
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
               .cover(FileUtils.readFileFromLocation(book.getBookCover()))
               .build();

    }

    public BorrowedBookResponse toBorrowedBookResponse(BookTransactionHistory bookTransactionHistory) {
        return BorrowedBookResponse.builder()
                .id(bookTransactionHistory.getBook().getId())
                .title(bookTransactionHistory.getBook().getTitle())
                .authorName(bookTransactionHistory.getBook().getAuthorName())
                .isbn(bookTransactionHistory.getBook().getIsbn())
                .rate(bookTransactionHistory.getBook().getRate())
                .returned(bookTransactionHistory.getBook().isArchived())
                .returnedApproved(bookTransactionHistory.getBook().isSharable())
                .build();
    }
}
