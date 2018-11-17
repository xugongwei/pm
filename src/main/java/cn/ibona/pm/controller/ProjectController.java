package cn.ibona.pm.controller;

import cn.ibona.pm.entity.Project;
import cn.ibona.pm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author xugongwei
 * @date 2018/11/16 10:03
 */
@Controller
@RequestMapping("/api/pm/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listProject(Model model) {
        List<Project> projectList = projectService.listProject(null);
        model.addAttribute("projectList", projectList);
        return "project/index";
    }

    @RequestMapping("/insert")
    public String insert(Project project) {
        int i = projectService.insertProject(project);
        return "redirect:/api/pm/project/list";
    }

    @RequestMapping(value = "/updatePage/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        Project project = projectService.selectByProjectId(id);
        model.addAttribute("project", project);
        return "project/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(Project project) {
        int i = projectService.updateProject(project);
        return "redirect:/api/pm/project/list";
    }

    @RequestMapping("/hidden/{id}")
    public String hidden(@PathVariable("id") Integer id) {
        int i = projectService.updateByProjectId(id);
        return "redirect:/api/pm/project/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        int i = projectService.deleteProject(id);
        return "redirect:/api/pm/project/list";
    }

}
