package ru.netology;

public class Radio {

    private int volume;  // Уровень громкости
    private int radioStationNumber;  // Текущая радиостанция
    private int amountRadioStation;  // Кол-во радиостанций


    // Пустой конструктор класса
    public Radio() {
        this.amountRadioStation = 9;  // Устанавливаем количество радиостанций по умолчанию (10)
    }

    // Конструктор класса, который задает нужное количество радиостанций
    public Radio(int amountRadioStation) {
        this.amountRadioStation = amountRadioStation - 1;
    }

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
        if (newRadioStationNumber < 0 || newRadioStationNumber > this.amountRadioStation) {
            return;
        }
        this.radioStationNumber = newRadioStationNumber;
    }

    // Переключение на следующую радиостанцию
    public void nextRadioStationNumber() {
        if (this.radioStationNumber == this.amountRadioStation) {
            this.radioStationNumber = 0;
            return;
        }
        this.radioStationNumber++;
    }

    // Переключение на предыдущую радиостанцию
    public void prevRadioStationNumber() {
        if (this.radioStationNumber == 0) {
            this.radioStationNumber = this.amountRadioStation;
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
