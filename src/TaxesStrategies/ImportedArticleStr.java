
package TaxesStrategies;

import Articles.ExemptArticle;
import Articles.StandardArticle;

/**
 *
 * @author Paolo
 */
public class ImportedArticleStr implements TaxStrategy{

    @Override
    public void getTax(ExemptArticle eObj) {
        System.out.println("ImportedObjectStr: Tax = Duty");
        calculator.getDuty(eObj.getPrice()); // eObj.getPrice()
        
    }
    
    @Override
    public void getTax(StandardArticle sObj) {
        System.out.println("ImportedObjectStr: Tax = Duty + SaleTax");
        calculator.getDuty(sObj.getPrice()); // sObj.getPrice()
        calculator.getSaleTax(sObj.getPrice()); // sObj.getPrice()
    }    
    
}
