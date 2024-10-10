package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_different_class() {
        assertFalse(team.equals("different class"));
    }

    @Test
    public void equals_name_equals_members() {
        Team t2 = new Team(team.name);
        t2.addMember("name");
        team.addMember("name");
        assertTrue(team.equals(t2));
    }
    
    @Test
    public void equals_name_different_members() {
        Team t2 = new Team(team.name);
        t2.addMember("name_2");
        team.addMember("name");
        assertFalse(team.equals(t2));
    }

    @Test
    public void different_name_equal_members() {
        Team t2 = new Team("different_name");
        team.addMember("name");
        t2.addMember("name");
        assertFalse(team.equals(t2));
    }

    @Test
    public void different_name_different_members() {
        Team t2 = new Team("different_name");
        t2.addMember("different_member");
        team.addMember("name");
        assertFalse(team.equals(t2));
    }

    @Test
    public void hashCode_different_members() {
        team.addMember("name");
        Team t2 = new Team("test-team");
        t2.addMember("name_2");
        assertFalse(team.hashCode() == t2.hashCode());
    }

    @Test
    public void hashCode_same_members() {
        team.addMember("name");
        Team t2 = new Team("test-team");
        t2.addMember("name");
        assertTrue(team.hashCode() == t2.hashCode());
    }

    @Test
    public void hashCode_fixed_value() {
        Team t = new Team("fixed_name");
        t.addMember("fixed_member");
        
        int actualHashCode = t.hashCode();
        int expectedResult = 2112607734; 

        assertEquals(expectedResult, actualHashCode);
    }

}
