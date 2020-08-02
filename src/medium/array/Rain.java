package medium.array;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.MemoryImageSource;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Rain extends JDialog implements ActionListener {

    private Random random = new Random();
    private Dimension screenSize;
    private JPanel graphicsPanel;
    //行高,列宽
    private final static int gap = 15;
    //存放雨点顶部的位置信息(marginTop)
    private int[] posArr;
    //行数
    private int lines;
    //列数
    private int columns;

    public Rain() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        graphicsPanel = new GraphicsPanel();
        add(graphicsPanel, BorderLayout.CENTER);
        //设置光标不可见
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Image image = defaultToolkit.createImage(new MemoryImageSource(0, 0, null, 0, 0));
        Cursor invisibleCursor = defaultToolkit.createCustomCursor(image, new Point(0, 0), "cursor");
        setCursor(invisibleCursor);
        //ESC键退出
        KeyPressListener keyPressListener = new KeyPressListener();
        this.addKeyListener(keyPressListener);
        //this.setAlwaysOnTop(true);
        //去标题栏
        this.setUndecorated(true);
        //全屏
        this.getGraphicsConfiguration().getDevice().setFullScreenWindow(this);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        lines = screenSize.height / gap;
        columns = screenSize.width / gap;

        posArr = new int[columns + 1];
        random = new Random();
        for (int i = 0; i < posArr.length; i++) {
            posArr[i] = random.nextInt(lines);
        }

        //每秒10帧
        new Timer(150, this).start();
    }

    /**
     * @return 随机字符
     */
    private char getChr() {
        return (char) (random.nextInt(94) + 33);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        graphicsPanel.repaint();
    }

    private class GraphicsPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(getFont().deriveFont(Font.BOLD));
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, screenSize.width, screenSize.height);
            //当前列
            int currentColumn = 0;
            for (int x = 0; x < screenSize.width; x += gap) {
                int endPos = posArr[currentColumn];
                g2d.setColor(Color.CYAN);
                g2d.drawString(String.valueOf(getChr()), x, endPos * gap);
                int cg = 0;
                for (int j = endPos - 15; j < endPos; j++) {
                    //颜色渐变
                    cg += 20;
                    if (cg > 255) {
                        cg = 255;
                    }
                    g2d.setColor(new Color(0, cg, 0));
                    g2d.drawString(String.valueOf(getChr()), x, j * gap);
                }
                //每放完一帧，当前列上雨点的位置随机下移1~5行
                posArr[currentColumn] += random.nextInt(5);
                //当雨点位置超过屏幕高度时，重新产生一个随机位置
                if (posArr[currentColumn] * gap > getHeight()) {
                    posArr[currentColumn] = random.nextInt(lines);
                }
                currentColumn++;
            }
        }
    }

    private class KeyPressListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new Rain();
    }
}