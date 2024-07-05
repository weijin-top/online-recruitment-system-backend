package com.weijin.recruitment.converter;

import com.weijin.recruitment.model.entity.Project;
import com.weijin.recruitment.model.from.project.ProjectFrom;
import com.weijin.recruitment.model.vo.project.ProjectVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/5 20:23
 */
@Component
@Mapper(componentModel = "spring")
public interface ProjectConverter {
    Project fromToEntity(ProjectFrom projectFrom);

    ProjectVO entityToVO(Project project);

    List<ProjectVO> listEntityToListVO(List<Project> list);
}
