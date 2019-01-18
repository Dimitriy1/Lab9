package mate.academy.jpademo.service;

import mate.academy.jpademo.model.accessory.Accessory;

public interface AccessoryService {
    Accessory read(Integer id);

    Integer create(Accessory accessory);

    void update(Accessory accessory);

    void delete(Accessory accessory);

}