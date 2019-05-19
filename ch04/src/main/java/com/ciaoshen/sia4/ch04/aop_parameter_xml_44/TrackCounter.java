package com.ciaoshen.sia4.ch04.aop_parameter_xml_44;

import java.util.Map;
import java.util.HashMap;

public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    public void countTrack(int trackNumber) {
        System.out.println("Track Counts = " + trackCounts);
        int oldCount = trackCounts.getOrDefault(trackNumber, 0);
        System.out.println("Old count of track #" + trackNumber + " = [" + oldCount + "]");
        trackCounts.put(trackNumber, trackCounts.getOrDefault(trackNumber, 0) + 1);
        System.out.println("Now count of track #" + trackNumber + " = [" + trackCounts.get(trackNumber) + "]");
    }

    public Map<Integer, Integer> getCount() {
        return trackCounts;
    }

}
