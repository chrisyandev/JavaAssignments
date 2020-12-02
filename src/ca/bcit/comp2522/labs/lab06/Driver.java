package ca.bcit.comp2522.labs.lab06;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Driver {

    public static void main(final String[] args) {
        /* Part 1 */
        try {
            BufferedImage img = ImageIO.read(new File("man-with-mask.png"));
            Sprite sprite = new Sprite(100, 200, 0.7f, img);

            System.out.println("--- Sprite to be serialized ---");
            System.out.println(sprite);

            FileOutputStream fileOut = new FileOutputStream("sprite.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(sprite);
            objOut.flush();
            objOut.close();

            FileInputStream fileIn = new FileInputStream("sprite.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            Sprite sprite2 = (Sprite) objIn.readObject();
            objIn.close();

            System.out.println("--- Deserialized Sprite ---");
            System.out.println(sprite2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        /* Part 2 */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
        String saveFile = dateFormat.format(new Date()) + ".dat";

        try {
            Resources res = new Resources("Danger Ahead", 1, 150, 175, 100, 50);
            System.out.println("\n--- Resources to be saved out ---");
            System.out.println(res);

            DataOutputStream dataOut =
                    new DataOutputStream(
                        new BufferedOutputStream(
                            new FileOutputStream(saveFile)));
            dataOut.writeUTF(res.getLevelName());
            dataOut.writeInt(res.getLevelNumber());
            dataOut.writeInt(res.getSpriteX());
            dataOut.writeInt(res.getSpriteY());
            dataOut.writeInt(res.getHealth());
            dataOut.writeInt(res.getNumOfEnemies());
            dataOut.close();

            DataInputStream dataIn =
                    new DataInputStream(
                        new BufferedInputStream(
                            new FileInputStream(saveFile)));
            Resources res2 = new Resources(
                    dataIn.readUTF(), dataIn.readInt(),
                    dataIn.readInt(), dataIn.readInt(),
                    dataIn.readInt(), dataIn.readInt());
            dataIn.close();

            System.out.println("--- Retrieved Resources ---");
            System.out.println(res2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
