package pl.bookingsystem.action;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;

/**
 * A very simple calculator action.
 * @author Tim Fennell
 */
@UrlBinding("/calc")
public class CalculatorActionBean extends BaseActionBean {

    @Validate(required=true) private double numberOne;
    @Validate(required=true) private double numberTwo;
    private double result;


    public double getNumberOne() { return numberOne; }
    public void setNumberOne(double numberOne) { this.numberOne = numberOne; }

    public double getNumberTwo() { return numberTwo; }
    public void setNumberTwo(double numberTwo) { this.numberTwo = numberTwo; }

    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }

    /** An event handler method that adds number one to number two. */
    @DefaultHandler
    public Resolution addition() {
        result = numberOne + numberTwo;
        return new ForwardResolution("/WEB-INF/quickstart/index.jsp");
    }

    /** An event handler method that divides number one by number two. */
    public Resolution division() {
        result = numberOne / numberTwo;
        return new ForwardResolution("/WEB-INF/quickstart/index.jsp");
    }

    /**
     * An example of a custom validation that checks that division operations
     * are not dividing by zero.
     */
    @ValidationMethod(on="division")
    public void avoidDivideByZero(ValidationErrors errors) {
        if (this.numberTwo == 0) {
            errors.add("numberTwo", new SimpleError("Dividing by zero is not allowed."));
        }
    }
}
