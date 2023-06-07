package aquarium.core;

import aquarium.common.Command;
import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType){
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.add(aquarium);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE,aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
       switch (type){
           case "Ornament":
               decoration = new Ornament();
               break;
           case "Plant":
               decoration = new Plant();
               break;
           default:
               throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
       }
       this.decorations.add(decoration);
       return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE,type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);
        if(decoration == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }
        Aquarium aquarium = getAquariumByName(aquariumName);
        aquarium.addDecoration(decoration);
        this.decorations.remove(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    private Aquarium getAquariumByName(String aquariumName) {
        return this.aquariums.stream()
                .filter(aquarium -> aquarium.getName().equals(aquariumName))
                .findFirst()
                .get();
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        return null;
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = getAquariumByName(aquariumName);
        aquarium.feed();
        return String.format(ConstantMessages.FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = getAquariumByName(aquariumName);
        double fishSum = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decorationSum = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        double finalSum = fishSum + decorationSum;
        return String.format("The value of Aquarium %s is %.2f.",aquariumName,finalSum);
    }

    @Override
    public String report() {
        return null;
    }
}
