/**
 * Name: GoldMember
 * Date: November 11, 2023,
 * Author: Rhythm Bhandari and Birendra Bista
 * Purpose: The GoldMember class represents a movie membership with VIP privileges, inheriting from SilverMember and
 * implementing VIP-specific features like VIP lounge access and alcohol purchase.
 */

import java.util.Scanner;

/**
 * Represents a GoldMember, a type of MovieMembership with additional VIP privileges.
 * Inheriting a SilverMember Class to extend its functionality and also implementing VIPPrivilege interface.
 */
public class GoldMember extends SilverMember implements VIPPrivilege {
    // Variable to track whether the member has valid credentials for VIP privileges
    private boolean validCredentials;

    /**
     * Constructor for creating a GoldMember with default discount and points rates and initializes VIP privileges.
     *
     * @param memberName The name of the member.
     */
    public GoldMember(String memberName) {
        super(memberName, 0.25, 2.0);
        this.validCredentials = false;
        this.addPoints(50);
    }

    /**
     * Constructor for creating a GoldMember with custom discount and points rates, additional movie details, and initializes VIP privileges.
     *
     * @param memberName   The name of the member.
     * @param nextMovie    The next movie for the member.
     * @param theatreType  The type of theatre for the movie.
     * @param showHour     The hour of the showtime.
     * @param showMinute   The minute of the showtime.
     * @param snack        The chosen snack.
     */
    public GoldMember(String memberName, String nextMovie, String theatreType, int showHour, int showMinute, String snack) {
        super(memberName, nextMovie, theatreType, showHour, showMinute, snack, 0.25, 2.0);
        this.validCredentials = false;
        this.addPoints(50);
    }

    /**
     *
     * Returns the membership rank of the member.
     *
     * @return The membership rank.
     */
    @Override
    public String returnMembershipRank() {
        return "Gold";
    }

    /**
     * Display the member's details.
     *
     * @return Details of the member with VIP privileges.
     */
    @Override
    public String getMemberDetails() {
        return super.getMemberDetails() + " and VIP privileges.";
    }

    /**
     * Allows the GoldMember to access the VIP lounge by entering a password.
     * Sets the validCredentials flag based on the entered password.
     */
    @Override
    public void accessVIPLounge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the password to access VIP Lounge: ");
        int enteredPassword = scanner.nextInt();

        if (enteredPassword == VIPPrivilege.PASSWORD) {
            validCredentials = true;
            System.out.println("Access granted!");
        } else {
            validCredentials = false;
        }
        scanner.close();
    }

    /**
     * Allows the GoldMember to purchase alcohol if they have valid VIP credentials.
     *
     * @return Whether the beverage can be purchased or not.
     */
    @Override
    public String purchaseAlcohol() {
        if (validCredentials) {
            setSnack("alcohol");
            return "Enjoy your beverage";
        } else {
            return "Incorrect password. Beverage cannot be purchased.";
        }
    }
}
