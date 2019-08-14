package com.zhiyou.model;

/**
 * @author
 * @date 2019/6/17
 */
public class Speaker {
    private int id;
    private String speakerName;
    private String speakerDesc;
    private String speakerJob;
    private String picUrl;

    @Override
    public String toString() {
        return "Speaker{" +
                "id=" + id +
                ", speakerName='" + speakerName + '\'' +
                ", speakerDesc='" + speakerDesc + '\'' +
                ", speakerJob='" + speakerJob + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }

    public Speaker() {
    }

    public Speaker(int id, String speakerName, String speakerDesc, String speakerJob, String picUrl) {
        this.id = id;
        this.speakerName = speakerName;
        this.speakerDesc = speakerDesc;
        this.speakerJob = speakerJob;
        this.picUrl = picUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getSpeakerDesc() {
        return speakerDesc;
    }

    public void setSpeakerDesc(String speakerDesc) {
        this.speakerDesc = speakerDesc;
    }

    public String getSpeakerJob() {
        return speakerJob;
    }

    public void setSpeakerJob(String speakerJob) {
        this.speakerJob = speakerJob;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
