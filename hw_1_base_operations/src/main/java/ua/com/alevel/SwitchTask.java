package ua.com.alevel;

import java.io.IOException;

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
                SumOfNumbers sumOfNumbers = new SumOfNumbers();
                sumOfNumbers.run();
            }
            break;
            case ("2"): {
                SearchForCharactersAndNumberOfRepetitions searchForCharactersAndNumberOfRepetitions = new SearchForCharactersAndNumberOfRepetitions();
                searchForCharactersAndNumberOfRepetitions.run();
            }
            break;
            case ("3"): {
                EndLessonTime endLessonTime = new EndLessonTime();
                endLessonTime.run();
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
    }
}
