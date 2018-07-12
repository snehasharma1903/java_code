import java.util.ArrayList;
import java.util.List;

public class SBICustomer {

    /**
     * @value mName : name of customer (inherited)
     * @value mDob : date of birth of customer (inherited)
     * @value mEmail : email of customer (inherited)
     * @value mTotalBalance : current cumulative balance of customer
     * @value mAccountList : list of all accounts of customer
     */
    private String mName;
    private String mTotalBalance;
    private String mEmail;
    private String mDob;
    private List<String> mAccountList = new ArrayList<String>();

    /**
     *  constructor to create account entries
     * @param mName : name of customer of the account account
     * @param mEmail : email of customer
     * @param mDob  : date of birth of the customers
     */
    public SBICustomer(String mName, String mEmail, String mDob) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mDob = mDob;
    }

    /* setter and getter */
    public String getmName() {
        return mName;
    }

    protected void setmName(String mName) {
        this.mName = mName;
    }

    public String getmTotalBalance() {
        return mTotalBalance;
    }

    protected void setmTotalBalance(String mTotalBalance) {
        this.mTotalBalance = mTotalBalance;
    }

    public String getmEmail() {
        return mEmail;
    }

    protected void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmDob() {
        return mDob;
    }

    protected void setmDob(String mDob) {
        this.mDob = mDob;
    }
    /*setter and getter end*/

}
