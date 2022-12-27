package observer;

import org.junit.jupiter.api.Test;

class GroupAdminTest {

    Sender sender = new GroupAdmin();
    ConcreteMember m1 = new ConcreteMember();
    ConcreteMember m2 = new ConcreteMember();
    ConcreteMember m3 = new ConcreteMember();


    @Test
    void register() {
        sender.register(m1);

    }

    @Test
    void unregister() {
        sender.register(m1);
        sender.unregister(m2);
        sender.register(m1);
    }

    @Test
    void insert() {
    }

    @Test
    void append() {
    }

    @Test
    void delete() {
    }

    @Test
    void undo() {
    }
}