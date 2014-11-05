/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cal;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import mgn.obj._beans._resetBean;

/**
 *
 * @author lmeans
 */
@ManagedBean(name = "scheduleBean")
public class scheduleBean extends _resetBean  implements Serializable{
    private int scheduleId;
    private int sysId;
    private int custId;
    private int hrs;
    private int min;
    private int dur;
    private int dow;
    private int dowInd;
    private int lookup;
    private String text;
    private String body;

    /**
     * @return the scheduleId
     */
    public int getScheduleId() {
        return scheduleId;
    }

    /**
     * @param scheduleId the scheduleId to set
     */
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    /**
     * @return the sysId
     */
    public int getSysId() {
        return sysId;
    }

    /**
     * @param sysId the sysId to set
     */
    public void setSysId(int sysId) {
        this.sysId = sysId;
    }

    /**
     * @return the custId
     */
    public int getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(int custId) {
        this.custId = custId;
    }

    /**
     * @return the hrs
     */
    public int getHrs() {
        return hrs;
    }

    /**
     * @param hrs the hrs to set
     */
    public void setHrs(int hrs) {
        this.hrs = hrs;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @return the dur
     */
    public int getDur() {
        return dur;
    }

    /**
     * @param dur the dur to set
     */
    public void setDur(int dur) {
        this.dur = dur;
    }

    /**
     * @return the dow
     */
    public int getDow() {
        return dow;
    }

    /**
     * @param dow the dow to set
     */
    public void setDow(int dow) {
        this.dow = dow;
    }

    /**
     * @return the dowInd
     */
    public int getDowInd() {
        return dowInd;
    }

    /**
     * @param dowInd the dowInd to set
     */
    public void setDowInd(int dowInd) {
        this.dowInd = dowInd;
    }

    /**
     * @return the lookup
     */
    public int getLookup() {
        return lookup;
    }

    /**
     * @param lookup the lookup to set
     */
    public void setLookup(int lookup) {
        this.lookup = lookup;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }
}
