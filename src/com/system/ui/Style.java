package com.system.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author 徐文倩
 */

public class Style {
    /**
     * 功能按钮面板以及的字体以及颜色
     */
    public final static Dimension BUTTON_SIZE1 = new Dimension(200, 50);

    public final static Color BACKGROUND1 = new Color(106,125,138);
    public final static Color BACKGROUND2 = new Color(92,109,120);
    public final static Color FONTCOLOR1 = new Color(228,242,246);
    public final static Font BUTTON_FONT1 = new Font("华文楷体", Font.PLAIN, 20);

    public static void setFunctionButton1(JButton button){
        button.setPreferredSize(BUTTON_SIZE1);
        button.setBackground(BACKGROUND1);
        button.setForeground(FONTCOLOR1);
        button.setFont(BUTTON_FONT1);
        button.setBorderPainted(false);
    }
    public static void setFunctionButton2(JButton button){
        button.setPreferredSize(BUTTON_SIZE1);
        button.setBackground(BACKGROUND2);
        button.setForeground(FONTCOLOR1);
        button.setFont(BUTTON_FONT1);
    }

    /**
     * 顶部按钮
     */
    public final static Dimension BUTTON_SIZE2 = new Dimension(100, 40);
    public final static Font BUTTON_FONT2 = new Font("华文行楷", Font.PLAIN, 16);
    public final static Color BLUE = new Color(52, 152, 219);
    public static void setBlueButtonStyle(JButton button) {
        button.setPreferredSize(BUTTON_SIZE2);
        button.setBackground(BLUE);
        button.setForeground(WHITE);
        button.setFont(BUTTON_FONT2);
    }
    /**
     * 文本框的尺寸
     */
    public final static Dimension FIELD_SIZE = new Dimension(200, 30);

    public final static Color WHITE = new Color(255, 255, 255);
    public final static Color LIGHTGREEN = new Color(51, 204, 153);


    public final static Color WEIGHTWHITE = new Color(231, 239, 241);
    public final static Color GRAY = new Color(74, 82, 84);
    public final static Color B1COLOR = new Color(92, 109, 120);
    public final static Color B2COLOR = new Color(228, 242, 246);
    public final static Color B3COLOR = new Color(240, 248, 250);

    public final static Font NORMAL_FONT = new Font("华文行楷", Font.PLAIN, 16);
    public final static Font BOLD_FONT = new Font("微软雅黑", Font.BOLD, 24);

    /**
     * 尺寸中等，蓝色按钮
     * @param button
     */
    public static void setButtonStyle(JButton button) {
        button.setPreferredSize(BUTTON_SIZE);
        button.setBackground(BLUE);
        button.setForeground(WHITE);
        button.setFont(NORMAL_FONT);
    }
    /**
     * 尺寸较小，浅灰色按钮
     * @param button
     */
    public static void setSmallButtonStyle(JButton button){
        button.setPreferredSize(SMALL_BUTTON_SIZE);
        button.setBackground(WEIGHTWHITE);
        button.setForeground(GRAY);
        button.setFont(NORMAL_FONT);

    }

    /**
     * 尺寸较大，暗灰色按钮
     * @param button
     */
    public static void setBigButtonStyle(JButton button) {
        button.setPreferredSize(BIG_BUTTON_SIZE);
        button.setBackground(B1COLOR);
        button.setForeground(B2COLOR);
        button.setFont(NORMAL_FONT);
    }

    /**
     * 蓝色背景白色字体
     * @param component
     */
    public static void setFieldStyle(JComponent component) {
        component.setPreferredSize(FIELD_SIZE);
        component.setBackground(BLUE);
        component.setForeground(WHITE);
        component.setFont(NORMAL_FONT);
    }

    public static void setLabelStyle(JLabel label) {
        label.setForeground(BLUE);
        label.setFont(BOLD_FONT);
    }

    public static void setNormalFontFont(JComponent component) {
        component.setFont(NORMAL_FONT);
    }

    public static void setBoldFontFont(JComponent component) {
        component.setFont(BOLD_FONT);
    }
    /**
     * 按钮的尺寸
     */
    public final static Dimension BIG_BUTTON_SIZE = new Dimension(190, 50);
    public final static Dimension BUTTON_SIZE = new Dimension(125, 40);
    public final static Dimension SMALL_BUTTON_SIZE = new Dimension(120, 35);

}
