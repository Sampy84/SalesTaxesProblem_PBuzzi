
package TaxesStrategies;

import Articles.ExemptArticle;
import Articles.StandardArticle;

/**
 *
 * @author Paolo
 */
public class InternalArticletStr implements TaxStrategy{

    @Override
    public void getTax(ExemptArticle eObj) {
        System.out.println("InternalObjectStr: Tax = 0");
    }

    @Override
    public void getTax(StandardArticle sObj) {
        System.out.println("InternalObjectStr: Tax = SaleTax");
        calculator.getSaleTax(sObj.getPrice());
    }
}