package org.dario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Mappable> mappables = new ArrayList<>();

        mappables.add(new Building("Sydney", BuildingType.BUSINESS));

        mappables.add(new UtilityLine("noseq", UtilityType.FIBER_OPTIC));

        System.out.println(mappables);

        for (var element : mappables) {
            Mappable.printProperties(element);

        }


    }
}