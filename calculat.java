import java.util.Scanner;

public class calculat {
        private static final Scanner scanner = new Scanner(System.in);
        private static String result = "";

        public static void main(String[] args) throws Exception {
            String userInput = scanner.nextLine();
            System.out.println(calc(userInput));
        }


        static String calc(String userInput) throws Exception {
            String oper = userInput.replaceAll("[^+\\-*/]", "");

            String[] blocks = userInput.split("[" + oper + "]");

            String left = blocks[0].trim();
            String right = blocks[1].trim();

            if (left.length() > 12 || right.length() > 12) {
                throw new Exception("Dlina stroki bolee 10 simvolov");
            }
            if (!isText(left)) {
                throw new Exception("Pervim operandom doljen bit tekst");
            }

            left = left.substring(1, left.length() - 1);

            String result = "";
            switch (oper) {
                case "+": {
                    if (!isText(right))
                        throw new Exception("Vtoroi operand doljen bit tekst");
                    right = right.substring(1, right.length() - 1);
                    result = left.concat(right);
                    break;
                }
                case "-": {
                    if (!isText(right))
                        throw new Exception("Vtoroi operand doljen bit tekst");
                    right = right.substring(1, right.length() - 1);
                    result = left.replaceAll(right, "");
                    break;
                }
                case "*": {
                    if (!isNumber(right))
                        throw new Exception("Vtoroi operand doljen bit chislo");
                    int n = Integer.parseInt(right);
                    if (n < 1 || n > 10) {
                        throw new Exception("Nedopystimoe chislo");
                    }
                    for (int i = 0; i < n; i++) {
                        result += left;
                    }
                    break;
                }
                case "/": {
                    if (!isNumber(right))
                        throw new Exception("Vtoroi operand doljen bit chislo");
                    int n = Integer.parseInt(right);
                    if (n < 1 || n > 10) {
                        throw new Exception("Nedopystimoe chislo");
                    }
                    result = left.substring(0, left.length() / n);
                    break;
                }
            }
            if (result.length() > 40) {
                result = result.substring(0, 40) + "...";
            }
            return "\"" + result + "\"";
        }

        static boolean isText(String token) {
            return token.startsWith("\"") && token.endsWith("\"");

        }

        static boolean isNumber(String token) {
            try {
                Integer.parseInt(token);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

