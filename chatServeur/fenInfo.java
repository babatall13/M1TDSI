import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class fenInfo extends JFrame implements ActionListener
{
	
	private JButton Lancer=new JButton("Lancer le Tchat");
	private JLabel labelNom=new JLabel("Identifiant de connexion");
	private JLabel labelServeur=new JLabel("Adresse du serveur");
	private JTextField textNom=new JTextField(15);
	private JTextField textServeur=new JTextField(15);
	
	
	
	public fenInfo()
	{
		
		super("Informations de connexion");
		setBounds(350,200,250,200);
		setVisible(true);
        setAlwaysOnTop(true);
		setLayout(new FlowLayout ());
		labelNom.setForeground(Color.blue);
		//labelServeur.setForeground(Color.blue);
		
		
		
		
		add(labelNom);add(textNom);
		//add(labelServeur);add(textServeur);
		add(Lancer);
		
		
		
		
		Lancer.addActionListener(this);
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent e)              
		{ 
			
			String label = e.getActionCommand();
			
			if (label.equals("Lancer le Tchat"))
			{
				
				dispose();
				new fenChat(textNom.getText(),400,100,350,600);
				
			}
			
			

		}
	
	
}