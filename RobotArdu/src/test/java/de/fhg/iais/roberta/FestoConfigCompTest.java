package de.fhg.iais.roberta;

import org.junit.Test;

import de.fhg.iais.roberta.util.test.UnitTestHelper;

public class FestoConfigCompTest extends AstTest {

    @Test
    public void led_make_ByDefault_ReturnInstanceOfConfigurationComponentClass() {
        String expectedResult =
            "BlockAST [project=[ConfigurationComponent[componentType=LED,category=CONFIGURATION_ACTOR,userDefinedName=L,portName=L,componentProperties={INPUT=LED_BUILTIN}]]]";
        UnitTestHelper.checkConfigAstEquality(testFactory, expectedResult, "/ast/config/festo/robConf_led.xml");
    }

    @Test
    public void led_astToBlock_XMLtoJAXBtoASTtoXML_ReturnsSameXML() throws Exception {
        UnitTestHelper.checkConfigReverseTransformation(testFactory, "/ast/config/festo/robConf_led.xml");
    }

    @Test
    public void servo_make_ByDefault_ReturnInstanceOfConfigurationComponentClass() {
        String expectedResult =
            "BlockAST [project=[ConfigurationComponent[componentType=SERVOMOTOR,category=CONFIGURATION_ACTOR,userDefinedName=S,portName=S,componentProperties={PULSE=1}]]]";
        UnitTestHelper.checkConfigAstEquality(testFactory, expectedResult, "/ast/config/festo/robConf_servo.xml");
    }

    @Test
    public void servo_astToBlock_XMLtoJAXBtoASTtoXML_ReturnsSameXML() throws Exception {
        UnitTestHelper.checkConfigReverseTransformation(testFactory, "/ast/config/festo/robConf_servo.xml");
    }
}
