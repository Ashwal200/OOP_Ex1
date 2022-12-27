package observer;

import java.util.Stack;
// Some of the descriptions of the functions were inspired by the Website: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
class ExceptionNotInOrderIndex extends Exception {
    public ExceptionNotInOrderIndex(String error){
        super(error);
    }
}
public class UndoableStringBuilder {


    private StringBuilder sb = new StringBuilder();
    private Stack<StringBuilder> stack = new Stack<StringBuilder>();
    public StringBuilder getSb() {
        return sb;
    }
    /**
     * Constructs a string builder initialized to the contents of the specified string.<br>
     * The initial capacity of the string builder is 16 plus the length of the string argument.<br>
     * The function include Try and Catch to handle Exception.
     *
     * @param str new parameter to add.
     */
    public UndoableStringBuilder(String str) {
        try {
            exceptionStr(str);
            sb = new StringBuilder(str);
        } catch (NullPointerException e) {
            System.err.println("Cannot add null.");
            e.printStackTrace();
        }
    }

    /**
     * Constructs a undo string builder with no characters in it and an initial capacity of 16 characters.
     */
    public UndoableStringBuilder() {
    }


    /**
     * Function if that related to #Replace + #Delete + #Insert + #Remove
     *
     * @param start is the index of character to begin with.
     * @param end   is the index of character to stop.
     * @throws ExceptionNotInOrderIndex        if index start is bigger than index end.
     * @throws StringIndexOutOfBoundsException if index start or end is small then 0.
     */
    public void exception(int start, int end) throws ExceptionNotInOrderIndex, StringIndexOutOfBoundsException {
        if (start > end)
            throw new ExceptionNotInOrderIndex(" ExceptionNotInOrderIndex: Index " + start + " is bigger than " + end);
    }

    /**
     * Function if that related to #Replace + #Undostringbuilder.
     *
     * @param str new parameter to check.
     * @throws NullPointerException if String is null.
     */
    public void exceptionStr(String str) throws NullPointerException {
        if (str == null) throw new NullPointerException("NullPointerException: str = null.");
    }

    /**
     * First the current value in {@code sb} to {@code stack} <br>
     * Appends the specified string to this character sequence.<br>
     * And increase the length of the string builder.
     *
     * @param str new parameter to append.
     * @return a reference to this object.
     */
    public UndoableStringBuilder append(String str) {
        StringBuilder sbAppend = new StringBuilder(this.sb);
        this.stack.push(sbAppend);
        this.sb.append(str);
        return this;
    }

    /**
     * Removes the characters in a substring of this sequence.<br> The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.<br>
     * If start is equal to end, no changes are made.<br>
     * The function include Try and Catch to handle Exceptions.<br>
     * Then the current value in {@code sb} go to {@code stack}.
     *
     * @param start is the index of character to begin with.
     * @param end   is the index of character to stop.
     * @return a reference to this object.
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            exception(start, end);
            StringBuilder sbDelete = new StringBuilder(this.sb);
            this.sb.delete(start, end);
            this.stack.push(sbDelete);
        } catch (ExceptionNotInOrderIndex e) {
            System.err.println("Please enter a valid index.");
            e.printStackTrace();
            // If the index of start is bigger than the index of end.
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Please try again , the index doesn't exist. ");
            e.printStackTrace();
            // If the given Index is lower than 0.
        }
        // *** If any other 'Unknown' exception happens.. ***
        catch (Exception e) {
            System.err.println("Something went wrong.");
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Inserts the string into this character sequence.<Br>
     * The characters of the String argument are inserted, in order, into this sequence at the indicated offset,
     * moving up any characters originally above that position and increasing the length of this sequence by the length of the argument.<br>
     * If str is null , then the four characters "null" are inserted into this sequence.<br>
     * The function include Try and Catch to handle Exceptions.<br>
     * Then the current value in {@code sb} go to {@code stack}.
     *
     * @param offset is the indicated index to start from.
     * @param str    new parameter to append.
     * @return a reference to this object.
     */
    public UndoableStringBuilder insert(int offset, String str) {

        try {
            exception(0, offset);
            StringBuilder sbInsert = new StringBuilder(this.sb);
            this.sb.insert(offset, str);
            this.stack.push(sbInsert);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Please try again , the index doesn't exist.");
            e.printStackTrace();
            // If the given Index is lower than 0.
        }

        // *** If any other 'Unknown' exception happens.. ***
        catch (Exception e) {
            System.err.println("Something went wrong.");
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String.<br> The substring begins at the specified start and
     * extends to the character at index end - 1 or to the end of the sequence if
     * no such character exists.<br> First the characters in the substring are removed
     * and then the specified String is inserted at start.<br> (This sequence will be
     * lengthened to accommodate the specified String if necessary).<br>
     * The function include Try and Catch to handle Exceptions. <br>
     * Then the current value in {@code sb} go to {@code stack}.
     *
     * @param start is the index of character to begin with.
     * @param end   is the index of character to stop.
     * @param str   new parameter to append.
     * @return a reference to this object.
     */
    public UndoableStringBuilder replace(int start, int end, String str) {

        try {
            exception(start, end);
            exceptionStr(str);
            StringBuilder sbReplace = new StringBuilder(this.sb);
            this.sb.replace(start, end, str);
            this.stack.push(sbReplace);
        } catch (NullPointerException e) {
            System.err.println("Please do not enter a null String!");
            e.printStackTrace();
        } catch (ExceptionNotInOrderIndex e) {
            System.err.println("Please enter a valid index.");
            e.printStackTrace();
            // If the index of start is bigger than the index of end.
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Please try again , the index doesn't exist. ");
            e.printStackTrace();
            // If the given Index is lower than 0.
        }
        // *** If any other 'Unknown' exception happens.. ***
        catch (Exception e) {
            System.err.println("Something went wrong.");
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     * sequence.<br>
     * If there are any surrogate pairs included in the sequence, these are treated as single characters for the reverse operation.<br>
     * Thus, the order of the high-low surrogates is never reversed.<br>
     * Let n be the character length of this character sequence (not the length in char values) just prior to execution of the reverse method.<br>
     * Then the character at index k in the new character sequence is equal to the character at index n-k-1 in the old character sequence.<br>
     * Then the current value in {@code sb} go to {@code stack}.
     *
     * @return a reference to this object.
     */
    public UndoableStringBuilder reverse() {
        StringBuilder sbReverse = new StringBuilder(this.sb);
        this.sb.reverse();
        this.stack.push(sbReverse);
        return this;
    }


    /**
     * This function set {@code sbUndo} to the last value that enter to the stack. <br>
     * If the stack is empty return.
     *
     * @return a reference to this object.
     */
    public void undo() {
        if (stack.isEmpty() && !sb.toString().equals("")) sb = new StringBuilder("");
        if (!stack.isEmpty()) {
            StringBuilder sbUndo = new StringBuilder(this.sb);
            sb = this.stack.pop();
        }
    }

    @Override
    public String toString() {
        return sb + "";
    }
}