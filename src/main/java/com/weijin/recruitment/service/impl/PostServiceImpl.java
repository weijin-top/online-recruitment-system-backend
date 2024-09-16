package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.weijin.recruitment.converter.PostConverter;
import com.weijin.recruitment.model.entity.Post;
import com.weijin.recruitment.mapper.PostMapper;
import com.weijin.recruitment.model.from.post.ModifyPostFrom;
import com.weijin.recruitment.model.from.post.PostFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.post.PostVO;
import com.weijin.recruitment.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Result<String> delPost(Integer id) {
        // 获取子级id
        LambdaQueryWrapper<Post> wrapper = new LambdaQueryWrapper<Post>()
                .eq(Post::getParentId, id);
        List<Post> posts = baseMapper.selectList(wrapper);

        // 创建一个列表用于存储要删除的id
        List<Integer> idsToDelete = new ArrayList<>();

        // 如果有子帖子，将它们的id加入到列表中
        if (!posts.isEmpty()) {
            idsToDelete.addAll(posts.stream()
                    .map(Post::getId)
                    .toList());
        }

        // 把本来需要删除的id添加到集合里
        idsToDelete.add(id);

        // 执行批量删除
        int count = baseMapper.deleteBatchIds(idsToDelete);

        // 返回操作结果
        return count > 0 ? Result.success("删除成功") : Result.failed("删除失败");
    }

    @Override
    public Result<String> modifyPost(ModifyPostFrom modifyPostFrom) {
        Post post = postConverter.modifyFromToEntity(modifyPostFrom);
        int updated = baseMapper.updateById(post);
        return updated > 0 ? Result.success("修改成功") : Result.failed("修改失败");
    }

}
