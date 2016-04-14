/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.web.mgr.eNum;

/**
 *
 * @author lmeans
 */
public enum calObjMgrEnum {
    brwPg3_view("imagesV2/brwPg3_view.xhtml"),
    brwPg2_batch("imagesV2/brwPg2_batch.xhtml"),
    brwPg2_batchEdit("imagesV2/brwPg2_batchEdit.xhtml"),
    brwPg1_who("imagesV2/brwPg1_who.xhtml"),
    brwPg1_whoEdit("imagesV2/brwPg1_whoEdit.xhtml"),
    dispCalEvent("cal/DispCalEvent.xhtml"),
    newCalEvent("cal/newCalEvent.xhtml"),
    dispCalendar("cal/dispCalendar.xhtml"),
    rootImageDisplay("./images/viewImages.xhtml"),
     rootMsgEdit("post/PostMsgBrw.xhtml"),
      rootPostObjMgrEnum("post/posting.xhtml"),
    getNewPostingXHTML("post/newPosting.xhtml"),
     ;
    private final String url;
    private calObjMgrEnum(String url){
        this.url = url;
    }
    public String getUrl(){
        return url;
    }
}
