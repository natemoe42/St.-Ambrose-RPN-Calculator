import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author natemoe
 */
public class RPNCalc{
    public static void main(String[] args) {
        DLinked_StackGeneric<Integer> stack = new DLinked_StackGeneric<>();
        runCalc(stack);
    }
    
    public static boolean isInteger(String token){
        if(token==null){
            return false;
        }
        try{
            int i = Integer.parseInt(token);
        }
            catch (NumberFormatException e){
                    return false;
                    
        }
        return true;
    }
    
    public static boolean isOperator (String token){
        if("+".equals(token)){
            return true;
        }
        else if("-".equals(token)){
            return true;
        }
        else if("*".equals(token)){
            return true;
        }
        else if("/".equals(token)){
            return true;
        }else if("%".equals(token)){
            return true;
        }
        else{
            return false;
        }
        }
    public static boolean isInstruction (String token){
        if("^".equals(token)){
            return true;
        }
        else if("$".equals(token)){
            return true;
        }
        else if("?".equals(token)){
            return true;
        }
         else{
            return false;
        }
    }
    public static boolean isEnd(String token){
        if("!".equals(token)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static ArrayList<String> ReadInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.trim().isEmpty()) { // add this check to ensure input is not empty
            return new ArrayList<String>();
            }
        String[] output = input.split("\\s+");
        ArrayList<String> list = new ArrayList<String>();
        for (String s : output) {
            list.add(s);
        }
        return list;
    }
    public static boolean isError(String token){
        return !isInteger(token)&&!isOperator(token)&&!isInstruction(token)&&!isEnd(token);
    }
    public static void runCalc(DLinked_StackGeneric<Integer> stack) {
    System.out.println("RPN Calculator");
    boolean finished = false;
    while (!finished) {
        ArrayList<String> tokens = ReadInput();
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (isInteger(token)) {
                int j = Integer.parseInt(token);
                stack.push(j);
            }
            if (isOperator(token)) {
                if (stack.size() > 1) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    if (token.equals("+")) {
                        int result = num2 + num1;
                        stack.push(result);
                        System.out.println(result);                        
                    } else if (token.equals("-")) {
                        int result = num2 - num1;
                        stack.push(result);
                        System.out.println(result);                        
                    } else if (token.equals("*")) {
                        int result = num2 * num1;
                        stack.push(result);
                        System.out.println(result);                        
                    } else if (token.equals("/")) {
                        int result = num2 / num1;
                        System.out.println(result);
                        stack.push(result);
                    }
                } else {
                    System.err.println("# Need 2 numbers for an operation.");
                }
            }
            if (isInstruction(token)) {
                if ("?".equals(token)) {
                    System.out.println(stack.toString());
                }
                if ("^".equals(token)){
                    if(stack.size()>0){
                        int TOS = stack.pop();
                        System.out.println(TOS);
                    }else{
                        System.err.println("# The stack is empty.");
                    }
                }
                if("$".equals(token)){
                    stack.clear();
                }
            }
            if (isError(token)){
                System.err.println("# Invalid input: \""+ token + "\" is not recognized.");
            }
            if (isEnd(token)) {
                finished = true;
                System.out.println("Goodbye");
                break;
            }
        }
    }
}
}
