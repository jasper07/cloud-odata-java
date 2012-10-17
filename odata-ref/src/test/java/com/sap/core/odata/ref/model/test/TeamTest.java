package com.sap.core.odata.ref.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sap.core.odata.ref.model.Employee;
import com.sap.core.odata.ref.model.Team;

public class TeamTest {

  private static final String VALUE_NAME = "Team 1";
  private static final boolean SCRUM_TEAM_TRUE = true;

  @Test
  public void testId() {
    Team team1 = new Team();
    String testId = team1.getId();
    assertNotNull(testId);
  }

  @Test
  public void testName() {
    Team team1 = new Team();
    team1.setName(VALUE_NAME);
    String testName = team1.getName();
    assertEquals(testName, VALUE_NAME);
  }

  @Test
  public void testIsScrumTeam() {
    Team team1 = new Team();
    team1.setScrumTeam(SCRUM_TEAM_TRUE);
    boolean testValue = team1.isScrumTeam();
    assertEquals(testValue, SCRUM_TEAM_TRUE);
  }

  @Test
  public void testEmployees() {
    Team team1 = new Team(VALUE_NAME);
    Employee employee1 = new Employee();
    Employee employee2 = new Employee();
    List<Employee> testList = new ArrayList<Employee>();
    testList.add(employee1);
    testList.add(employee2);
    // Relationship should be set by n site
    for (Employee emp : testList) {
      emp.setTeam(team1);
    }
    assertEquals(testList, team1.getEmployees());
    assertEquals(team1, employee1.getTeam());
  }
}