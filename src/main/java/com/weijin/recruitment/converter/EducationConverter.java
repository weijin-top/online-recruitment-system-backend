package com.weijin.recruitment.converter;

import com.weijin.recruitment.model.entity.Education;
import com.weijin.recruitment.model.from.education.EducationFrom;
import com.weijin.recruitment.model.vo.education.EducationVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/4 18:57
 */
@Component
@Mapper(componentModel = "spring")
public interface EducationConverter {

    Education fromToEntity(EducationFrom educationFrom);

    EducationVO entityToVO(Education education);

    List<EducationVO> listEntityToListVO(List<Education> list);
}
