package glacialExpedition;

import glacialExpedition.common.core.Controller;
import glacialExpedition.common.core.ControllerImpl;
import glacialExpedition.common.core.Engine;
import glacialExpedition.common.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
