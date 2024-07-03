package com.weijin.recruitment.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 *      岗位实体
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@Data
@TableName("t_post")
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer parentId;

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 逻辑删除
     */
    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;

    @Override
    public String toString() {
        return "Station{" +
            "id = " + id +
            ", parentId = " + parentId +
            ", name = " + name +
            ", isDeleted = " + isDeleted +
        "}";
    }
}
