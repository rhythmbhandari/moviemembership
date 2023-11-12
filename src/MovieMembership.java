/**
 * Abstract class representing a movie membership.
 */
public abstract class MovieMembership {
    // Member variables
    private String memberName;
    private String nextMovie;
    private String theatreType;
    private int showHour;
    private int showMinutes;
    private String snack;
    private int points;

    /**
     * Constructor for creating a MovieMembership with basic details.
     *
     * @param memberName The name of the member.
     */
    public MovieMembership(String memberName) {
        // Initialize with default values
        this.memberName = memberName;
        this.nextMovie = "unknown";
        this.theatreType = "standard";
        this.showHour = 0;
        this.showMinutes = 0;
        this.snack = "unknown";
        this.points = 0;
    }

    /**
     * Constructor for creating a MovieMembership with specified details.
     *
     * @param memberName  The name of the member.
     * @param nextMovie   The name of the next movie.
     * @param theatreType The type of theatre.
     * @param showHour    The hour of the showtime.
     * @param showMinutes The minute of the showtime.
     * @param snack       The snack for the movie.
     */
    public MovieMembership(String memberName, String nextMovie, String theatreType, int showHour, int showMinutes, String snack) {
        // Initialize with specified values
        this.memberName = memberName;
        this.nextMovie = nextMovie;
        this.theatreType = theatreType;
        this.showHour = showHour;
        this.showMinutes = showMinutes;
        this.snack = snack;
        this.points = 0;
    }

    /**
     * Returns the membership rank of the member.
     *
     * @return The membership rank.
     */
    public abstract String returnMembershipRank();

    /**
     * Prints the benefits associated with the membership.
     */
    public abstract void printMemberBenefits();

    /**
     * Purchases a movie ticket and updates member details.
     *
     * @param ticketPrice The price of the movie ticket.
     * @param nextMovie   The name of the next movie.
     * @param theatreType The type of theatre.
     * @param showHour    The hour of the showtime.
     * @param showMinutes The minute of the showtime.
     * @param snack       The snack to be purchased.
     */
    public abstract void purchaseMovieTicket(double ticketPrice, String nextMovie, String theatreType, int showHour, int showMinutes, String snack);

    // Getter methods

    /**
     * Gets the name of the member.
     *
     * @return The member's name.
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * Gets the name of the next movie.
     *
     * @return The name of the next movie.
     */
    public String getNextMovie() {
        return nextMovie;
    }

    /**
     * Gets the type of theatre.
     *
     * @return The type of theatre.
     */
    public String getTheatreType() {
        return theatreType;
    }

    /**
     * Gets the hour of the showtime.
     *
     * @return The hour of the showtime.
     */
    public int getShowHour() {
        return showHour;
    }

    /**
     * Gets the minute of the showtime.
     *
     * @return The minute of the showtime.
     */
    public int getShowMinutes() {
        return showMinutes;
    }

    /**
     * Gets the snack for the movie.
     *
     * @return The snack for the movie.
     */
    public String getSnack() {
        return snack;
    }

    /**
     * Gets the points earned by the member.
     *
     * @return The points earned.
     */
    public int getPoints() {
        return points;
    }

    // Setter methods

    /**
     * Sets the name of the next movie.
     *
     * @param nextMovie The name of the next movie.
     */
    public void setNextMovie(String nextMovie) {
        this.nextMovie = nextMovie;
    }

    /**
     * Sets the type of theatre.
     *
     * @param theatreType The type of theatre.
     */
    public void setTheatreType(String theatreType) {
        this.theatreType = theatreType;
    }

    /**
     * Sets the snack for the movie.
     *
     * @param snack The snack for the movie.
     */
    public void setSnack(String snack) {
        this.snack = snack;
    }

    /**
     * Sets the showtime for the movie.
     *
     * @param hour   The hour of the showtime.
     * @param minute The minute of the showtime.
     */
    public void setShowtime(int hour, int minute) {
        this.showHour = hour;
        this.showMinutes = minute;
    }

    /**
     * Adds points to the member's total points.
     *
     * @param points The points to be added.
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * Returns a formatted string representation of the showtime.
     *
     * @return The showtime as a formatted string.
     */
    public String displayShowTime() {
        return String.format("%02d:%02d", showHour, showMinutes);
    }

    /**
     * Returns a string representation of the member's details.
     *
     * @return Details of the member.
     */
    public String getMemberDetails() {
        return String.format("This membership card belongs to %s. They have %d points. Their next movie is \n%s at %s with a %s screening. They will be having %s as a snack.",
                memberName, points, nextMovie, displayShowTime(), theatreType, snack);
    }
}
