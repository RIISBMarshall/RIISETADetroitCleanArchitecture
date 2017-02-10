package riis.etadetroit.presentationlayer.presenter;

import android.content.Context;

import riis.etadetroit.domainlayer.interactor.CompanyImageIDInteractor;
import riis.etadetroit.domainlayer.interactor.CompanyListSizeInteractor;
import riis.etadetroit.domainlayer.interactor.CompanyNameInteractor;

public class MainActivityPresenter {

    private Context context;

    public MainActivityPresenter(Context context){
        this.context = context;
    }

    public int getCompanyListSize() {
        CompanyListSizeInteractor companyListSizeInteractor = new CompanyListSizeInteractor(context);
        return companyListSizeInteractor.getCompanyListSize();
    }

    public String getCompanyName(int position) {
        CompanyNameInteractor companyNameInteractor = new CompanyNameInteractor(context);
        return companyNameInteractor.getCompanyName(position);
    }

    public int getCompanyImageResourceId(int position) {
        CompanyImageIDInteractor companyImageIDInteractor = new CompanyImageIDInteractor(context);
        return companyImageIDInteractor.getCompanyImageResourceId(position);
    }
}
