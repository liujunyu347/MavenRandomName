import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RandomName {
    public static void main(String[] args) {
        RandomName RN = new RandomName();
//        String[] names = readString("names.txt");
        String[] names = new String[]{"Shakur Ahmed", "Prithvi Atani", "Diming Chu", "Sumid Dhungel", "Jason H"
                , "Yan Huang", "Honorine icyitegetse", "Scott Jhou", "Shahriar Kabir", "dongshuo li", "Kun Li",
                "Kelly Liu", "Junyu Liu", "Louisss", "Shahbaz Mansahia", "Ahmed Mujtaba", "Ola Temitope Olanrewaju",
                "shrina Patel", "Siyu Qiu", "TAO TAO", "Abby Truong", "Muhammed Rabiu Umar", "Peiqi Wang", "Samuel Yang"
                , "Richard Zhou"};
        String output = RN.getRandomName(names);
        RN.printOutput(output);
    }

    private void printOutput(String output){
        System.out.println(output);
    }

    public String getRandomName(String[] names){
        int index = getRandom(names.length);
        return names[index];
//        JOptionPane.showMessageDialog(null,
//                names[index],
//                "A Random Student Name",
//                JOptionPane.PLAIN_MESSAGE);
    }

    public String[] readString(String path){
        int count = 0;
        try{
            Scanner s1 = new Scanner(new File(path));
            while(s1.hasNextLine()){
                s1.nextLine();
                count++;
            }

            String[] names = new String[count];
            Scanner s2 = new Scanner(new File(path));
            for (int i = 0; i < count; i++){
                names[i] = s2.nextLine();
            }
            return names;
        }catch (FileNotFoundException e){
            System.out.println("File not Found");
        }
        return null;
    }

    private int getRandom(int len){
        return (int)(Math.random() * (len));
    }
}
