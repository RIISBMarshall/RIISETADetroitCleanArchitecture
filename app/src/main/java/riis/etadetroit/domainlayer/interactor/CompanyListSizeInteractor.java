package riis.etadetroit.domainlayer.interactor;

import android.content.Context;

import riis.etadetroit.datalayer.repository.Repository;

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
