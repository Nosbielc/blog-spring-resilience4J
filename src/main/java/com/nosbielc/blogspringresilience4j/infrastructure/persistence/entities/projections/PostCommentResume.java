package com.nosbielc.blogspringresilience4j.infrastructure.persistence.entities.projections;

import com.nosbielc.blogspringresilience4j.infrastructure.persistence.entities.PostComment;
import com.nosbielc.blogspringresilience4j.infrastructure.persistence.enums.CommentStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "postCommentResume", types = { PostComment.class })
public interface PostCommentResume {

    Long getId();
    String getReview();
    Integer getVotes();
    CommentStatus getStatus();

}
