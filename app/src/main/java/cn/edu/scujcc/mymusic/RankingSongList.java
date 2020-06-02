package cn.edu.scujcc.mymusic;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class RankingSongList {
    private String singer_id;
    private String original_song;
    private String hot_song;
    private String new_song;
    private String songid;
    private String songname;
    private String singer;
    private String quality;
    private String url;
    //private List<SongList> songLists;


    public String getSinger_id() {
        return singer_id;
    }

    public void setSinger_id(String singer_id) {
        this.singer_id = singer_id;
    }

    public String getOriginal_song() {
        return original_song;
    }

    public void setOriginal_song(String original_song) {
        this.original_song = original_song;
    }

    public String getHot_song() {
        return hot_song;
    }

    public void setHot_song(String hot_song) {
        this.hot_song = hot_song;
    }

    public String getNew_song() {
        return new_song;
    }

    public void setNew_song(String new_song) {
        this.new_song = new_song;
    }

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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankingSongList that = (RankingSongList) o;
        return singer_id.equals(that.singer_id) &&
                original_song.equals(that.original_song) &&
                hot_song.equals(that.hot_song) &&
                new_song.equals(that.new_song) &&
                songid.equals(that.songid) &&
                songname.equals(that.songname) &&
                singer.equals(that.singer) &&
                quality.equals(that.quality) &&
                url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(singer_id, original_song, hot_song, new_song, songid, songname, singer, quality, url);
    }

    @Override
    public String toString() {
        return "RankingSongList{" +
                "singer_id='" + singer_id + '\'' +
                ", original_song='" + original_song + '\'' +
                ", hot_song='" + hot_song + '\'' +
                ", new_song='" + new_song + '\'' +
                ", songid='" + songid + '\'' +
                ", songname='" + songname + '\'' +
                ", singer='" + singer + '\'' +
                ", quality='" + quality + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
