package mate.academy.jpademo.service.impl;

import mate.academy.jpademo.dao.DeviceDao;
import mate.academy.jpademo.model.device.Device;
import mate.academy.jpademo.service.DeviceService;

public class DeviceServiceImpl implements DeviceService {
    private DeviceDao deviceDao;

    public DeviceServiceImpl(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public Device read(Integer id) {
        return deviceDao.read(id);
    }

    @Override
    public Integer create(Device device) {
        return deviceDao.create(device);
    }

    @Override
    public void update(Device device) {
        deviceDao.update(device);
    }

    @Override
    public void delete(Device device) {
        deviceDao.delete(device);
    }
}