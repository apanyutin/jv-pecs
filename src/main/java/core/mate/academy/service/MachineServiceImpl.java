package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

public class MachineServiceImpl implements MachineService<Machine> {
    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        if (type == Bulldozer.class) {
            BulldozerProducer bulldozerProducer = new BulldozerProducer();
            List<? extends Machine> machines = bulldozerProducer.get();
            return new ArrayList<>(machines);
        } else if (type == Excavator.class) {
            ExcavatorProducer excavator = new ExcavatorProducer();
            List<? extends Machine> machines = excavator.get();
            return new ArrayList<>(machines);
        } else if (type == Truck.class) {
            TruckProducer truckProducer = new TruckProducer();
            List<? extends Machine> machines = truckProducer.get();
            return new ArrayList<>(machines);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (int i = 0; i < machines.size(); i++) {
            Machine machine = (Machine) machines.get(i);
            machine.doWork();
        }
    }
}
