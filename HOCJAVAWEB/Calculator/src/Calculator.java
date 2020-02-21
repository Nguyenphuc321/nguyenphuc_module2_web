public class Calculator {
    public static float caculator(float firtnumber, float secondnumber, char opert) {
        switch (opert) {
            case '+':
                return firtnumber + secondnumber;
            case '-':
                return firtnumber - secondnumber;
            case '*':
                return firtnumber * secondnumber;
            case '/':
                if (secondnumber != 0)
                    return firtnumber / secondnumber;
                else
                    throw new RuntimeException("cant divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
