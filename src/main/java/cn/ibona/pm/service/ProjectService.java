package cn.ibona.pm.service;

import cn.ibona.pm.entity.Project;

import java.util.List;

/**
 * @author xugongwei
 * @date 2018/11/16 10:01
 */
public interface ProjectService {

    List<Project> listProject(Integer isDelete);

    int insertProject(Project project);

    int updateProject(Project project);

    int updateByProjectId(Integer id);

    int deleteProject(Integer id);

    Project selectByProjectId(Integer id);
}
