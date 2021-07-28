package com.oidc.social.dao;

import com.oidc.social.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public Long getUid(String userId);

    public Long getMid(String title);

    public int insertTitle(String title);

    public int insertComment(CommentDto params);

    public CommentDto selectCommentDetail(Long cid);

    public int updateComment(CommentDto params);

    public int deleteComment(Long cid);

    public List<CommentDto> selectCommentList(CommentDto params);

    public int selectCommentTotalCount(CommentDto params);
}
