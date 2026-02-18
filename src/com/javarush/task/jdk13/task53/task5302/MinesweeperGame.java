package com.javarush.task.jdk13.task53.task5302;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;  //  переменная константа задающаая размер поля
    private GameObject gameField[][] = new GameObject[SIDE][SIDE];  //  масиив ячеек
    private int countMinesOnField; //  счетчик мин
    private static final String MINE = "\uD83D\uDCA3"; //  символ мины

    private void openTile(int x, int y){  //  метод открытия ячейки
        GameObject gameObject = gameField[y][x]; //  получаем объект из ячейки массива
        if (gameObject.isMine){
            setCellValue(gameObject.x,gameObject.y,MINE);  // если ячейка заминирована, рисуем мину
        } else setCellNumber(x,y,gameObject.countMineNeighbors); //иначе показываем колличество соседей заминированных
        gameObject.isOpen = true; //  отрисовываем ячейку зеленым если она открыта
        setCellColor(x,y,Color.GREEN);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {  //  переопределяем метод
        openTile(x,y);
    }

    private void createGame() {  //  создали метод
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) { //  прошлись циклом по массиву
                int randomNumber = getRandomNumber(10); //  генерируем рандом
                boolean isMine = randomNumber < 1;  //  вероятность 10%
                if (isMine) {
                    countMinesOnField++;  //  счетчик мин
                }
                gameField[y][x] = new GameObject(x, y, isMine);  //  присвоили значения ячейкам
                setCellColor(x, y, Color.ORANGE);  //  закрасили ячейки
            }
        }
        countMineNeighbors(); //  вызываем метод получения заминированных соседей
    }


    public void initialize() {
        setScreenSize(SIDE, SIDE);  // задаем размер игрового поля
        createGame();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {  //  метод для получения списка соседей
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }


    private void countMineNeighbors() {  //  метод для получения заминированных соседей
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {  //  проходимся циклом
                GameObject gameObject = gameField[y][x];  //  извлекаем обьект из ячейки
                if (!gameObject.isMine) {  //  если объект не заминирован
                    for (GameObject neighbor : getNeighbors(gameObject)) {  //  перебираем всех соседей текущей ячейки
                        if (neighbor.isMine) {  //  если сосед заминирован
                            gameObject.countMineNeighbors++;  //  увеличиваем счетчик
                        }
                    }
                }
            }

        }
    }

}