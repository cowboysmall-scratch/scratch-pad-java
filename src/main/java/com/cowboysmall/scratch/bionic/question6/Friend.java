package com.cowboysmall.scratch.bionic.question6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Friend {

    private Collection<Friend> friends;

    private String email;


    //_________________________________________________________________________

    public Friend(String email) {

        this.friends = new ArrayList<>();
        this.email = email;
    }


    //_________________________________________________________________________

    public String getEmail() {

        return email;
    }

    public Collection<Friend> getFriends() {

        return friends;
    }

    public void addFriendship(Friend friend) {

        friends.add(friend);
        friend.getFriends().add(this);
    }


    //_________________________________________________________________________

    public boolean canBeConnected(Friend friend) {

        if (friends.contains(friend)) return true;

        Set<Friend> set = new HashSet<>(friends);

        Stack<Friend> stack = new Stack<>();
        stack.addAll(friends);

        while (!stack.empty()) {

            Collection<Friend> friends = stack.pop().getFriends();

            if (friends.contains(friend)) return true;

            for (Friend ff : friends) {

                if (!set.contains(ff)) {

                    set.add(ff);
                    stack.push(ff);
                }
            }
        }

        return false;
    }
}
