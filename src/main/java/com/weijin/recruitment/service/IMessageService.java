package com.weijin.recruitment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.model.entity.Message;
import com.weijin.recruitment.model.from.message.MessageFrom;
import com.weijin.recruitment.model.vo.message.LastMessageVo;
import com.weijin.recruitment.model.vo.message.MutualMessageVo;

import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/24 18:47
 */
public interface IMessageService extends IService<Message> {

    /**
     * 添加一条聊天信息
     *
     * @param messageFrom 信息入参
     * @return 影响数据库记录条数
     */
    int addMessage(MessageFrom messageFrom);

    /**
     * 获取最后一次聊天信息列表
     *
     * @return 结果集
     */
    List<LastMessageVo> queryLastRecord();

    /**
     * 查询两人聊天记录，包含额外信息，如：求职者：学校、专业、学历，招聘者：公司名称，职位名称等
     *
     * @param userId 对方id
     * @return 结果
     */
    List<MutualMessageVo> queryMutualRecord(Integer userId);

    /**
     * 修改消息状态为已读
     *
     * @param otherId 对方用户id
     * @return 影响数据库记录条数
     */
    int modifyMessageRead(Integer otherId);
}
