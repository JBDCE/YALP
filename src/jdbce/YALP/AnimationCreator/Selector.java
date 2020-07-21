package jdbce.YALP.AnimationCreator;

import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.*;

public class Selector extends JPanel{
	private static final long serialVersionUID = -7839203331317179671L;

	private JPanel southWestPanel;
	private JButton selectFilesButton;
	private JButton createAnimationButton;
	private JList<String> list;
	private DefaultListModel<String> files;
	private JFileChooser fc;
	
	public Selector() {
		files = new DefaultListModel<String>();
		
		southWestPanel = new JPanel();
		selectFilesButton = new JButton("Add Pictures");
		createAnimationButton = new JButton("Create Animation");
		list = new JList<String>(files);
		list.setVisibleRowCount(25);
		
		fc = new JFileChooser("H:\\Java\\workspace\\YALP\\res");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setMultiSelectionEnabled(true);
		fc.setFileFilter(new FileNameExtensionFilter("Pictures", "png", "jpeg", "jpg"));
		
		this.setLayout(new BorderLayout());
		this.add(list, BorderLayout.CENTER);
		this.add(southWestPanel, BorderLayout.SOUTH);
		southWestPanel.setLayout(new BorderLayout());
		southWestPanel.add(selectFilesButton, BorderLayout.WEST);
		southWestPanel.add(createAnimationButton, BorderLayout.EAST);
	}

	
	public JFileChooser getFC() {
		return fc;
	}
	public JButton getSelectFilesButton() {
		return selectFilesButton;
	}
	public JButton getCreateAnimationButton() {
		return createAnimationButton;
	}
	public DefaultListModel<String> getFiles(){
		return files;
	}
	public JList<String> getList() {
		return list;
	}
}
