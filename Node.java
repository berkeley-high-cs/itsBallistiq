import java.util.Scanner;
import java.io.File;
import java.util.*;
public class Node{
    private Scanner sc = new Scanner(System.in);
    private Node left;
    private Node right;
    private String question;
    private static int lineNumber;
    public static boolean isQuestion = true;
    private static ArrayList<String> fileQuestions = new ArrayList<String>();
    public static void generate(){
        try{Scanner fsc = new Scanner(new File("questions.txt"));
        while(fsc.hasNextLine()){fileQuestions.add(fsc.nextLine());}}
        catch(Exception e){System.out.println("were all gonna die");}
        
    }
    public Node(String question){
        this.question = question;
        lineNumber=0;
    }
    public Node(int newLineNumber){
        lineNumber = newLineNumber;
        try{
            this.question = fileQuestions.get(lineNumber-1);
            if(fileQuestions.size()<=lineNumber*2+1){
                System.out.println("i think it is " +question);
                isQuestion=false;
            }
        }
        catch(Exception e){;}
    }

    public void askQuestion(){
        System.out.println(question);
        char response = sc.nextLine().charAt(0);
        if(response == 'y'){
            left = new Node(lineNumber*2+1);
            if(isQuestion){left.askQuestion();}
        }
        else{
            right = new Node(lineNumber*2+2);
            if(isQuestion){right.askQuestion();}
        }
    }
    public void setQuestion(String question){
        this.question=question;
    }

    public boolean hasChildren(){
        if(this.left!=null||this.right!=null){return true;}
        return false;
    }
}
