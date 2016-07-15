package com.danyapivovarov.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpivovar on 15.07.2016.
 */
public class FindTeamTask {
    private List<String> result;
    private String[] names;
    private int teamSize;

    public FindTeamTask(String[] names, int teamSize) {
        this.names = names;
        this.teamSize = teamSize;
        this.result = new ArrayList<>();
    }

    public void findTeams(String mode, int shift, int full, int team, int next) {
        if (full < team || team == 0) {
            return;
        }

        if (mode.equals("left")) {
            findTeams("left", shift+1, full-1, team-1, next);
            findTeams("right", shift, full-1, team, next);
        }

        if (mode.equals("right")) {
            if (team == 1) {
                String prefix = "";
                for (int i = 0; i < shift; i++) {
                    prefix += names[i];
                }

                if (next == -1) next = shift;

                String t = prefix + names[next];
                next++;
                result.add(t);
            }

            findTeams("left", shift+1, full-1, team-1, next);
            findTeams("right", shift, full-1, team, next);
        }
    }

    public List<String> getResult() {
        return result;
    }

    public static void main(String[] args) {
        String[] full = new String[]{"A", "B", "C", "D", "E"};

        FindTeamTask task = new FindTeamTask(full, 3);
        task.findTeams("left", 1, full.length-1, 2, -1);
        task.findTeams("right", 0, full.length-1, 3, -1);
    }
}
