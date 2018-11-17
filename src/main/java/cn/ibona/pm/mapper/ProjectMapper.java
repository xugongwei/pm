package cn.ibona.pm.mapper;

import cn.ibona.pm.entity.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xugongwei
 * @date 2018/11/16 9:55
 */
public interface ProjectMapper {

    /**
     * 获取项目列表
     *
     * @param isDelete 项目当前状态
     * @return 项目列表
     */
    List<Project> listProject(@Param("isDelete") Integer isDelete);

    /**
     * 添加项目
     *
     * @param project
     * @return
     */
    int insertProject(@Param("project") Project project);

    /**
     * 更新项目信息
     *
     * @param project
     * @return
     */
    int updateProject(@Param("project") Project project);

    /**
     * 根据id隐藏指定的项目（假删除）
     * @param id
     * @return
     */
    int updateByProjectId(@Param("id")Integer id);

    /**
     * 根据id删除项目
     *
     * @param id
     * @return
     */
    int deleteProject(@Param("id") Integer id);

    /**
     * 根据项目id查找
     * @param id
     * @return
     */
    Project selectByProjectId(@Param("id") Integer id);
}
