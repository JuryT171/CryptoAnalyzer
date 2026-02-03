package com.javarush.task.pro.task11.task1107;

/* 
Двигатель — сердце автомобиля
*/

public class Car {
    //напишите тут ваш код
    Engine engine = new Engine();
    class Engine{
        private boolean isRunning;

        public void start(){   //  передаем значение true методу start
         this.isRunning=true;
        }
        public void stop(){   //  передаем значение false методу stop
          this.isRunning=false;
        }
    }
}
