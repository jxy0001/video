package com.zhiyou.model;

/**
 * @author
 * @date 2019/6/17
 */
public class Video {
    private int videoId;
    private String title;
    private String detail;
    private int time;
    private int speakerId;
    private int courseId;
    private String videoUrl;
    private String imageUrl;
    private int playNum;
    private Speaker speaker;
    private Course course;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    public int getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", time=" + time +
                ", speakerId=" + speakerId +
                ", courseId=" + courseId +
                ", videoUrl='" + videoUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", playNum=" + playNum +
                ", speaker=" + speaker +
                ", course=" + course +
                '}';
    }

    public Video() {
    }

    public Video(int videoId, String title, String detail, int time, int speakerId, int courseId, String videoUrl, String imageUrl, int playNum, Speaker speaker, Course course) {
        this.videoId = videoId;
        this.title = title;
        this.detail = detail;
        this.time = time;
        this.speakerId = speakerId;
        this.courseId = courseId;
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.playNum = playNum;
        this.speaker = speaker;
        this.course = course;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
