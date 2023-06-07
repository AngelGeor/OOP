package fairyShop.models;

import fairyShop.common.ExceptionMessages;

public class InstrumentImpl implements Instrument{
    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    protected void setPower(int power) {
        if (power < 0){
            throw new IllegalArgumentException(ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void use() {
    this.setPower(Math.max(this.getPower() - 10,0));
    }

    @Override
    public boolean isBroken() {
        return getPower() == 0;
    }
}
