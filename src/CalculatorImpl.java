public class CalculatorImpl {
    private int pos;
    private String[] tokens;

    public CalculatorImpl() {
    }

    public CalculatorImpl(String exp) {
        this.tokens = exp.split(" ");
        this.pos = 0;
    }

    public double calculate() {
        double first = multipy();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            double second = multipy();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    public double multipy() {
        double first = factor();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else {
                pos++;
            }

            double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }

    public double factor() {
        String next = tokens[pos];
        double result;

        if (next.equals("(")) {
            pos++;
            result = calculate();
            String closingBracket;
            if (pos < tokens.length) {
                closingBracket = tokens[pos];
            } else {
                throw new IllegalArgumentException("Unexpected and of expresion");
            }
            if (closingBracket.equals(")")) {
                pos++;
                return result;
            }

            throw new IllegalArgumentException("')' expected but " + closingBracket + " found ");
        }
        pos++;
        return Double.parseDouble(next);
    }


}
