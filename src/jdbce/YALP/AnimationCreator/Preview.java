package jdbce.YALP.AnimationCreator;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

public class Preview extends JPanel{
	private static final long serialVersionUID = 1097671261772476514L;
	
	private ImageIcon icon;
	private JLabel picture;	
	private JButton testAnimation;
	
	public Preview() {
		this.setBackground(Color.WHITE);
		icon = new ImageIcon();
		picture = new JLabel();
		testAnimation = new JButton("Test Animation");
		
		this.setLayout(new BorderLayout());
		this.add(picture, BorderLayout.CENTER);
		this.add(testAnimation, BorderLayout.SOUTH);
	}

	public void setImage(BufferedImage img) {		
		icon.setImage(resize(img));
		picture.setIcon(this.icon);
		repaint();
	}
	
	private BufferedImage resize(BufferedImage img) {
		int height = 256, width = 256;
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
	
	public JButton getTestButton() {
		return testAnimation;
	}	
}
