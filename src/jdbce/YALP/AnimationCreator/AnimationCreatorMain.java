package jdbce.YALP.AnimationCreator;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;

public class AnimationCreatorMain extends JFrame{
	private static final long serialVersionUID = 6766181043582379123L;
	
	public static final String FILE_EXTENTION = ".anim";
	
	private ArrayList<BufferedImage> images;
	
	private Preview preview;
	private Selector selector;
	
	
	public AnimationCreatorMain() throws IOException {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Animation Creator");
		
		images = new ArrayList<BufferedImage>();
		
		preview = new Preview();
		preview.getTestButton().addActionListener(new EventHandler());
		
		selector = new Selector();
		selector.getList().addListSelectionListener(new EventHandler());
		selector.getCreateAnimationButton().addActionListener(new EventHandler());
		selector.getSelectFilesButton().addActionListener(new EventHandler());
		
		
		this.add(preview, BorderLayout.EAST);
		this.add(selector, BorderLayout.WEST);	
		
		this.setVisible(true);
		
		preview.setImage(ImageIO.read(new File("res/dickbutt.png")));
	}

	private void outputFile() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("Animation", FILE_EXTENTION));
		fc.showSaveDialog(this);
		
		File requestedFile = fc.getSelectedFile();
		
		if(requestedFile!=null) {
			File outputFile = new File(requestedFile.getAbsolutePath() + FILE_EXTENTION);
		
			int pictureWidth = images.get(0).getWidth();
			int pictureHeight = images.get(0).getHeight();
			BufferedImage output = new BufferedImage(pictureWidth*images.size(), pictureHeight, BufferedImage.TYPE_INT_ARGB);
			Graphics g = output.getGraphics();
			
			int currentImage = 0;
			for(BufferedImage bi : images) {
				g.drawImage(bi, pictureWidth*currentImage, 0, null);
				currentImage++;
			}
			
			try {
				ImageIO.write(output, "png", outputFile);		
				Files.write(outputFile.toPath(), ("\n" + String.valueOf(images.size())).getBytes(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
	}
	
	
	
	public class EventHandler implements ActionListener, ListSelectionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(selector.getSelectFilesButton())) {
				selector.getFC().showOpenDialog(AnimationCreatorMain.this);
				for(File f : selector.getFC().getSelectedFiles()) {
					selector.getFiles().addElement(f.getAbsolutePath());
					try {
						images.add(ImageIO.read(f));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}	
			}else 
			if(e.getSource().equals(selector.getCreateAnimationButton())) {
				if(!images.isEmpty()) {
					outputFile();
				}
			}else 
			if(e.getSource().equals(preview.getTestButton())) {
				for(BufferedImage bi : images) {
					preview.setImage(bi);
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			preview.setImage(images.get(selector.getList().getSelectedIndex()));
		}
	}
	
	public static void main(String[] args) throws IOException {
		new AnimationCreatorMain();
	}
}
