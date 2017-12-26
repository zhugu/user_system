package com.system.thread;

import com.system.frame.ImagePanel;

import java.util.Random;

/**
 * @author 徐文倩
 */
public class Thread implements Runnable {
    private ImagePanel imagePanel;
    private Random random = new Random();

    public  void setImagePanel(ImagePanel imagePanel){
        this.imagePanel = imagePanel;
    }
    @Override
    public void run() {
        int index = random.nextInt(3)+1;
        imagePanel.setImgPath(String.valueOf(index)+".png");
        imagePanel.repaint();
    }
}
