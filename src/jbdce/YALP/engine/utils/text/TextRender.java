package jbdce.YALP.engine.utils.text;

import java.awt.*;
import java.awt.image.*;

public class TextRender {
	
	private BufferedImage img;
	private Graphics2D g2d;
	private Font font;
	private FontMetrics fm;
	
	private String fontName;
	private int fontStyle;
	private final int fontSize = 64;
	private Color fontColor;

	public TextRender(String fontName, int fontStyle, Color fontColor){
		this.fontName = fontName;
		this.fontStyle = fontStyle;
		this.fontColor = fontColor;
	}

	
	
	
	public BufferedImage generateImage(String text){
		if(text == ""){
			text = " ";
		}
		
		img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		g2d = img.createGraphics();
		font = new Font(fontName, fontStyle, fontSize);
		g2d.setFont(font);
		fm = g2d.getFontMetrics();
		int width = fm.stringWidth(text);
	    int height = fm.getHeight();
	    g2d.dispose();
		
	    img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(fontColor);
        g2d.drawString(text, 0, fm.getAscent());
        g2d.dispose();
		return img;
	}	
}
