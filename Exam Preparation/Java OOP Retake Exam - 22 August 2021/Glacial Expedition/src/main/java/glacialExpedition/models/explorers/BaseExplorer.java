package glacialExpedition.models.explorers;

import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import static glacialExpedition.common.ConstantMessages.*;

public abstract class BaseExplorer implements Explorer{
    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase = new Carton();
    }

    protected void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if(energy < 0){
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return this.getEnergy() > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        if(this.getEnergy() - 15 < 0){
            this.setEnergy(0);
        }else {
            this.setEnergy(this.getEnergy() - 15);
        }

    }
    @Override
        public String toString() {
            StringBuilder info = new StringBuilder();

            info.append(String.format(FINAL_EXPLORER_NAME, this.name)).append(System.lineSeparator());
            info.append(String.format(FINAL_EXPLORER_ENERGY, this.energy)).append(System.lineSeparator());
            info.append("Suitcase exhibits: ");

            int exhibitsCount = this.suitcase.getExhibits().size();

            String suitcaseExhibit = exhibitsCount == 0
                    ? "None"
                    : String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, this.getSuitcase().getExhibits());

            info.append(suitcaseExhibit);

            return info.toString().trim();
    }
    }

