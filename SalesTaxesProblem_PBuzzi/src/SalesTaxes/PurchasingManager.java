
package SalesTaxes;

import Articles.*;
import TaxesStrategies.ImportedArticleStr;
import TaxesStrategies.InternalArticleStr;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Paolo
 */
public class PurchasingManager {
        
    private BufferedReader bufReader;
    private BufferedWriter bufWriter;
    private final int numOrder;
    private final ArrayList<AbstractArticle> soldArticles;
    
    
    
    public PurchasingManager(String shoppingListName, String invoiceName, int numOrder) {
    
        this.numOrder=numOrder;
        this.soldArticles=new ArrayList<>();
        
        try {
            
            bufReader=new BufferedReader(new FileReader(shoppingListName));
            bufWriter=new BufferedWriter(new FileWriter(invoiceName));
        }
        catch (IOException ioe){
        
            System.err.println("SalesTaxes.PurchasingManager(): "+ioe.getMessage());
            System.exit(0);
        }
    }

    
    /*Public Methods*/
    
    public void checkShoppinglist() { 
    
    /* Read and analyze a shopping list by checking their lines one by one. */
    
        try {
            
            String lineRead=bufReader.readLine();
            AbstractArticle newArticle;
            boolean isImported;
            boolean isExempt;
           
            while(lineRead!=null) {

                isImported=false;
                isExempt=false;
                
                String orderedArtDesc[]= lineRead.split(" ");
                
                int quantity=Integer.valueOf(orderedArtDesc[0]);               
                BigDecimal price=new BigDecimal(orderedArtDesc[(orderedArtDesc.length)-1]);
                String orderDescription="";
                
                for (int i=0; i<(orderedArtDesc.length)-3; i++)
                    orderDescription+=orderedArtDesc[i]+" ";    // Article description generation
                
                orderDescription+=(orderedArtDesc[(orderedArtDesc.length)-3])+":"; // Add the tail of the description.
    
    /*
    Create a new Article instance for each article requested by checking it's type which can be:
    Internal and Exempt;
    Internal and Standard (not Exempt);
    Imported and Exempt;
    Imported and Standard.
    */   
    
                for (int i=1; i<orderedArtDesc.length-2; i++) {
                    
                    if(orderedArtDesc[i].equals("imported")) 
                        isImported=true;
                    
                    if(orderedArtDesc[i].equalsIgnoreCase("book")||orderedArtDesc[i].equalsIgnoreCase("chocolate") || orderedArtDesc[i].equalsIgnoreCase("chocolates") || orderedArtDesc[i].equalsIgnoreCase("pills")) // Search for exempt keyword.
                        isExempt=true;
                    
                } // A single line of the shopping list has been analyzed.
                
                if(isExempt){
                    newArticle=new ExemptArticle(quantity, orderDescription, price);
                }
                else{
                    newArticle=new StandardArticle(quantity, orderDescription, price);
                }
                if (isImported){
                    addImportedArticle(newArticle);
                }
                else{ 
                    addInternalArticle(newArticle);
                }
                
                lineRead=bufReader.readLine();
            } // End while. The entire shopping list has been analyzed.
            
    
    /*Require the invoice creation.*/
            createInvoice();
            
        }
        catch (IOException ioe){
            System.err.println("FileManager.FileManager: "+ioe.getMessage());
            System.exit(0);
        }
    }    

    
    /*Private Methods*/
    
    private void addInternalArticle(AbstractArticle article){
        
    /*
    Add a new Internal article to the soldArticles list.
    The article get the corresponding tax. Possible values are:
    0 --> For an Internal Exempt article;
    SaleTax --> For an Internal Standard article;
    */
        this.soldArticles.add(article);
        article.evaluateAndStoreTotalSaleTax(new InternalArticleStr());
    }
    
    private void addImportedArticle(AbstractArticle article){
    
    /*
    Add a new Imported article to the soldArticles list.
    The article get the corresponding tax. Possible values are:
    Duty --> For an Imported Exempt article.
    Duty + SaleTax --> For an Imported Standard article.
    */
        this.soldArticles.add(article);
        article.evaluateAndStoreTotalSaleTax(new ImportedArticleStr());
    }
    
    private void createInvoice(){
        
    /* Create and print on the standard output the invoice related to the shopping list handled. */
        BigDecimal currentArticleTotalSalePrice=new BigDecimal(BigInteger.ZERO);
        BigDecimal totalShoppingSaleTaxes=new BigDecimal(BigInteger.ZERO);
        BigDecimal totalShoppingSale=new BigDecimal(BigInteger.ZERO);
        
        System.out.println();
        System.out.println("Output "+Integer.toString(numOrder)+":");
        writeInvoice("Output "+Integer.toString(numOrder)+":");
        
        for (AbstractArticle art:soldArticles){
            
            currentArticleTotalSalePrice=art.getTotalSalePrice(); // Total sales price stored in AbstractArticle. It just consider the quantity.
            totalShoppingSaleTaxes=totalShoppingSaleTaxes.add(art.getTotalSaleTax());   // Total sales taxes stored in AbstractArticle. It just consider the quantity.
            totalShoppingSale=totalShoppingSale.add(currentArticleTotalSalePrice);        // Update the Total Sales
            System.out.println(art.getArticleDescription()+" "+currentArticleTotalSalePrice.toString());
            writeInvoice(art.getArticleDescription()+" "+currentArticleTotalSalePrice.toString());
        }
        
        System.out.println("Sales Taxes: "+totalShoppingSaleTaxes.toString());
        System.out.println("Total: "+totalShoppingSale.toString());
        writeInvoice("Sales Taxes: "+totalShoppingSaleTaxes.toString());
        writeInvoice("Total: "+totalShoppingSale.toString());
    }    
    
    private void writeInvoice(String line){
    
    /* Create a .txt file containing the invoice related to the shopping list handled. */
        try {
            bufWriter.write(line+"\r\n");
            bufWriter.flush();        
        }
        
        catch (IOException ioe){
            System.err.println("FileManager.FileManager: "+ioe.getMessage());
            System.exit(0);        
        }
    }    
}