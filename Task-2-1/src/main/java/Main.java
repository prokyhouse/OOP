
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {


        System.out.println("Введите количество команд: ");
        Scanner in = new Scanner(System.in);
        //Считываем
        int N = Integer.parseInt(in.nextLine()); //количество команд для стека
        MyStack stack = new MyStack(N);
        for (int i = 0;i<N;i++){
            String command = in.nextLine();
            if (command.contains("push")){
                stack.push(Integer.parseInt(command.replaceAll("[push()]", "")));
                //  System.out.println(command.replaceAll("[push()]", ""));
            } else if (command.contains("pop")){
                stack.pop();
            } else { //count
                System.out.println(stack.count());
            }
        }
    }
}
