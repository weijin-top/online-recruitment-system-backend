package com.weijin.recruitment.controller;

import com.weijin.recruitment.model.from.post.ModifyPostFrom;
import com.weijin.recruitment.model.from.post.PostFrom;
import com.weijin.recruitment.common.Result;
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
     *
     * @param postFrom 入参
     * @return 响应
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('admin')")
    public Result<String> savePost(@Validated @RequestBody PostFrom postFrom) {
        return iPostService.savePost(postFrom);
    }

    /**
     * 获取岗位类别
     *
     * @return 响应结果
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('seeker','recruiter','admin')")
    public Result<List<PostVO>> queryPosts() {
        return iPostService.queryPosts();
    }

    /**
     * 删除职位类型
     *
     * @param id 职位id
     * @return 响应
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('admin')")
    public Result<String> delPost(@PathVariable("id") Integer id) {
        return iPostService.delPost(id);
    }

    /**
     * 修改职位类型
     *
     * @param modifyPostFrom 入参
     * @return 响应
     */
    @PutMapping
    @PreAuthorize("hasAnyRole('admin')")
    public Result<String> modifyPost(@Validated @RequestBody ModifyPostFrom modifyPostFrom) {
        return iPostService.modifyPost(modifyPostFrom);
    }
}
