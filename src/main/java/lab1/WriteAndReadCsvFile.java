
package lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadCsvFile {


    protected static List<Insect> getDataFromFile() {

        var file = new File("insect.csv");
        List<Insect> insectList = new ArrayList<>();

        if (!file.exists()) {
            createFileWithInsectData();
        }
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {

            String line;
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(",");
                insectList.add(new Insect(tokens[0], Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return insectList;
    }

    private static void createFileWithInsectData() {

        var insectList = createInsectList();

        try (FileWriter fileWriter = new FileWriter("insect.csv")) {

            fileWriter.write(Insect.getHeaders() + "\n");

            for (Insect insect : insectList) {
                fileWriter.write(insect.toCSV());
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Insect> createInsectList() {
        List<Insect> insectList = new ArrayList<>();
        insectList.add(new Insect("Insect1", 1F, 3F));
        insectList.add(new Insect("Insect2", 2F, 25F));
        insectList.add(new Insect("Insect3", 0.5F, 31F));
        insectList.add(new Insect("Insect4", 0.7F, 3F));
        insectList.add(new Insect("Insect5", 0.1F, 30F));
        insectList.add(new Insect("Insect6", 5F, 23F));
        insectList.add(new Insect("Insect7", 0.3F, 30F));
        insectList.add(new Insect("Insect8", 0.7F, 60F));
        insectList.add(new Insect("Insect9", 0.4F, 12F));
        insectList.add(new Insect("Insect10", 1F, 18F));
        return insectList;
    }
}
