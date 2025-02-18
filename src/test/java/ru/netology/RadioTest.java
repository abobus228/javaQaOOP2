package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    Radio radio = new Radio();
    Radio radioAmount = new Radio(20);


    @Test  // Установка вручную валидного номера радиостанции
    public void shouldSetRadioStationNumber() {

        radio.setRadioStationNumber(5);

        int expected = 5;
        int actual = radio.getRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test  // Установка вручную номера радиостанции при указании своего диапазона станций
    public void shouldSetRadioStationNumberInObjectWithAmountRadio() {

        radioAmount.setRadioStationNumber(15);

        int expected = 15;
        int actual = radioAmount.getRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test  // Установка вручную невалидного номера радиостанции при указании своего диапазона станций
    public void shouldNotSetRadioStationNumberAboveMaxInObjectWithAmountRadio() {

        radioAmount.setRadioStationNumber(20);

        int expected = 0;
        int actual = radioAmount.getRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test  // Установка вручную невалидного номера радиостанции (больше 9 и меньше 0)
    public void shouldNotSetRadioStationNumberAboveMaxAndBelowMin() {
        Radio radioAboveMax = new Radio();
        Radio radioBelowMin = new Radio();

        radioAboveMax.setRadioStationNumber(11);
        radioBelowMin.setRadioStationNumber(-2);

        int expected = 0;
        int actualAboveMax = radioAboveMax.getRadioStationNumber();
        int actualBelowMin = radioBelowMin.getRadioStationNumber();

        Assertions.assertEquals(expected, actualAboveMax);
        Assertions.assertEquals(expected, actualBelowMin);
    }

    @Test  // Проверка на граничное значение установки номера радиостанции (Валидное)
    public void shouldSetRadioStationNumberBorderValueCorrect() {

        // Нижняя граница значений
        radio.setRadioStationNumber(0);
        radioAmount.setRadioStationNumber(0);

        int expected = 0;
        int actual = radio.getRadioStationNumber();
        Assertions.assertEquals(expected, actual);
        // Проверка с установкой своего диапазона
        actual = radioAmount.getRadioStationNumber();
        Assertions.assertEquals(expected, actual);


        radio.setRadioStationNumber(1);
        radioAmount.setRadioStationNumber(1);

        expected = 1;
        actual = radio.getRadioStationNumber();
        Assertions.assertEquals(expected, actual);
        // Проверка с установкой своего диапазона
        actual = radioAmount.getRadioStationNumber();
        Assertions.assertEquals(expected, actual);

        // Верхняя граница значений
        radio.setRadioStationNumber(9);
        expected = 9;
        actual = radio.getRadioStationNumber();
        Assertions.assertEquals(expected, actual);

        radio.setRadioStationNumber(8);
        expected = 8;
        actual = radio.getRadioStationNumber();
        Assertions.assertEquals(expected, actual);

        // Верхняя граница значений у объекта с установленным количеством радиостанций
        radioAmount.setRadioStationNumber(19);
        expected = 19;
        actual = radioAmount.getRadioStationNumber();
        Assertions.assertEquals(expected, actual);

        radioAmount.setRadioStationNumber(18);
        expected = 18;
        actual = radioAmount.getRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test  // Проверка на граничное значение установки номера радиостанции (Невалидное)
    public void shouldNotSetRadioStationNumberBorderValueNotCorrect() {

        // Нижняя граница значения (ниже 0)
        radio.setRadioStationNumber(-1);
        int expected = 0;
        int actual = radio.getRadioStationNumber();
        Assertions.assertEquals(expected, actual);

        // Верхняя граница значение (выше 9)
        radio.setRadioStationNumber(10);
        expected = 0;
        actual = radio.getRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test  // Переключение на следующую радиостанцию (если ее значение меньше последней)
    public void shouldNextRadioStationNumberBelowMax() {

        radio.setRadioStationNumber(4);
        radio.nextRadioStationNumber(); // Следующая радиостанция

        int expected = 5;
        int actual = radio.getRadioStationNumber();

        Assertions.assertEquals(expected, actual);


        // Проверка переключения при установке диапазона вручную
        radioAmount.setRadioStationNumber(14);
        radioAmount.nextRadioStationNumber(); // Следующая радиостанция

        expected = 15;
        actual = radioAmount.getRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test  // Переключение на следующую радиостанцию (если ее значение было равно последней)
    public void shouldNextRadioStationNumberAboveMax() {

        radio.setRadioStationNumber(9);  // Последняя радиостанция в списке
        radio.nextRadioStationNumber();  // Следующая радиостанция

        int expected = 0;
        int actual = radio.getRadioStationNumber();

        Assertions.assertEquals(expected, actual);


        // Проверка переключения при установке диапазона вручную
        radioAmount.setRadioStationNumber(19);
        radioAmount.nextRadioStationNumber(); // Следующая радиостанция

        actual = radioAmount.getRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test  // Переключение на предыдущую радиостанцию (если ее значение выше начальной - 0)
    public void shouldPrevRadioStationNumberAboveMin() {

        radio.setRadioStationNumber(4);
        radio.prevRadioStationNumber(); // Предыдущая радиостанция

        int expected = 3;
        int actual = radio.getRadioStationNumber();

        Assertions.assertEquals(expected, actual);


        // Проверка переключения при установке диапазона вручную
        radioAmount.setRadioStationNumber(14);
        radioAmount.prevRadioStationNumber(); // Следующая радиостанция

        expected = 13;
        actual = radioAmount.getRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test  // Переключение на предыдущую радиостанцию (если ее значение было равно начальной - 0)
    public void shouldNextRadioStationNumberBelowMin() {

        radio.setRadioStationNumber(0);  // Последняя радиостанция в списке
        radio.prevRadioStationNumber();  // Следующая радиостанция

        int expected = 9;
        int actual = radio.getRadioStationNumber();

        Assertions.assertEquals(expected, actual);


        // Проверка переключения при установке диапазона вручную
        radioAmount.setRadioStationNumber(0);
        radioAmount.prevRadioStationNumber(); // Следующая радиостанция

        expected = 19;
        actual = radioAmount.getRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test  // Увеличение громкости звука (если значение меньше максимального)
    public void shouldIncreaseVolumeBelowMax() {

        for (int i = 0; i < 95; i++) {
            radio.increaseVolume();
        }

        int expected = 95;
        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test  // Увеличение громкости звука (если значение больше максимального)
    public void shouldIncreaseVolumeAboveMax() {

        for (int i = 0; i < 110; i++) {
            radio.increaseVolume();
        }

        int expected = 100;
        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test  // Проверка валидных граничных значений при увеличении звука
    public void shouldIncreaseVolumeBorderValueCorrect() {
        Radio radioMax = new Radio();

        // Ниже граничного значения - 99
        for (int i = 0; i < 99; i++) {
            radio.increaseVolume();
        }
        int expected = 99;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);

        // Граничное значение - 100
        for (int i = 0; i < 100; i++) {
            radioMax.increaseVolume();
        }
        expected = 100;
        actual = radioMax.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test  // Уменьшение громкости звука (если значение выше минимального)
    public void shouldDecreaseVolumeAboveMin() {

        for (int i = 0; i < 10; i++) {
            radio.increaseVolume();
        }
        for (int i = 0; i < 6; i++) {
            radio.decreaseVolume();
        }

        int expected = 4;
        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test  // Уменьшение громкости звука (если значение ниже минимального)
    public void shouldDecreaseVolumeBelowMin() {

        for (int i = 0; i < 10; i++) {
            radio.increaseVolume();
        }
        for (int i = 0; i < 12; i++) {
            radio.decreaseVolume();
        }

        int expected = 0;
        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test  // Проверка валидных граничных значений при уменьшении звука
    public void shouldDecreaseVolumeBorderValueCorrect() {
        Radio radioMin = new Radio();

        // Выше граничного значения - 1
        for (int i = 0; i < 10; i++) {
            radio.increaseVolume();
        }
        for (int i = 0; i < 9; i++) {
            radio.decreaseVolume();
        }
        int expected = 1;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);

        // Граничное значение - 0
        for (int i = 0; i < 10; i++) {
            radioMin.increaseVolume();
        }
        for (int i = 0; i < 10; i++) {
            radioMin.decreaseVolume();
        }
        expected = 0;
        actual = radioMin.getVolume();
        Assertions.assertEquals(expected, actual);
    }
}
