package com.weijin.recruitment.model.vo.post;

import lombok.Data;

import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/2 20:59
 */
@Data
public class PostVO {
    private Integer id;
    private Integer parentId;
    private String name;
    private List<PostVO> postVOS;
}
