public class Application {

    public static void main(String[] args) {

        int credit = 26;
        System.out.println(countNumberOfCredits(credit));
    }

    public static int countNumberOfCredits (int creditNumber) {
        int counter = 0;

        for (int i = 1; i <= creditNumber; i++) {
            if (i%13 != 0) {
                if (i % 3 == 0 ) {
                    System.out.println("The credit # " + i + " is related to Mary");
                    counter++;
                }
                if (i % 3 == 1) {
                    System.out.println("The credit # " + i + " is related to Petr");
                    counter++;
                }
                if (i % 3 == 2) {
                    System.out.println("The credit # " + i + " is related to Vasily");
                    counter++;
                }
            }
        }
        return counter;
    }
}
