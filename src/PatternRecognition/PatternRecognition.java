package PatternRecognition;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class PatternRecognition extends JFrame{
	JFrame main=new JFrame("Pattern Recognition");
	JPanel show_output=new JPanel();
	int[] inputdata=new int[28*28];
	File f=null;
	BufferedImage image=new BufferedImage(28,28,BufferedImage.TYPE_BYTE_GRAY);
	JFileChooser fc=new JFileChooser("testSample//testSample");
	//JButtons
	JButton open=new JButton("Open");
	JButton run=new JButton("Run");
	//JLables
	JLabel show=new JLabel("  ");
	Font font1 = new Font("SansSerif", Font.BOLD, 130);
	public static void main(String[] args) {
	new PatternRecognition().start();
}
	public void start() {
		
	    //ActionListeners of all buttons
		ActionListener open_Image=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i=fc.showOpenDialog(null);
				if(i==JFileChooser.APPROVE_OPTION){    
			        f=fc.getSelectedFile();
			        try{  
			        	inputdata=GetDataFromFile(f);
			            }catch (Exception ex) {ex.printStackTrace();  }                 
			        }    
			}
			
		};
		ActionListener run_Action=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (f==null) {
					JOptionPane.showMessageDialog(main,"Image not selected .!","Warning",JOptionPane.WARNING_MESSAGE);
					return;
				}
				show.setText(" ");
				String ans=Recognize(inputdata);
				show.setText(ans);
				show_output.setBackground(new Color(255,255,255));
				show.setVisible(true);
				//JLabel of recognized pattern
			}
		 };
		 
		 //Configuring buttons
		 open.addActionListener(open_Image);
		 open.setBounds(100,100,75,25);
		 run.addActionListener(run_Action);
		 run.setBounds(100,200,75,25);
		 show.setFont(font1);
		 show.setVisible(true);
		 show.setBounds(50, 50, 70, 100);
		 //configuring show_output panel
		 show_output.setBounds(50, 100, 70, 100);
		 show_output.setLayout(new FlowLayout());
		 show_output.setBackground(new Color(179,204,255));
		 show_output.add(show);
		//Adding Buttons to Frame
		 
		 main.add(show_output);
		 main.add(open);
		 main.add(run);
		 
		//frame settings
		main.getContentPane().setBackground(new Color(179, 204, 255));
		main.setVisible(true);
		main.setLayout(new FlowLayout());
		main.setSize(500,350);
		
	}
	public int[] GetDataFromFile(File f) {
		 try {
				image=resizeImage(ImageIO.read(f),28,28);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 for (int i = 0; i < 28; i++) {
		      for (int j = 0; j < 28; j++) {
		        int gray= image.getRGB(j, i) & 0xFF;
		        gray= gray > 145 ? 1 : 0;
		       inputdata[i*28+j]=gray;
		        System.out.print(gray+" ");
		      }
		      System.out.println();
		    }
		 return inputdata;
	}
	public BufferedImage resizeImage(BufferedImage orgImage, int i, int j) {
		BufferedImage resizedImage = new BufferedImage(i, j, BufferedImage.TYPE_BYTE_GRAY);
	     Graphics2D graphics2D = resizedImage.createGraphics();
	     graphics2D.drawImage(orgImage, 0, 0, i, j, null);
	     graphics2D.dispose();
	     return resizedImage;
	}
	public String Recognize(int[] input) {
		
		//Implement File Training
		HashMap<Integer,String> map=new HashMap<>();
		int max=-1;
		try {
			List<String> allLines=Files.readAllLines(Paths.get("TrainLog.txt"));
			int res=0;
			for(String line:allLines) {
				res=0;
				String[] temp=new String[28*28+1];
				temp=line.split(",");
				for(int i=1;i<28*28+1;i++) {
					res=res+(input[i-1]*Integer.valueOf(temp[i]));	
				}
				map.put(res,temp[0]);
				max=Math.max(max,res);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return map.get(max);
		
	}
}
