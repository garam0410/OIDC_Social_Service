package com.oidc.social.service;

import com.oidc.social.dto.CommentDto;

import java.util.List;

public interface CommentService {
    public boolean registerComment(CommentDto params);
    public boolean deleteComment(Long cid);
    public List<CommentDto> getCommentList(CommentDto params);
}
