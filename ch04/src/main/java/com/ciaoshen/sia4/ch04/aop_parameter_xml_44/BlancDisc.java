package com.ciaoshen.sia4.ch04.aop_parameter_xml_44;

import java.util.List;

public class BlancDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public void playTrack(int trackNumber) {
        System.out.println("Playing track #[" + trackNumber + "]: " + tracks.get(trackNumber));
    }

    public int size() {
        return tracks.size();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

}
