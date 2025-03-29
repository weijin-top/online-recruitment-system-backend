package com.weijin.recruitment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weijin.recruitment.model.entity.Message;
import com.weijin.recruitment.model.vo.message.LastMessageVo;
import com.weijin.recruitment.model.vo.message.MutualMessageVo;

import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/24 18:49
 */
public interface MessageMapper extends BaseMapper<Message> {
    /**
     * 求职者查询与所有沟通富过的招聘者的最后一次聊天记录
     *
     * @param userId 求职者用户id
     * @return 查询结果集
     */
    List<LastMessageVo> selectSeekerLastRecord(Integer userId);

    /**
     * 招聘者查询与所有求职者沟通过最后一次聊天记录
     *
     * @param userId 招聘者用户id
     * @return 查询结果借
     */
    List<LastMessageVo> selectRecruiterLastRecord(Integer userId);

    /**
     * 获取两人之间的聊天记录
     *
     * @param senderId   发送方id
     * @param receiverId 接收方id
     * @return 结果集
     */
    List<MutualMessageVo> selectMutualRecord(Integer senderId, Integer receiverId);

}
