package com.weijin.recruitment.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/24 18:41
 */
@Data
@TableName("t_message")
public class Message {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer senderId;
    private Integer receiverId;
    private String content;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    private Integer isRead;
}
