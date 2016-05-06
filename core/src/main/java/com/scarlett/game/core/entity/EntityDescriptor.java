package com.scarlett.game.core.entity;

import com.badlogic.gdx.Gdx;
import com.scarlett.game.core.animation.AnimationDescriptor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "entity")
public class EntityDescriptor {
    @XmlElement(name = "animation")
    private List<AnimationDescriptor> animations;
    @XmlElement(name = "idle-animation-id")
    private int idleAnimationId;
    @XmlElement(name = "walk-animation-id")
    private int walkAnimationId;
    @XmlElement(name = "shoot-animation-id")
    private int shootAnimationId;
    @XmlElement(name = "death-animation-id")
    private int deathAnimationId;
    @XmlElement(name = "attributes")
    private AttributesDescriptor attributes;

    EntityDescriptor(){
        this.animations = null;
        this.idleAnimationId = 0;
        this.walkAnimationId = 0;
        this.shootAnimationId = 0;
        this.deathAnimationId = 0;
        this.attributes = null;
    }

    public EntityDescriptor(List<AnimationDescriptor> animations, int idleAnimationId, int walkAnimationId, int shootAnimationId, int deathAnimationId, AttributesDescriptor attributes) {
        this.animations = animations;
        this.idleAnimationId = idleAnimationId;
        this.walkAnimationId = walkAnimationId;
        this.deathAnimationId = deathAnimationId;
        this.shootAnimationId = shootAnimationId;
        this.attributes = attributes;
    }

    public AttributesDescriptor getAttributes() {
        return attributes;
    }

    public int getDeathAnimationId() {
        return deathAnimationId;
    }

    public int getShootAnimationId() {
        return shootAnimationId;
    }

    public int getWalkAnimationId() {
        return walkAnimationId;
    }

    public int getIdleAnimationId() {
        return idleAnimationId;
    }

    public List<AnimationDescriptor> getAnimations() {
        return animations;
    }

    public static EntityDescriptor getFromFile(String filepath) {
        EntityDescriptor result = null;
        File file = Gdx.files.internal(filepath).file();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EntityDescriptor.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            result = (EntityDescriptor) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }
}
