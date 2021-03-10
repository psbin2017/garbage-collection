package com.collection.gc.sample.interfaces;

public interface SingerSongWriter extends Singer, SongWriter {
    AudioClip strum();
    void actSensitive();
}

interface Singer {
    AudioClip sing(Song song);
}

interface SongWriter {
    Song compose(int chartPosition);
}

class AudioClip {
    
}

class Song {

}

class SingerSongWriterImpl implements SingerSongWriter {

    @Override
    public AudioClip sing(Song song) {
        return null;
    }

    @Override
    public Song compose(int chartPosition) {
        return null;
    }

    @Override
    public AudioClip strum() {
        return null;
    }

    @Override
    public void actSensitive() {

    }

}