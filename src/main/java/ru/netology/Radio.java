package ru.netology;

public class Radio {

    private int volume;
    private int radioStationNumber;


    // Проверка текущего уровня громкости
    public int getVolume() {
        return this.volume;
    }

    // Проверка текущего номера радиостанции
    public int getRadioStationNumber() {
        return this.radioStationNumber;
    }

    // Установка номера радиостанции вручную
    public void setRadioStationNumber(int newRadioStationNumber) {
        if (newRadioStationNumber < 0 || newRadioStationNumber > 9) {
            return;
        }
        this.radioStationNumber = newRadioStationNumber;
    }

    // Переключение на следующую радиостанцию
    public void nextRadioStationNumber() {
        if (this.radioStationNumber == 9) {
            this.radioStationNumber = 0;
            return;
        }
        this.radioStationNumber++;
    }

    // Переключение на предыдущую радиостанцию
    public void prevRadioStationNumber() {
        if (this.radioStationNumber == 0) {
            this.radioStationNumber = 9;
            return;
        }
        this.radioStationNumber--;
    }

    // Увеличение громкости звука
    public void increaseVolume() {
        if (this.volume < 100)
            this.volume++;
    }

    // Уменьшение громкости звука
    public void decreaseVolume() {
        if (this.volume > 0)
            this.volume--;
    }

}
