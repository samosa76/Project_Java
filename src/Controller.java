public class Controller {
    public static class PlayGame {
        private String level;
        private Monster.SummonMonster currentMonster;
        private Characters.Character character;

        public PlayGame(String level) {
            this.level = level;
            this.currentMonster = monster();
        }

        public void createCharacter(){
            this.character = new Characters.Create();
            this.character.startGame();
            System.out.println(this.character.getStatus());
        }

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
