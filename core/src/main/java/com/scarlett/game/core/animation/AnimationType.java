package com.scarlett.game.core.animation;

public enum AnimationType {
    NORMAL(0),
    STATIC(1),
    SINGLE(2),
    REVERSE(3);

    private final int code;

    AnimationType(int code) {
        this.code = code;
    }

    public static AnimationType getByCode(int code) {
        for (AnimationType type : AnimationType.values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("unknown animation type with code" + code);
    }
}
