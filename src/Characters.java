import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Characters {
    public static interface Character {
        public String getStatus();

        public int getCharHp();

        public int getCharAttack();

        public void startGame();
    }

    public static class CharacterStats {
        private String name;
        private int hp;
        private int attack;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getAttack() {
            return attack;
        }

        public void setAttack(int attack) {
            this.attack = attack;
        }
    }

    public static class Create extends CharacterStats implements Character {

        @Override
        public String getStatus() {
            String playerName = getName();
            int playerHp = getHp();
            int playerAttack = getAttack();
            return ("-------------------------------\nName : " + playerName + "\nHP : " + playerHp + "\nAttack : " + playerAttack+"\n-------------------------------\n");
        }

        @Override
        public void startGame() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("WHat is your name :");
                String username = br.readLine();
                int hp = 100;
                int attack = 10;

                setName(username);
                setHp(hp);
                setAttack(attack);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getCharHp() {
            int healthPoint = getHp();
            return healthPoint;
        }

        @Override
        public int getCharAttack() {
            int attackPower = getAttack();
            return attackPower;
        }

    }
}
