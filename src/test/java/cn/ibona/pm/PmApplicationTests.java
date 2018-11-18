package cn.ibona.pm;

import cn.ibona.pm.entity.Project;
import cn.ibona.pm.entity.Service;
import cn.ibona.pm.mapper.ProjectMapper;
import cn.ibona.pm.mapper.ServiceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmApplicationTests {

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ServiceMapper serviceMapper;

    @Test
    public void contextLoads() {
        for (int i = 1; i <= 150; i++) {
            for (int j = 0; j < 75; j++) {
                String pName = String.valueOf(UUID.randomUUID());
                String name = pName.substring(0, 12);
                String pDesc = String.valueOf(UUID.randomUUID());
                String pPrincipal = String.valueOf(UUID.randomUUID());
                String substring = pPrincipal.substring(0, 8);
                Date cTime = new Date();

                String language = "java";
                String gitAddress = "https://github.com/xugongwei/pm/" + substring;
                String gitBranch = "https://github.com/xugongwei/pm/branch/" + substring;

                Service service = new Service();
                service.setServiceName(name)
                        .setProjectId(i)
                        .setServiceDesc(pDesc)
                        .setServiceLanguage(language)
                        .setServicePrincipal(pPrincipal)
                        .setGitAddress(gitAddress)
                        .setGitBranch(gitBranch)
                        .setServiceVersion(1)
                        .setCreatedTime(cTime)
                        .setIsDelete(0);
                serviceMapper.insert(service);
            }
        }
    }

}
