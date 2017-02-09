package riis.etadetroit.presentationlayer.presenter;

import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.domainlayer.interactor.CompanyImageIDInteractor;
import riis.etadetroit.domainlayer.interactor.CompanyNameInteractor;
import riis.etadetroit.domainlayer.interactor.RoutesInteractor;
import riis.etadetroit.domainlayer.interfaces.CompanyDetailsContract;
import riis.etadetroit.datalayer.model.CompanyData;
import riis.etadetroit.datalayer.model.ETADetroitDatabaseHelper;

/**
 * Created by bmarshall on 2/6/17.
 */

public class CompanyDetailsPresenter implements CompanyDetailsContract.CompanyDetailsPresenter {

    private Context context;

    public CompanyDetailsPresenter(Context context){
        this.context = context;
    }

    public String getCompanyName(int position) {
        CompanyNameInteractor companyNameInteractor = new CompanyNameInteractor(context);
        return companyNameInteractor.getCompanyName(position);
    }

    public int getCompanyImageResourceId(int position) {
        CompanyImageIDInteractor companyImageID = new CompanyImageIDInteractor(context);
        return companyImageID.getCompanyImageResourceId(position);
    }

    public Cursor getRoutes(String company) {
        RoutesInteractor routesInteractor = new RoutesInteractor(context);
        return routesInteractor.getRoutes(company);
    }
}
