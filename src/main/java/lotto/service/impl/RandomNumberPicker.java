package lotto.service.impl;


import lotto.model.LottoBall;
import lotto.service.LottoNumberPicker;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class RandomNumberPicker implements LottoNumberPicker {

    private static final int MAX_BOUND_NUM = 100;
    private final List<Integer> source = IntStream.range(0, MAX_BOUND_NUM).boxed().collect(Collectors.toList());

    @Override
    public List<LottoBall> pick() {
        Collections.shuffle(this.source);
        return this.source.subList(0, LottoNumberPicker.LOTTO_LENGTH).stream().map(LottoBall::noBonusBall).collect(Collectors.toList());
    }
}
