package sk.stuba.fei.uim.oop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import sk.stuba.fei.uim.oop.eshop.item.domain.Item;
import sk.stuba.fei.uim.oop.eshop.item.domain.Manufacturer;
import sk.stuba.fei.uim.oop.eshop.item.service.ItemService;
import sk.stuba.fei.uim.oop.eshop.item.service.ManufacturerService;

@SpringBootApplication
@Slf4j
@Controller
public class OnlineEshopApplication implements CommandLineRunner {

    private final ManufacturerService manufacturerService;
    private final ItemService itemService;
    @Value("classpath:manufacturers.json")
    private Resource manufacturersJson;
    @Value("classpath:items.json")
    private Resource itemsJson;

    public OnlineEshopApplication(ManufacturerService manufacturerService, ItemService itemService) {
        this.manufacturerService = manufacturerService;
        this.itemService = itemService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OnlineEshopApplication.class, args);
        log.info("Open in browser: http://localhost:8080");
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Manufacturer[] manufacturers = objectMapper.readValue(
                manufacturersJson.getInputStream(),
                Manufacturer[].class);
        for (Manufacturer manufacturer : manufacturers) {
            manufacturerService.addManufacturer(manufacturer);

            Item[] items = objectMapper.readValue(
                    itemsJson.getInputStream(),
                    Item[].class);
            for (Item item : items) {
                item.setManufacturerId(manufacturer.getId());
                item.setName(manufacturer.getName() + " " + item.getName());
                itemService.addItem(item);
            }
        }
    }
}
