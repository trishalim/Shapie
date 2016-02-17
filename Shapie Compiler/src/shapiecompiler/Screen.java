package shapiecompiler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Screen extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static int height = 600, width = 1000, padding = 10;
	static JTextArea codeArea;
	MouseAdapter runListener, saveListener, openListener;
	static JPanel container;
	static Output output;
	static JLabel error;
	JFileChooser fc;

	public Screen() {
		runListener = new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	runBtnClicked(evt);
            }
        };
        	saveListener = new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	saveBtnClicked(evt);
            }
        };
       	 	openListener = new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	openBtnClicked(evt);
            }
        };
		//saving code
        fc = new JFileChooser();
        
        Color basecol = new Color (0, 191, 165);
        //JPanel containing code and output panels
		container = new JPanel();
		container.setLayout(null);
		
		//Left JPanel for Code
		JPanel code = new JPanel();
		code.setLayout(null);
		code.setBackground(Color.white);
		code.setBounds(padding + 25, padding, width/2-50, height-70);
		code.setBorder(BorderFactory.createLineBorder(basecol));
		Font font = new Font("Courier New", Font.PLAIN, 14);
		codeArea = new JTextArea();
		codeArea.setFont(font);
		codeArea.setBorder(BorderFactory.createLineBorder(Color.white));
		codeArea.setBounds(padding, padding, 430,height-140);
		code.add(codeArea);
		error= new JLabel();
		error.setBounds(padding, 480, 340,40);
		error.setText(" ");
		error.setForeground(Color.RED);
		code.add(error);

		JButton runBtn = new JButton("Run");
		runBtn.setBounds(370, 480, 70, 40);
		runBtn.addMouseListener(runListener);
		runBtn.setBorder(new LineBorder(Color.gray, 1));
		runBtn.setFocusPainted(false);
		runBtn.setBackground(Color.white);
		runBtn.setForeground(basecol);
		runBtn.setFont(new Font("Courier New", Font.BOLD, 18));
		code.add(runBtn);
		JButton saveBtn = new JButton("Save");
		saveBtn.setBounds(295, 480, 70, 40);
		saveBtn.addMouseListener(saveListener);
		saveBtn.setBorder(new LineBorder(Color.gray, 1));
		saveBtn.setFocusPainted(false);
		saveBtn.setBackground(Color.white);
		saveBtn.setForeground(basecol);
		saveBtn.setFont(new Font("Courier New", Font.BOLD, 18));
		code.add(saveBtn);
		JButton openBtn = new JButton("Open");
		openBtn.setBounds(220, 480, 70, 40);
		openBtn.addMouseListener(openListener);
		openBtn.setBorder(new LineBorder(Color.gray, 1));
		openBtn.setFocusPainted(false);
		openBtn.setBackground(Color.white);
		openBtn.setForeground(basecol);
		openBtn.setFont(new Font("Courier New", Font.BOLD, 18));

		code.add(openBtn);

		container.add(code);
		
		//Right JPanel for Output
		output = new Output();
		output.setBounds(width/2-5, padding, width/2-50, height-70);
		output.setBorder(BorderFactory.createLineBorder(basecol));		
		output.setBackground(Color.white);
		container.add(output);
		
		add(container);
		setSize(width,height-10);
		setVisible(true);
		setTitle("Shapie");
	}
	
	public void runBtnClicked(MouseEvent evt) {
		setOutput();
		Output.ObjectList = new ArrayList<Object>();
		Shapie.checkCode(codeArea.getText());
	}
	public void saveBtnClicked(MouseEvent evt) {
		System.out.println("SAVING");

		 int exInput = JOptionPane.NO_OPTION;
		 File file = null;
		 String text = codeArea.getText();
		    // use a do-while and "no" to reshow the save dialog if exists

		    do {
		        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		        fc.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
		    	int returnVal = fc.showSaveDialog(null);
		        if (returnVal != JFileChooser.APPROVE_OPTION) {
		            return;
		        }

		        file = fc.getSelectedFile();
		        String[] tok = file.getName().split("\\.");
		       
		        if (!file.getName().endsWith(".txt")) {
		            file = new File(file.getParentFile(), tok[0] + ".txt");
		        }

		        if (file.exists()) {
		            exInput = JOptionPane.showConfirmDialog(
		                            null, "This file already exists, overwrite it?");
		            if (exInput == JOptionPane.CANCEL_OPTION) {
		                return;
		            }
		        }
		    } while (file.exists() && exInput == JOptionPane.NO_OPTION);

		    System.out.println(file.getName());
	        try{

	            FileWriter fw = new FileWriter(file);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(text);
	            bw.close();

                System.out.println("saved");
	    	   }catch(Exception ex){
	    		   System.out.println("Error");
               }
	}
	public void openBtnClicked(MouseEvent evt) {
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
		int returnVal = fc.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			//This is where a real application would open the file.
			try{

				StringBuilder b = new StringBuilder();
				FileReader fr = new FileReader(file);
				BufferedReader tr=new BufferedReader(fr);
				System.out.println("asdasd");
				String line = tr.readLine();
				while (line != null) {
					b.append(line);
					line = tr.readLine();
					if(line!=null)
						b.append("\n");
				}
				tr.close();
				codeArea.setText(b.toString());
				System.out.println("opening" + file.getName());				
			}catch(Exception ex){
				System.out.println(ex);
			}

		} else {
				System.out.println("cancelled");
		}
	}
	public void setOutput() {
		output.redraw();
	}
	
	public static void setError(String err){
		error.setText(err);
	}
	
}
