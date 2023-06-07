package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class GangNeighbourhood implements Neighbourhood{


    @Override
    public void action(Player tommy, Collection<Player> civilPlayers) {
        Repository<Gun> tommyGunRepository = tommy.getGunRepository();
        Deque<Gun> tommyGuns = new ArrayDeque<>(tommyGunRepository.getModels());
        Deque<Player> players = new ArrayDeque<>(civilPlayers);
        //1. Phase I
        Player player = players.poll();
        Gun gun = tommyGuns.poll();

        while(player != null && gun != null){
            while(gun.canFire() && player.isAlive()){
                int shot = gun.fire();
                player.takeLifePoints(gun.fire());
            }
            if(gun.canFire()){
                player = players.poll();
            }else {
                gun = tommyGuns.poll();
            }
        }

        //Phase ||
        for(Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                Collection<Gun> civilPlayerGunRepository = civilPlayer.getGunRepository().getModels();
                Deque<Gun> civilPlayerGuns = new ArrayDeque<>(civilPlayerGunRepository);
                Gun civilPlayerGun = civilPlayerGuns.poll();
                while (civilPlayerGun != null) {
                    while (civilPlayerGun.canFire() && tommy.isAlive()) {
                        int shot = civilPlayerGun.fire();
                        tommy.takeLifePoints(shot);
                    }
                    if(!tommy.isAlive()){
                        return;
                    }
                   civilPlayerGun = civilPlayerGuns.poll();
                }
            }
        }

    }
}
