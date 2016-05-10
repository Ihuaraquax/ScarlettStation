package com.scarlett.game.core.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Sound {
    private final SoundDescriptor descriptor;
    private final com.badlogic.gdx.audio.Sound sound;
    private final SoundType type;
    private Long id = null;

     public Sound(SoundDescriptor descriptor){
        this.descriptor  = descriptor;
        FileHandle fileHandle = Gdx.files.internal(descriptor.getDirectory());
        sound = Gdx.audio.newSound(fileHandle);
        type = SoundType.getForType(descriptor.getType());
    }

    public static Sound createSound(String descriptorPath){
        SoundDescriptor descriptor = SoundDescriptor.getFromFile(descriptorPath);
        return new Sound(descriptor);
    }

    public void playSound(){
        if(SoundType.SINGLE.equals(type)) {
            id = sound.play();
        } else if(id == null){
            id = sound.loop();
        }
        sound.setVolume(id, descriptor.getVolume());
    }

    public void stop(){
        if(id != null){
            sound.stop(id);
        }
    }
}
