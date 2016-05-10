package com.scarlett.game.core.sound;

import com.badlogic.gdx.Gdx;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

@XmlRootElement(name = "sound")
public class SoundDescriptor {
    @XmlElement(name = "directory")
    private String directory;
    @XmlElement(name = "type")
    private int type;
    @XmlElement(name = "volume")
    private float volume;
    @XmlElement(name = "id")
    private int id;

    public SoundDescriptor(){
        directory = null;
        type = 0;
        volume = 0;
        id = 0;
    }

    public SoundDescriptor(String directory, int type, float volume, int id) {
        this.directory = directory;
        this.type = type;
        this.volume = volume;
        this.id = id;
    }

    public float getVolume() {
        return volume;
    }

    public int getType() {
        return type;
    }

    public String getDirectory() {
        return directory;
    }

    public static SoundDescriptor getFromFile(String filepath){
        SoundDescriptor result = null;
        File file = Gdx.files.internal(filepath).file();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(SoundDescriptor.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            result = (SoundDescriptor) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int getId() {
        return id;
    }
}
