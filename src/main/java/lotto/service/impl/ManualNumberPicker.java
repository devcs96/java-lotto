package lotto.service.impl;

import lotto.model.LottoBall;
import lotto.service.LottoNumberPicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualNumberPicker implements LottoNumberPicker {

    private final static String DEFAULT_DELIMITER = ",";
    private final BufferedReader bufferedReader;

    public ManualNumberPicker(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public List<LottoBall> pick() {
        try {
            return Arrays.stream(this.bufferedReader.readLine().split(DEFAULT_DELIMITER))
                    .map((num) -> new LottoBall(Integer.valueOf(num.trim())))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 입력 번호는 숫자여야만 합니다.", e);
        }
    }
}
