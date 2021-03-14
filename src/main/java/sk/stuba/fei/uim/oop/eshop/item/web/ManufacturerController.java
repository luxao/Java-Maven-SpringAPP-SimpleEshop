package sk.stuba.fei.uim.oop.eshop.item.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.stuba.fei.uim.oop.eshop.item.domain.Manufacturer;
import sk.stuba.fei.uim.oop.eshop.item.service.ManufacturerService;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/")
    public String all(Model model) {
        model.addAttribute("manufacturers", manufacturerService.findAllManufacturers());
        return "manufacturer/all";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturer/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute Manufacturer manufacturer, Model model) {
        manufacturerService.addManufacturer(manufacturer);
        model.addAttribute("manufacturers", manufacturerService.findAllManufacturers());
        return "manufacturer/all";
    }
}
