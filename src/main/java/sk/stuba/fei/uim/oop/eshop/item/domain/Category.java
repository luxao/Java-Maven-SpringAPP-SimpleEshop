package sk.stuba.fei.uim.oop.eshop.item.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class Category extends Entity {

    private String name;
    private Set<Category> subcategories;

    public Category(String name) {
        super();
        this.name = name;
        this.subcategories = new LinkedHashSet<>();
    }

    public void addSubcategory(Category subcategory) {
        subcategories.add(subcategory);
    }

    public String toStringTree(String tabs) {
        StringBuilder builder = new StringBuilder();
        builder.append(tabs).append(name).append("\n");
        for (Category subcategory : subcategories) {
            builder.append(subcategory.toStringTree(tabs+" "));
        }
        return builder.toString();
    }
}
