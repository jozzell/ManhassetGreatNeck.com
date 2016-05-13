/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj._beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Lloyd
 */
@ManagedBean(name = "customerLinkBean")
public class customerLinkBean  implements Serializable{
    private Date dob;
    private int type,cust_id,cust_rollup_id;
    

    /**
     * @return the dob
     */
    public Date getDob() {
        if (dob == null) dob = Calendar.getInstance().getTime();
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the cust_id
     */
    public int getCust_id() {
        return cust_id;
    }

    /**
     * @param cust_id the cust_id to set
     */
    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    /**
     * @return the cust_rollup_id
     */
    public int getCust_rollup_id() {
        return cust_rollup_id;
    }

    /**
     * @param cust_rollup_id the cust_rollup_id to set
     */
    public void setCust_rollup_id(int cust_rollup_id) {
        this.cust_rollup_id = cust_rollup_id;
    }

    
}
