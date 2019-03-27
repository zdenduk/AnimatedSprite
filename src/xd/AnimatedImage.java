package xd;

import javafx.scene.image.Image;

public class AnimatedImage {
    // assumes animation loops,
    //  each image displays for equal time
    private Image[] frames; // todo with list
    private double duration;

    public AnimatedImage(final String sprite, int numberOfSpritesToAnimate, double duration) {
        loadSprites(sprite, numberOfSpritesToAnimate);
        this.duration = duration;
    }

    private void loadSprites(final String sprite, int number) {
        Image[] frames = new Image[number];
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Image(sprite + i + ".png", 64, 112, true, false);
        }
        this.frames = frames;
    }

    public Image getFrame(double time) {
        int index = (int) ((time % (frames.length * duration)) / duration);
        return frames[index];
    }
}