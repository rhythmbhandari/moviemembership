import java.util.Scanner;

/**
 * Represents a GoldMember, a type of MovieMembership with additional VIP privileges.
 */
public class GoldMember extends SilverMember implements VIPPrivilege {
    // Flag to track whether the member has valid credentials for VIP privileges
    private boolean validCredentials;

    /**
     * Constructs a GoldMember with default discount and points rates and initializes VIP privileges.
     *
     * @param memberName The name of the member.
     */
    public GoldMember(String memberName) {
        super(memberName, 0.25, 2.0);
        this.validCredentials = false;
        this.addPoints(50); // Gold members begin with 50 points
    }

    /**
     * Constructs a GoldMember with custom discount and points rates, additional movie details, and initializes VIP privileges.
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
        this.addPoints(50); // Gold members begin with 50 points
    }

    /**
     * Returns the membership rank of the member.
     *
     * @return The membership rank.
     */
    @Override
    public String returnMembershipRank() {
        return "Gold";
    }

    /**
     * Returns a string representation of the member's details, including VIP privileges.
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
    }

    /**
     * Allows the GoldMember to purchase alcohol if they have valid VIP credentials.
     *
     * @return A message indicating whether the beverage can be purchased.
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
