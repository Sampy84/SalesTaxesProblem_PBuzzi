
package TaxesStrategies;

import Util.SalesTaxCalculator;
import Articles.ExemptArticle;
import Articles.StandardArticle;
import java.math.BigDecimal;

/**
 *
 * @author Paolo
 */
public interface TaxStrategy {
    
    final SalesTaxCalculator calculator = SalesTaxCalculator.getInstance();
    
    public BigDecimal getSaleTaxes(ExemptArticle eArt);
    public BigDecimal getSaleTaxes(StandardArticle sArt);
}