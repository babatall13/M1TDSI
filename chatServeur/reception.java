import java.net.* ;
import java.io.* ;
import java.awt.*;

public class reception extends Thread
{
	
	private DataInputStream entree;
	private TextArea chat;
	private String recu;
	String nomClient;
	
	public reception(DataInputStream DIS,TextArea texte,String n)
	{
		entree=DIS;
		chat=texte;
		start();
		nomClient=n;
		
	}
	
	
	public void run()
	{
		String texte;
		
	
			try
			{	
				
				while (true)	
				{
					recu=entree.readLine();
					
					chat.setText(chat.getText()+nomClient+"  :\n"+recu+"\n");
					
				}
				
			}
		
			catch(IOException e) { System.out.println(e);System.exit(0);}
		
		
	}	
	
	
}