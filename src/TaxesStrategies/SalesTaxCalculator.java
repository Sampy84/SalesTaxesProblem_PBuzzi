
package TaxesStrategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Paolo
 */
public class SalesTaxCalculator {
    
    private final byte saleTaxPerc=10;
    private final byte dutyPerc=5;
    private static SalesTaxCalculator calculator;
    
    
    
    public static SalesTaxCalculator getInstance() {
    
        if (calculator==null)
            calculator=new SalesTaxCalculator();
        
        return calculator;
    }
    
    public void getSaleTax(double price){
        
        double saleTax=(saleTaxPerc*price)/100;
    
        BigDecimal bd = new BigDecimal(saleTax);
        bd = bd.setScale(1, RoundingMode.HALF_EVEN);
        double saleTaxRounded=bd.doubleValue();
                
        System.out.println("saleTax: "+saleTax);
        System.out.println("saleTaxRounded: "+saleTaxRounded);
    }
    
    public void getDuty(double price){
    
        double duty=(dutyPerc*price)/100;
    
        BigDecimal bd = new BigDecimal(duty);
        bd = bd.setScale(1, RoundingMode.HALF_EVEN);
        double dutyRounded=bd.doubleValue();
                
        System.out.println("duty: "+duty);
        System.out.println("dutyRounded: "+dutyRounded);
    }
}