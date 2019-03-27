package xd;

import javafx.scene.image.Image;

public class AnimatedImage {
    // assumes animation loops,
    //  each image displays for equal time
    public Image[] frames; // todo with list
    public double duration;

    public Image getFrame(double time) {
        int index = (int) ((time % (frames.length * duration)) / duration);
        return frames[index];
    }
}