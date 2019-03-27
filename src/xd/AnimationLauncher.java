package xd;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class AnimationLauncher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) {
        theStage.setTitle("AnimatedImage Example");

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        //Canvas canvas = new Canvas(320, 320);
        //root.getChildren().add(canvas);

        /*List<Image> runAnim = new ArrayList<>();
        runAnim.add(new Image("elf_m_run_anim_f0.png"));
        runAnim.add(new Image("elf_m_run_anim_f1.png"));
        runAnim.add(new Image("elf_m_run_anim_f2.png"));
        runAnim.add(new Image("elf_m_run_anim_f3.png"));

        Image[] frames = new Image[4];
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Image("elf_m_run_anim_f" + i + ".png", 64, 112, true, false);
        }*/

        AnimatedImage hero = new AnimatedImage(SpriteUtil.ELF_M_RUN, 4, 0.100);

        List<Image> map = new ArrayList<>();
        map.add(new Image("floor_3.png", 64, 64, true, false));
        Map bg = new Map(map);

        Timer time = new Timer(); // Instantiate Timer Object
        AnimationLoop gl = new AnimationLoop(root, hero, bg); // Instantiate SheduledTask class
        time.schedule(gl, 0, 1000 / 30); // Create Repetitively 30 task for every 1 secs = 30FPS

        theStage.show();
    }
}