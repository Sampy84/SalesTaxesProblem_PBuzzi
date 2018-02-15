
package TaxesStrategies;

import Articles.ExemptArticle;
import Articles.StandardArticle;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Paolo
 */
public class InternalArticleStr implements TaxStrategy{

    
    @Override
    public BigDecimal getSaleTaxes(ExemptArticle eArt) {
        
        /* Return the SaleTax for a single Exempt Internal article, which is 0. */
        return new BigDecimal(BigInteger.ZERO);
    }

    @Override
    public BigDecimal getSaleTaxes(StandardArticle sArt) {
        
        /* Return the SaleTax for a single Standard Internal article. */
        return calculator.getSaleTax(sArt.getArticlePrice());
    }
}