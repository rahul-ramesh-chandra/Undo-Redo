import java.util.*;
class unredo
{
    public static void main(String args[])
    {
        Stack<String> undostack = new Stack<>();
        Stack<String> redostack = new Stack<>();
        Stack<String> stack = new Stack<>();

        Scanner in = new Scanner(System.in);
        String word = "";
        String text = "";
        System.out.println(" Type '<' to undo a word.\n Type '>' to redo a undo.\n Type '-' to delete a word.\n Type '< >' to display the sentence.\n Type 'exit' to exit Text editor.");
        //Iterates until the user doesn't type exit.
        while(!word.equals("exit"))
        {
            word=in.next();
            if(word.equals("<"))
            undo(undostack,redostack);
            else if(word.equals(">"))
            redo(undostack,redostack,stack);
            else if(word.equals("-"))
            {
                //redostack.push(undostack.peek());
                System.out.println("'deleted'"+undostack.pop());
            }
            else 
            {
                undostack.push(word);
            }
        }
    }
    //Function to undo the words one by one from very recent onwards.
    static void undo(Stack<String> undostack,Stack<String> redostack)
    {
        if(!undostack.isEmpty())
        {
            String text = undostack.pop();
            redostack.push(text);
            System.out.println("'removed'"+text);
        }
    }
    //Function to redo the words from undoed words.
    static void  redo(Stack<String> undostack ,Stack<String> redostack,Stack<String> stack)
    {
        String sentence=" ";
        String temp;
        if(!redostack.isEmpty())
        {
            while(!undostack.isEmpty())
            {
                String text = undostack.pop();
                stack.push(text);
            }
            while(!stack.isEmpty())
            {
                String text = stack.pop();
                sentence +=text + " ";
                undostack.push(text);
            }
            sentence+=redostack.peek();
            System.out.println("'added'"+redostack.peek());
            undostack.push(redostack.pop());
            System.out.println(sentence);
        }
    }
}