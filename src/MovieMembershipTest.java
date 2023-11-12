/**
 * Name: MovieMembershipTest
 * Date: November 11, 2023,
 * Author: Rhythm Bhandari
 * Purpose: This program demonstrates the functionality of the MovieMembership hierarchy.
 */

public class MovieMembershipTest {

    /**
     * The main method where the program starts.
     */
    public static void main(String[] args) {
        // Three movie membership objects, one of each type (SilverMember, GoldMember, IMAXMember)
        MovieMembership mySilver = new SilverMember("John Silver", "Inception", "Standard", 18, 30, "Popcorn");
        MovieMembership myGold = new GoldMember("Jane Gold", "Avatar", "IMAX", 20, 15, "Candy");
        MovieMembership myIMAX = new IMAXMember("Alex IMAX", "Interstellar", "IMAX", 22, 0, "Soda");

        // Array to store MovieMembership objects
        MovieMembership[] movieMembershipArray = {mySilver, myGold, myIMAX};

        // Display information for each MovieMembership object
        for (MovieMembership member : movieMembershipArray) {
            displayMemberMethods(member);
        }

        // Purchase tickets for each MovieMembership and display updated information
        for (MovieMembership member : movieMembershipArray) {
            purchaseMovieTicketAndPrintDetails(member, "The Matrix 4", "Standard", 11, 25, "Sour Keys", 6.99);
        }

        // Access VIP Lounge and purchase alcohol for a GoldMember
        System.out.println();
        invokeAccessVIPLounge(myGold);
        invokePurchaseAlcohol(myGold);
        System.out.printf("%s%n", myGold.getMemberDetails());
        System.out.println();

        // Purchase tickets and display information
        mySilver.purchaseMovieTicket(7.89, "Suicide Squad", "Standard", 14, 25, "Smarties");
        myGold.purchaseMovieTicket(15.98, "The Big Short", "Standard", 13, 50, "Kitkat");
        myIMAX.purchaseMovieTicket(14.50, "Godzilla vs Kong", "IMAX", 15, 0, "Gummies");

        System.out.println();

        // Display updated information for all MovieMembership objects
        System.out.printf("%s%n", mySilver.getMemberDetails());
        System.out.printf("%s%n", myGold.getMemberDetails());
        System.out.printf("%s%n", myIMAX.getMemberDetails());
    }

    /**
     * Display information about a MovieMembership.
     *
     * @param member The MovieMembership object.
     */
    private static void displayMemberMethods(MovieMembership member) {
        // Display various details for the MovieMembership
        System.out.printf("Member Name: %s%n", member.getMemberName());
        System.out.printf("Membership Rank: %s%n", member.returnMembershipRank());
        System.out.printf("Points: %d%n", member.getPoints());
        System.out.printf("Next Movie: %s%n", member.getNextMovie());
        System.out.printf("Theatre Type: %s%n", member.getTheatreType());
        System.out.printf("Show Time: %s%n", member.displayShowTime());
        System.out.printf("Snack: %s%n", member.getSnack());
        System.out.printf("%s%n", member.getMemberDetails());
        member.printMemberBenefits();
        System.out.println();
    }

    /**
     * Purchase a movie ticket for a MovieMembership and display updated information.
     *
     * @param member      The MovieMembership object.
     * @param movie       The name of the movie.
     * @param theatreType The type of theatre.
     * @param showHour    The hour of the showtime.
     * @param showMinute  The minute of the showtime.
     * @param snack       The snack to set.
     * @param ticketPrice The price of the movie ticket.
     */
    private static void purchaseMovieTicketAndPrintDetails(MovieMembership member, String movie,
                                                           String theatreType, int showHour, int showMinute,
                                                           String snack, double ticketPrice) {
        // Purchase a movie ticket for the MovieMembership
        member.purchaseMovieTicket(ticketPrice, movie, theatreType, showHour, showMinute, snack);
        // Display updated information
        System.out.println(member.getMemberDetails());
    }

    /**
     * Invoke the VIP Lounge access for a MovieMembership with VIPPrivilege.
     *
     * @param member The MovieMembership object.
     */
    private static void invokeAccessVIPLounge(MovieMembership member) {
        // Check if the MovieMembership has VIPPrivilege and access the VIP Lounge
        if (member instanceof VIPPrivilege) {
            VIPPrivilege vipMember = (VIPPrivilege) member;
            vipMember.accessVIPLounge();
        } else {
            System.out.println("This member does not have VIP privileges.");
        }
    }

    /**
     * Invoke the purchaseAlcohol method for a MovieMembership with VIPPrivilege and display the result.
     *
     * @param member The MovieMembership object.
     */
    private static void invokePurchaseAlcohol(MovieMembership member) {
        // Check if the MovieMembership has VIPPrivilege and purchase alcohol
        if (member instanceof VIPPrivilege) {
            VIPPrivilege vipMember = (VIPPrivilege) member;
            System.out.println(vipMember.purchaseAlcohol());
        } else {
            System.out.println("This member does not have VIP privileges.");
        }
    }
}