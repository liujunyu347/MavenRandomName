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
        RN.start(names);
    }

    public void start(String[] names){
        System.out.println("Menu:");
        System.out.println("exit: exit the program");
        System.out.println("get: get random name from the current list, and delete it from the current list");
        System.out.println("show: show current name list");
        System.out.println("put: put all names into the list");
        System.out.println("post <Name List File path>: update the name list");
        System.out.println();
        RandomName RN = new RandomName();
        List<String> currList = new ArrayList<String>(Arrays.asList(names));
        Scanner input = new Scanner(System.in);
        String[] command = new String[]{"", ""};
        while (!command[0].equals("exit")){
            System.out.print("Please enter a command: ");
            command = input.nextLine().trim().split(" ", 2);
            if (command[0].equals("get")){
                String output = RN.getRandomName(currList);
                RN.printOutput(output, currList.size());
                currList.remove(output);
            }else if (command[0].equals("show")){
                System.out.println(currList);
            }else if (command[0].equals("put")){
                currList = new ArrayList<String>(Arrays.asList(names));

            }else if (command[0].equals("post")){
                if (command.length >= 2){
                    String[] newList = readString(command[1]);
                    if (newList != null){
                        currList = new ArrayList<String>(Arrays.asList(newList));
                    }
                }else{
                    System.out.println("Please enter the input path");
                }

            }
        }

    }

    private void printOutput(String output, int size){
        System.out.println(output);
        System.out.println(size + " names left in the list");
    }

    public String getRandomName(List<String> currList){
        int index = getRandom(currList.size());
        return currList.get(index);
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
            System.out.println("File not found, please check the path");
        }
        return null;
    }

    private int getRandom(int len){
        return (int)(Math.random() * len);
    }
}
