
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
        for (int orderNumber=1; orderNumber<=3; orderNumber++) {
        
            String shoppingListName="shoppingList"+Integer.toString(orderNumber)+".txt";
            String invoiceName="Invoice_"+"shoppingList"+Integer.toString(orderNumber)+".txt";
            PurchasingManager purchisingManager=new PurchasingManager(shoppingListName, invoiceName, orderNumber);
            purchisingManager.checkShoppinglist();
            
        }
    }  
}