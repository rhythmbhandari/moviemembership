/**
 * Represents a VIPPrivilege interface with VIP privileges.
 */
public interface VIPPrivilege {
    // Constant for the VIP lounge password
    int PASSWORD = 2222;

    /**
     * Grants access to the VIP lounge.
     */
    void accessVIPLounge();

    /**
     * Purchases alcohol and returns a message.
     *
     * @return A message indicating the purchase of alcohol.
     */
    String purchaseAlcohol();
}
