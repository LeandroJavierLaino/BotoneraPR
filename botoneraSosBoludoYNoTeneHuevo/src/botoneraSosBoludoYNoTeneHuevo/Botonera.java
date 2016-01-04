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
	JButton boton1 = new JButton("Tomatela te dije");
	JButton boton2 = new JButton("Maiameee");
	JButton boton3 = new JButton("No comments");
	JButton boton4 = new JButton("Para que te traje");
	JButton boton5 = new JButton("So boludo y no tene huevos");
	JButton boton6 = new JButton("Ese es el equilatero");
	JButton boton7 = new JButton("Puede darme dinero");
	JButton boton8 = new JButton("Basta Chicos");
	JButton boton9 = new JButton("Aguantaaaa");		
    public Botonera(){
        super("Botonera PR");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(boton1);
        boton1.addActionListener(this);
        add(boton2);
        boton2.addActionListener(this);
        add(boton3);
        boton3.addActionListener(this);
        add(boton4);
        boton4.addActionListener(this);
        add(boton5);
        boton5.addActionListener(this);
        add(boton6);
        boton6.addActionListener(this);
        add(boton7);
        boton7.addActionListener(this);
        add(boton8);
        boton8.addActionListener(this);
        add(boton9);
        boton9.addActionListener(this);         
        setVisible(true);
    }
    public static void main(String[] args){
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
            ReproducirSonido("sounds/Me_importa_un_carajo_tomatel_te_dije.wav");
        }if(e.getSource() == boton2){
        	ReproducirSonido("sounds/MAIAMEEE_-_Ricardo_Fort_Jus.wav");
        }if(e.getSource() == boton3){
        	ReproducirSonido("sounds/Coco_Basile_No_comments.wav");
        }if(e.getSource() == boton4){
        	ReproducirSonido("sounds/Para_que_te_traje_Vicente_-_Bambino_Pons.wav");
        }if(e.getSource() == boton5){
        	ReproducirSonido("sounds/Sos_boludo_y_no_tenes_huevos.wav");
        }if(e.getSource() == boton6){
        	ReproducirSonido("sounds/Ese_es_el_equilatero_idiota.wav");
        }if(e.getSource() == boton7){
        	ReproducirSonido("sounds/Puede_darme_dinero.wav");
        }if(e.getSource() == boton8){
        	ReproducirSonido("sounds/Jajaja_Basta_Chicos.wav");
        }if(e.getSource() == boton9){
        	ReproducirSonido("sounds/Aguantaaaa.wav");
        }
    }
}