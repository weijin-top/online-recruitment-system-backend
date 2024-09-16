package com.weijin.recruitment.converter;

import com.weijin.recruitment.model.entity.Interview;
import com.weijin.recruitment.model.from.interview.ModifyInterviewFrom;
import com.weijin.recruitment.model.from.interview.SaveInterviewFrom;
import com.weijin.recruitment.model.vo.interview.InterviewResultDetailVO;
import com.weijin.recruitment.model.vo.interview.InterviewVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/8/16 21:40
 */

@Component
@Mapper(componentModel = "spring")
public interface InterviewConverter {

    Interview saveFromToEntity(SaveInterviewFrom saveInterviewFrom);
    Interview modifyFromToEntity(ModifyInterviewFrom modifyInterviewFrom);

    InterviewVO entityToVO(Interview interview);

    InterviewResultDetailVO entityToResultDetailVO(Interview interview);
}
