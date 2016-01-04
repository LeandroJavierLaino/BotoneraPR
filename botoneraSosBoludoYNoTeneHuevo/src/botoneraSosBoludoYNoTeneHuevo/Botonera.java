package botoneraSosBoludoYNoTeneHuevo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Botonera extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2680107113469547550L;
	private JPanel contentPane;
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				try{
					Botonera frame = new Botonera();
					frame.setVisible(true);				
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public Botonera(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton soBoludo = new JButton("So Boludo");
		soBoludo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						soBoludo();
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
			}
		});
		contentPane.add(soBoludo, BorderLayout.SOUTH);
		
		JButton maiameee = new JButton("Maiameee");
		maiameee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						maiameee();
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		});
		contentPane.add(maiameee, BorderLayout.CENTER);
		
	}
	
	void soBoludo () throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		BufferedInputStream bis = new BufferedInputStream(getClass().getResourceAsStream("sound/tada.wav"));	
		AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
		Clip sound = AudioSystem.getClip();
		sound.open(ais);
		try{
		sound.start();
		}finally{
			if(ais != null){
				sound.close();
			}
		}
		//sound.close();
	}
	
	void maiameee () throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		Clip sound = AudioSystem.getClip();
		sound.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("sound/tada.wav")));
		sound.start();
		//sound.close();
	}
}
