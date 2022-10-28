package facade;

import facade.mathsubsystem.Math1;
import facade.mathsubsystem.Math2;

public class MathFacadeImpl implements MathFacade {
    private final Math1 math1 = new Math1();
    private final Math2 math2 = new Math2();

    @Override
    public Long round(Double a) {
        return math1.round(a);
    }

    @Override
    public Double floor(Double a) {
        return math2.floor(a);
    }

    @Override
    public Double random() {
        return math1.random();
    }
}
