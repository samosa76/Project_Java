package Controller;
// Create monster and Action for user

import Model.Characters;
import Model.Monster;

public class Controller {
    public static class PlayGame {
        //get level for creating monster
        private String level;

        //Get current monster
        private Monster.SummonMonster currentMonster;

        //Get char attribute
        private Characters.Character character;

        //constructor PlayGame
        public PlayGame(String level) {
            this.level = level;
            this.currentMonster = monster();
        }

        //displaying character info
        public void createCharacter(){
            this.character = new Characters.Create();
            this.character.startGame();
            System.out.println(this.character.getStatus());
        }


        //summon monster 
        public Monster.SummonMonster monster() {
            System.out.println("You've encounter a Monster....\n");
            Monster.MonsterBuilder monsterBuilder = new Monster.MonsterBuilder();
            Monster.SummonMonster monster = null;

            switch (level) {
                case "1":
                    monster = monsterBuilder.summonSlime();
                    break;
                case "2":
                    monster = monsterBuilder.summonBandit();
                    break;
                default:
                    break;
            }
            return monster;
        }

        public Actions.Action player(String option) {
            Actions.ActionOptions test = new Actions.ActionOptions(currentMonster);
            Actions.Action action = test.getAttackOptions("slash");
            Actions.Action action2 = test.getAttackOptions("skill");
            if (option.equalsIgnoreCase("skill")) {
                return action2;
            }else {
                return action;
            }
        }

    }
}
