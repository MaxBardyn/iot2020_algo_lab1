package lab1;

import lombok.Data;

import java.util.List;

@Data
public class SortMethods {

    public static int selectionSwapCounter;
    public static int selectionCompareCounter;
    public static double selectionTimeInMillis;

    public static int quickSwapCounter;
    public static int quickCompareCounter;
    public static double quickTimeInMillis;

    public static void selectionSortInsectsBySpeedDesc(List<Insect> insectArray) {
        long startTime = System.nanoTime();
        for (int i = 0; i < insectArray.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < insectArray.size(); j++) {
                if (insectArray.get(j).getSpeed() > insectArray.get(minIndex).getSpeed())
                    minIndex = j;
                swap(insectArray, minIndex, i);
                selectionSwapCounter++;
            }
            selectionCompareCounter++;
        }
        selectionTimeInMillis = (System.nanoTime() - startTime) / 1000D;
    }

    public static void quickSortInsectByWeightDesc(List<Insect> insectList) {
        long startTime = System.nanoTime();
        quickSort(insectList, 0, insectList.size() - 1);
        quickTimeInMillis = (System.nanoTime() - startTime) / 1000D;
    }

    private static void quickSort(List<Insect> insectList, int low, int high) {
        if (low < high + 1) {
            int p = partition(insectList, low, high);
            quickSort(insectList, low, p - 1);
            quickSort(insectList, p + 1, high);
        }
    }

    private static int partition(List<Insect> insectList, int low, int high) {
        swap(insectList, low, getPivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high; i++) {
            if (insectList.get(i).getWeight() < insectList.get(low).getWeight()) {
                swap(insectList, i, border++);
                quickSwapCounter++;
            }
            quickCompareCounter++;
        }
        swap(insectList, low, border - 1);
        quickSwapCounter += 2;
        return border - 1;
    }

    private static int getPivot(int low, int high) {
        return (low + high) / 2;
    }

    private static void swap(List<Insect> array, int currentElement, int elementToSwap) {
        Insect temp = array.get(currentElement);
        array.set(currentElement, array.get(elementToSwap));
        array.set(elementToSwap, temp);
    }
}
