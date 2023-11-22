/**
 * Name: VIPPrivilege
 * Date: November 11, 2023,
 * Author: Rhythm Bhandari and Birendra Bista
 * Purpose: The VIPPrivilege interface defines methods for VIP lounge access, alcohol purchase,
 * and a constant for the VIP lounge password, to be implemented by classes requiring VIP privileges.
 */

/**
 * Represents a VIPPrivilege interface with VIP privileges.
 */
public interface VIPPrivilege {
    // Declaring a constant for the VIP lounge password
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
