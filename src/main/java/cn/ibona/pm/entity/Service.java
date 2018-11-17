package cn.ibona.pm.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xugongwei
 * @date 2018/11/17 19:48
 */

@Data
@Accessors(chain = true)
public class Service implements Serializable {

    private Integer id;

    private String serviceName;

    private Integer projectId;

    private String serviceDesc;

    private String serviceLanguage;

    private String servicePrincipal;

    private String gitAddress;

    private String gitBranch;

    private Integer serviceVersion;

    private Date createdTime;

    private Integer isDelete;
}
