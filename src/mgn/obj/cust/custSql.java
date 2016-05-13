/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cust;

import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class custSql implements Serializable{
  private  final String 
          custSql =  " select c.cust_id ,c.email_key ,c.keyStr ,c.FIRST_NAME , c.LAST_NAME, c.ADDR1 , "
            + " c.ADDR2 , c.CITY, c.STATE,c.HM_PHONE , c.WK_PHONE , c.WK_EXT ,c.ZIP , "
            + " c.EMAIL ,0,	c.user_name ,c.user_pass ,	c.vendor_id ,c.access_lvl  ,   c.SPONSOR_LINK_ID",
            
         sqlCust = custSql+ " From mgn_CUSTOMER C "
         
          ;
  
    public  final String  
            sql66 = "xxx",
            sqlCust_Email = sqlCust+ " where EMAIL = ? and cust_id != ?",
            sqlCustLink = 
                 custSql 
                 + ",case l.cust_type when -101 then 'Parent'  when -102 then date_format(dob,'%b %d, %Y')    else 'Coach' end as dob" 
                 +" From mgn_CUSTOMER C ,mgn_customer_link l where l.cust_id = c.cust_id and l.cust_rollup_id = ?",
            sqlSelectCustChk =
            " select max(cust_id) from mgn_CUSTOMER where EMAIL = ? ",
             sqlSelectCustChk_withEMail_ID =
            " select max(cust_id) from mgn_CUSTOMER where EMAIL = ? and cust_id = ? ",
            sqlSelectByCustID =
            sqlCust +" where cust_id = ?",
            sqlUpdateCust =
            " update mgn_CUSTOMER set "
            + " FIRST_NAME  =?, LAST_NAME =?, ADDR1 =? , "
            + " ADDR2  =?, CITY =?, STATE =?,HM_PHONE  =?, WK_PHONE  =?, WK_EXT  =?,ZIP  =?, "
            + " EMAIL  =?,user_pass =? ,access_lvl =?  "
            + " where CUST_ID = ?",
            sqlInsertCust =
            " insert into mgn_CUSTOMER "
            + "    (FIRST_NAME , LAST_NAME, ADDR1 , "
            + " ADDR2 , CITY, STATE,HM_PHONE , WK_PHONE , WK_EXT ,ZIP , "
            + " EMAIL,	user_pass ,	access_lvl  ) "
            + "    values     (?,?,?,?,?,?,?,?,?,?,?,?,?)";
}
