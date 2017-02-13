package riis.etadetroit.domainlayer.interactor;

import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.datalayer.repository.Repository;

public class CompanyNameInteractor {
    private Context context;

    public CompanyNameInteractor(Context context) {
        this.context = context;
    }

    public String getCompanyName(int position) {
        Repository repository = new Repository(context);
        Cursor companyNames = repository.getCompanyNames();
        if (companyNames != null && companyNames.moveToPosition(position)) {
            return companyNames.getString(0);
        }
        return null;
    }
}
