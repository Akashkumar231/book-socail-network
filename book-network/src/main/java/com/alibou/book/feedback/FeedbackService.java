package com.alibou.book.feedback;

import com.alibou.book.book.Book;
import com.alibou.book.book.BookRepository;
import com.alibou.book.exception.OperationNotPermittedException;
import com.alibou.book.user.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final BookRepository bookRepository;

    public Integer save(FeedbackRequest request, Authentication connectedUser) {
       Book book = bookRepository.findById(request.bookId())
               .orElseThrow(()-> new EntityNotFoundException("No book found with ID:: " + request.bookId()));
       if (book.isArchived() || !book.isSharable()){
           throw new OperationNotPermittedException("You cannot give a feedback for an archived or not shareable.");
       }

       User user = ((User)connectedUser.getPrincipal());

       if (Objects.equals(book.getOwner().getId(), user.getId()))
       {
           throw new OperationNotPermittedException("You cannot give a feedback to your own book");
       }

       Feedback feedback = feedbackMapper.toFeedback(request);
       return null;
    }
}
