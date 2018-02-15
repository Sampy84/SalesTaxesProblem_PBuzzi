
package Articles;

import TaxesStrategies.TaxStrategy;
import java.math.BigDecimal;

/**
 *
 * @author Paolo
 */
public class ExemptArticle extends AbstractArticle{

    public ExemptArticle(int quantity, String description, BigDecimal price) {
        
        super(quantity, description, price);
    }

    
    @Override
    public void evaluateAndStoreTotalSaleTax(TaxStrategy ts) {
        
    /*
    Get the tax for a single Exempt article. Possible values are:
    0 --> For an Internal Exempt article;
    Duty --> For an Imported Exempt article.
    */
        BigDecimal taxForSingleArticle=ts.getSaleTaxes(this);
        super.setTotalSaleTaxesAndPrice(taxForSingleArticle);
    }   
}