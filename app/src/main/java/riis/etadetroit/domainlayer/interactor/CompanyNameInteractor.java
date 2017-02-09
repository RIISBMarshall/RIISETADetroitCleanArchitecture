package riis.etadetroit.domainlayer.interactor;

import android.content.Context;

import riis.etadetroit.datalayer.Repository;

/**
 * Created by bmarshall on 2/9/17.
 */

public class CompanyNameInteractor {
    private Context context;

    public CompanyNameInteractor(Context context){
        this.context = context;
    }

    public String getCompanyName(int position) {
        Repository repository = new Repository(context);
        return repository.getCompanyName(position);
    }
}
