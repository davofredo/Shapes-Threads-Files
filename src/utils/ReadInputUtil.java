package utils;

import javax.swing.*;
import static constants.MenuMessages.OPTION_NOT_VALID;
import static constants.MenuMessages.NOT_ZERO;

public class ReadInputUtil {
    public static double readDouble(String str1, String str2) {
        boolean valid = false;
        double input = 0.0;
        String choice;
        do {
            try {
                choice = JOptionPane.showInputDialog(String.format(str1, str2));
                input = Double.parseDouble(choice);
                if (input == 0.0)
                    JOptionPane.showMessageDialog(null,NOT_ZERO);
                else
                    return input;
                // TODO: choice is never null but if it was, why not to handle it here, instead of throwing an exception?
                if (choice == null) throw new NullPointerException();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, OPTION_NOT_VALID);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            } catch (NullPointerException ex) {
                Exit.exit();
            }
            // TODO: Valid is not modified in the loop, but anyway, the loop is going to exit when the input gets returned. In this case, while(true) is a valid option
        } while (!valid);
        return input;
    }
}
