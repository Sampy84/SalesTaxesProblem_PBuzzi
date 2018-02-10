
package SalesTaxes;

import Articles.StandardArticle;
import Articles.AbstractArticle;
import Articles.ExemptArticle;
import TaxesStrategies.*;

/**
 *
 * @author Paolo
 */
public class Sales_Taxes {    
    
    public static void main(String[] args) {
        
        double parfumePrice=14.99;
        double chocolatePrice=0.85;
        double importedParfumePrice=47.50;
        double importedChocolatePrice=10.00;
        AbstractArticle parfume=new StandardArticle(parfumePrice); //Internal standard
        AbstractArticle chocolate=new ExemptArticle(chocolatePrice); // Internal exempt
        AbstractArticle importedParfume=new StandardArticle(importedParfumePrice); // Imported standard
        AbstractArticle importedChocolate=new ExemptArticle(importedChocolatePrice); // Imported exempt
        
//        System.out.println("Price: "+parfume.getPrice());
//        parfume.getTax(new InternalObjectStr());
//        System.out.println("Price: "+chocolate.getPrice());
//        chocolate.getTax(new InternalObjectStr());        
        System.out.println("Price: "+importedParfume.getPrice());
        importedParfume.getTax(new ImportedArticleStr());
//        System.out.println("Price: "+importedChocolate.getPrice());
//        importedChocolate.getTax(new ImportedArticleStr());        
             
       
    }  
}