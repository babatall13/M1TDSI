import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.* ;
import java.io.* ;


public class fenChat extends JFrame implements ActionListener{

		
		//private JLabel label1=new JLabel("Le java est de retour");
		private JPanel panneau=new JPanel();
		private TextArea chat=new TextArea(20,40);
		private TextArea envoi=new TextArea(10,40);
		private JButton Envoyer=new JButton("Envoyer");
		//private expedition exped;
		private PrintStream sortie;
		private connexion connec;
		private String nom;
		
		
	

    	public fenChat(String n,int x,int y,int l,int L) 
    	{
    		super(n);
    		setBounds(x,y,l,L);
        	setResizable(true);
        	setVisible(true);
        	setAlwaysOnTop(true);
			setLayout(new FlowLayout ());
        	add("Center",chat);
        	add("Center",envoi);
        	add(Envoyer);
        	chat.setEditable(false);
        	envoi.requestFocusInWindow();
        	nom=n;
			
			addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
        	}});
 
        	
        	Envoyer.addActionListener(this);
        	chat.setText("En attente du client...\n");
			
			
			
			
			
        	show();
        	connec=new connexion(chat,nom);
        	sortie=connec.recupererSortie();
        	
			
    	}
    	
    	
    	
    	public void actionPerformed(ActionEvent e)              
		{ 
			
			String label = e.getActionCommand();
			
			if (label.equals("Envoyer")) 
        {
        	String texte=envoi.getText();
        	sortie.println(texte);sortie.flush();
        	chat.setText(chat.getText()+nom+"  dit:\n"+texte+"\n");
        	envoi.setText(null);
        	envoi.requestFocusInWindow();
        	
        	
        	
        	
        	
        }

		}
		
		
		
	

    
    
}