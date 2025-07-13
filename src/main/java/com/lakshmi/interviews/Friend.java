package com.lakshmi.interviews;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Friend {
    private Collection<Friend> friends;
    private String email;
    
    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }
    
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
    
    public static void main(String[] args) {
        
        Friend a= new Friend("A");
        Friend b= new Friend("B");
        Friend c= new Friend("C");
        Friend d= new Friend("D");
        Friend e= new Friend("E");
        Friend f= new Friend("F");
        Friend g= new Friend("G");
        Friend h= new Friend("H");
        Friend i= new Friend("I");
        Friend j= new Friend("J");
        Friend k= new Friend("K");
        Friend l= new Friend("L");
        Friend m= new Friend("M");
        Friend n= new Friend("N");
        Friend o= new Friend("O");
        Friend p= new Friend("P");
        Friend q= new Friend("Q");
        Friend r= new Friend("R");
        Friend s= new Friend("S");
        Friend t= new Friend("T");
        Friend u= new Friend("U");
        Friend v= new Friend("V");
        Friend w= new Friend("W");
        Friend x= new Friend("X");
        Friend y= new Friend("Y");
        Friend z= new Friend("Z");

        a.addFriendship(b);
        b.addFriendship(c);
        c.addFriendship(d);
        d.addFriendship(e);
        e.addFriendship(f);
        f.addFriendship(g);
        g.addFriendship(h);
        h.addFriendship(i);
        i.addFriendship(j);
        j.addFriendship(k);
        k.addFriendship(l);
        l.addFriendship(m);
        m.addFriendship(n);
        n.addFriendship(o);
        o.addFriendship(p);
        p.addFriendship(q);
        q.addFriendship(r);
        r.addFriendship(s);
        s.addFriendship(t);
        t.addFriendship(u);
        u.addFriendship(v);
        v.addFriendship(w);
        w.addFriendship(x);
        x.addFriendship(y);
        y.addFriendship(z);
        
        System.out.println("a can be connected to z : "+a.canBeConnected(z));
//        System.out.println("z can be connected to a : "+z.canBeConnected(a));
    }
    
    public boolean canBeConnected(Friend friend) {
    	
    	if(friend == null) {
	        throw new UnsupportedOperationException("Waiting to be implemented.");
	    }
	    
    	/* Not working if any gap in the chain
    	 * for(final Friend f : friend.getFriends()){
    		if(f.getEmail() == this.getEmail() || canBeConnected(f)){
                return true;
            }
        }
    	return false;*/
    	
    	return canConnect(this, friend, new ArrayList<>());
    }
    
    public boolean canConnect(Friend srcfriend, Friend destFriend, ArrayList<String> visitedFriendMails) {
    	
    	for(int i = 0; i < destFriend.getFriends().size() && !visitedFriendMails.contains(srcfriend.getEmail()); i++ ) {
    		
    		Friend newFriend = destFriend.getFriends().stream().collect(Collectors.toList()).get(i);
    		
    		if(!visitedFriendMails.contains(newFriend.getEmail()) ) {
    			visitedFriendMails.add(newFriend.getEmail());
    			
        		if(srcfriend.getEmail().equals(newFriend.getEmail())  ) {
        			return true;
        		} else {
        			canConnect(srcfriend, newFriend, visitedFriendMails);
        		}
    		}
    	}
    	
    	if(visitedFriendMails.contains(srcfriend.getEmail()) ) {
			return true;
		}
    	
    	return false;
    }
}