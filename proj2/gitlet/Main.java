package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author LeoanrdoFerigutti
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            Utils.message("Please enter a command.");
            System.exit(0);
        }
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                validateNumArgs("init", args, 0);
                break;
            case "add":
                break;
            case "commit":
                break;
            default:
                Utils.message("No command with that name exists.");
                System.exit(0);
        }
    }
    /**
     * Checks the number of arguments versus the expected number,
     * throws a RuntimeException if they do not match.
     *
     * @param cmd Name of command you are validating
     * @param args Argument array from command line
     * @param n Number of expected arguments
     */
    public static void validateNumArgs(String cmd, String[] args, int n) {
        if (args.length != n) {
            Utils.message("Incorrect Operands.");
            System.exit(0);
        }
    }
}
