package com.alibou.book.history;

import com.alibou.book.book.Book;
import com.alibou.book.common.BaseEntity;
import com.alibou.book.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class BookTransactionHistory extends BaseEntity {

    // user relationship
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // book relationship
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private boolean returned;
    private boolean returnedApproved;

}
