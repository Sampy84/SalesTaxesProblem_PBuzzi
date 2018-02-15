
package Articles;

import TaxesStrategies.TaxStrategy;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Paolo
 */
public abstract class AbstractArticle {
    
    private final int quantity;
    private final BigDecimal price;
    private final String description;
    private BigDecimal totalSaleTax=new BigDecimal(BigInteger.ONE);
    private BigDecimal totalSalePrice=new BigDecimal(BigInteger.ZERO);
    
    
    
    public AbstractArticle(int quantity, String description, BigDecimal price ){
        
        this.price=price;
        this.quantity=quantity;
        this.description=description;
    }
    
    
    /*Public Methods*/
    
    public BigDecimal getArticlePrice(){
        
        return this.price;
    }
    
    public void setTotalSaleTaxesAndPrice(BigDecimal taxForSingleArticle){
        
        this.totalSaleTax=this.totalSaleTax.multiply(new BigDecimal(this.quantity));
        this.totalSaleTax=this.totalSaleTax.multiply(taxForSingleArticle);
        this.totalSalePrice=this.totalSalePrice.add(this.price);
        this.totalSalePrice=this.totalSalePrice.add(taxForSingleArticle);
        this.totalSalePrice=this.totalSalePrice.multiply(new BigDecimal(this.quantity));
    }
    
    public BigDecimal getTotalSalePrice() {
        
        return this.totalSalePrice;
    }
    
    public BigDecimal getTotalSaleTax() {
        
        return this.totalSaleTax;
    }
    
    public String getArticleDescription(){
        
        return this.description;
    }
    
    
    /*Abstract Methods*/
    
    public abstract void evaluateAndStoreTotalSaleTax(TaxStrategy ts);
}