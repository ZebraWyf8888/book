package com.atguigu.springboot.verification;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author LB
 * @create 2019-03-14 7:44
 */
public class DrawImage {
    //图片的宽度
    public static  final int WIDTH = 120;
    //图片的高度
    public static  final int HEIGHT = 30;

    public void image(HttpServletRequest request, HttpServletResponse response)  {
        String createTypeFlag = request.getParameter("createTypeFlag");
        BufferedImage bufferedImage = new BufferedImage(WIDTH,HEIGHT , BufferedImage.TYPE_INT_RGB );
        Graphics graphics = bufferedImage.getGraphics();

        //设置图片的背景颜色
        setBackGround(graphics);
        //再图片上画干扰线
        drawRandomLine(graphics);
        //设置图片的边框
        setBorder(graphics);
        //根据客服端传来的createTypeFlag生成对应的验证码图片
        String random = drawRandomNum((Graphics2D)graphics,createTypeFlag);
        System.out.println(random);
        request.getSession().setAttribute("checkcode",random );
        //设置响应头通知浏览器以图片的形式打开
        response.setContentType("image/jpeg");

        //设置响应头控制浏览器不要缓存
        response.setDateHeader("expries",-1 );
        response.setHeader("Cache-Control","no-cache" );
        response.setHeader("Pragma","no-cache" );

        try {
            ImageIO.write(bufferedImage,"jpg" ,response.getOutputStream() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写出随机字符
     * @param graphics
     * @param createTypeFlag
     * @return
     */
    private String drawRandomNum(Graphics2D graphics, String... createTypeFlag) {
        graphics.setColor(Color.red);
        graphics.setFont(new Font("宋体", Font.BOLD ,20 ));

        //常见的中文字符
        String baseChineseChar = "\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4\u5c31\u53bb\u5b50\u5f97\u4e5f\u548c\u90a3\u8981\u4e0b\u770b\u5929\u65f6\u8fc7\u51fa\u5c0f\u4e48\u8d77\u4f60\u90fd\u628a\u597d\u8fd8\u591a\u6ca1\u4e3a\u53c8\u53ef\u5bb6\u5b66\u53ea\u4ee5\u4e3b\u4f1a\u6837\u5e74\u60f3\u751f\u540c\u8001\u4e2d\u5341\u4ece\u81ea\u9762\u524d\u5934\u9053\u5b83\u540e\u7136\u8d70\u5f88\u50cf\u89c1\u4e24\u7528\u5979\u56fd\u52a8\u8fdb\u6210\u56de\u4ec0\u8fb9\u4f5c\u5bf9\u5f00\u800c\u5df1\u4e9b\u73b0\u5c71\u6c11\u5019\u7ecf\u53d1\u5de5\u5411\u4e8b\u547d\u7ed9\u957f\u6c34\u51e0\u4e49\u4e09\u58f0\u4e8e\u9ad8\u624b\u77e5\u7406\u773c\u5fd7\u70b9\u5fc3\u6218\u4e8c\u95ee\u4f46\u8eab\u65b9\u5b9e\u5403\u505a\u53eb\u5f53\u4f4f\u542c\u9769\u6253\u5462\u771f\u5168\u624d\u56db\u5df2\u6240\u654c\u4e4b\u6700\u5149\u4ea7\u60c5\u8def\u5206\u603b\u6761\u767d\u8bdd\u4e1c\u5e2d\u6b21\u4eb2\u5982\u88ab\u82b1\u53e3\u653e\u513f\u5e38\u6c14\u4e94\u7b2c\u4f7f\u5199\u519b\u5427\u6587\u8fd0\u518d\u679c\u600e\u5b9a\u8bb8\u5feb\u660e\u884c\u56e0\u522b\u98de\u5916\u6811\u7269\u6d3b\u90e8\u95e8\u65e0\u5f80\u8239\u671b\u65b0\u5e26\u961f\u5148\u529b\u5b8c\u5374\u7ad9\u4ee3\u5458\u673a\u66f4\u4e5d\u60a8\u6bcf\u98ce\u7ea7\u8ddf\u7b11\u554a\u5b69\u4e07\u5c11\u76f4\u610f\u591c\u6bd4\u9636\u8fde\u8f66\u91cd\u4fbf\u6597\u9a6c\u54ea\u5316\u592a\u6307\u53d8\u793e\u4f3c\u58eb\u8005\u5e72\u77f3\u6ee1\u65e5\u51b3\u767e\u539f\u62ff\u7fa4\u7a76\u5404\u516d\u672c\u601d\u89e3\u7acb\u6cb3\u6751\u516b\u96be\u65e9\u8bba\u5417\u6839\u5171\u8ba9\u76f8\u7814\u4eca\u5176\u4e66\u5750\u63a5\u5e94\u5173\u4fe1\u89c9\u6b65\u53cd\u5904\u8bb0\u5c06\u5343\u627e\u4e89\u9886\u6216\u5e08\u7ed3";
        //数字个字母的组合
        String baseNumLetter = "0123456789ABCDEFGHJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        //纯数字
        String baseNum = "0123456789";
        //纯字母
        String baseLetter = "ABCDEFGHJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        //默认生成数字加字母
        if(createTypeFlag.length>0 && createTypeFlag[0] != null){
            if(createTypeFlag[0].equals("ch")){
                return createRandomChar(graphics,baseChineseChar);
            }else if(createTypeFlag[0].equals("nl")){
                return createRandomChar(graphics,baseNumLetter);
            }else if(createTypeFlag[0].equals("n")){
                return createRandomChar(graphics,baseNum);
            }else if(createTypeFlag[0].equals("l")){
                return createRandomChar(graphics,baseLetter);
            }
        }else {
            return createRandomChar(graphics,baseNumLetter);
        }
        return "";
    }

    /**
     * 创建随机字符
     * @param graphics
     * @param baseChar
     * @return
     */
    private String createRandomChar(Graphics2D graphics, String baseChar) {
        StringBuffer stringBuffer = new StringBuffer();
        int x = 5;
        String s = "";
        for(int i = 0;i < 4;i++){
            int degree = new Random().nextInt()%30;
            s = baseChar.charAt(new Random().nextInt(baseChar.length()))+"";
            stringBuffer.append(s);

            graphics.rotate(degree* Math.PI/180,x,20);
            graphics.drawString(s,x ,20 );
            graphics.rotate(-degree* Math.PI/180,x,20);
            x += 30;
        }
        return stringBuffer.toString();
    }

    private void setBorder(Graphics graphics) {
        //边框颜色
        graphics.setColor(Color.BLUE);
        //边框区域
        graphics.drawRect(1,1 ,WIDTH-2 ,HEIGHT-2 );
    }

    private void drawRandomLine(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        //随机在(x1,y1),(x2,y2)画五条线
        for(int i =0;i<5;i++){
            int x1 = new Random().nextInt(WIDTH);
            int y1 = new Random().nextInt(HEIGHT);
            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HEIGHT);
            graphics.drawLine(x1,y1 ,x2 ,y2 );
        }
    }

    private void setBackGround(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0 ,WIDTH ,HEIGHT );
    }
}

