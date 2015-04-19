package com.fixmyfolks.data;

import org.mongodb.morphia.query.Query;

import com.fixmyfolks.data.model.Account;
import com.fixmyfolks.data.model.Problem;
import com.fixmyfolks.justgiving.model.SearchResult;

public interface FixFolkData {
    public Query<Account> getAllAccounts();
    public Query<Problem> getAllProblems();
    public Account getAccountById(String id);
    public Problem getProblemById(String id);
    public Account getAccountByVenmoId(String id);
    public Query<Problem> getProblemsForFolk(Account account);
    public Query<Problem> getProblemsForFixer(Account account);
	public Query<Problem> getAvailableProblemsForFixer(Account account);
    public Query<Account> getFixersInterestedInTag(String tag);
    public String getJustGivingDonationFormUrl(String charityId, Double price, String problemId);
    public void flagDonationOnProblem(String problemId, SearchResult charity);
    public void save(Object thing);
    public void delete(Object thing);
}
