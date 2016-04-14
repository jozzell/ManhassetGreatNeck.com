package mgn.obj._beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmeans
 */
@ManagedBean(name = "mgnLookupBean")
public class mgnLookupBean extends _resetBean  implements Serializable{
    private int lookupId,lookupRollupId,lookupType,lookupFlag,cnt;
    private String lookupDesc,searchKey;
    private String subjectText,subjectBody;

    /**
     * @return the lookupId
     */
    public int getLookupId() {
        return lookupId;
    }

    /**
     * @param lookupId the lookupId to set
     */
    public void setLookupId(int lookupId) {
        this.lookupId = lookupId;
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
     * @return the subjectText
     */
    public String getSubjectText() {
        return subjectText;
    }

    /**
     * @param subjectText the subjectText to set
     */
    public void setSubjectText(String subjectText) {
        this.subjectText = subjectText;
    }

    /**
     * @return the lookupRollupId
     */
    public int getLookupRollupId() {
        return lookupRollupId;
    }

    /**
     * @param lookupRollupId the lookupRollupId to set
     */
    public void setLookupRollupId(int lookupRollupId) {
        this.lookupRollupId = lookupRollupId;
    }

    /**
     * @return the lookupType
     */
    public int getLookupType() {
        return lookupType;
    }

    /**
     * @param lookupType the lookupType to set
     */
    public void setLookupType(int lookupType) {
        this.lookupType = lookupType;
    }

    /**
     * @return the lookupFlag
     */
    public int getLookupFlag() {
        return lookupFlag;
    }

    /**
     * @param lookupFlag the lookupFlag to set
     */
    public void setLookupFlag(int lookupFlag) {
        this.lookupFlag = lookupFlag;
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
     * @return the searchKey
     */
    public String getSearchKey() {
        return searchKey;
    }

    /**
     * @param searchKey the searchKey to set
     */
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    /**
     * @return the cnt
     */
    public int getCnt() {
        return cnt;
    }

    /**
     * @param cnt the cnt to set
     */
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
