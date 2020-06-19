package tuegum.web.servlet.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 实现随机生成验证码
 */

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //1.创建对象，在内存中生成的图片(验证码图片)
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        //2.2画边款
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 1, height - 1);

        //创建随机字符集和随机数对象
        String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
        Random ran = new Random();

        //2.3写验证码
        for (int i = 0; i < 4; i++) {
            //获取随机字符
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            //获取随机色
            Color randomColor = getRandomColor(ran);
            g.setColor(randomColor);
            //设置字体
            Font font = new Font("宋体", Font.BOLD, height / 2);
            g.setFont(font);
            //写入验证码
            g.drawString(ch + "", (i == 0) ? width / 4 * i + 2 : width / 4 * i, height - height / 4);
//            g.drawString(ch + "",width/5*i,height/2);
        }

        //2.4画干扰线
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            //获取随机色
            Color randomColor = getRandomColor(ran);
            g.setColor(randomColor);
            g.drawLine(x1,y1,x2,y2);
        }


        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    private Color getRandomColor(Random random) {
        //获取随机颜色
        int colorIndex = random.nextInt(3);
        switch (colorIndex) {
            case 0:
                return Color.BLUE;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.RED;
            case 3:
                return Color.YELLOW;
            default:
                return Color.MAGENTA;
        }
    }

}
