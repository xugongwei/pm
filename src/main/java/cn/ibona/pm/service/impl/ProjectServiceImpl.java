package cn.ibona.pm.service.impl;

import cn.ibona.pm.entity.Project;
import cn.ibona.pm.mapper.ProjectMapper;
import cn.ibona.pm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xugongwei
 * @date 2018/11/16 10:02
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public List<Project> listProject(Integer isDelete) {
        return projectMapper.listProject(isDelete);
    }

    @Override
    public int insertProject(Project project) {
        return projectMapper.insertProject(project);
    }

    @Override
    public int updateProject(Project project) {
        return projectMapper.updateProject(project);
    }

    @Override
    public int updateByProjectId(Integer id) {
        return projectMapper.updateByProjectId(id);
    }

    @Override
    public int deleteProject(Integer id) {
        return projectMapper.deleteProject(id);
    }

    @Override
    public Project selectByProjectId(Integer id) {
        return projectMapper.selectByProjectId(id);
    }
}
