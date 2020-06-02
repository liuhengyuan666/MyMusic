package cn.edu.scujcc.mymusic;

import java.io.Serializable;

public class Song implements Serializable {
    private String musicName; //歌名
    public String singer; //歌手
    public long size; //歌曲所占空间大小
    public long duration; //歌曲时间长度
    public String url; //歌曲地址

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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Song{" +
                "musicName='" + musicName + '\'' +
                ", singer='" + singer + '\'' +
                ", size=" + size +
                ", duration=" + duration +
                ", url='" + url + '\'' +
                '}';
    }
}
