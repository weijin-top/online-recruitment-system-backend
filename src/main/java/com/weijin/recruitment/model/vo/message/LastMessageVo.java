package com.weijin.recruitment.model.vo.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/24 19:38
 */
@Data
public class LastMessageVo {
    /**
     * 聊天id
     */
    private Integer id;
    /**
     * 对方用户id
     */
    private Integer otherId;
    /**
     * 求职者姓名，招聘者公司简称
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 信息内容
     */
    private String content;

    /**
     * 未读消息数量
     */
    private Integer unreadCount;
    /**
     * 发送时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;
}
