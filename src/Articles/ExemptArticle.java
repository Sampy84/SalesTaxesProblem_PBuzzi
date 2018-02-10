
package Articles;

import TaxesStrategies.TaxStrategy;

/**
 *
 * @author Paolo
 */
public class ExemptArticle extends AbstractArticle{

    public ExemptArticle(double p) {
        super(p);
    }

    @Override
    public void getTax(TaxStrategy ts) {
//        System.out.println("ExemptArticle: Method getTax()");
        ts.getTax(this); // ExemptArticle
    }
    
}
