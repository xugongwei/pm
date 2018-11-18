package cn.ibona.pm.service.impl;

import cn.ibona.pm.entity.Service;
import cn.ibona.pm.mapper.ServiceMapper;
import cn.ibona.pm.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author xugongwei
 * @date 2018/11/17 20:00
 */
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceMapper serviceMapper;

    @Autowired
    public ServiceServiceImpl(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }

    @Override
    public List<Service> listByProjectId(Integer id, Integer isDelete) {
        return serviceMapper.listByProjectId(id, isDelete);
    }

    @Override
    public Service selectById(Integer id) {
        return serviceMapper.selectById(id);
    }

    @Override
    public int insert(Service service) {
        return serviceMapper.insert(service);
    }

    @Override
    public int updateById(Service service) {
        return serviceMapper.updateById(service);
    }

    @Override
    public int hiddenById(Integer id) {
        return serviceMapper.hiddenById(id);
    }

    @Override
    public int deleteById(Integer id) {
        return serviceMapper.deleteById(id);
    }
}
