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

        switch (enter) {
            case ("1"): {
                ReverseString revString = new ReverseString();
//                revString.enterString();
                revString.reverseString();
            }
            break;
            case ("2"): {
                ReverseString revString = new ReverseString();
//                revString.enterString();
                revString.reverseSubstringInString();
            }
            break;
            case ("3"): {
                ReverseString revString = new ReverseString();
//                revString.enterString();
                revString.reverseStringByIndex();
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
