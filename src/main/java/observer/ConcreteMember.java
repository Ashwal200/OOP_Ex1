package observer;

public class ConcreteMember implements Member{

    private String data;

    /**
     * Constructor to build a ConcreteMember.
     */
    public ConcreteMember(){
    }

    /**
     * Update the {@code data} to the new data from the GroupAdmin.
     * The data save as a shallow copy.
     * @param usb the new data to update.
     */
    @Override
    public void update(UndoableStringBuilder usb){
        data = usb.toString();
    }

    /**
     * Return the current data of the member.
     * @return the member's data.
     */
    public String getData(){
        return data;
    }

}
