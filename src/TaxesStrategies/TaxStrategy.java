
package TaxesStrategies;

import Articles.ExemptArticle;
import Articles.StandardArticle;

/**
 *
 * @author Paolo
 */
public interface TaxStrategy {
    
    final SalesTaxCalculator calculator = SalesTaxCalculator.getInstance();
    
    public void getTax(ExemptArticle eObj);
    public void getTax(StandardArticle sObj);
    
}
