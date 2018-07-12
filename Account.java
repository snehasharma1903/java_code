import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

public class Account extends SBICustomer {

    /**
     * @value mName : name of customer (inherited)
     * @value mDob : date of birth of customer (inherited)
     * @value mEmail : email of customer (inherited)
     * @value mBalance : current balance of customer
     * @value mAcNumber : account number
     * @value mStatus : status of account
     */
    private float mBalance;
    private long mAcNumber;
    private boolean mStatus;

    /**
     *  constructor to create account entries
     * @param name : name of customer of the account account
     * @param dob  : date of birth of the customers
     * @param email : email of customer
     * @param depAmount : the initial deposit amount (1600 - 10000)
     */
    public Account(String name,String dob, String email, float depAmount) {
        super(name,email,dob);
        mAcNumber = new Random().nextInt(100000000)%1000000000;
        insertIntoSBI(depAmount);
    }

    /*---- SQL methods ----*/

    /**
     * to initialize the SQL Database
     * @return true : if no exceptions occur
     */
    public boolean initAccount() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * to insert into database
     * @param amount : the amount to be inserted
     * @return true : if no exception occurs
     */
    public boolean insertIntoSBI(Float amount) {
        mBalance = amount;
        try {
            //insert corresponding sql code here
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * to update the database
     * @param amount : the amount to be inserted
     * @param flag : 1 to deposit, 2 to remove
     * @return true : if no exception occurs
     */
    public boolean updateSBI(float amount,int flag) {
        switch(flag) {
            case 1:
                mBalance = mBalance + amount;
                break;
            case 2:
                mBalance = mBalance - amount;
        }
        try {
            //insert corresponding sql code here
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * to transfer funds from one account to another
     * @param ac : account to transfer funds to
     * @param amount : the amount to be inserted
     * @return true : if no exception occurs
     */
    public boolean transferFund(Account ac, float amount) {
        this.mBalance = this.mBalance - amount;
        ac.mBalance = ac.mBalance + amount;
        try {
            //insert corresponding sql code here
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * to insert into database
     * @return mBalance : the balance of the object after being updated from database
     */
    public float getSQLmBalance() {
        float balance = -1;
        try {
            //insert corresponding sql code here
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        mBalance = balance;
        return mBalance;
    }
    /*----SQL methods end----*/


    /* getter and setter methods (setters are private) */
    public Float getmBalance() {
        return mBalance;
    }

    private void setmBalance(Float mBalance) {
        this.mBalance = mBalance;
    }

    public Long getmAcNumber() {
        return mAcNumber;
    }

    private void setmAcNumber(Long mAcNumber) {
        this.mAcNumber = mAcNumber;
    }

    public boolean ismStatus() {
        return mStatus;
    }

    private void setmStatus(boolean mStatus) {
        this.mStatus = mStatus;
    }
    /* getter and setter methods end */


}
