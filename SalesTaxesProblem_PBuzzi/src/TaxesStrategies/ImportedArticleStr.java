
package TaxesStrategies;

import Articles.ExemptArticle;
import Articles.StandardArticle;
import java.math.BigDecimal;

/**
 *
 * @author Paolo
 */
public class ImportedArticleStr implements TaxStrategy{

    
    @Override
    public BigDecimal getSaleTaxes(ExemptArticle eArt) {
        
        /* Return the Duty for a single Exempt Imported article. */
        return calculator.getDuty(eArt.getArticlePrice());
    }
    
    @Override
    public BigDecimal getSaleTaxes(StandardArticle sArt) {
        
        /* Return the Duty+SaleTax for a single Standard Imported article. */
        return calculator.getDutyAndTax(sArt.getArticlePrice());
    }    
}