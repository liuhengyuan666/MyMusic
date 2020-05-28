package cn.edu.scujcc.mymusic;

import java.io.Serializable;
import java.util.Objects;

public class RankingList implements Serializable {
    private String songid;
    private String songname;
    private String singer;
    private String quality;

    public String getSongid() {
        return songid;
    }

    public void setSongid(String songid) {
        this.songid = songid;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankingList that = (RankingList) o;
        return songid.equals(that.songid) &&
                songname.equals(that.songname) &&
                singer.equals(that.singer) &&
                quality.equals(that.quality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songid, songname, singer, quality);
    }

    @Override
    public String toString() {
        return "RankingList{" +
                "songid='" + songid + '\'' +
                ", songname='" + songname + '\'' +
                ", singer='" + singer + '\'' +
                ", quality='" + quality + '\'' +
                '}';
    }
}
