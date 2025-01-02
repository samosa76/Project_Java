import Controller.Actions;
import Controller.Controller;
import Model.Monster;

public class App {
    public static void main(String[] args) throws Exception {

        //Starting Message
        System.out.println("Welocme Adventure....");


        //Setup Level to make a monster per level
        Controller.PlayGame level1 = new Controller.PlayGame("1");

        //Make a new Character using BufferedReader
        level1.createCharacter();

        //Make a monster by level
        Monster.SummonMonster monster = level1.monster();

        //showing monster
        monster.showMonsters();


        //Option Attack to decrease monster hp
        Actions.Action playerSkill = level1.player("skill");
        // Actions.Action playerSlash = level1.player("slash");

        playerSkill.Attack();
        playerSkill.Attack();
        playerSkill.Attack();
        playerSkill.Attack();
        playerSkill.Attack();

        // playerSlash.Attack();
    }

    

}
