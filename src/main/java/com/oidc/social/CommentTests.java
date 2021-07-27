package com.oidc.social;

import com.oidc.social.dto.CommentDto;
import com.oidc.social.service.CommentService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentTests {

    @Autowired
    private CommentService commentService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void registerComments() {
        int number = 20;

        for (int i = 1; i <= number; i++) {
            CommentDto params = new CommentDto();
            params.setMid((long) 1); // 댓글을 추가할 게시글 번호
            params.setComment(i + "번 댓글을 추가합니다!");
            params.setUid((long) i);
            System.out.println(params.getMid());
            System.out.println(params.getComment());
            System.out.println(params.getUid());
            commentService.registerComment(params);

        }

        logger.debug("댓글 " + number + "개가 등록되었습니다.");
    }

    @Test
    public void deleteComment() {
        commentService.deleteComment((long) 10); // 삭제할 댓글 번호

        getCommentList();
    }

    @Test
    public void getCommentList() {
        CommentDto params = new CommentDto();
        params.setMid((long) 1); // 댓글을 추가할 게시글 번호

        commentService.getCommentList(params);
    }
}
