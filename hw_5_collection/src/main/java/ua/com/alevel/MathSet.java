package ua.com.alevel;

import java.util.Objects;

public class MathSet {
    private Number[] elementData;
    private int countOfElements = 0;
    private boolean isFixedCountElements = false;
    private final int DEFAULT_SIZE = 10;

    public MathSet() {
        elementData = new Number[DEFAULT_SIZE];
        isFixedCountElements = false;
    }

    public MathSet(int capacity) {
        elementData = new Number[capacity];
        isFixedCountElements = true;
    }

    public MathSet(Number[] numbers) {
        elementData = new Number[numbers.length];
        for (Number number : numbers) {
            add(number);
        }
    }

    public MathSet(Number[]... numbers) {
        int length = 0;
        for (Number[] elementOfNumbers : numbers) {
            length += elementOfNumbers.length;
        }
        elementData = new Number[length];
        for (Number[] number : numbers) {
            for (Number value : number) {
                add(value);
            }
        }
    }

    public MathSet(MathSet numbers) {
        elementData = numbers.toArray();
        countOfElements = elementData.length;
    }

    public MathSet(MathSet... numbers) {
        int lenght = 0;
        for (MathSet mathSets : numbers) {
            lenght += mathSets.toArray().length;
        }
        elementData = new Number[lenght];
        for (MathSet mathSet : numbers) {
            for (Number value : mathSet.toArray()) {
                add(value);
            }
        }
    }

    protected Number[] toArray() {
        return elementData;
    }

    public int getCountOfElements() {
        return countOfElements;
    }

    public Number getElement(int index) {
        if (index >= 0 && index <= elementData.length) {
            return elementData[index - 1];
        }
        return null;
    }

    public boolean consistElement(Number number) {
        for (Number element : elementData) {
            if (Objects.nonNull(element) && element.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public void add(Number number) {
        if (!isFixedCountElements) { //когда созданный MathSet динамический
            if (countOfElements == elementData.length) {
                Number[] tmp = elementData;
                elementData = new Number[elementData.length + (elementData.length * 2 / 3 + 1)];
                for (int i = 0; i < tmp.length; i++) {
                    if (elementData[i] == null && !consistElement(number)) {
                        elementData[i] = tmp[i];
                    }
                }
                elementData[countOfElements] = number;
            } else {
                for (int i = 0; i < elementData.length; i++) {
                    if (elementData[i] == null && !consistElement(number)) {
                        elementData[i] = number;
                    }
                }
            }
            countOfElements++;
        } else { //когда созданный MathSet статический
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == null && !consistElement(number)) {
                    elementData[i] = number;
                    countOfElements++;
                    break;
                }
            }
        }
    }

    void sortDesc() {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 0; i < elementData.length; i++) {
                if (i == countOfElements - 1) {
                    break;
                }
                if (elementData[i] != null && elementData[i + 1] != null && ((int) elementData[i + 1] < (int) elementData[i])) {
                    swap(elementData, i + 1, i);
                    needIteration = true;
                }
            }
        }
    }

    void sortDesc(int firstIndex, int lastIndex) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = firstIndex - 1; i < lastIndex - 1; i++) {
                if (i == countOfElements - 1) {
                    break;
                }
                if (elementData[i] != null && elementData[i + 1] != null && ((int) elementData[i + 1] < (int) elementData[i])) {
                    swap(elementData, i + 1, i);
                    needIteration = true;
                }
            }
        }
    }

    void sortDesc(int index) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = index - 1; i < elementData.length; i++) {
                if (i == countOfElements - 1) {
                    break;
                }
                if (elementData[i] != null && elementData[i + 1] != null && ((int) elementData[i + 1] < (int) elementData[i])) {
                    swap(elementData, i + 1, i);
                    needIteration = true;
                }
            }
        }
    }

    void sortAsc() {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 0; i < elementData.length; i++) {
                if (i == countOfElements - 1) {
                    break;
                }
                if (elementData[i] != null && elementData[i + 1] != null && ((int) elementData[i + 1] > (int) elementData[i])) {
                    swap(elementData, i + 1, i);
                    needIteration = true;
                }
            }
        }
    }

    void sortAsc(int firstIndex, int lastIndex) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = firstIndex - 1; i < lastIndex - 1; i++) {
                if (i == countOfElements - 1) {
                    break;
                }
                if (elementData[i] != null && elementData[i + 1] != null && ((int) elementData[i + 1] > (int) elementData[i])) {
                    swap(elementData, i + 1, i);
                    needIteration = true;
                }
            }
        }
    }

    void sortAsc(int index) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = index - 1; i < elementData.length; i++) {
                if (i == countOfElements - 1) {
                    break;
                }
                if (elementData[i] != null && elementData[i + 1] != null && ((int) elementData[i + 1] > (int) elementData[i])) {
                    swap(elementData, i + 1, i);
                    needIteration = true;
                }
            }
        }
    }

    private void swap(Number[] array, int i, int j) {
        Number tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void join(MathSet joinMathSet) {
        for (Number element : joinMathSet.toArray()) {
            add(element);
        }
    }

    public void join(MathSet... mathSets) {
        for (MathSet mathSet : mathSets) {
            for (Number element : mathSet.toArray()) {
                add(element);
            }
        }
    }

    public Number getMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < elementData.length; i++) {
            if ((int) elementData[i] > max) {
                max = (int) elementData[i];
            }
        }
        return max;
    }

    public Number getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < elementData.length; i++) {
            if ((int) elementData[i] < min) {
                min = (int) elementData[i];
            }
        }
        return min;
    }

    public Number getAverage() {
        double average = 0.0;
        double sum = 0.0;
        for (int i = 0; i < elementData.length; i++) {
            sum += (int) elementData[i];
            average = sum / (i + 1);
        }
        return average;
    }

    public Number getMedian() {
        Number median;
        if (elementData.length % 2 == 0) {
            median = ((int) elementData[elementData.length / 2] + (int) elementData[elementData.length / 2 - 1]) / 2;
        } else {
            median = elementData[elementData.length / 2];
        }
        return median;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Number elementDatum : elementData) {
            if (elementDatum != null) {
                stringBuilder.append(elementDatum).append(", ");
            }
        }
        if (stringBuilder.length() > 2) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
        }
        return "Ваш MathSet содержит элементы: \n" +
                "[" + stringBuilder + "]";
    }
}