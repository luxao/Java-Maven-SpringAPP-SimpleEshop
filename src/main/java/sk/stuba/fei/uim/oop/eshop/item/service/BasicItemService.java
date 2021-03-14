package sk.stuba.fei.uim.oop.eshop.item.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.eshop.item.domain.Category;
import sk.stuba.fei.uim.oop.eshop.item.domain.Item;
import sk.stuba.fei.uim.oop.eshop.item.domain.Manufacturer;

import java.util.*;

@Service
public class BasicItemService implements ItemService, ManufacturerService, CategoryService {

    private final Map<Long, Item> items;
    private final Map<Long, Manufacturer> manufacturers;
    private final Category rootCategory;

    public BasicItemService() {
        items = new HashMap<>();
        manufacturers = new HashMap<>();
        rootCategory = new Category("Kategorie");
    }

    @Override
    public Category getRootCategory() {
        return rootCategory;
    }

    @Override
    public void addItem(Item item) {
        items.put(item.getId(), item);
    }

    @Override
    public Map<Long, Item> findAllItems() {
        return items;
    }

    @Override
    public Optional<Item> findItemById(long id) {
        return Optional.ofNullable(items.get(id));
    }

    @Override
    public Optional<Item> findItemByName(String name) {
        return items.values().stream()
                .filter(item -> item.getName().equals(name))
                .findFirst();
    }

    @Override
    public void addManufacturer(Manufacturer manufacturer) {
        manufacturers.put(manufacturer.getId(), manufacturer);
    }

    @Override
    public Map<Long, Manufacturer> findAllManufacturers() {
        return manufacturers;
    }

    @Override
    public Manufacturer findById(long id) {
        return manufacturers.get(id);
    }
}
