package com.weijin.recruitment.model.vo.message;

import com.weijin.recruitment.model.from.message.MessageFrom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/24 19:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageVo {
    /**
     * 发送方姓名，如果是招聘方则为公司简称
     */
    private String name;
    /**
     * 发送方头像
     */
    private String avatar;

    /**
     * 聊天信息
     */
    private MessageFrom messageFrom;
}
