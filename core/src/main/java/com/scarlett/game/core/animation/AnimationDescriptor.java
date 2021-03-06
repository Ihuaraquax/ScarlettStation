package com.scarlett.game.core.animation;

import com.badlogic.gdx.Gdx;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

@XmlRootElement(name = "animation")
public class AnimationDescriptor {
    @XmlElement(name = "directory")
    private String directory;
    @XmlElement(name = "image-width")
    private int width;
    @XmlElement(name = "image-height")
    private int height;
    @XmlElement(name = "type")
    private int type;
    @XmlElement(name = "speed")
    private float speed;
    @XmlElement(name = "id")
    private int id;

    AnimationDescriptor(){
        this.directory = null;
        this.width = 0;
        this.height = 0;
        this.type = 0;
        this.speed = 0;
        this.id = 0;
    }

    AnimationDescriptor(String directory, int width, int height, int type, float speed, int id) {
        this.directory = directory;
        this.width = width;
        this.height = height;
        this.type = type;
        this.speed = speed;
        this.id = id;
    }

    public static AnimationDescriptor getFromFile(String filepath) {
        AnimationDescriptor result = null;
        File file = Gdx.files.internal(filepath).file();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AnimationDescriptor.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            result = (AnimationDescriptor) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }

    public float getSpeed() {
        return speed;
    }

    public int getType() {
        return type;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getDirectory() {
        return directory;
    }

    public int getId() {
        return id;
    }
}
