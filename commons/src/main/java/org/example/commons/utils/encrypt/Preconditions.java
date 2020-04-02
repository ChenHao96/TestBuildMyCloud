package org.example.commons.utils.encrypt;

public class Preconditions {
    public static void checkArgument(boolean result, String msg) {
        if (!result) throw new IllegalArgumentException(msg);
    }
}
