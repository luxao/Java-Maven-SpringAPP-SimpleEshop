package sk.stuba.fei.uim.oop.eshop.item.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.eshop.item.domain.Category;

@Service
public interface CategoryService {

    Category getRootCategory();
}
