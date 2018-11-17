package cn.ibona.pm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@MapperScan("cn.ibona.pm.mapper")
@Controller
@SpringBootApplication
public class PmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "redirect:/api/pm/project/list";
    }
}
