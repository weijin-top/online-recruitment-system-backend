package com.weijin.recruitment.model.from.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weijin.recruitment.group.MessageGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/24 18:44
 */
@Data
public class MessageFrom {
    @NotNull(message = "发送人id不能为空", groups = MessageGroup.SaveMessageGroup.class)
    private Integer senderId;
    @NotNull(message = "接收人id不能为空", groups = MessageGroup.SaveMessageGroup.class)
    private Integer receiverId;
    @NotBlank(message = "消息内容不能为空", groups = MessageGroup.SaveMessageGroup.class)
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
