package de.fhg.iais.roberta.syntax.configuration.actor;

import de.fhg.iais.roberta.syntax.configuration.ConfigurationComponent;
import de.fhg.iais.roberta.transformer.forClass.NepoConfiguration;
import de.fhg.iais.roberta.util.dbc.DbcException;

@NepoConfiguration(name = "SENSEBOX_PLOTTING", category = "CONFIGURATION_ACTOR",
    blocklyNames = {"robConf_plotting"})
public final class SenseboxPlottingActor extends ConfigurationComponent {
    private SenseboxPlottingActor() {
        super(null, null, null, null, null);
        throw new DbcException("should NEVER be called");
    }
}
