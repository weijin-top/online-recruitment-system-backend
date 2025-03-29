package com.weijin.recruitment.controller;

import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.message.LastMessageVo;
import com.weijin.recruitment.model.vo.message.MutualMessageVo;
import com.weijin.recruitment.service.IMessageService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/24 20:49
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Resource
    private IMessageService messageService;

    /**
     * 获取聊天记录列表
     *
     * @return 聊天记录列表
     */
    @GetMapping("/getLastRecord")
    @PreAuthorize("hasAnyRole('seeker','recruiter')")
    public Result<List<LastMessageVo>> queryLastRecord() {
        List<LastMessageVo> lastMessageVos = messageService.queryLastRecord();
        return Result.success("查询成功", lastMessageVos);
    }

    /**
     * 获取两人的聊天记录
     *
     * @param otherId 对方id
     * @return 查询结果
     */
    @GetMapping("/getMutualRecord/{otherId}")
    @PreAuthorize("hasAnyRole('seeker','recruiter')")
    public Result<List<MutualMessageVo>> queryMutualRecord(@PathVariable("otherId") Integer otherId) {
        List<MutualMessageVo> resList = messageService.queryMutualRecord(otherId);
        return Result.success("查询成功", resList);
    }

    /**
     * 修改消息状态为已读
     *
     * @param otherId 对方用户id
     * @return 统一响应结果
     */
    @PutMapping("/modifyMessageRead/{otherId}")
    @PreAuthorize("hasAnyRole('seeker','recruiter')")
    public Result<String> modifyMessageRead(@PathVariable("otherId") Integer otherId) {
        messageService.modifyMessageRead(otherId);
        // 没报错就是成功，不需要响应给前端是否把未读消息修改已读成功，没有未读消息不回修改，也是正常情况
        return Result.success();
    }
}
