package com.company;

public class Application {

    private static double M_VEL = 1;
    private static double P_VEL = 0.8;
    private static double V_LAZY_VEL = 0.5;
    private static double V_MOTIVATED_VEL = 1;
    private static int V_MOTIVATION_BORDER = 80; //percents
    private static int CREDITS_BORDER = 1370;
    private static int MONTH_BORDER = 10;
    private static int PERFORMANCE = 1;

    public static void main(String[] args) {

        boolean planOnTime = isPlanOnTime(1150, 480);
        System.out.println(planOnTime);

        int counterOfMonths = toCountMonths (2100, 50);
        System.out.println(counterOfMonths);

        int counterOfCredits = toCountCredits (18, 50, 40, 50);
        System.out.println(counterOfCredits);

    }

    private static int toCountCredits(int numberOfMonths, int mCreditsPerMonth, int pCreditsPerMonth, int vCreditsPerMonth) {

        int totalNumberOfCredits = mCreditsPerMonth+pCreditsPerMonth+vCreditsPerMonth;

        for (int i = 1; i < numberOfMonths; i++) {

            totalNumberOfCredits = totalNumberOfCredits + mCreditsPerMonth + PERFORMANCE;

            if (i % 2 == 0) {
                totalNumberOfCredits = totalNumberOfCredits + pCreditsPerMonth + PERFORMANCE;
            } else {
                totalNumberOfCredits = totalNumberOfCredits + pCreditsPerMonth;
            }

            if (i < MONTH_BORDER) {
                totalNumberOfCredits = totalNumberOfCredits + vCreditsPerMonth - PERFORMANCE;
            } else {
                totalNumberOfCredits = totalNumberOfCredits + vCreditsPerMonth;
            }
        }

        return totalNumberOfCredits;
    }

    private static int toCountMonths(int totalCredits, int mCreditsPerMonth) {

        int firstNumberOfCreditsPerMonth = (int) (mCreditsPerMonth + mCreditsPerMonth * P_VEL + mCreditsPerMonth * V_LAZY_VEL);
        int firstNumberOfMonths = CREDITS_BORDER / firstNumberOfCreditsPerMonth;
        int restCredits = totalCredits - CREDITS_BORDER;
        int secondNumberOfCreditsPerMonth = (int) (mCreditsPerMonth + mCreditsPerMonth * P_VEL + mCreditsPerMonth * V_MOTIVATED_VEL);
        int secondNumberOfMonths = restCredits / secondNumberOfCreditsPerMonth;

        return firstNumberOfMonths + secondNumberOfMonths;
    }

    private static boolean isPlanOnTime(int totalCredits, int mashaTotalCredits) {

        int firstPackCredits = totalCredits * V_MOTIVATION_BORDER / 100;
        int mashaFirstPartCredits = (int) (firstPackCredits / (M_VEL + P_VEL + V_LAZY_VEL)); //downCasting int
        int mashaRestCredits = mashaTotalCredits - mashaFirstPartCredits;
        int restCredits = (int) (mashaRestCredits * (M_VEL + P_VEL + V_MOTIVATED_VEL));

        return firstPackCredits + restCredits >= totalCredits;

    }


}
