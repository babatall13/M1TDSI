import java.net.* ;
import java.io.* ;
import java.awt.*;



public class connexion {

    private ServerSocket serverSocket;
    private int port = 11111 ;
    private DataInputStream entree;
    private PrintStream sortie;
    private reception rc;
    private String nomClient;
    
    
    
    public connexion(TextArea chat,String nom) 
    {
    	
    	
    	try 
    	{
      		serverSocket = new ServerSocket(port) ;
      		 
      			
        			
        			Socket socket = serverSocket.accept() ;
        			
        			
        			
        			entree=new DataInputStream(socket.getInputStream());
        			sortie=new PrintStream(socket.getOutputStream());
        			
        			nomClient=entree.readLine();
        			sortie.println(nom);sortie.flush();
        			chat.setText(chat.getText()+"Vous êtes connecté avec "+nomClient+"\nDébut de la discussion...\n");
        			

        			rc=new reception(entree,chat,nomClient);
        			
        			//System.out.println(entree.readLine());
        			
        			//System.out.println("client connecté");
        
        			
        		
        }
        
    	catch(IOException e) { System.out.println("problème");}

    	
    	
    }
    
    
    public PrintStream recupererSortie()
    {
    	return sortie;
    	
    }
    
    
}