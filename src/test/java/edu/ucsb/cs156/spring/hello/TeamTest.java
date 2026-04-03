package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    public void test_toString() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void test_equalsSelf() {
        assertEquals(team, team);
    }

    @Test
    public void test_equalsSameData() {
        Team team2 = new Team("test-team");
        assertEquals(team, team2);
    }

    @Test
    public void test_equalsDifferentMembers() {
        Team team2 = new Team("test-team");
        team2.addMember("Member 1");
        assertNotEquals(team, team2);
    }

    @Test
    public void test_equals_differentNameSameMembers() {
        Team team1 = new Team("team-1");
        Team team2 = new Team("team-2");
        assertNotEquals(team1, team2);
    }

    @Test
    public void test_equals_differentObject() {
        Object notATeam = new Object();
        assertNotEquals(team, notATeam);
    }

    @Test
    public void test_hashCode() {
        Team t1 = new Team("Alpha");
        t1.addMember("Arjun");

        Team t2 = new Team("Zeta");
        t2.addMember("SomeoneElse");
        t2.addMember("AnotherPerson");

        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void test_hashCode_all_fields() {
        Team t1 = new Team("Team-Alpha-Prime");
        int h1 = t1.hashCode();

        Team t2 = new Team("Team-Beta-Omega");
        int h2 = t2.hashCode();

        Team t3 = new Team("Team-Alpha-Prime");
        t3.addMember("FirstUniqueMember");
        int h3 = t3.hashCode();

        Team t4 = new Team("Team-Beta-Omega");
        t4.addMember("SecondUniqueMember");
        t4.addMember("ThirdUniqueMember");
        int h4 = t4.hashCode();

        assertNotEquals(h1, h2);
        assertNotEquals(h1, h3);
        assertNotEquals(h1, h4);
        assertNotEquals(h2, h3);
        assertNotEquals(h2, h4);
        assertNotEquals(h3, h4);
    }
}