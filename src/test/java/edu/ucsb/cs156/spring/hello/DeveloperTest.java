package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s26-teams>
        assertEquals("Arjun Malaviya", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("ArjunLovesCoding", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("s26-12", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Arjun Malaviya"), "Team should contain Arjun Malaviya");
        assertTrue(t.getMembers().contains("Arjun Shah"), "Team should contain Arjun Shah");
        assertTrue(t.getMembers().contains("Jay Yeung"), "Team should contain Jay Yeung");
        assertTrue(t.getMembers().contains("Lorenzo Zucca"), "Team should contain Lorenzo Zucca");
        assertTrue(t.getMembers().contains("Pau Marsa"), "Team should contain Pau Marsa");
        assertTrue(t.getMembers().contains("Pengyu Chen"), "Team should contain Pengyu Chen");
        assertEquals(6, t.getMembers().size());
    }



}
