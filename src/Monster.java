import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Monster {
    public static interface Stats {
        public String name();

        public int hp();

        public int attack();
    }

    public static abstract class GenerateMonster implements Stats {
        public abstract String name();

        public abstract int hp();

        public abstract int attack();
    }

    public static class Slime extends GenerateMonster {

        @Override
        public String name() {
            return "Slime";
        }

        @Override
        public int hp() {
            return 100;
        }

        @Override
        public int attack() {
            return 2;
        }
    }

    public static class Bandit extends GenerateMonster {

        @Override
        public String name() {
            return "Bandit";
        }

        @Override
        public int hp() {
            return 500;
        }

        @Override
        public int attack() {
            return 20;
        }
    }
    

    public static class SummonMonster {
        private List<Stats> monsters = new ArrayList<Stats>();
        private Map<Stats, Integer> currentHpMap = new HashMap<>();

        public void addMonster(Stats stats) {
            monsters.add(stats);
            currentHpMap.put(stats, stats.hp());
        }

        public int getAttack() {
            for (Stats stats : monsters) {
                return stats.attack();
            }
            return 0;
        }

        public int getHp() {
            int totalHp = 0;
            for (Stats stats : monsters) {
                totalHp += currentHpMap.getOrDefault(stats, stats.hp());
            }
            return totalHp;
        }

        public void decreaseHp(int dmg) {
            for (Stats stats : monsters) {
                int currentHp = currentHpMap.getOrDefault(stats, stats.hp());
                currentHp = Math.max(currentHp - dmg, 0);
                currentHpMap.put(stats, currentHp);

                if (currentHp == 0) {
                    System.out.println("\n!!!Monster " + stats.name() + " is defeated!!!\n");
                }
            }
        }

        public void showMonsters() {
            for (Stats stats : monsters) {
                int currentHp = currentHpMap.getOrDefault(stats, stats.hp());
                System.out.println("Monster : " + stats.name());
                System.out.println("HP : " + currentHp + "/" + stats.hp());
                System.out.println("Attack : " + stats.attack());
            }
        }
    }

    public static class MonsterBuilder {
        public SummonMonster summonSlime() {
            SummonMonster summonMonster = new SummonMonster();
            summonMonster.addMonster(new Slime());
            return summonMonster;
        }

        public SummonMonster summonBandit() {
            SummonMonster summonMonster = new SummonMonster();
            summonMonster.addMonster(new Bandit());
            return summonMonster;
        }
    }
}
