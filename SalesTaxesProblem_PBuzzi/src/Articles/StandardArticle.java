
package Articles;

import TaxesStrategies.TaxStrategy;
import java.math.BigDecimal;

/**
 *
 * @author Paolo
 */
public class StandardArticle extends AbstractArticle{

    public StandardArticle(int quantity, String description, BigDecimal price){
        
        super(quantity, description, price);
    }

    
    @Override
    public void evaluateAndStoreTotalSaleTax(TaxStrategy ts) {
        
    /*
    Get the tax for a single Standard (not Exempt) article. Possible values are:
    SaleTax --> For an Internal Standard article;
    Duty + SaleTax --> For an Imported Standard article.
    */
        BigDecimal taxForSingleArticle=ts.getSaleTaxes(this);
        super.setTotalSaleTaxesAndPrice(taxForSingleArticle);
    }
}