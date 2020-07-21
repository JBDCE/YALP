package jbdce.YALP.engine.utils;

import java.awt.image.*;
import java.io.*;
import java.nio.*;

import javax.imageio.*;

import org.lwjgl.*;
import static org.lwjgl.opengl.GL11.*;

public class Texture {

	private int id;
	private int width;
	private int height;
	
	public Texture(String path){
		BufferedImage bi;
		try {
			bi = ImageIO.read(new File(path));
			width = bi.getWidth();
			height = bi.getHeight();
			
			int[] rawPixels = new int[width*height*4];
			rawPixels = bi.getRGB(0, 0, width, height, null, 0, width);
			
			ByteBuffer pixels = BufferUtils.createByteBuffer(width*height*4);
			ByteBuffer.allocateDirect(height*width*4);
			
			for (int i = 0; i<width; i++){
				for (int j = 0; j<height;j++){
					int pix = rawPixels[i*height+j];
					pixels.put((byte) ((pix >> 16) & 0xFF));	//Red 
					pixels.put((byte) ((pix >>  8) & 0xFF));	//Green
					pixels.put((byte) ((pix      ) & 0xFF));	//Blue
					pixels.put((byte) ((pix >> 24) & 0xFF));	//Alpha
				}
			}
			pixels.flip();
			
			id = glGenTextures();			
			
			glBindTexture(GL_TEXTURE_2D, id);
			
			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixels);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
	public Texture(BufferedImage bi){
		width = bi.getWidth();
		height = bi.getHeight();
				
		int[] rawPixels = new int[width*height*4];
		rawPixels = bi.getRGB(0, 0, width, height, null, 0, width);
		
		ByteBuffer pixels = BufferUtils.createByteBuffer(width*height*4);
		ByteBuffer.allocateDirect(height*width*4);
		
		for (int i = 0; i<width; i++){
			for (int j = 0; j<height;j++){
				int pix = rawPixels[i*height+j];
				pixels.put((byte) ((pix >> 16) & 0xFF));	//Red 
				pixels.put((byte) ((pix >>  8) & 0xFF));	//Green
				pixels.put((byte) ((pix      ) & 0xFF));	//Blue
				pixels.put((byte) ((pix >> 24) & 0xFF));	//Alpha
			}
		}
		pixels.flip();
		
		id = glGenTextures();			
		
		glBindTexture(GL_TEXTURE_2D, id);
		
		glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixels);
	}
	
	public void bind(){
		glBindTexture(GL_TEXTURE_2D, id);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
