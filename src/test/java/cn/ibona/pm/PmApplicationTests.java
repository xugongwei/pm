package cn.ibona.pm;

import cn.ibona.pm.entity.Project;
import cn.ibona.pm.mapper.ProjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmApplicationTests {

    @Autowired
    private ProjectMapper projectMapper;

    @Test
    public void contextLoads() {
        List<Project> projects = projectMapper.listProject(0);
        System.out.println(projects);
    }

}
