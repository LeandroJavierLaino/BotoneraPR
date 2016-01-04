package botoneraSosBoludoYNoTeneHuevo;

//public class Botonera extends JFrame {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -2680107113469547550L;
//	private JPanel contentPane;
//	public static void main(String[] args){
//		EventQueue.invokeLater(new Runnable() {
//			public void run(){
//				try{
//					Botonera frame = new Botonera();
//					frame.setVisible(true);				
//				} catch (Exception e){
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
//	public Botonera(){
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100,100,450,300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//		
//		JButton soBoludo = new JButton("So Boludo");
//		soBoludo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//					try {
//						soBoludo();
//					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}				
//			}
//		});
//		contentPane.add(soBoludo, BorderLayout.SOUTH);
//		
//		JButton maiameee = new JButton("Maiameee");
//		maiameee.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//					try {
//						maiameee();
//					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				
//			}
//		});
//		contentPane.add(maiameee, BorderLayout.CENTER);
//		
//	}
//	
//	void soBoludo () throws LineUnavailableException, IOException, UnsupportedAudioFileException{
////		BufferedInputStream bis = new BufferedInputStream(getClass().getResourceAsStream("src/sound/tada.wav"));	
//		AudioStream as = null;
//		FileInputStream in = new FileInputStream("src/sound/tada.wav");
//	}
//	
//	void maiameee () throws LineUnavailableException, IOException, UnsupportedAudioFileException{
//		Clip sound = AudioSystem.getClip();
//		sound.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("src/sound/tada.wav")));
//		sound.start();
//		//sound.close();
//	}
//}

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class Botonera extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8287199945932537354L;
	JButton boton1 = new JButton("Tada");
	JButton boton2 = new JButton("Tada2");
    public Botonera(){
        super("Pulse el boton");
        setSize(400,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(boton1);
        boton1.addActionListener(this);
        add(boton2);
        boton2.addActionListener(this);
        setVisible(true);
    }
    public static void main(String[] Dar10){
        new Botonera();
    }
    public void ReproducirSonido(String nombreSonido){
       try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
         System.out.println("Error al reproducir el sonido.");
       }
     }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton1){
            ReproducirSonido("sounds/tada.wav");
        }if(e.getSource() == boton2){
        	ReproducirSonido("sounds/tada.wav");
        }
    }
}