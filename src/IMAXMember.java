/**
 * Name: IMAXMember
 * Date: November 11, 2023,
 * Author: Rhythm Bhandari and Birendra Bista
 * Purpose: The IMAXMember class extends MovieMembership to model members with IMAX privileges,
 * featuring customized discount and points rates, and methods for purchasing IMAX tickets,
 * displaying benefits, and returning membership details.
 */


/**
 * Represents a member with IMAX membership.
 * Inheriting a MovieMembership Class to extend its functionality
 */
public class IMAXMember extends MovieMembership {
    // Member variables specific to IMAXMember
    private double discountRate;
    private double pointsRate;

    /**
     * Constructor for creating an IMAXMember with default values and initial points.
     *
     * @param memberName The name of the member.
     */
    public IMAXMember(String memberName) {
        super(memberName);
        this.discountRate = 0.5;
        this.pointsRate = 1.3;
        // Add initial points for IMAX membership
        this.addPoints(25);
    }

    /**
     * Constructor for creating an IMAXMember with specified details and initial points.
     *
     * @param memberName  The name of the member.
     * @param nextMovie   The name of the next movie.
     * @param theatreType The type of theatre.
     * @param showHour    The hour of the showtime.
     * @param showMinute  The minute of the showtime.
     * @param snack       The snack for the movie.
     */
    public IMAXMember(String memberName, String nextMovie, String theatreType, int showHour, int showMinute, String snack) {
        // Calling the base class constructor with specified details
        super(memberName, nextMovie, theatreType, showHour, showMinute, snack);
        this.discountRate = 0.5;
        this.pointsRate = 1.3;
        // Add initial points for IMAX membership
        this.addPoints(25);
    }

    /**
     * Returns the membership rank of the member.
     *
     * @return The membership rank.
     */
    @Override
    public String returnMembershipRank() {
        return "IMAX";
    }

    /**
     * Returns the member's details, including membership rank.
     *
     * @return Details of the member.
     */
    @Override
    public String getMemberDetails() {
        return String.format("%s They have %s membership.", super.getMemberDetails(), returnMembershipRank());
    }

    /**
     * Prints the benefits associated with IMAX membership.
     */
    @Override
    public void printMemberBenefits() {
        System.out.printf("Discount Rate: %.1f%%%n", discountRate * 100);
        System.out.println("Points gained per dollar: " + pointsRate);
    }

    /**
     * Purchases a movie ticket for an IMAX member, updating member details accordingly.
     *
     * @param ticketPrice The price of the movie ticket.
     * @param nextMovie   The name of the next movie.
     * @param theatreType The type of theatre.
     * @param showHour    The hour of the showtime.
     * @param showMinute  The minute of the showtime.
     * @param snack       The snack for the movie.
     */
    @Override
    public void purchaseMovieTicket(double ticketPrice, String nextMovie, String theatreType, int showHour, int showMinute, String snack) {
        // Set member details based on the purchased ticket
        setNextMovie(nextMovie);
        setTheatreType(theatreType);
        setShowtime(showHour, showMinute);
        setSnack(snack);

        if ("IMAX".equalsIgnoreCase(theatreType)) {
            // Apply discount for IMAX theatre
            double priceWithDiscount = ticketPrice * (1 - discountRate);

            // Calculate and add points based on the ticket price
            int pointsToAdd = (int) (ticketPrice * pointsRate);
            addPoints(pointsToAdd);

            // Display purchase details with points earned
            System.out.println(String.format("The Movie %s has been purchased by %s for %.2f and will be showing at %s with %s screening. They have earned %d points.",
                    nextMovie, getMemberName(), priceWithDiscount, displayShowTime(), theatreType, pointsToAdd));

        } else {
            // Display purchase details without points for non-IMAX theatre
            System.out.println(String.format("The Movie %s has been purchased by %s for %.2f and will be showing at %s with %s screening. They have not earned any points.",
                    nextMovie, getMemberName(), ticketPrice, displayShowTime(), theatreType));

        }
    }
}
