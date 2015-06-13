/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 * 宣告Calculator建構子
 */
public class Calculator extends java.util.Observable {
    String string= "",sym;
    int num,num2,sum,num3;
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
    /**
     * 按下按鈕JFrame即出現數字
     * @param digit 
     */
    public void appendDigit(int digit) {
      if(string.equals("0")){
          string = "";
      }
      string += String.valueOf(digit);
      System.out.print(digit);
      getDisplay();
    }
    /**
     * 小數點判斷
     * @param dot 
     */
    public void appendDot(String dot) {
        string += String.valueOf(dot);
        getDisplay();
    }
    /**
     * 判斷加、減、乘、除、等於、情除判斷
     * @param operator 
     */
    public void performOperation(Operator operator) {
        switch(operator)
        {
            case PLUS:
                performOperation(Operator.EQUAL);
                num = Integer.parseInt(string);
                string= "0";
                //getDisplay();
                sym ="+";
                break;
               
            case MINUS:
                performOperation(Operator.EQUAL);
                num = Integer.parseInt(string);
                string= "0";
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
            case CLEAR:
                string= "";
                getDisplay();
                break;
            case CLEAR_ENTRY:
                num = Integer.parseInt(string);
                string= "";
                getDisplay();
                break;
            
            case EQUAL:
                
                if(sym =="+")
                {
                    num2 = Integer.parseInt(string);
                    sum = num+num2;
                    string = String.valueOf(sum);
                    getDisplay();
                    //string="";
                    num=0;
                    System.out.println(string);
                }
                if(sym =="-")
                {
                    num2 = Integer.parseInt(string);
                    sum = num-num2;
                    string = String.valueOf(sum);
                    getDisplay();
                    //string="";
                    num=0;
                    
                    System.out.println(string);
                }
                if(sym =="*")
                {
                    num2 = Integer.parseInt(string);
                    sum = num*num2;
                    string = String.valueOf(sum);
                    getDisplay();
                    //string="";
                }
                if(sym =="/")
                {
                    num2 = Integer.parseInt(string);
                    sum = num/num2;
                    string = String.valueOf(sum);
                    getDisplay();
                    //string="";
                }
                
                
                break;
               
        }
         System.out.println(operator);
    }
    /**
     * 顯示判斷運算結果
     * @return 
     */
    public String getDisplay() {
        setChanged();
        notifyObservers(string);
        // TODO code application logic here
        return null;
    }
    /**
     * 存取運算符號，使JFrame可套用
     * @param txt 
     */
    public void operator(String txt)
    {
        if(txt =="+") performOperation(Operator.PLUS);
        if(txt =="-") performOperation(Operator.MINUS);
        if(txt =="*") performOperation(Operator.TIMES);
        if(txt =="/") performOperation(Operator.OVER);
        if(txt =="C") performOperation(Operator.CLEAR);
        if(txt =="CE") performOperation(Operator.CLEAR_ENTRY);
        if(txt =="=") performOperation(Operator.EQUAL);
    }
  

}
