/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cust;

import java.io.Serializable;

/**
 *
 * @author Lloyd
 */
public class custRegSql  implements Serializable{
     public static final String
           sqlCustReg = 
                " SELECT r.reg_id,r.cust_id,r.lookup_id,r.reg_paided,r.reg_note,r.pdf,r.reg_completed,l.dob,l.cust_type,ml.lookup_desc" +
                " FROM mgn_customer_link l" +
                " left join mgn_customer_reg r on l.cust_id = r.cust_id" +
                " left join mgn_lookup ml on ml.lookup_id = r.lookup_id" +
                " where l.cust_id = ?";
}
