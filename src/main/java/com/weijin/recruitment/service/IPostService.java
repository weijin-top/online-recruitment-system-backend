package com.weijin.recruitment.service;

import com.weijin.recruitment.model.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.model.from.post.PostFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.post.PostVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface IPostService extends IService<Post> {

    /**
     * 添加岗位
     * @param postFrom 入参
     * @return 响应
     */
    Result<String> savePost(PostFrom postFrom);

    /**
     * 获取岗位类别
     * @return 响应结果
     */
    Result<List<PostVO>> queryPosts();
}
