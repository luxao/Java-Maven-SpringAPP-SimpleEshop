package sk.stuba.fei.uim.oop.eshop.item.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // kvoli nacitavaniu z json suboru
public class Manufacturer extends Entity implements WithName {

    private String name;
}
