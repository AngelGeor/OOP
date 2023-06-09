package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    private static final double NATURAL_EXPLORER_ENERGY = 60;
    public NaturalExplorer(String name) {
        super(name, NATURAL_EXPLORER_ENERGY);
    }
    @Override
    public void search(){
        if(this.getEnergy() - 7 < 0){
            super.setEnergy(0);
        }else {
            super.setEnergy(this.getEnergy() - 7);
        }
    }

    }

