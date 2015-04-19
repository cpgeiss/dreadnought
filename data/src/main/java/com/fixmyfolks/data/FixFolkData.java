package com.fixmyfolks.data;

import com.fixmyfolks.data.model.Folk;
import com.fixmyfolks.data.model.Fixer;
import com.fixmyfolks.data.model.Problem;

public interface FixFolkData {
    public Iterable<Folk> getAllFolks();
    public Iterable<Fixer> getAllFixers();
    public Iterable<Problem> getAllProblems();
    public Folk getFolkById(String id);
    public Fixer getFixerById(String id);
    public Problem getProblemById(String id);
    public void save(Object thing);
}
