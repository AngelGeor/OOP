package WorkingWithAbstraction_Ex.TrafficLights;

public class Light {
    private LightColour colour;

    public Light(LightColour colour) {
        this.colour = colour;
    }

    public LightColour getColour() {
        return colour;
    }

    public void setColour(LightColour colour) {
        this.colour = colour;
    }
    public void changeColour(){
        if(this.colour == LightColour.RED){
            this.colour = LightColour.GREEN;
        }else if(this.colour == LightColour.GREEN){
            this.colour = LightColour.YELLOW;
        }else if(this.colour == LightColour.YELLOW){
            this.colour = LightColour.RED;
        }
    }
}
