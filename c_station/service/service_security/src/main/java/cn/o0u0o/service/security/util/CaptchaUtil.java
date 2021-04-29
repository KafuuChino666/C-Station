package cn.o0u0o.service.security.util;

import java.util.Random;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 验证码生成
 */
public class CaptchaUtil {

    private String str;// 验证码
    private static char code[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toCharArray();
    public static final String SESSION_CODE_NAME="code";
    public int num = 0;

    //生成随机算式
    public static String random(){
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for(int i =0;i<4;i++){
            stringBuffer.append(code[random.nextInt(code.length)]);
        }
        return stringBuffer.toString();
    }
    public static void outputImage(String str, OutputStream os){
        Random ran = new Random();
        //创建图片对象
        BufferedImage img = new BufferedImage(100,40, BufferedImage.TYPE_INT_RGB);
        //获取画布
        Graphics g = img.getGraphics();
        //设置背景
        g.setColor(Color.orange);
        g.fillRect(0,0,100,40);
        //写字
        g.setColor(Color.black);
        g.setFont(new Font("Ink Free",Font.PLAIN,35));
        g.drawString(str,10,40);
        //随机三条线
        for(int i=0;i<10;i++) {
            g.drawLine(ran.nextInt(100), ran.nextInt(40),
                    ran.nextInt(100), ran.nextInt(40));
        }
        // 4. 输出结果
        // 常见的压缩格式：jpeg(有损压缩), png(无损压缩) ...
        try {
            ImageIO.write(img, "png", os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
