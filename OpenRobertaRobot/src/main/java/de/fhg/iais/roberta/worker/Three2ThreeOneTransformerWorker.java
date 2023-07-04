package de.fhg.iais.roberta.worker;

import de.fhg.iais.roberta.bean.NewUsedHardwareBean;
import de.fhg.iais.roberta.components.ConfigurationAst;
import de.fhg.iais.roberta.components.Project;
import de.fhg.iais.roberta.visitor.TransformerVisitor;

public class Three2ThreeOneTransformerWorker extends AbstractTransformerWorker {

    public Three2ThreeOneTransformerWorker() {
        super("3.0", "3.0", "3.1");
    }

    @Override
    protected TransformerVisitor getVisitor(Project project, NewUsedHardwareBean.Builder builder, ConfigurationAst configuration) {
        return null;
    }
}
