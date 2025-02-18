package ru.netology;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {

    private int volume;  // Уровень громкости
    private int radioStationNumber;  // Текущая радиостанция
    private int amountRadioStation = 9;  // Кол-во радиостанций


       // Конструктор класса, который задает нужное количество радиостанций
    public Radio(int amountRadioStation) {
        this.amountRadioStation = amountRadioStation - 1;
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
