import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;


public class Tests {

    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

    // Local variable to work with.
    GroupAdmin sender = new GroupAdmin();
    ConcreteMember m1 = new ConcreteMember();
    ConcreteMember m2 = new ConcreteMember();


    @Test
    void register() {
        sender.append("Aviya");
        assertNotEquals(sender.getData(), m1.getData());
        // Append new string to show the different between sender and m1 before the register function(not equals).

        assertEquals(0, sender.getMemberHashSet().size());
        //Show that the member list is empty in the start.

        sender.register(m1);
        sender.register(m1);
        assertEquals(1, sender.getMemberHashSet().size());
        //Show that if the user adding the same member twice, only one will save (no duplicate members).

        assertEquals(false, sender.getMemberHashSet().contains(m2));
        sender.register(m2);
        assertEquals(true, sender.getMemberHashSet().contains(m2));
        // show the before and after apply register function on new member.
    }

    @Test
    void unregister() {
        assertEquals(false, sender.getMemberHashSet().contains(m1));
        sender.register(m1);
        assertEquals(true, sender.getMemberHashSet().contains(m1));

        sender.unregister(m1);
        assertEquals(false, sender.getMemberHashSet().contains(m1));
        // show the before and after apply un register function on new member.

        sender.unregister(m1);
        //If the member is not in the member's set the function will do nothing.

    }

    @Test
    void insert() {
        sender.register(m1);
        assertEquals(m1.getData(), sender.getData());

        sender.insert(0,"Aviya and Ron");
        assertEquals("Aviya and Ron", m1.getData());
        assertEquals(m1.getData(), sender.getData());
    }

    @Test
    void append() {
        sender.register(m1);
        assertEquals(m1.getData(), sender.getData());

        sender.append("Aviya and Ron");
        assertEquals("Aviya and Ron", m1.getData());
        assertEquals(m1.getData(), sender.getData());
    }

    @Test
    void delete() {
        sender.register(m1);
        sender.append("Aviya and Ron");
        assertEquals(m1.getData(), sender.getData());

        System.out.println(sender.getData());
        sender.delete(0,6);
        System.out.println(sender.getData());
        assertEquals(m1.getData(), sender.getData());
    }

    @Test
    void undo() {
        sender.register(m1);
        assertEquals(m1.getData(), sender.getData());

        sender.append("Aviya and Ron");
        assertEquals(m1.getData(), sender.getData());

        sender.undo();
        assertEquals(m1.getData(), sender.getData());
    }

    /**
     * The test shows that after register a new member the memory size increase.
     */
    @Test
    void objectFootPrint(){
        logger.info(()->JvmUtilities.objectFootprint(sender));
        sender.register(m1);
        logger.info(()->JvmUtilities.objectFootprint(sender));
        logger.info(()->JvmUtilities.jvmInfo());

    }
    /**
     * The test shows that after append a new string to the sender the memory size increase.
     */
    @Test
    void objectTotalSize(){
        logger.info(()->JvmUtilities.objectTotalSize(sender));
        sender.append("Ron and Aviya.");
        logger.info(()->JvmUtilities.objectTotalSize(sender));
        logger.info(()->JvmUtilities.jvmInfo());
    }


}
