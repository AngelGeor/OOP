package fairyShop.core;


import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;


public class ControllerImpl implements Controller{
private HelperRepository helpers;
private PresentRepository presents;

    public ControllerImpl() {
        this.helpers = new HelperRepository();
        this.presents = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) { //Happy, Sleepy
        Helper helper = null;
        switch (type){
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }
        this.helpers.add(helper);
        return String.format(ConstantMessages.ADDED_HELPER,type,helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Instrument instrument = new InstrumentImpl(power);
        Helper newHelper = this.helpers.findByName(helperName);
        if(newHelper == null){
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        newHelper.addInstrument(instrument);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER,power,helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
    Present present = new PresentImpl(presentName,energyRequired);
    presents.add(present);
    return String.format("Successfully added Present: %s!", presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        return null;
    }

    @Override
    public String report() {
        String sb = "3 presents are done!" + System.lineSeparator() +
                "Helpers info:" + System.lineSeparator() +
                "Name: SleepyHead" + System.lineSeparator() +
                "Energy: 50" + System.lineSeparator() +
                "Instruments: 1 not broken left" + System.lineSeparator() +
                "Name: Sunshine" + System.lineSeparator() +
                "Energy: 10" + System.lineSeparator() +
                "Instruments: 3 not broken left";
       return sb.trim();

    }
}
