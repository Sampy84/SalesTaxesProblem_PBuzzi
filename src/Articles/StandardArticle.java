
package Articles;

import TaxesStrategies.TaxStrategy;

/**
 *
 * @author Paolo
 */
public class StandardArticle extends AbstractArticle{

    public StandardArticle(double p) {
        super(p);
    }

    @Override
    public void getTax(TaxStrategy ts) {
//        System.out.println("StandardArticle: Method getTax()");
        ts.getTax(this); // StandardArticle
    }
    
}
