package CaseStudy.controllers;

import CaseStudy.models.AcademicLevel;
import CaseStudy.services.AcademicLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AcademicLevelController {

    @Autowired
    private AcademicLevelService academicLevelService;

    @GetMapping("/admin/levels")
    public ModelAndView showLevel(Pageable pageable) {
        Page<AcademicLevel> academicLevels = academicLevelService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("academicLevel/list");
        modelAndView.addObject("levels",academicLevels);
        return modelAndView;
    }

    @GetMapping("/admin/academicLevel/create")
    public ModelAndView createAcademicLevelForm() {
        ModelAndView modelAndView = new ModelAndView("academicLevel/create");
        modelAndView.addObject("level", new AcademicLevel());
        return modelAndView;
    }

    @PostMapping("/admin/academicLevel/create")
    public ModelAndView saveCreateAcademicLevel(@Validated @ModelAttribute("level") AcademicLevel academicLevel, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("academicLevel/create");
            return modelAndView;
        }
        academicLevelService.save(academicLevel);
        ModelAndView modelAndView = new ModelAndView("academicLevel/create");
        modelAndView.addObject("level", new AcademicLevel());
        modelAndView.addObject("message", "Add new AcademicLevel successfully");
        return modelAndView;
    }

    @GetMapping("/admin/academicLevel/edit/{id}")
    public ModelAndView editAcademicLevelForm(@PathVariable("id") Long id) {
        AcademicLevel academicLevel = academicLevelService.findById(id);
        ModelAndView modelAndView = new ModelAndView("academicLevel/edit");
        modelAndView.addObject("level",academicLevel);
        return modelAndView;
    }

    @PostMapping("/admin/academicLevel/edit")
    public ModelAndView saveEditAcademicLevel(@Validated @ModelAttribute("level") AcademicLevel academicLevel, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("academicLevel/edit");
            return modelAndView;
        }
        academicLevelService.save(academicLevel);
        ModelAndView modelAndView = new ModelAndView("academicLevel/edit");
        modelAndView.addObject("level", academicLevel);
        modelAndView.addObject("message", "Update successfully");
        return modelAndView;
    }

    @GetMapping("/admin/academicLevel/delete/{id}")
    public ModelAndView deleteAcademicLevelForm(@PathVariable("id") Long id) {
        AcademicLevel academicLevel = academicLevelService.findById(id);
        ModelAndView modelAndView = new ModelAndView("academicLevel/delete");
        modelAndView.addObject("level", academicLevel);
        return modelAndView;
    }

    @PostMapping("/admin/academicLevel/delete")
    public ModelAndView deleteAcademicLevel(@ModelAttribute("level") AcademicLevel academicLevel, Pageable pageable) {
        academicLevelService.remove(academicLevel.getId());
        ModelAndView modelAndView = new ModelAndView("academicLevel/list");
        modelAndView.addObject("levels", academicLevelService.findAll(pageable));
        return modelAndView;
    }
}
