/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj._beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Lloyd
 */
@ManagedBean(name = "customerRegBean")
public class customerRegBean extends customerLinkBean implements Serializable{
    private int regId;
    private int regCustId;
    private int regLookupId;
    private int regPaidId,regCompleted;
    private String regNote,pdf,lookupDesc;
    

    /**
     * @return the regId
     */
    public int getRegId() {
        return regId;
    }

    /**
     * @param regId the regId to set
     */
    public void setRegId(int regId) {
        this.regId = regId;
    }

    /**
     * @return the regCustId
     */
    public int getRegCustId() {
        return regCustId;
    }

    /**
     * @param regCustId the regCustId to set
     */
    public void setRegCustId(int regCustId) {
        this.regCustId = regCustId;
    }

    /**
     * @return the regLookupId
     */
    public int getRegLookupId() {
        return regLookupId;
    }

    /**
     * @param regLookupId the regLookupId to set
     */
    public void setRegLookupId(int regLookupId) {
        this.regLookupId = regLookupId;
    }

    /**
     * @return the regPaidId
     */
    public int getRegPaidId() {
        return regPaidId;
    }

    /**
     * @param regPaidId the regPaidId to set
     */
    public void setRegPaidId(int regPaidId) {
        this.regPaidId = regPaidId;
    }

    /**
     * @return the regNote
     */
    public String getRegNote() {
        return regNote;
    }

    /**
     * @param regNote the regNote to set
     */
    public void setRegNote(String regNote) {
        this.regNote = regNote;
    }

    /**
     * @return the pdf
     */
    public String getPdf() {
        return pdf;
    }

    /**
     * @param pdf the pdf to set
     */
    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

   

    /**
     * @return the regCompleted
     */
    public int getRegCompleted() {
        return regCompleted;
    }

    /**
     * @param regCompleted the regCompleted to set
     */
    public void setRegCompleted(int regCompleted) {
        this.regCompleted = regCompleted;
    }

    /**
     * @return the lookupDesc
     */
    public String getLookupDesc() {
        return lookupDesc;
    }

    /**
     * @param lookupDesc the lookupDesc to set
     */
    public void setLookupDesc(String lookupDesc) {
        this.lookupDesc = lookupDesc;
    }
}
