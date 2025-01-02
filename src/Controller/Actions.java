package Controller;
import Model.Monster;

public class Actions {

    public static interface Action {
        //default method for action
        void Attack();
    }

    public static class ActionOptions {
        //declare SummonMonster class to get all monster Attribut

        /* declaring this Summon here are to make a dynamic attribut which is can change every time attack method used */

        private Monster.SummonMonster monster;

        public ActionOptions(Monster.SummonMonster monster) {
            this.monster = monster;
        }

        public Action getAttackOptions(String attackOption){
            if (attackOption == null) {
                return null;
            }
            
            if (attackOption.equalsIgnoreCase("slash")) {
                return new Slash(monster);
            } else if (attackOption.equalsIgnoreCase("skill")) {
                return new Skill(monster);
            }
            
            return null;
        }
    }

    public static class Slash implements Action {
        //Instan
        private Monster.SummonMonster monster;

        public Slash(Monster.SummonMonster monster) {
            this.monster = monster;
        }
        @Override
        public void Attack() {
            monster.decreaseHp(5);
            if (monster.getHp() >= 0) {
                System.out.println("-----------------------");
                System.out.println("\nUse Normal Attack... \n");
                monster.showMonsters();
                System.out.println("-----------------------");
            } else {
                System.out.println("CONGRATULATIONS");
            }
            
        }
    }

    public static class Skill implements Action {
        private Monster.SummonMonster monster;
        
        public Skill(Monster.SummonMonster monster) {
            this.monster = monster;
        }

        @Override
        public void Attack() {
            monster.decreaseHp(20);
            if (monster.getHp() >= 0) {
                System.out.println("-----------------------");
                System.out.println("\nUse Fireball.. \n");
                monster.showMonsters();
                System.out.println("-----------------------");
            } else {
                System.out.println("CONGRATULATIONS");
            }
        }
        
    }
}