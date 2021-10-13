package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchTask {
    private String enter;

    public SwitchTask(String enter) {
        this.enter = enter;
    }

    public void setEnter(String enter) {
        this.enter = enter;
    }

    public void run() throws IOException {
//        BufferedReader readerNumberTask = new BufferedReader(new InputStreamReader(System.in));
//        String numberTask = readerNumberTask.readLine();

        switch (enter) {
            case ("1"): {
                Task1 task1 = new Task1();
                task1.run();
            }
            break;
            case ("2"): {
                Task2 task2 = new Task2();
                task2.run();
            }
            break;
            case ("3"): {
                Task3 task3 = new Task3();
                task3.run();
            }
            break;
            case ("0"): {
                System.exit(0);
            }
            break;
            default: {
                System.out.println("Такой задачи не существует");
            }
            break;
        }
//        readerNumberTask.close();
    }
}
