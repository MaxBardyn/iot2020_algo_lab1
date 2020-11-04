package lab1;

import java.util.List;

import static lab1.SortMethods.*;

public class Main {

    public static void main(String[] args) {
        List<Insect> dataFromFile = WriteAndReadCsvFile.getDataFromFile();

        selectionSortInsectsBySpeedDesc(dataFromFile);

        System.out.println("Selection Algorithm");
        System.out.println("Work time: " + selectionTimeInMillis);
        System.out.println("Swaps: " + selectionSwapCounter);
        System.out.println("Comparisons: " + selectionCompareCounter);
        for (Insect insect : dataFromFile) {
            System.out.println(insect);
        }

        System.out.println("========================================================================");

        quickSortInsectByWeightDesc(dataFromFile);

        System.out.println("Quick Algorithm");
        System.out.println("Work time: " + quickTimeInMillis);
        System.out.println("Swaps: " + quickSwapCounter);
        System.out.println("Comparisons: " + quickCompareCounter);
        for (Insect insect : dataFromFile) {
            System.out.println(insect);
        }
    }
}