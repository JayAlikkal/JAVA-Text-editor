package TextEditor;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Formatter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Texteditorapp {

	private JFrame frmTextEditor;
	private JTextArea txtArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Texteditorapp window = new Texteditorapp();
					window.frmTextEditor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Texteditorapp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTextEditor = new JFrame();
		frmTextEditor.setTitle("HTML Text Editor");
		frmTextEditor.setBounds(100, 100, 701, 493);
		frmTextEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTextEditor.getContentPane().setLayout(new BorderLayout(0, 0));
		
		txtArea = new JTextArea();
		JTextArea txtArea = new JTextArea();
		frmTextEditor.getContentPane().add(txtArea, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane(txtArea);
		frmTextEditor.getContentPane().add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);
		
		JMenu mnNewMenu = new JMenu("Files");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save As");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Save");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			save();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Close");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Undo");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Copy");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Paste");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Find");
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Clear screen");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtArea.setText(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("About TextEditor");
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_3 = new JMenu("Feedback");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Developer info");
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		}
	private void open() {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select a HTML.txt File to open");
		chooser.showOpenDialog(null);
		File selectedfile = chooser.getSelectedFile();
		String filename = selectedfile.getAbsolutePath();
				
		try {
			FileReader reader = new FileReader(filename);
			BufferedReader br = new BufferedReader(reader);
			txtArea.read(br, null);
			br.close();
			txtArea.requestFocus();
			
		 	}catch(Exception e){
		 		JOptionPane.showMessageDialog(null, "Erorr");
			e.printStackTrace();
		}
	}
	
	private void create() {
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Select new file");
			chooser.showOpenDialog(null);
			
			File selectedFile = chooser.getSelectedFile();
			String contents = txtArea.getText();
			
			Formatter form = new Formatter(selectedFile);
			form.format("%s", contents);
			form.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void save() {
		try {
			
		}catch(Exception e){
		e.printStackTrace();
	}
	}
}

