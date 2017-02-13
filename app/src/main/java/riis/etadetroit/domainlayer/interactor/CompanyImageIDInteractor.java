package riis.etadetroit.domainlayer.interactor;

import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.datalayer.repository.Repository;

public class CompanyImageIDInteractor {

    Context context;

    public CompanyImageIDInteractor(Context context) {
        this.context = context;
    }

    public int getCompanyImageResourceId(int position) {
        Repository repository = new Repository(context);
        Cursor companyNames = repository.getCompanyNames();

        if (companyNames != null && companyNames.moveToPosition(position)) {
            String imageName = companyNames.getString(0).toLowerCase();
            return context.getResources().getIdentifier(imageName, "drawable",
                    context.getPackageName());
        }
        return 0;
    }
}
