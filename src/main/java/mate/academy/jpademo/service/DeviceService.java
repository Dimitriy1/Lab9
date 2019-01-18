package mate.academy.jpademo.service;

import mate.academy.jpademo.model.device.Device;

public interface DeviceService {
    Device read(Integer id);

    Integer create(Device device);

    void update(Device device);

    void delete(Device device);
}