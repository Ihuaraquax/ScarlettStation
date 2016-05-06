package com.scarlett.game.core.sound;

public enum SoundType {
    LOOP(0),
    SINGLE(1);

    private final int code;

    SoundType(int code) {
        this.code = code;
    }

    public static SoundType getForType(int code){
        for (SoundType type : SoundType.values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("unknown animation type with code" + code);
    }
}
