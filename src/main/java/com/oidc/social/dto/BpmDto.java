package com.oidc.social.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BpmDto {
    private Long mid;
    private Long uid;
    private Long tid;
    private String userId;
    private String title;
    private String bpm;

    public BpmDto(){}
}
