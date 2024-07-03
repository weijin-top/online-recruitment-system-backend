package com.weijin.recruitment.mapper;

import com.weijin.recruitment.model.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weijin.recruitment.model.vo.post.PostVO;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface PostMapper extends BaseMapper<Post> {

    /**
     * 获取岗位类别，获取父级
     *
     * @return 查询结果
     */
    List<PostVO> selectParentPosts();


    /**
     * 获取岗位类别，获取子级
     *
     * @param parentId 父级id
     * @return 查询结果
     */
    List<PostVO> selectChildPosts(Integer parentId);


}
