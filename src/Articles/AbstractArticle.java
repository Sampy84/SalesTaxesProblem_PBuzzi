
package Articles;

import TaxesStrategies.TaxStrategy;

/**
 *
 * @author Paolo
 */
public abstract class AbstractArticle {
    
    final private double price;
    
    public AbstractArticle(double p){
    
        this.price=p;
    }
    
    public double getPrice(){
    
        return this.price;
    }
    
    public abstract void getTax(TaxStrategy ts);
}
