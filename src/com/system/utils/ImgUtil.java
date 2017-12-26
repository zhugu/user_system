package com.system.utils;
import java.io.*;

/**
 * @author 徐文倩
 * 图片工具类
 */
public class ImgUtil {

    public static byte[] getImgByte(String  imgPath) throws IOException {
        File file = new File(imgPath);
        byte[] b = new byte[(int) file.length()];
        InputStream inputStream = new FileInputStream(file);
        inputStream.read(b);
        inputStream.close();
        return b;
    }

    public static void saveImg(File file, byte[] b) throws
            Exception {
        OutputStream out = new FileOutputStream(file);
        out.write(b);
        out.close();
    }
}
