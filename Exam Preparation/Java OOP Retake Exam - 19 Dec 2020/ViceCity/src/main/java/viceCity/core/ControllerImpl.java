package viceCity.core;

import viceCity.common.Command;
import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Player tommy;
    private Map<String, Player> civilPlayers;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        tommy = new MainPlayer();
        civilPlayers = new LinkedHashMap<>();
        guns = new ArrayDeque<>();
        neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player playerToAdd = new CivilPlayer(name);
        civilPlayers.put(name, playerToAdd);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return ConstantMessages.GUN_TYPE_INVALID;
        }
        guns.offer(gun);
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String playerName) {
        Gun gunToAdd = guns.poll();
        if (gunToAdd == null) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        if (playerName.equals("Vercetti")) {
            tommy.getGunRepository().add(gunToAdd);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gunToAdd.getName(), tommy.getName());
        }
        Player civilPlayer = civilPlayers.get(playerName);
        if (civilPlayer == null) {
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        civilPlayer.getGunRepository().add(gunToAdd);
        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gunToAdd.getName(), playerName);
    }

    @Override
    public String fight() {
        neighbourhood.action(tommy, civilPlayers.values());

        if (tommy.getLifePoints() == 100 && civilPlayers.values().stream().
                allMatch(player -> player.getLifePoints() == 50)) {
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        }
        List<Player> deadPlayers = civilPlayers.values()
                .stream()
                .filter(player -> !player.isAlive())
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder(ConstantMessages.FIGHT_HAPPENED)
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, tommy.getLifePoints()))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size() -
                        deadPlayers.size()));

        for (Player deadPlayer : deadPlayers) {
            civilPlayers.remove(deadPlayer.getName());
        }
        return sb.toString();
    }

}
