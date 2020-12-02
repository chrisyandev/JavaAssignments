package ca.bcit.comp2522.labs.lab06;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.Serializable;
import java.util.ArrayList;

public class Sprite implements Serializable {

    private static final long serialVersionUID = 1L;

    private int x;
    private int y;
    private transient float gravity;
    private ArrayList<String> weapons;
    private byte[] pixelData;

    public Sprite(final int x, final int y, final float gravity,
                  final BufferedImage img) {
        this.x = x;
        this.y = y;
        this.gravity = gravity;
        weapons = new ArrayList<>();
        pixelData = ((DataBufferByte) img.getRaster()
                .getDataBuffer()).getData();
    }

    public String toString() {
        return "x: " + x
                + "\ny: " + y
                + "\ngravity: " + gravity
                + "\n# of bytes: " + pixelData.length;
    }
}
