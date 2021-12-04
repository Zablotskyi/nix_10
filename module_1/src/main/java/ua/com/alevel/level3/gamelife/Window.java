package ua.com.alevel.level3.gamelife;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable {

    JFrame frame;
    Box[][] boxes;
    Config config;

    @Override
    public void run() {
        initFrame();
        initBoxes();
        initTimer();
    }

    public void initConfigParams(int width, int height) {
        config = new Config(width, height);
    }

    void initFrame() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(Config.SIZE * config.getWidth(), Config.SIZE * config.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Игра Жизнь");

    }

    void initBoxes() {
        boxes = new Box[config.getWidth()][config.getHeight()];
        for (int x = 0; x < config.getWidth(); x++) {
            for (int y = 0; y < config.getHeight(); y++) {
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }
        }
        for (int x = 0; x < config.getWidth(); x++) {
            for (int y = 0; y < config.getHeight(); y++) {
                for (int sx = -1; sx <= 1; sx++) {
                    for (int sy = -1; sy <= 1; sy++) {
                        if (!(sx == 0 && sy == 0)) {
                            boxes[x][y].cell.addNear(boxes[(x + sx + config.getWidth()) % config.getWidth()][(y + sy + config.getHeight()) % config.getHeight()].cell);
                        }
                    }
                }
            }
        }
        for (int x = 10; x < 15; x ++) {
            boxes[x][10].cell.status = Status.LIVE;
            boxes[x][10].setColor();
        }
    }

    private void initTimer() {
        TimerListener t1 = new TimerListener();
        Timer timer = new Timer(Config.SLEEPMS, t1);
        timer.start();
    }

    private class TimerListener implements ActionListener {

        boolean flop = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;
            for (int x = 0; x < config.getWidth(); x++) {
                for (int y = 0; y < config.getHeight(); y++) {
                    if (flop) {
                        boxes[x][y].step1();
                    } else {
                        boxes[x][y].step2();
                    }
                }
            }
        }
    }
}
