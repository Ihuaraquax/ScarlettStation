package com.scarlett.game.core.entity.player;

import com.badlogic.gdx.Gdx;
import com.scarlett.game.core.entity.EntityDescriptor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

@XmlRootElement(name = "player")
public class PlayerDescriptor {
    @XmlElement(name = "entity")
    private EntityDescriptor entityDescriptor;

    public PlayerDescriptor(){
        entityDescriptor = null;
    }

    public PlayerDescriptor(EntityDescriptor entityDescriptor) {
        this.entityDescriptor = entityDescriptor;
    }

    public EntityDescriptor getEntityDescriptor() {
        return entityDescriptor;
    }


    public static PlayerDescriptor getFromFile(String filepath) {
        PlayerDescriptor result = null;
        File file = Gdx.files.internal(filepath).file();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PlayerDescriptor.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            result = (PlayerDescriptor) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }
}
