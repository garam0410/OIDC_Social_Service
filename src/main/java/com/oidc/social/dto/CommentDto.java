package com.oidc.social.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto{
    private Long cid;
    private Long mid;
    private Long uid;
    private String title;
    private String userId;
    private String comment;
    private String deleteYn;
    private String insert_time;
    private String update_time;

    public CommentDto(){

    }
}
