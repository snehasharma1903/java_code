/**
 * Implementation of a bank system
 * @author shubhamtewari@gmail.com
 */

public class BankAdapter {
    public static void main(String args[]) {
        Account a1 = new Account("Shubham","13/10/1997","shbmtewari@gmail.com", 1700);
        Account a2 = new Account("Sakshi","15/8/2001","sakshitewari@gmail.com", 23);
        a1.transferFund(a2, 1500);
        a1.updateSBI(120,2);
        System.out.println("Amount of "+a1.getmAcNumber()+" is "+a1.getmBalance());
        System.out.println("Amount of "+a2.getmAcNumber()+" is "+a2.getmBalance());
        }
}
