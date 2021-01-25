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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Song compose(int chartPosition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AudioClip strum() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void actSensitive() {
        // TODO Auto-generated method stub

    }

}