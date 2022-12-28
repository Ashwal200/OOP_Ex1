package observer;

import java.util.HashSet;


public class GroupAdmin implements Sender{

    private UndoableStringBuilder data;
    private HashSet<Member> memberHashSet;


    /**
     * Constructor to build a GroupAdmin object.
     * The constructor make a new hash set to save all the members.
     * Forevermore make a new UndoableStringBuilder to save the data.
     */
    public GroupAdmin(){
        memberHashSet = new HashSet<>();
        data = new UndoableStringBuilder();
    }

    /**
     * @return the hash set
     */
    public HashSet<Member> getMemberHashSet() {
        return memberHashSet;
    }

    /**
     * @return the data as a String
     */
    public String getData() {
        return data.toString();
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
        memberHashSet.add(obj);
        obj.update(data);
    }


    /**
     * Remove a member from the GroupAdmin's hash set.
     * If the member is in the hash set, he will be removed.
     * Else the function will do nothing.
     * @param obj member to remove.
     */
    @Override
    public void unregister(Member obj){
            memberHashSet.remove(obj);
    }


    /**
     * Inserts the string into this character sequence.<Br>
     * The characters of the String argument are inserted, in order, into this sequence at the indicated offset,
     * moving up any characters originally above that position and increasing the length of this sequence by the length of the argument.<br>
     * If str is null , then the four characters "null" are inserted into this sequence.<br>
     * Function {@code notifyAll} Updates all the members who are in the group, with the latest update of {@code data}.
     *
     * @param offset is the indicated index to start from.
     * @param obj    new parameter to append.
     */
    @Override
    public void insert(int offset, String obj){
        data.insert(offset, obj);
        notifyAll(data);
    }

    /**
     * Appends the specified string to this character sequence.<br>
     * And increase the length of the string builder.<br>
     * Function {@code notifyAll} Updates all the members who are in the group, with the latest update of {@code data}.
     *
     * @param obj new parameter to append.
     */
    @Override
    public void append(String obj){
        data.append(obj);
        notifyAll(data);
    }

    /**
     * Removes the characters in a substring of this sequence.<br> The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.<br>
     * If start is equal to end, no changes are made.<br>
     * Function {@code notifyAll} Updates all the members who are in the group, with the latest update of {@code data}.
     *
     * @param start is the index of character to begin with.
     * @param end   is the index of character to stop.
     */
    @Override
    public void delete(int start, int end){
        data.delete(start, end);
        notifyAll(data);
    }

    /**
     * This function set {@code data} to the last form of {@code data}. <br>
     * Function {@code notifyAll} Updates all the members who are in the group, with the latest update of {@code data}.
     */
    @Override
    public void undo(){
        data.undo();
        notifyAll(data);
    }

    /**
     * In order to update all our members,
     * we will use a function that will automatically update them on any change with data.
     * @param usb - The latest update of {@code data}.
     */
    private void notifyAll(UndoableStringBuilder usb){
        for (Member member: memberHashSet) {
            member.update(usb);
        }
    }



}
