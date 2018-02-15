
package SalesTaxes;

/**
 *
 * @author Paolo
 */
public class SalesTaxesProblem {    
    
    private static final String shoppingList1="ShoppingList1.txt";
    private static final String shoppingList2="ShoppingList2.txt";
    private static final String shoppingList3="ShoppingList3.txt";
    
    
    
    public static void main(String[] args) {

    /* Create the invoices for the 3 above shopping lists. */
        for (int i=1; i<=3; i++) {
        
            String shoppingListName="shoppingList"+Integer.toString(i)+".txt";
            String invoiceName="Invoice_"+"shoppingList"+Integer.toString(i)+".txt";
            PurchasingManager purchisingManager=new PurchasingManager(shoppingListName, invoiceName, i);
            purchisingManager.checkShoppinglist();
            
        }
    }  
}