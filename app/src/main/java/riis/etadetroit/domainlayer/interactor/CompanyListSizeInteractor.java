package riis.etadetroit.domainlayer.interactor;

import android.content.Context;

import riis.etadetroit.datalayer.Repository;

/**
 * Created by bmarshall on 2/9/17.
 */

public class CompanyListSizeInteractor {
    private Context context;

    public CompanyListSizeInteractor(Context context){
        this.context = context;
    }

    public int getCompanyListSize(){
        Repository repository = new Repository(context);
        return repository.getCompanyListSize();
    }
}
