import java.util.Scanner;// Import la classe scanner
// celle ci nous servira a lire les entrees de l'utilisateur

public class User extends Player {
 private static final Scanner scan=new Scanner(System.in); 

    @Override
    
 public  void play(Game game) {
     //un message est envoyer orsque le jeu prend fin
   if(game.getRound() == game.getRows()*game.getColumns()){
     System.out.println("Game is finished already!");
   }
     // VOTRE CODE ICI
     
//on verifie si le jeu est jouable
   if(game.getGameState() != GameState.PLAYING)
   {
       System.out.println("Vous ne pouvez pas jouer pour le moment");
       return;
   }
   
   //Affiche le symbole de joueur actuel
   System.out.println("Tour du joueur " + mySymbol);
   System.out.println(game);
   
   // une boucle ce declanche afin d'entrer une valeur valide
   int index;
   while (true){
       //try catch ici utiliser pour gerer les exceptions
       try 
        {
        System.out.println("Entrez l'index de la case (0-"+ (game.getRows()*game.getColumns()-1)+"):");
        String input = scan.nextLine(); // Lit l'entree de l'utilisateur 
        index=Integer.parseInt(input);//Convertit l'entree en entier
        if(index >= 0 && index < game.getRows() * game.getColumns() && game.boxSymbolAt(index) == BoxSymbol.EMPTY)
        {
            game.play(index); //joue le coup
            break;// On sort de la boucle
        }
        else{ System.out.println("Index invalide Reessayer");
        }
        } 
        catch (NumberFormatException e) // une exception sur la variable e
                {
                System.out.println("Entree invalide");
                }
       }
   }
}