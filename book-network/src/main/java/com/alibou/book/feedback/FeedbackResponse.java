package com.alibou.book.feedback;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackResponse {
    private Double note;
    private String comment;
    private boolean ownFeedback;
}
