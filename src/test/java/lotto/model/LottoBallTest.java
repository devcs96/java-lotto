package lotto.model;

import lotto.service.LottoNumberPicker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoBallTest {

    @Test
    void shouldValidateLottoBall(){
        Assertions.assertThatThrownBy(()->LottoBall.noBonusBall(LottoNumberPicker.MAX_BOUND_NUM)).isInstanceOf(IllegalArgumentException.class);
    }
}