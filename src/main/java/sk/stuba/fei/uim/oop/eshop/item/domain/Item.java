package sk.stuba.fei.uim.oop.eshop.item.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor // kvoli nacitavaniu z json suboru
public class Item extends Entity implements WithName {

    private String name;
    private Float price;
    private long manufacturerId;
    private Category category;
}
