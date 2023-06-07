package aquarium.entities.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    protected void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {
    if(this.capacity <= this.fish.size()){
        throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
    }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
    this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
    this.decorations.add(decoration);
    }

    @Override
    public void feed() {
    for(Fish singleFish : fish){
        singleFish.eat();
    }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s:",this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Fish: ");

        if(this.fish.isEmpty()){
            sb.append("none").append(System.lineSeparator());
        }else {
            sb.append(this.getFish().stream().map(Fish::getName).collect(Collectors.joining(" ")).trim())
                    .append(System.lineSeparator());
            sb.append(String.format("Decorations: %d", this.decorations.size()))
                    .append(System.lineSeparator());
            sb.append(String.format("Comfort: %d", calculateComfort()));
        }
        return sb.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
