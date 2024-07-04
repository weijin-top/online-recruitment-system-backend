package com.weijin.recruitment.controller;

import com.weijin.recruitment.model.from.post.PostFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.post.PostVO;
import com.weijin.recruitment.service.IPostService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 岗位类别管理
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/api/post")
public class PostController {

    @Resource
    private IPostService iPostService;

    /**
     * 添加岗位
     * @param postFrom 入参
     * @return 响应
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('admin')")
    public Result<String> savePost(@Validated @RequestBody PostFrom postFrom){
        return iPostService.savePost(postFrom);
    }

    /**
     * 获取岗位类别
     * @return 响应结果
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('seeker','recruiter','admin')")
    public Result<List<PostVO>> queryPosts(){
        return iPostService.queryPosts();
    }
}
