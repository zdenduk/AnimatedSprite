package xd;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.TimerTask;

public class AnimationLoop extends TimerTask {

    GraphicsContext gc;
    Canvas c;
    AnimatedImage img;
    Map bg;
    private long startNanoTime;

    public AnimationLoop(Group g, AnimatedImage img, Map bg) {
        this.img = img;
        startNanoTime = System.nanoTime();
        c = new Canvas(320, 320);
        g.getChildren().add(c);
        this.gc = c.getGraphicsContext2D();
        this.bg = bg;
    }

    public void update() {

    }

    private void render() {
        gc.clearRect(0, 0, c.getWidth(), c.getHeight());
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                gc.drawImage(bg.images.get(0), row * 64, column * 64);
            }
        }
        double t = (System.nanoTime() - startNanoTime) / 1000000000.0;
        gc.drawImage(img.getFrame(t), 128, 64);
    }

    @Override
    public void run() {
        render();
    }
}
