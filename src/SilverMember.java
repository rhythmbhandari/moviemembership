/**
 * Name: SilverMember
 * Date: November 11, 2023,
 * Author: Rhythm Bhandari and Birendra Bista
 * Purpose: The SilverMember class extends MovieMembership,
 * representing Silver status with customizable discount and points rates,
 * and provides methods for purchasing tickets, displaying benefits, and returning membership details.
 */

/**
 * Represents a SilverMember, a type of MovieMembership.
 */
public class SilverMember extends MovieMembership {
    // Discount rate for Silver members
    private double discountRate;

    // Points rate for Silver members
    private double pointsRate;

    /**
     * Constructor for creating a SilverMember with default discount and points rates.
     *
     * @param memberName The name of the member.
     */
    public SilverMember(String memberName) {
        super(memberName);
        this.discountRate = 0.1;
        this.pointsRate = 1.2;
    }

    /**
     * Constructor for creating a SilverMember with custom discount and points rates.
     *
     * @param memberName   The name of the member.
     * @param discountRate The custom discount rate for the member.
     * @param pointsRate   The custom points rate for the member.
     */
    public SilverMember(String memberName, double discountRate, double pointsRate) {
        super(memberName);
        this.discountRate = discountRate;
        this.pointsRate = pointsRate;
    }

    /**
     * Constructor for creating a SilverMember with default discount, points rates and additional movie details.
     *
     * @param memberName   The name of the member.
     * @param nextMovie    The next movie for the member.
     * @param theatreType  The type of theatre for the movie.
     * @param showHour     The hour of the showtime.
     * @param showMinute   The minute of the showtime.
     * @param snack        The chosen snack.
     */
    public SilverMember(String memberName, String nextMovie, String theatreType, int showHour, int showMinute, String snack) {
        super(memberName, nextMovie, theatreType, showHour, showMinute, snack);
        this.discountRate = 0.1;
        this.pointsRate = 1.2;
    }

    /**
     * Constructor for creating a SilverMember with custom discount and points rates and additional movie details.
     *
     * @param memberName   The name of the member.
     * @param nextMovie    The next movie for the member.
     * @param theatreType  The type of theatre for the movie.
     * @param showHour     The hour of the showtime.
     * @param showMinute   The minute of the showtime.
     * @param snack        The chosen snack.
     * @param discountRate The custom discount rate for the member.
     * @param pointsRate   The custom points rate for the member.
     */
    public SilverMember(String memberName, String nextMovie, String theatreType, int showHour, int showMinute, String snack, double discountRate, double pointsRate) {
        super(memberName, nextMovie, theatreType, showHour, showMinute, snack);
        this.discountRate = discountRate;
        this.pointsRate = pointsRate;
    }

    /**
     * Returns the membership rank of the member.
     *
     * @return The membership rank.
     */
    @Override
    public String returnMembershipRank() {
        return "Silver";
    }

    /**
     * Returns the member's details.
     *
     * @return Details of the member.
     */
    @Override
    public String getMemberDetails() {
        return String.format("%s They have %s membership.", super.getMemberDetails(), returnMembershipRank());
    }

    /**
     * Prints the benefits associated with Silver membership.
     */
    @Override
    public void printMemberBenefits() {
        System.out.printf("Discount Rate: %.1f%%%n", discountRate * 100);
        System.out.println("Points gained per dollar: " + pointsRate);
    }

    /**
     * Purchases a movie ticket for a Silver member and updates member details.
     *
     * @param ticketPrice The price of the movie ticket.
     * @param nextMovie   The name of the next movie.
     * @param theatreType The type of theatre.
     * @param showHour    The hour of the showtime.
     * @param showMinute  The minute of the showtime.
     * @param snack       The snack to be purchased.
     */
    @Override
    public void purchaseMovieTicket(double ticketPrice, String nextMovie, String theatreType, int showHour, int showMinute, String snack) {
        setNextMovie(nextMovie);
        setTheatreType(theatreType);
        setShowtime(showHour, showMinute);
        setSnack(snack);

        double priceWithDiscount = ticketPrice * (1 - discountRate);
        int pointsEarned = (int) (ticketPrice * pointsRate);

        addPoints(pointsEarned);

        System.out.println(String.format("The Movie %s has been purchased by %s for %.4f and will be showing at %s with %s screening. They have earned %d points.", nextMovie, getMemberName(), priceWithDiscount, displayShowTime(), theatreType, pointsEarned));
    }
}
