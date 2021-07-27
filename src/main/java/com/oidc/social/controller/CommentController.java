package com.oidc.social.controller;

import com.oidc.social.dto.CommentDto;
import com.oidc.social.service.CommentService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan(basePackages="com.oidc.social.dao")

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = { "/comments", "/comments/{cid}" }, method = { RequestMethod.POST, RequestMethod.PATCH })
    public JSONObject registerComment(@PathVariable(value = "cid", required = false) Long cid, @RequestBody final CommentDto params) {

        JSONObject jsonObject = new JSONObject();

        try {
            if (cid != null) {
                params.setCid(cid);
            }

            boolean isRegistered = commentService.registerComment(params);
            jsonObject.put("result", isRegistered);

        } catch (DataAccessException e) {
            e.printStackTrace();
            jsonObject.put("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");

        } catch (Exception e) {
            jsonObject.put("message", "시스템에 문제가 발생하였습니다.");
        }

        return jsonObject;
    }

    @GetMapping(value = "/comments/delete/{cid}")
    public JSONObject deleteComment(@PathVariable(value = "cid") Long cid){
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("result",commentService.deleteComment(cid));
        }catch(DataAccessException e){
            jsonObject.put("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");
        }catch (Exception e){
            jsonObject.put("message", "시스템에 문제가 발생하였습니다.");
        }
        return jsonObject;
    }

    @GetMapping(value = "/comments/{mid}")
    public JSONObject getCommentList(@PathVariable("mid") Long mid, @ModelAttribute("params") CommentDto params) {

        JSONObject jsonObject = new JSONObject();

        List<CommentDto> commentList = commentService.getCommentList(params);
        if (CollectionUtils.isEmpty(commentList) == false) {

            jsonObject.put("commentList", commentList);
        }

        return jsonObject;
    }

}
