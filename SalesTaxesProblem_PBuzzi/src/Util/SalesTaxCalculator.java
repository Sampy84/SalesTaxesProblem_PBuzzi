
package Util;

import java.math.BigDecimal;
import java.math.BigInteger;


/**
 *
 * @author Paolo
 */
public class SalesTaxCalculator {
    
    private static SalesTaxCalculator calculator;
    private final BigDecimal saleTaxPercentage=new BigDecimal("0.1");
    private final BigDecimal dutyPercentage=new BigDecimal("0.05");    
    private BigDecimal dutyRounded=new BigDecimal(BigInteger.ZERO);
    private BigDecimal saleTaxRounded=new BigDecimal(BigInteger.ZERO);
    private BigDecimal dutyAndTaxRounded=new BigDecimal(BigInteger.ZERO);
    
    
    
    private SalesTaxCalculator(){}
    
    
    /* Static Methods */
    
    public static SalesTaxCalculator getInstance() {
    
        if (calculator==null)
            calculator=new SalesTaxCalculator();
        
        return calculator;
    }
    
    
    /* Public Methods */
    
    public BigDecimal getDuty(BigDecimal price){
        
    /* Return the Duty at a rate of 5% for a single Imported article. */    
        calculateDuty(price);
        return this.dutyRounded;
    }
    
    public BigDecimal getSaleTax(BigDecimal price){
        
    /* Return the SaleTax at a rate of 10% for a single Standard article. */
        calculateSaleTax(price);
        return this.saleTaxRounded;
    }
    
    public BigDecimal getDutyAndTax(BigDecimal price){
    
    /* Return the Duty and SaleTax for a single Imported Standard article. */
        calculateDuty(price);
        calculateSaleTax(price);
        BigDecimal dutyAndTax=new BigDecimal(BigInteger.ZERO);
        dutyAndTax=dutyAndTax.add(this.dutyRounded);
        dutyAndTax=dutyAndTax.add(this.saleTaxRounded);
        dutyAndTaxRounded=getRoundedValue(dutyAndTax);
        
        return this.dutyAndTaxRounded;
    } 
    
    
    /* Private Methods */

    private void calculateDuty(BigDecimal price){
    
        /* Calculate the Duty at a rate of 5% for a single Imported article. */
        BigDecimal duty=new BigDecimal(BigInteger.ONE);
        duty=duty.multiply(price);
        duty=duty.multiply(dutyPercentage);
        dutyRounded=getRoundedValue(duty);
    }
    
    private void calculateSaleTax(BigDecimal price){
    
    /* Return the SaleTax at a rate of 10% for a single Standard article. */
        BigDecimal saleTax=new BigDecimal(BigInteger.ONE);
        saleTax=saleTax.multiply(price);
        saleTax=saleTax.multiply(saleTaxPercentage);
        saleTaxRounded=getRoundedValue(saleTax);
    }
   
    private BigDecimal getRoundedValue(BigDecimal value) {
    
    /* Return a value rounded up to the nearest 0.05. */
        value=value.divide(new BigDecimal("0.05"));
        value=new BigDecimal(Math.ceil(value.doubleValue()));
        value=value.multiply(new BigDecimal("0.05"));

        return value;
    }
}