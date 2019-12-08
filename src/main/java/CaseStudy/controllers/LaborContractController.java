package CaseStudy.controllers;

import CaseStudy.models.Employee;
import CaseStudy.models.LaborContract;
import CaseStudy.services.EmployeeService;
import CaseStudy.services.LaborContractService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LaborContractController {
    @Autowired
    private LaborContractService laborContractService;
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/admin/laborContract")
    public ModelAndView listLabor(@PageableDefault(size = 10) Pageable pageable, @RequestParam("c") Optional<String> c) {
        Page<LaborContract> laborContracts;
        if (c.isPresent()) {
            laborContracts = laborContractService.findAllByNameContaining(c.get(), pageable);
        } else {
            laborContracts = laborContractService.findAll(pageable);
        }
            ModelAndView modelAndView = new ModelAndView("laborContract/list");
            modelAndView.addObject("laborContracts", laborContracts);
            return modelAndView;

    }
    @GetMapping("/admin/create-labor")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("laborContract/create");
        modelAndView.addObject("laborContract",new LaborContract());
        return modelAndView;
    }
    @PostMapping("/admin/create-labor")
    public ModelAndView createLabor(LaborContract laborContract){
        laborContractService.save(laborContract);
        ModelAndView modelAndView = new ModelAndView("laborContract/create");
        modelAndView.addObject("laborContract", new LaborContract());
        modelAndView.addObject("message", "New labor contract has been created");
        return modelAndView;
    }
    @GetMapping("/admin/edit-labor/{id}")
    public ModelAndView editForm(@PathVariable("id")Long id){
        LaborContract laborContract = laborContractService.findById(id);
        if(laborContract!=null){
            ModelAndView modelAndView = new ModelAndView("laborContract/edit");
            modelAndView.addObject("laborContract",laborContract);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("/admin/edit-labor")
    public ModelAndView updateLaborContract(LaborContract laborContract){
        laborContractService.save(laborContract);
        ModelAndView modelAndView = new ModelAndView("laborContract/edit");
        modelAndView.addObject("laborContract",laborContract);
        modelAndView.addObject("message", "New labor contract has been created");
        return modelAndView;
    }
    @GetMapping("/admin/delete-labor/{id}")
    public ModelAndView deleteForm(@PathVariable("id") Long id){
        LaborContract laborContract = laborContractService.findById(id);
        if(laborContract!=null){
            ModelAndView modelAndView = new ModelAndView("laborContract/delete");
            modelAndView.addObject("laborContract", laborContract);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("/admin/delete-labor")
    public String deleteLabor(@ModelAttribute("laborContract")LaborContract laborContract, Pageable pageable, Model model){
        Page<Employee> employees = employeeService.findAll(pageable);
        if (employees!=null){
            model.addAttribute("laborContract", laborContractService.findById(laborContract.getId()));
            model.addAttribute("message", "You must remove the employee associated with this field");
            return "laborContract/delete";
        }
        laborContractService.remove(laborContract.getId());
        return "redirect:/admin/laborContract";
    }

}
