package com.fixmyfolks.data;

import com.fixmyfolks.data.model.Account;
import com.fixmyfolks.data.model.Problem;

public interface FixFolkData {
    public Iterable<Account> getAllAccounts();
    public Iterable<Problem> getAllProblems();
    public Account getAccountById(String id);
    public Problem getProblemById(String id);
    public Iterable<Problem> getProblemsForFolk(Account account);
    public Iterable<Problem> getProblemsForFixer(Account account);
    public void save(Object thing);
}
