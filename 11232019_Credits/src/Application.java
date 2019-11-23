public class Application {

    public static void main(String[] args) {

        int credit = 14;
        System.out.println(countNumberOfCredits(credit));
    }

    public static int countNumberOfCredits (int creditNumber) {
        int counter = 0;

        for (int i = 0; i <= creditNumber; i++) {
            if (creditNumber != 13 && i != 13) {
                if (creditNumber % 3 == 0) {
                    System.out.println("The credit # " + i + " is related to Mary");
                    counter++;
                }
                if (creditNumber % 3 == 1) {
                    System.out.println("The credit # " + i + " is related to Petr");
                    counter++;
                }
                if (creditNumber % 3 == 2) {
                    System.out.println("The credit # " + i + " is related to Vasily");
                    counter++;
                }
            }
        }
        return counter;
    }
}
