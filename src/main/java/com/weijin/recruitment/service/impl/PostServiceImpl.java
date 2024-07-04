package com.weijin.recruitment.service.impl;

import com.weijin.recruitment.converter.PostConverter;
import com.weijin.recruitment.model.entity.Post;
import com.weijin.recruitment.mapper.PostMapper;
import com.weijin.recruitment.model.from.post.PostFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.post.PostVO;
import com.weijin.recruitment.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

    @Resource
    private PostConverter postConverter;

    @Override
    public Result<String> savePost(PostFrom postFrom) {
        Post post = postConverter.fromToEntity(postFrom);
        int inserted = baseMapper.insert(post);
        return inserted > 0 ? Result.success("添加成功") : Result.failed("添加失败");
    }

    @Override
    public Result<List<PostVO>> queryPosts() {
        List<PostVO> postVOS = baseMapper.selectParentPosts();
        return Result.success("查询成功", postVOS);
    }
}
