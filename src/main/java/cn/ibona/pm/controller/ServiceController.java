package cn.ibona.pm.controller;

import cn.ibona.pm.entity.Project;
import cn.ibona.pm.entity.Service;
import cn.ibona.pm.service.ProjectService;
import cn.ibona.pm.service.ServiceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xugongwei
 * @date 2018/11/17 20:01
 */
@Controller
@RequestMapping("/api/pm/service")
public class ServiceController {

    private final ServiceService serviceService;

    private final ProjectService projectService;

    @Autowired
    public ServiceController(ServiceService serviceService, ProjectService projectService) {
        this.serviceService = serviceService;
        this.projectService = projectService;
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public String list(@PathVariable(value = "id") Integer id, @RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model, HttpServletRequest request) {
        ServletContext servletContext = request.getSession().getServletContext();
        PageHelper.startPage(pn, 10);
        List<Service> serviceList = serviceService.listByProjectId(id, 0);
        PageInfo<Service> pageInfo = new PageInfo<>(serviceList,5);
        Project project = projectService.selectByProjectId(id);
        servletContext.setAttribute("project", project);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("projectId", id);
        return "service/service";
    }

    @RequestMapping(value = "/toInsert/{id}", method = RequestMethod.GET)
    public String insertPage(Model model, @PathVariable("id") Integer id) {
        // 项目名下拉列表
        List<Project> projectList = projectService.listProject(0);
        model.addAttribute("projectList", projectList);
        model.addAttribute("pId", id);
        return "service/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(Service service) {
        int insert = serviceService.insert(service);
        return "redirect:/api/pm/project/list";
    }

    @RequestMapping("/toUpdate/{id}")
    public String updatePage(@PathVariable("id") Integer id, Model model) {
        Service service = serviceService.selectById(id);
        model.addAttribute("service", service);
        return "service/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(Service service) {
        int i = serviceService.updateById(service);
        return "redirect:/api/pm/project/list";
    }


    @RequestMapping("/hidden/{id}")
    public String hidden(@PathVariable("id") Integer id) {
        serviceService.hiddenById(id);
        return "redirect:/api/pm/project/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        serviceService.deleteById(id);
        return "redirect:/api/pm/project/list";
    }
}
