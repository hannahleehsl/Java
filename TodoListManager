import java.util.*;
import java.io.*;

//Hannah Lee
//CSE 122 AB
//TA: Andrew Awada
//January 17, 2023
//Creative Project 0: TODO List Manager
//This program creates a todo list solely based on the user's input
//     and has different options for what you want to do to the list.

public class TodoListManager {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO: Your Code Here
        Scanner console = new Scanner(System.in);
        List<String> todos = new ArrayList<>();
        List<String> completed = new ArrayList<>();
        String option = "";
        //while (!option.equalsIgnoreCase("Q")){
        System.out.println("Welcome to your TODO List Manager!");
        System.out.println("What would you like to do?");
        System.out.print("(A)dd TODO, (M)ark TODO as done, (L)oad TODOs,"
            + " (S)ave TODOs, (Q)uit? ");
        option = console.nextLine();
        while(!option.equalsIgnoreCase("Q")){
            if(option.equalsIgnoreCase("A")){
                System.out.print("Do you want to add multiple tasks? (Y/N) ");
                String yN = console.nextLine();
                if(yN.equalsIgnoreCase("Y")){
                    addMult(console, todos);
                } else if(yN.equalsIgnoreCase("N")){
                    addItem(console, todos);
                } else {
                    System.out.println("Invalid output: " + yN);
                }
            } else if(option.equalsIgnoreCase("M")){
                markItemAsDone(console, todos, completed);
            } else if(option.equalsIgnoreCase("L")){
                loadItems(console, todos);
            } else if(option.equalsIgnoreCase("S")){
                saveItems(console, todos);
            } else {
                System.out.println("Unknown input: " + option);
            }
            printTodos(todos, completed);

            //System.out.println("Welcome to your TODO List Manager!");
            System.out.println("What would you like to do?");
            System.out.print("(A)dd TODO, (M)ark TODO as done, (L)oad TODOs,"
                + " (S)ave TODOs, (Q)uit? ");
            option = console.nextLine();
        }
    }

    //this method prints all of the tasks in the todo list and the completed
    //  list. if the todo list empty, it prints a statement instead. if the 
    //  completed list is empty, it doesn't get printed.
    //parameters:
    //  - List<String> todos: the array list containing tasks
    //  - List<String> completed: the array list containing the
    //      completed tasks
    //returns:
    //  - none
    public static void printTodos(List<String> todos, List<String> completed) {
        // TODO: Your Code Here
        System.out.println("Today's TODOs:");
        if(todos.size() > 0){
            for(int i = 0; i < todos.size(); i++){
            System.out.println("  " + (i + 1) + ": " + todos.get(i));
            }
        } else {
            System.out.println("  You have nothing to do yet today! Relax!");
        }

        if(completed.size() > 0) {
            System.out.println("Today's Completed: ");
            for (int j = 0; j < completed.size(); j++) {
                System.out.println("    " + (j + 1) + ": " + completed.get(j));
            }
        }
    }

    //this method adds tasks to the arraylist. if the list already has
    //  a task in it, the code prompts the user for the desired location
    //  of the task.
    //parameters:
    //  - Scanner console: to allow for user prompting
    //  - List<String> todos: the array list containing the tasks
    //returns:
    //  -none
    public static void addItem(Scanner console, List<String> todos) {
        // TODO: Your Code Here
        System.out.print("What would you like to add? ");
        String task = console.nextLine();
        if(todos.size() > 0){
            System.out.print("Where in the list should it be (1-"
                    + (todos.size() + 1) + ")? (Enter for end): ");
            String placement = console.nextLine();
            if(placement.equals("")){
                todos.add(task);
            } else {
                int location = Integer.parseInt(placement);
                todos.add(location - 1, task);
            }
        } else {
            todos.add(task);
        }

    }

    //this method removes items from the array list because they are now completed.
    //  if the list is already empty, it prints a statement instead.
    //parameters:
    //  - Scanner console: to allow for user prompting
    //  - List<String> todos: the array list containing the tasks
    //  - List<String> completed: the array list containg the 
    //      completed tasks
    //returns:
    //  -none
    public static void markItemAsDone(Scanner console, List<String> todos, 
            List<String> completed) {
        // TODO: Your Code Here
        if(todos.size() > 0){
            System.out.print("Which item did you complete (1-" + todos.size() + ")? ");
            String taskNumber = console.nextLine();
            int completedNumber = Integer.parseInt(taskNumber);
            completed.add(todos.get(completedNumber - 1));
            todos.remove(completedNumber - 1);
        } else {
            System.out.println("All done!");
            System.out.println("Nothing left to mark as done!");
        }


    }

    //this method prompts the user for the name of a file to move tasks
    //  from the file to the todos array list
    //parameters:
    //  - Scanner console: to allow for user prompting
    //  - List<String> todos: the array list containing the tasks
    //returns:
    //  -none
    public static void loadItems(Scanner console, List<String> todos)
            throws FileNotFoundException {
        // TODO: Your Code Here
        int length = todos.size();
        for(int i = 0; i < length; i++){
            todos.remove(0);
        }
        System.out.print("File name? ");
        String fileName = console.nextLine();
        Scanner file = new Scanner(new File(fileName));
        while(file.hasNextLine()){
            String task = file.nextLine();
            todos.add(task);
        }
    }

    //this method prints the tasks in the todos array list to a file
    //parameters:
    //  - Scanner console: to allow for user prompting
    //  - List<String> todos: the array list containing the tasks
    //returns:
    //  -none
    public static void saveItems(Scanner console, List<String> todos)
            throws FileNotFoundException {
        // TODO: Your Code Here
        System.out.print("File name? ");
        String usersFile = console.nextLine();
        PrintStream output = new PrintStream(new File(usersFile));
        for(int i = 0; i < todos.size(); i++){
            output.println(todos.get(i));
        }

    }

    //this method allows users to add multiple tasks at one time without
    //  having to type a multiple times
    //parameters:
    //  - Scanner console: to allow for user prompting
    //  - List<String> todos: the array list containing the tasks
    //returns:
    //  -none
    public static void addMult(Scanner console, List<String> todos) {
        System.out.print("How many tasks would you like to add? ");
        String amount = console.nextLine();
        for (int i = 0; i < Integer.parseInt(amount); i++) {
            System.out.print("What would you like to add? ");
            String task = console.nextLine();
            if (todos.size() > 0) {
                System.out.print("Where in the list should it be (1-"
                        + (todos.size() + 1) + ")? (Enter for end): ");
                String placement = console.nextLine();
                if (placement.equals("")) {
                    todos.add(task);
                } else {
                    int location = Integer.parseInt(placement);
                    todos.add(location - 1, task);
                }
            } else {
                todos.add(task);
            }
        }
    }
}
