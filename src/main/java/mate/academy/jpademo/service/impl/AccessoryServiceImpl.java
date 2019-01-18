package mate.academy.jpademo.service.impl;

import mate.academy.jpademo.dao.AccessoryDao;
import mate.academy.jpademo.model.accessory.Accessory;
import mate.academy.jpademo.service.AccessoryService;

public class AccessoryServiceImpl implements AccessoryService {
    private AccessoryDao accessoryDao;

    public AccessoryServiceImpl(AccessoryDao accessoryDao) {
        this.accessoryDao = accessoryDao;
    }

    @Override
    public Accessory read(Integer id) {
        return accessoryDao.read(id);
    }

    @Override
    public Integer create(Accessory accessory) {
        return accessoryDao.create(accessory);
    }

    @Override
    public void update(Accessory accessory) {
        accessoryDao.update(accessory);
    }

    @Override
    public void delete(Accessory accessory) {
        accessoryDao.delete(accessory);
    }
}
