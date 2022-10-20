import java.io.*;
import java.util.*;

public class CSV2JSON {
    public static void main(String[] args) {
        try{
            File csvFile = new File("src/resources/persons.csv");
            String csvFileName = csvFile.getName().substring(0, csvFile.getName().lastIndexOf("."));
            BufferedReader properties = new BufferedReader(new FileReader("src/resources/config.properties"));
            BufferedReader csv = new BufferedReader(new FileReader("src/resources/persons.csv"));
            String[] csvHeading = csv.readLine().toLowerCase().replaceAll("\\s","_").split(",");
            List<String[]> csvValues = new ArrayList<>();

            String csvLine = "";
            while((csvLine = csv.readLine()) != null){
                csvValues.add(csvLine.split(","));
            }
            System.out.println("{");
            System.out.println("    " + csvFileName + ":[");
            for (int i = 0; i < csvValues.size(); i++) {
                String[] strings = csvValues.get(i);
                System.out.println("        {");
                for(int j = 0 ; j < strings.length; j++){
                    if (j != strings.length -1)
                        System.out.println("            \"" + csvHeading[j] + "\"" +  ":" + "\"" + strings[j] + "\"");
                    if (j == strings.length -1)
                        System.out.println("            \"" + csvHeading[j] + "\"" +  ":" +  strings[j] );
                }
                if (i != csvValues.size() -1)
                    System.out.println("        },");
                if (i == csvValues.size() -1)
                    System.out.println("        }");
            }
            System.out.println("    ]");
            System.out.println("}");
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
