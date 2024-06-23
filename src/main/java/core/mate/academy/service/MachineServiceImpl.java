package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.BulldozerProducer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.ExcavatorProducer;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import core.mate.academy.model.TruckProducer;
import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl<T extends Machine> implements MachineService<T> {

    @Override
    public List<T> getAll(Class<? extends T> typeofmachine) {
        MachineProducer<? extends Machine> producer;

        if (typeofmachine == Bulldozer.class) {
            producer = new BulldozerProducer();
        } else if (typeofmachine == Truck.class) {
            producer = new TruckProducer();
        } else if (typeofmachine == Excavator.class) {
            producer = new ExcavatorProducer();
        } else {
            return new ArrayList<>();
        }
        return (List<T>) producer.get();
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends T> machines) {
        for (T machine : machines) {
            machine.doWork();
        }
    }
}
