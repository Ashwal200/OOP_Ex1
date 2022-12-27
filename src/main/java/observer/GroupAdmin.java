package observer;

import java.util.HashSet;


public class GroupAdmin implements Sender{

    private UndoableStringBuilder usb;
    private HashSet<Member> alcm;

    /**
     * Constructor to build a GroupAdmin object.
     * The constructor make a new hash set to save all the members.
     */
    public GroupAdmin(){
        alcm = new HashSet<>();
        usb = new UndoableStringBuilder(); // לבדוק האם צריך בכלל הנוטיפי בפונקציית ההוספה
    }

    /**
     * Add a new member to the GroupAdmin's hash set.
     * If the member is already in the hash set, the function will override
     * the last member and save the new one.
     * Else it will be added to the hash set.
     * @param obj new member to add.
     */
    @Override
    public void register(Member obj){
        alcm.add(obj);
        obj.update(usb);
    }


//    public void unregister(Member obj) throws UnexistMember {
//        if (alcm.contains(obj)) {
//            alcm.remove(obj);
//        }
//        else { //throw expiation
//            throw  new UnexistMember();
//        }
//    }

    /**
     * Remove a member from the GroupAdmin's hash set.
     * If the member is in the hash set, he will be removed.
     * Else the function will do nothing.
     * @param obj member to remove.
     */
    @Override
    public void unregister(Member obj){
            alcm.remove(obj);
    }


    /**
     * Inserts the string into this character sequence.<Br>
     * The characters of the String argument are inserted, in order, into this sequence at the indicated offset,
     * moving up any characters originally above that position and increasing the length of this sequence by the length of the argument.<br>
     * If str is null , then the four characters "null" are inserted into this sequence.<br>
     * Function {@code notifyAll} Updates all the members who are in the group, with the latest update of {@code usb}.
     *
     * @param offset is the indicated index to start from.
     * @param obj    new parameter to append.
     */
    @Override
    public void insert(int offset, String obj){
        usb.insert(offset, obj);
        notifyAll(usb);
    }

    /**
     * Appends the specified string to this character sequence.<br>
     * And increase the length of the string builder.<br>
     * Function {@code notifyAll} Updates all the members who are in the group, with the latest update of {@code usb}.
     *
     * @param obj new parameter to append.
     */
    @Override
    public void append(String obj){
        usb.append(obj);
        notifyAll(usb);
    }

    /**
     * Removes the characters in a substring of this sequence.<br> The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.<br>
     * If start is equal to end, no changes are made.<br>
     * Function {@code notifyAll} Updates all the members who are in the group, with the latest update of {@code usb}.
     *
     * @param start is the index of character to begin with.
     * @param end   is the index of character to stop.
     */
    @Override
    public void delete(int start, int end){
        usb.delete(start, end);
        notifyAll(usb);
    }

    /**
     * This function set {@code usb} to the last form of {@code usb}. <br>
     * Function {@code notifyAll} Updates all the members who are in the group, with the latest update of {@code usb}.
     */
    @Override
    public void undo(){
        usb.undo();
        notifyAll(usb);
    }

    /**
     * In order to update all our members,
     * we will use a function that will automatically update them on any change with usb.
     * @param usb - The latest update of {@code usb}.
     */
    private void notifyAll(UndoableStringBuilder usb){
        for (Member member:alcm) {
            member.update(usb);
        }
    }

//    /**
//     *
//     */
//    public class UnexistMember extends Exception{
//        public UnexistMember() {
//            super();
//            System.err.println("The member does not exist!");
//        }
//    }


}
