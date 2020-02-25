package recursion;

import javax.swing.plaf.synth.SynthUI;
import java.util.Arrays;
import java.util.List;

/**
 * Expr -> Term + Expr | Term - Expr | Term
 * Term -> Factor * Term | Factor / Term | Factor
 * Factor -> Number | (Expr) | func(Expr)
 *
 * 2 + 2 - 3
 * 2 + 3 * ( 4 + 5 ) - 6 * 7 + sin(10) + cos(12 + 1)
 *
 */
public class RecursiveDescentParser {

    private final List<String> tokens;
    private int pos = 0;

    public RecursiveDescentParser(List<String> tokens) {
        this.tokens = tokens;
    }

    public Double parse() {
        return expression();
    }

    private Double expression() {
        Double first = term();

        while (pos < tokens.size()) {
            String operator = tokens.get(pos);

            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            Double second = term();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    private Double term() {
        Double first = factor();

        while (pos < tokens.size()) {
            String operator = tokens.get(pos);
            if (!operator.equals("*") && !operator.equals("/")) {
                return first;
            } else {
                pos++;
            }

            Double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }

    private Double factor() {
        String next = tokens.get(pos);
        Double result;
        if (next.indexOf('(') > -1) {
            pos++;
            result = expression();
            String closingBracket = null;
            if (pos < tokens.size() && (closingBracket = tokens.get(pos)).equals(")")) {
                pos++;
                System.out.println(next);
                switch(next) {
                    case "sin(": return Math.sin(result);
                    case "cos(": return Math.cos(result);
                    case "tg(": return Math.tan(result);
                    case "ctg(": return 1.0 / Math.tan(result);
                }

                return result;
            }
            throw new IllegalStateException("')' expected but " + closingBracket);
        }

        if(next.equals("sin(")) {

        }

        pos++;
        return Double.parseDouble(next);
    }

    public static void main(String[] args) {
        String expr = "2.111 * 3.5 + ( 3 + 4 * ( 2.1 + 3 ) - 10 ) * ( 5 - 7 + 4 - 2 ) + 11";
        expr = "2 + 3 * ( 4 + 5 ) - 6 * 7 + sin( 10 ) + cos( 12 + 1 ) + tg( 10 ) + ctg( 5 )";
        RecursiveDescentParser recursiveDescentParser = new RecursiveDescentParser(Arrays.asList(expr.split(" ")));
        System.out.println(recursiveDescentParser.parse());
        System.out.println(2 + 3 * ( 4 + 5 ) - 6 * 7 + Math.sin( 10 ) + Math.cos( 12 + 1 ) + Math.tan( 10 ) + (1.0 / Math.tan( 5 )));
        //System.out.println(2.111*3.5+(3 + 4 * (2.1 + 3) - 10 )*(5-7+4-2) + 11);
    }
}
