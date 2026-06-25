package org.dominokit.showcases.samples.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ContactsProvider {

    public static final ContactsProvider instance =  new ContactsProvider();

    static List<Contact> contacts = new ArrayList<>();

    public static void setContacts(List<Contact> contacts) {
        ContactsProvider.contacts = contacts == null ? new ArrayList<>() : new ArrayList<>(contacts);
    }

    public List<Contact> contactsList(int count) {
        List<Contact> generatedContacts = new ArrayList<>();
        if (contacts.isEmpty() || count <= 0) {
            return generatedContacts;
        }

        Random random = new Random(new Date().getTime());
        for (int rootIndex = 0; rootIndex < count; rootIndex++) {
            Contact root = new Contact(randomContact(random));
            root.setDepth(0);
            root.setIndex(rootIndex);
            generatedContacts.add(root);
        }

        return generatedContacts;
    }

    public void addFriends(Contact root, int leavesCount, int depth, int maxDepth) {
        if (root == null || contacts.isEmpty()) {
            return;
        }

        Random random = new Random(new Date().getTime());
        if (depth > 0 && root.getDepth() < maxDepth) {
            for (int leafIndex = 0; leafIndex < leavesCount; leafIndex++) {
                Contact friend = new Contact(randomContact(random));
                int childDepth = root.getDepth() + 1;
                friend.setDepth(childDepth);
                friend.setIndex(leafIndex);
                if(childDepth == maxDepth){
                    friend.setHasChildren(false);
                }
                root.addFriend(friend);
                addFriends(friend, leavesCount, depth - 1, maxDepth);
            }
        }

        root.getFriends().sort((o1, o2) -> Double.compare(o2.getIndex(), o1.getIndex()));
    }

    public List<Contact> subList() {
        return subList(0, 15);
    }

    public List<Contact> subList(int size) {
        return subList( 0, size);
    }

    public List<Contact> subList(int from, int to) {
        if (contacts.isEmpty()) {
            return new ArrayList<>();
        }

        int safeFrom = Math.max(0, Math.min(from, contacts.size()));
        int safeTo = Math.max(safeFrom, Math.min(to, contacts.size()));
        return contacts.subList(safeFrom, safeTo).stream().map(Contact::new).collect(Collectors.toList());
    }

    private Contact randomContact(Random random) {
        return contacts.get(random.nextInt(contacts.size()));
    }
}
