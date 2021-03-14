package sk.stuba.fei.uim.oop.eshop.item.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.eshop.item.domain.Manufacturer;

import java.util.Map;
import java.util.Optional;

@Service
public interface ManufacturerService {

    void addManufacturer(Manufacturer manufacturer);

    Map<Long, Manufacturer> findAllManufacturers();

    Manufacturer findById(long id);
}
