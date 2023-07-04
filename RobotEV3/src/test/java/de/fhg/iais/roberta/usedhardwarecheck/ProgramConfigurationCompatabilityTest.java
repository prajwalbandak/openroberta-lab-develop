package de.fhg.iais.roberta.usedhardwarecheck;

import java.util.Arrays;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import de.fhg.iais.roberta.Ev3LejosAstTest;
import de.fhg.iais.roberta.components.ConfigurationAst;
import de.fhg.iais.roberta.components.Project;
import de.fhg.iais.roberta.syntax.configuration.ConfigurationComponent;
import de.fhg.iais.roberta.util.Util;
import de.fhg.iais.roberta.util.test.UnitTestHelper;
import de.fhg.iais.roberta.worker.validate.Ev3ValidatorAndCollectorWorker;

public class ProgramConfigurationCompatabilityTest extends Ev3LejosAstTest {

    @Test
    public void ev3program_configuration_compatibility_4_errors() throws Exception {

        Map<String, String> motorAproperties = Util.createMap("MOTOR_REGULATION", "TRUE", "MOTOR_REVERSE", "OFF", "MOTOR_DRIVE", "LEFT");
        ConfigurationComponent motorA = new ConfigurationComponent("LARGE", "CONFIGURATION_ACTOR", "A", "A", motorAproperties);

        Map<String, String> motorBproperties = Util.createMap("MOTOR_REGULATION", "TRUE", "MOTOR_REVERSE", "OFF", "MOTOR_DRIVE", "RIGHT");
        ConfigurationComponent motorB = new ConfigurationComponent("LARGE", "CONFIGURATION_ACTOR", "B", "B", motorBproperties);

        ConfigurationComponent touchSensor = new ConfigurationComponent("TOUCH", "CONFIGURATION_SENSOR", "S1", "1", Util.createMap("TYPE", "TOUCH"));
        ConfigurationComponent ultrasonicSensor = new ConfigurationComponent("ULTRASONIC", "CONFIGURATION_SENSOR", "S2", "2", Util.createMap("TYPE", "ULTRASONIC"));

        final ConfigurationAst.Builder builder = new ConfigurationAst.Builder();
        builder.setTrackWidth(17f).setWheelDiameter(5.6f).addComponents(Arrays.asList(motorA, motorB, touchSensor, ultrasonicSensor));

        Project.Builder builder1 = UnitTestHelper.setupWithProgramXMLWithDefaultConfig(testFactory, Util.readResourceContent("/visitors/program_config_compatibility.xml"));
        builder1.setConfigurationAst(builder.build());
        Ev3ValidatorAndCollectorWorker worker = new Ev3ValidatorAndCollectorWorker();
        Project project = builder1.build();
        worker.execute(project);
        Assert.assertEquals(4, project.getErrorCounter());

    }

    @Test
    public void ev3program_configuration_compatibility_0_errors() throws Exception {
        ConfigurationAst.Builder builder = new ConfigurationAst.Builder();

        Map<String, String> motorAproperties = Util.createMap("MOTOR_REGULATION", "TRUE", "MOTOR_REVERSE", "OFF", "MOTOR_DRIVE", "LEFT");
        ConfigurationComponent motorA = new ConfigurationComponent("MEDIUM", "CONFIGURATION_ACTOR", "A", "A", motorAproperties);

        Map<String, String> motorBproperties = Util.createMap("MOTOR_REGULATION", "TRUE", "MOTOR_REVERSE", "OFF", "MOTOR_DRIVE", "RIGHT");
        ConfigurationComponent motorB = new ConfigurationComponent("LARGE", "CONFIGURATION_ACTOR", "B", "B", motorBproperties);

        ConfigurationComponent touchSensor = new ConfigurationComponent("TOUCH", "CONFIGURATION_SENSOR", "S1", "1", Util.createMap("TYPE", "TOUCH"));
        ConfigurationComponent colorSensor = new ConfigurationComponent("COLOR", "CONFIGURATION_SENSOR", "S2", "2", Util.createMap("TYPE", "COLOR"));
        ConfigurationComponent gyroSensor = new ConfigurationComponent("GYRO", "CONFIGURATION_SENSOR", "S3", "3", Util.createMap("TYPE", "GYRO"));
        ConfigurationComponent ultrasonicSensor = new ConfigurationComponent("ULTRASONIC", "CONFIGURATION_SENSOR", "S4", "4", Util.createMap("TYPE", "ULTRASONIC"));

        builder.setTrackWidth(17f).setWheelDiameter(5.6f).addComponents(Arrays.asList(motorA, motorB, touchSensor, colorSensor, gyroSensor, ultrasonicSensor));

        Project.Builder builder1 =
            UnitTestHelper.setupWithProgramXMLWithDefaultConfig(testFactory, Util.readResourceContent("/visitors" + "/program_config_compatibility_gyro_touch_ultra_color.xml"));
        builder1.setConfigurationAst(builder.build());
        Ev3ValidatorAndCollectorWorker worker = new Ev3ValidatorAndCollectorWorker();
        Project project = builder1.build();
        worker.execute(project);
        Assert.assertEquals(0, project.getErrorCounter());
    }
}
