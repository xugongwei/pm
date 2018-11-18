package cn.ibona.pm.service;

import cn.ibona.pm.entity.Service;

import java.util.List;

/**
 * @author xugongwei
 * @date 2018/11/17 19:59
 */
public interface ServiceService {

    List<Service> listByProjectId(Integer id,Integer isDelete);

    Service selectById(Integer id);

    int insert(Service service);

    int updateById(Service service);

    int hiddenById(Integer id);

    int deleteById(Integer id);
}
