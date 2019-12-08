package CaseStudy.controllers;

import CaseStudy.models.Position;
import CaseStudy.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PositionController {
    @Autowired
    private PositionService positionService;
    @GetMapping("/admin/positions")
    public ModelAndView listPosition(@PageableDefault(size=10) Pageable pageable, @RequestParam("s") Optional<String> s){
        Page<Position> positions;
        if(s.isPresent()){
            positions = positionService.findAllByNameContaining(s.get(), pageable);
        } else {
            positions = positionService.findAll(pageable);
        }
            ModelAndView modelAndView = new ModelAndView("position/list");
            modelAndView.addObject("positions", positions);
            return modelAndView;
        }
    @GetMapping("/admin/create-position")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView =  new ModelAndView("position/create");
        modelAndView.addObject("position", new Position());
        return modelAndView;
    }
    @PostMapping("/admin/create-position")
    public ModelAndView savePosition(@Valid @ModelAttribute("position") Position position, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView  = new ModelAndView("position/create");
            return modelAndView;
        } else {
            positionService.save(position);
            ModelAndView modelAndView = new ModelAndView("position/create");
            modelAndView.addObject("position", position);
            modelAndView.addObject("message", "new Position has been created");
            return modelAndView;
        }
    }
    @GetMapping("/admin/edit-position/{id}")
    public ModelAndView showEditForm(@PathVariable("id")Long id){
        Position position = positionService.findById(id);
        if(position != null){
            ModelAndView modelAndView = new ModelAndView("position/edit");
            modelAndView.addObject("position", position);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("/admin/edit-position")
    public ModelAndView updatePosition(@ModelAttribute("position") Position position){
        positionService.save(position);
        ModelAndView modelAndView = new ModelAndView("position/edit");
        modelAndView.addObject("position", position);
        modelAndView.addObject("message", "updated position");
        return modelAndView;
    }
    @GetMapping("/admin/delete-position/{id}")
    public ModelAndView deleteForm(@PathVariable("id")Long id){
        Position position = positionService.findById(id);
        if(position !=null){
            ModelAndView modelAndView = new ModelAndView("position/delete");
            modelAndView.addObject("position", position);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("/admin/delete-position")
    public String deletePosition(@ModelAttribute("position") Position position){

        positionService.remove(position.getId());
        return "redirect:/admin/positions";
    }

}
