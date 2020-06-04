package cn.edu.scujcc.mymusic;

import android.media.Image;

public class LocalMusicBean {

    private String musicName; //歌名
    private String singer; //歌手
    private Image musicPicture; //歌曲图片
    private String duration; //歌曲时长
    private String current_duration; //剩余歌曲时长
    private String path; //歌曲路径

    public LocalMusicBean() {
    }

    public LocalMusicBean(String musicName, String singer, Image musicPicture, String duration, String current_duration, String path) {
        this.musicName = musicName;
        this.singer = singer;
        this.musicPicture = musicPicture;
        this.duration = duration;
        this.current_duration = current_duration;
        this.path = path;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Image getMusicPicture() {
        return musicPicture;
    }

    public void setMusicPicture(Image musicPicture) {
        this.musicPicture = musicPicture;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCurrent_duration() {
        return current_duration;
    }

    public void setCurrent_duration(String current_duration) {
        this.current_duration = current_duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
