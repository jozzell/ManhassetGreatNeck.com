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
    private String regNote="",pdf,lookupDesc;
    private int shirtSize,warmupSuiteSize,shortSide;
    private String shirtSizeStr,warmupSuiteSizeStr,shortSideStr;
    private String dobStr,fullname,school,health,contact,subjectBody,feeDesc;

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

    /**
     * @return the shirtSize
     */
    public int getShirtSize() {
        return shirtSize;
    }

    /**
     * @param shirtSize the shirtSize to set
     */
    public void setShirtSize(int shirtSize) {
        this.shirtSize = shirtSize;
    }

    /**
     * @return the warmupSuiteSize
     */
    public int getWarmupSuiteSize() {
        return warmupSuiteSize;
    }

    /**
     * @param warmupSuiteSize the warmupSuiteSize to set
     */
    public void setWarmupSuiteSize(int warmupSuiteSize) {
        this.warmupSuiteSize = warmupSuiteSize;
    }

    /**
     * @return the shortSide
     */
    public int getShortSide() {
        return shortSide;
    }

    /**
     * @param shortSide the shortSide to set
     */
    public void setShortSide(int shortSide) {
        this.shortSide = shortSide;
    }

    /**
     * @return the dobStr
     */
    @Override
    public String getDobStr() {
        return dobStr;
    }

    /**
     * @param dobStr the dobStr to set
     */
    @Override
    public void setDobStr(String dobStr) {
        this.dobStr = dobStr;
    }

    /**
     * @return the fullName
     */
@Override
    public String getFullname() {
        return fullname;
    }

   
    @Override
    public void setFullname(String fullName) {
        
        this.fullname = fullName;
    }

    /**
     * @return the shirtSizeStr
     */
    public String getShirtSizeStr() {
        return shirtSizeStr;
    }

    /**
     * @param shirtSizeStr the shirtSizeStr to set
     */
    public void setShirtSizeStr(String shirtSizeStr) {
        this.shirtSizeStr = shirtSizeStr;
    }

    /**
     * @return the warmupSuiteSizeStr
     */
    public String getWarmupSuiteSizeStr() {
        return warmupSuiteSizeStr;
    }

    /**
     * @param warmupSuiteSizeStr the warmupSuiteSizeStr to set
     */
    public void setWarmupSuiteSizeStr(String warmupSuiteSizeStr) {
        this.warmupSuiteSizeStr = warmupSuiteSizeStr;
    }

    /**
     * @return the shortSideStr
     */
    public String getShortSideStr() {
        return shortSideStr;
    }

    /**
     * @param shortSideStr the shortSideStr to set
     */
    public void setShortSideStr(String shortSideStr) {
        this.shortSideStr = shortSideStr;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the health
     */
    public String getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(String health) {
        this.health = health;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the subjectBody
     */
    public String getSubjectBody() {
        return subjectBody;
    }

    /**
     * @param subjectBody the subjectBody to set
     */
    public void setSubjectBody(String subjectBody) {
        this.subjectBody = subjectBody;
    }

    /**
     * @return the feeDesc
     */
    public String getFeeDesc() {
        return feeDesc;
    }

    /**
     * @param feeDesc the feeDesc to set
     */
    public void setFeeDesc(String feeDesc) {
        this.feeDesc = feeDesc;
    }
}
