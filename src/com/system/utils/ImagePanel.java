package com.system.utils;

import javax.swing.*;
import java.awt.*;

/**
 * @author 徐文倩
 */
public class ImagePanel extends JPanel {
    private int width;
    private int height;
    private String imgPath;

    public ImagePanel(int width, int height, String  imgPath){
        this.width=width;
        this.height=height;
        this.imgPath =imgPath;
        this.setPreferredSize(new Dimension(this.width,this.height));
    }
    public ImagePanel(){
        super();
    }
    public void setImgPath(String string){
        imgPath=string;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/"+imgPath));
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(this.width, this.height, Image.SCALE_FAST));
        imageIcon.paintIcon(this, g, 0, 0);
    }
}