package riis.etadetroit.domainlayer.interactor;

import android.content.Context;

import riis.etadetroit.datalayer.Repository;
import riis.etadetroit.datalayer.model.CompanyData;

/**
 * Created by bmarshall on 2/9/17.
 */

public class CompanyImageIDInteractor {

    Context context;

    public CompanyImageIDInteractor(Context context){
        this.context = context;
    }

    public int getCompanyImageResourceId(int position) {
        Repository repository = new Repository(context);
        return repository.getCompanyImageResourceId(position);
    }
}
