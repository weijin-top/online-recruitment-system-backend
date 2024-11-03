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
        List<Integer> idsToDelete = new ArrayList<>();
        // 递归获取所有子级的ID
        collectChildIds(id, idsToDelete);
        idsToDelete.add(id);
        // 执行批量删除
        int count = baseMapper.deleteBatchIds(idsToDelete);
        return count > 0 ? Result.success("删除成功") : Result.failed("删除失败");
    }

    /**
     * 递归获取子级id
     * @param parentId 父id
     * @param idsToDelete 存储容器
     */
    private void collectChildIds(Integer parentId, List<Integer> idsToDelete) {
        // 获取当前层级的所有子级
        LambdaQueryWrapper<Post> wrapper = new LambdaQueryWrapper<Post>()
                .eq(Post::getParentId, parentId);
        List<Post> posts = baseMapper.selectList(wrapper);
        if (!posts.isEmpty()) {
            // 将这些子级的ID加入到列表中
            for (Post post : posts) {
                idsToDelete.add(post.getId());
                // 递归调用以处理下一层级的子级
                collectChildIds(post.getId(), idsToDelete);
            }
        }
    }
    @Override
    public Result<String> modifyPost(ModifyPostFrom modifyPostFrom) {
        Post post = postConverter.modifyFromToEntity(modifyPostFrom);
        int updated = baseMapper.updateById(post);
        return updated > 0 ? Result.success("修改成功") : Result.failed("修改失败");
    }

}
