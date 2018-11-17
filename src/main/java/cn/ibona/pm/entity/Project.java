package cn.ibona.pm.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author xugongwei
 * @date 2018/11/16 9:50
 */
@Data
@Accessors(chain = true)

public class Project {

    private Integer id;

    private String projectName;

    private String projectDesc;

    private String projectPrincipal;

    private Date createdTime;

    private Integer isDelete;
}
