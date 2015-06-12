/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Calculator extends java.util.Observable {
    String string= "",sym;
    int num,num2,sum;
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
    
    public void appendDigit(int digit) {
      string += String.valueOf(digit);
      getDisplay();
    }
    
    public void appendDot(String dot) {
        string += String.valueOf(dot);
        getDisplay();
    }
    
    public void performOperation(Operator operator) {
        switch(operator)
        {
            case PLUS:
                num = Integer.parseInt(string);
                string= "";
                getDisplay();
                sym ="+";
                break;
            case MINUS:
                num = Integer.parseInt(string);
                string= "";
                getDisplay();
                sym ="-";
                break;
            case TIMES:
                num = Integer.parseInt(string);
                string= "";
                getDisplay();
                sym ="*";
                break;
            case OVER:
                num = Integer.parseInt(string);
                string= "";
                getDisplay();
                sym ="/";
                break;
            case CLEAR_ENTRY:
                string= "";
                getDisplay();
                break;
            
            case EQUAL:
                switch(sym){
                    case "+":
                        num2 = Integer.parseInt(string);
                        sum = num+num2;
                        string = String.valueOf(sum);
                        getDisplay();
                        string="";
                        break;
                    case "-":
                        num2 = Integer.parseInt(string);
                        sum = num-num2;
                        string = String.valueOf(sum);
                        getDisplay();
                        string="";
                        break;
                    case "*":
                        num2 = Integer.parseInt(string);
                        sum = num*num2;
                        string = String.valueOf(sum);
                        getDisplay();
                        string="";
                        break;
                    case "/":
                        num2 = Integer.parseInt(string);
                        sum = num/num2;
                        string = String.valueOf(sum);
                        getDisplay();
                        string="";
                        break;
                }
                /*if(sym =="+")
                {
                    num2 = Integer.parseInt(string);
                    sum = num+num2;
                    string = String.valueOf(sum);
                    getDisplay();
                    string="";
                }
                if(sym =="-")
                {
                    num2 = Integer.parseInt(string);
                    sum = num-num2;
                    string = String.valueOf(sum);
                    getDisplay();
                    string="";
                }
                if(sym =="*")
                {
                    num2 = Integer.parseInt(string);
                    sum = num*num2;
                    string = String.valueOf(sum);
                    getDisplay();
                    string="";
                }
                if(sym =="/")
                {
                    num2 = Integer.parseInt(string);
                    sum = num/num2;
                    string = String.valueOf(sum);
                    getDisplay();
                    string="";
                }*/
                
                
                break;
        }
    }
    
    public String getDisplay() {
        setChanged();
        notifyObservers(string);
        // TODO code application logic here
        return null;
    }
    public void operator(String txt)
    {
        if(txt =="+") performOperation(Operator.PLUS);
        if(txt =="-") performOperation(Operator.MINUS);
        if(txt =="*") performOperation(Operator.TIMES);
        if(txt =="/") performOperation(Operator.OVER);
        if(txt =="CE") performOperation(Operator.CLEAR_ENTRY);
        if(txt =="=") performOperation(Operator.EQUAL);
    }
  

}
