package sk.stuba.fei.uim.oop.eshop.item.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.eshop.item.domain.Item;

import java.util.Map;
import java.util.Optional;

@Service
public interface ItemService {

    void addItem(Item item);

    Map<Long, Item> findAllItems();

    Optional<Item> findItemById(long id);

    Optional<Item> findItemByName(String name);
}
