import javax.xml.bind.SchemaOutputResolver;
import java.util.*;
public class EncryptionProgram {
    private  Scanner scanner;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private String line;
    private char[] letter;
    private char[] secretLetter;

    EncryptionProgram(){
        scanner=new Scanner(System.in);
       random=new Random();
       list=new ArrayList<>();
       shuffledList=new ArrayList<>();
       character=' ';

       newKey();
       askQustion();
    }
    private void askQustion(){
        while(true) {
            System.out.println("*********************************************");
            System.out.println("what to do you want to do?");
            System.out.println("(N)ewKey,(G)etKey,(E)ncrypt,(D)ecrypt,(Q)uit");
            char response= Character.toUpperCase(scanner.nextLine().charAt(0));
            switch (response) {
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("Not a valid key");
            }
        }
    }
    private void newKey(){
        character=' ';
        list.clear();
        shuffledList.clear();

       for(int i=32;i<127;i++){
           list.add(Character.valueOf(character));
           character++;
       }
       shuffledList=new ArrayList<>(list);
       Collections.shuffle(shuffledList);
        System.out.println("*A new Key has been Generated");
    }
    private void getKey(){
        System.out.println("Key: ");

        for(Character x : list){
            System.out.print(x);
        }
        System.out.println();
        for (Character x : shuffledList){
            System.out.print(x);
        }
        System.out.println();


    }
    private void encrypt(){
        System.out.println("Enter the letter of Encrypted");
        String message=scanner.nextLine();
        letter=message.toCharArray();
        for(int i=0;i< letter.length;i++){
            for(int j=0;j<list.size();j++){
                if(letter[i]==list.get(j)){
                    letter[i]=shuffledList.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted: ");
        for (char x : letter){
            System.out.print(x);
        }
        System.out.println();

    }
    private void decrypt(){
        System.out.println("Enter the letter of Decrypted");
        String message=scanner.nextLine();
        letter=message.toCharArray();
        for(int i=0;i< letter.length;i++){
            for(int j=0;j<shuffledList.size();j++){
                if(letter[i]==shuffledList.get(j)){
                    letter[i]=list.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted: ");
        for (char x : letter){
            System.out.print(x);
        }
        System.out.println();

    }
    private void quit(){
        System.out.println("Thank you  worked in encryption");
        System.exit(0);

    }

}
