package com.weijin.recruitment.model.vo.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 两人相互的聊天记录
 *
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/25 19:31
 */
@Data
public class MutualMessageVo {
    private Integer id;
    private Integer senderId;
    private Integer receiverId;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;
}
