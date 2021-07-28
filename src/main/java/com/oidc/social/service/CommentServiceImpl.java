package com.oidc.social.service;

import com.oidc.social.dao.CommentMapper;
import com.oidc.social.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public boolean registerComment(CommentDto params) {
        int queryResult = 0;

        params.setUid(commentMapper.getUid(params.getUserId()));

        if (params.getCid() == null) {
            queryResult = commentMapper.insertComment(params);
        } else {
            queryResult = commentMapper.updateComment(params);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public boolean deleteComment(Long cid) {
        int queryResult = 0;

        CommentDto comment = commentMapper.selectCommentDetail(cid);

        if (comment != null && "N".equals(comment.getDeleteYn())) {
            queryResult = commentMapper.deleteComment(cid);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<CommentDto> getCommentList(CommentDto params) {
        List<CommentDto> commentList = Collections.emptyList();
        params.setMid(commentMapper.getMid(params.getTitle()));
        int commentTotalCount = commentMapper.selectCommentTotalCount(params);
        if (commentTotalCount > 0) {
            commentList = commentMapper.selectCommentList(params);
        }

        return commentList;
    }
}
