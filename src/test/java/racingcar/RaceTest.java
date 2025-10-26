package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.*;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class RaceTest {

    @Test
    void 가장_거리값이_큰_자동차가_우승자() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.move(5);
        woni.move(3);
        jun.move(6);
        jun.move(7);

        Race race = new Race(List.of(pobi, woni, jun));

        List<String> winners = race.findWinner();

        assertThat(winners).containsExactly("jun");
    }

    @Test
    void 동점자가_있다면_모두_우승자() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        pobi.move(5);
        woni.move(6);

        Race race = new Race(List.of(pobi, woni));

        List<String> winners = race.findWinner();

        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }
}
