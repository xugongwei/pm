package cn.ibona.pm.mapper;

import cn.ibona.pm.entity.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xugongwei
 * @date 2018/11/17 19:53
 */
public interface ServiceMapper {

    List<Service> listByProjectId(@Param("id") Integer id);

    Service selectById(@Param("id") Integer id);

    int insert(@Param("service") Service service);

    int deleteById(@Param("id") Integer id);

}
