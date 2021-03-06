package com.piter.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ParsePost
{
    private StackX theStack;
    private String input;
    //--------------------------------------------------------------
    public ParsePost(String s)
    { input = s; }
    //--------------------------------------------------------------
    public int doParse()
    {
        theStack = new StackX(20);             // make new stack
        char ch;
        int j;
        int num1, num2, interAns;

        for(j=0; j<input.length(); j++)       // for each char,
        {
            ch = input.charAt(j);              // read from input
            theStack.displayStack(""+ch+" ");  // *diagnostic*
            if(ch >= '0' && ch <= '9')         // if it's a number
                theStack.push( (int)(ch-'0') ); //   push it
            else                               // it's an operator
            {
                num2 = theStack.pop();          // pop operands
                num1 = theStack.pop();
                switch(ch)                      // do arithmetic
                {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }  // end switch
                theStack.push(interAns);        // push result
            }  // end else
        }  // end for
        interAns = theStack.pop();            // get answer
        return interAns;
    }  // end doParse()

    public static void main(String[] args) throws IOException
    {
        String input;
        int output;

        while(true)
        {
            System.out.print("Enter postfix: ");
            System.out.flush();
            input = getString();         // read a string from kbd
            if( input.equals("") )       // quit if [Enter]
                break;
            // make a parser
            ParsePost aParser = new ParsePost(input);
            output = aParser.doParse();  // do the evaluation
            System.out.println("Evaluates to " + output);
        }  // end while
    }  // end main()
    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}  // end class ParsePost
