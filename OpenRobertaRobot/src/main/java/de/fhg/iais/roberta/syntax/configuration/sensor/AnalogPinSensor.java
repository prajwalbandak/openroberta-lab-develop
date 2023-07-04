package de.fhg.iais.roberta.syntax.configuration.sensor;

import de.fhg.iais.roberta.syntax.configuration.ConfigurationComponent;
import de.fhg.iais.roberta.transformer.forClass.NepoConfiguration;
import de.fhg.iais.roberta.util.dbc.DbcException;

@NepoConfiguration(name = "ANALOG_PIN", category = "CONFIGURATION_SENSOR", blocklyNames = {"robConf_analogout"})
public final class AnalogPinSensor extends ConfigurationComponent {
    private AnalogPinSensor() {
        super(null, null, null, null, null);
        throw new DbcException("should NEVER be called");
    }
}
