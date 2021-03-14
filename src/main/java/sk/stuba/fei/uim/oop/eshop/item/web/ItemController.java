package sk.stuba.fei.uim.oop.eshop.item.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.eshop.item.domain.Item;
import sk.stuba.fei.uim.oop.eshop.item.service.ItemService;
import sk.stuba.fei.uim.oop.eshop.item.service.ManufacturerService;

import java.util.Optional;

@Controller
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final ManufacturerService manufacturerService;

    @Autowired
    public ItemController(ItemService itemService, ManufacturerService manufacturerService) {
        this.itemService = itemService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/")
    public String all(Model model) {
        model.addAttribute("items", itemService.findAllItems());
        model.addAttribute("manufacturers", manufacturerService.findAllManufacturers());
        return "item/all";
    }

    @GetMapping("/id/{id}")
    public String byId(@PathVariable long id, Model model) {
        Optional<Item> itemById = itemService.findItemById(id);
        if (itemById.isPresent()) {
            Item item = itemById.get();
            model.addAttribute("item", item);
            model.addAttribute("manufacturer", manufacturerService.findById(item.getManufacturerId()));
        }
        return "item/one";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("manufacturers", manufacturerService.findAllManufacturers());
        return "item/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute Item item) {
        itemService.addItem(item);
        return "redirect:/item/";
    }


}
