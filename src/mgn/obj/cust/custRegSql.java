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
             sqlwww="",
            sqlDeleteLink = "delete from mgn_customer_link where cust_id = ? and cust_rollup_id = ?",
            sqlInsertCustLink = "INSERT INTO mgn_customer_link (cust_id,cust_rollup_id,dob,cust_type) values (?,?,?,?)",
            sqlInsertCustReg = "INSERT INTO mgn_customer_reg (cust_id,lookup_id,reg_paided,reg_note,pdf,reg_completed,shirt_size,suite_size,short_side,school,eContact)  VALUES" +
                    "(?,?,?,?,?,?,?,?,?,?,?);",
             

             sqlCustRegUpdate = 
             " UPDATE mgn_customer_reg SET cust_id = ?,lookup_id = ?,reg_paided = ?,reg_note =?,pdf = ?, "+
            " reg_completed =?,shirt_size = ?,suite_size = ?,short_side = ?,school=?,eContact=? "+
            " WHERE reg_id = ? ",
           _sqlCustRegList = 
                 " SELECT r.reg_id,r.cust_id,r.lookup_id,r.reg_paided,r.reg_note,r.pdf,r.reg_completed,l.dob,l.cust_type,ml.lookup_desc "+
                " , r.shirt_size,r.suite_size,r.short_side,concat(c.last_name,', ',c.first_name),DATE_FORMAT(l.dob,'%b %d , %Y') "+
             ",m2.lookup_desc,m3.lookup_desc,m4.lookup_desc,r.school,r.eContact,ml.subject_body,ml.subject_text"+
              "    FROM mgn_customer_link l,mgn_customer_reg r,mgn_lookup ml,mgn_customer c "+
             " ,mgn_lookup m2,mgn_lookup m3,mgn_lookup m4"+
               "   where l.cust_id = r.cust_id and ml.lookup_id = r.lookup_id and c.cust_id = l.cust_id "+
             "and m2.lookup_id = r.shirt_size and m3.lookup_id = r.short_side and m4.lookup_id = r.suite_size",
     sqlCustRegList_rollup = _sqlCustRegList+ " and l.cust_rollup_id = ? order by ml.lookup_desc desc,c.first_name",
             sqlCustRegList_regId = _sqlCustRegList+ " and r.reg_id = ? ",
             sqlCustReg = 
                " SELECT l.cust_id,l.cust_rollup_id,l.dob,l.cust_type" +
             " ,concat(c.last_name,', ',c.first_name),DATE_FORMAT(l.dob,'%b %d , %Y')"+
                " FROM mgn_customer_link l,mgn_customer c" +
                " where c.cust_id = l.cust_id and l.cust_id = ?",
            sqlUpdatePdf = "update mgn_customer_reg set pdf = ? where reg_id = ?";;
}
