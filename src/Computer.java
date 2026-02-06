import java.util.Random;

public class Computer extends Player {

    private static final Random rand=new Random(); 
    
 public  void play(Game game) {
   if(game.getRound() == game.getRows()*game.getColumns()){
     System.out.println("Game is finished already!");
   }

   // VOTRE CODE ICI
System.out.println("Tour du joueur " + mySymbol);
   System.out.println(game);
   // une boucle ce declanche afin d'entrer une valeur valide
   int index;
   while (true){
       //try catch ici utiliser pour gerer les exceptions
       try 
        {
        index=rand.nextInt(9)+1; //l'ordinateur choisi une valeur entre 0 et 8
        if(index >= 0 && index < game.getRows() * game.getColumns() && game.boxSymbolAt(index) == BoxSymbol.EMPTY)
        {
            game.play(index); //joue le coup
            break;// On sort de la boucle
        }
        else{ System.out.println("Index invalide Reessayer");
        }
        } 
        catch (NumberFormatException e)
                {
                System.out.println("Entree invalide");
                }
       }
   }
}