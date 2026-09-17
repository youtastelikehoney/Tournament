import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    Game game = new Game();

    @Test
    void shouldThrowExceptionWhenFirstPlayerNotRegistered() {
        Player player1 = new Player(1, "Anna2006", 38);
        Player player2 = new Player(2, "Sanek", 54);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anna2006", "Sanek");

        });

    }

    @Test
    void shouldThrowExceptionWhenSecondPlayerNotRegistered() {
        Player player1 = new Player(1, "Anna2006", 38);
        Player player2 = new Player(2, "Sanek", 54);
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anna2006", "Sanek");
        });

    }

    @Test
    void shouldThrowExceptionWhenBothPlayersNotRegistered() {
        Player player1 = new Player(1, "Anna2006", 38);
        Player player2 = new Player(2, "Sanek", 54);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anna2006", "Sanek");

        });

    }

    @Test
    void shouldReturn1WhenFirstPlayerStronger() {
        Player player1 = new Player(1, "Anna2006", 78);
        Player player2 = new Player(2, "Sanek", 54);
        game.register(player1);
        game.register(player2);
        Assertions.assertEquals(1, game.round("Anna2006", "Sanek"));
    }

    @Test
    void shouldReturn2WhenSecondPlayerStronger() {
        Player player1 = new Player(1, "Anna2006", 35);
        Player player2 = new Player(2, "Sanek", 66);
        game.register(player1);
        game.register(player2);
        Assertions.assertEquals(2, game.round("Anna2006", "Sanek"));
    }

    @Test
    void shouldReturn0WhenStrengthsEqual() {
        Player player1 = new Player(1, "Anna2006", 75);
        Player player2 = new Player(2, "Sanek", 75);
        game.register(player1);
        game.register(player2);
        Assertions.assertEquals(0, game.round("Anna2006", "Sanek"));
    }


}
