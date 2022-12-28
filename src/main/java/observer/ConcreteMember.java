package observer;

public class ConcreteMember implements Member{

    // The data object is instance of UndoableStringBuilder for the shallow copy.
    private UndoableStringBuilder data;

    /**
     * Constructor to build a ConcreteMember.
     * Set the default data value to the string null.
     */
    public ConcreteMember(){
        data = new UndoableStringBuilder("null");
    }


    /**
     * Update the {@code data} to the new data from the GroupAdmin.
     * The data save as a shallow copy.
     * @param usb the new data to update.
     */
    @Override
    public void update(UndoableStringBuilder usb){
        data = usb;
    }

    /**
     * @return the current data of the member as a String.
     */
    public String getData(){
        return data.toString();
    }

}
