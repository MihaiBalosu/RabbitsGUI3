package player;

import java.util.List;

public interface EnemyRole {

    boolean hasSamePositionAs(PlayerRole player);

    void attack(PlayerRole player);

    int getX();

    int getY();

    void searchFor(PlayerRole player);

    void turn(List<PlayerRole> copyList);
}
 