package com.oidc.social.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto{
    private Long cid;
    private Long mid;
    private Long uid;
    private String userId;
    private String comment;
    private String deleteYn;

    public CommentDto(){

    }
}
