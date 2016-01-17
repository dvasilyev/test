package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitry on 16.01.2016.
 */
public class EFrame extends JFrame {

    private static int scale = 200;

    private List<EObject> objects = new ArrayList<>();

    public volatile int xDirection = 1;
    public volatile int yDirection = 0;

    public EFrame() {
        super("EFrame");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(2 * scale, 2 * scale));
        pack();
        setVisible(true);

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                Graphics2D g = (Graphics2D) getGraphics();
                g.clearRect(0, 0, 2 * scale, 2 * scale);
                g.setColor(Color.BLACK);
                EGraphics eg = new EGraphics(g, 30);
                objects.stream().forEach(o -> o.draw(eg));
                try {
                    TimeUnit.MILLISECONDS.sleep(175);
                } catch (InterruptedException ignored) {
                }
            }
        }).start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 37:
                        xDirection = -1;
                        yDirection = 0;
                        break;
                    case 38:
                        xDirection = 0;
                        yDirection = -1;
                        break;
                    case 39:
                        xDirection = 1;
                        yDirection = 0;
                        break;
                    case 40:
                        xDirection = 0;
                        yDirection = 1;
                        break;
                }
            }
        });
    }

    public void add(EObject... eObject) {
        objects.addAll(Arrays.asList(eObject));
    }

    public void add(List<EObject> eObjects) {
        objects.addAll(eObjects);
    }


    public static void main(String[] args) {
        SnakeService.run(new EFrame());
//        eFrame.add(new ECell(0, 0), new ECell(1, 1), new ECell(2, 1), new ECell(2, 2));
    }
}
