package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {


    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        for (Astronaut astronaut : astronauts) {
            while (astronaut.canBreath() && planet.getItems().iterator().hasNext()) {
                String item = planet.getItems().iterator().next();
                planet.getItems().remove(item);
                astronaut.getBag().getItems().add(item);
                astronaut.breath();

            }
        }
    }
}
