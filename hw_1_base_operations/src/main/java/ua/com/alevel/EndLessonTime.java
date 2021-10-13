package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EndLessonTime {
    public void run() throws IOException {
        //создаем map в котором будем хранить в ключе номер урока, а в значении объект у которого два поля (часы и минуты)
        Map<String, LessonTime> lessonsByTime = new HashMap<>();
        lessonsByTime.put("1", new LessonTime(9,45));
        lessonsByTime.put("2", new LessonTime(10,35));
        lessonsByTime.put("3", new LessonTime(11,35));
        lessonsByTime.put("4", new LessonTime(12,25));
        lessonsByTime.put("5", new LessonTime(13,25));
        lessonsByTime.put("6", new LessonTime(14,15));
        lessonsByTime.put("7", new LessonTime(15,15));
        lessonsByTime.put("8", new LessonTime(16,5));
        lessonsByTime.put("9", new LessonTime(17,5));
        lessonsByTime.put("10", new LessonTime(17,55));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ведите номер урока (от 1 до 10) который вас интересует:");
        String lesson = reader.readLine();

        //создаем объект и передаем в него ключ
        LessonTime needLesson = lessonsByTime.get(lesson);

        //через геттеры выводим нужные нам значения часов и минут
        System.out.print("Урок под номером: " + lesson + " закончится в: ");
        System.out.println(needLesson.getHour() + " " + needLesson.getMinutes());

    }
}
