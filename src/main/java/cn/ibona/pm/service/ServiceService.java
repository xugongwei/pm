package cn.ibona.pm.service;

import cn.ibona.pm.entity.Service;

import java.util.List;

/**
 * @author xugongwei
 * @date 2018/11/17 19:59
 */
public interface ServiceService {

    List<Service> listByProjectId(Integer id);

    Service selectById(Integer id);

    int insert(Service service);

    int deleteById(Integer id);
}
