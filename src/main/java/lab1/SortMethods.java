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
        if (low < high) {
            int pi = partition(insectList, low, high);
            quickSort(insectList, low, pi - 1);
            quickSort(insectList, pi + 1, high);
        }
    }

    private static int partition(List<Insect> insectList, int low, int high) {
        float pivot = insectList.get(high).getWeight();
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (insectList.get(j).getWeight() > pivot) {
                i++;
                swap(insectList, i, j);
                quickSwapCounter++;
            }
            quickCompareCounter++;
        }
        // swap arr[i+1] and arr[high] (or pivot)
        swap(insectList, i + 1, high);
        quickSwapCounter++;

        return i + 1;
    }

    private static void swap(List<Insect> array, int firstElement, int secondElement) {
        Insect temp = array.get(firstElement);
        array.set(firstElement, array.get(secondElement));
        array.set(secondElement, temp);
    }
}
