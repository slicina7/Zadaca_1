package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    public static Double evaluate(String izraz) throws RuntimeException{
        Stack<String> operatori=new Stack<>();
        Stack<Double> brojevi=new Stack<>();
        for(String c : izraz.split(" ")){
            if(c.equals("("))
                continue;
            else if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("sqrt"))
            {
                operatori.push(c);
                continue;
            }
            else if(c.equals(")")) {
                Double broj = brojevi.pop();
                String znak=operatori.pop();
                if(znak.equals("+")) brojevi.push(brojevi.pop()+broj);
                else if(znak.equals("-")) brojevi.push(brojevi.pop()-broj);
                else if(znak.equals("*")) brojevi.push(brojevi.pop()*broj);
                else if(znak.equals("/")) brojevi.push(brojevi.pop()/broj);
                else if(znak.equals("sqrt")) brojevi.push(Math.sqrt(broj));
            }
            else {
                try{
                    brojevi.push(Double.parseDouble(c));
                }catch (Exception e){
                    throw new RuntimeException("Pogresan izraz");
                }
            }
        }
        return brojevi.peek();
    }
}
