package riis.etadetroit.presentationlayer.presenter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.graphics.Palette;
import android.widget.AdapterView;

import riis.etadetroit.domainlayer.interactor.CompanyImageIDInteractor;
import riis.etadetroit.domainlayer.interactor.CompanyNameInteractor;
import riis.etadetroit.domainlayer.interactor.OnClickSetupInteractor;
import riis.etadetroit.domainlayer.interactor.RoutesInteractor;

public class CompanyDetailsPresenter {

    private Context context;

    public CompanyDetailsPresenter(Context context) {
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

    public AdapterView.OnItemClickListener getRouteListClickListener(String companyName, Palette mPalette, int defaultColor) {
        OnClickSetupInteractor onClickSetupInteractor = new OnClickSetupInteractor(context);
        return onClickSetupInteractor.getRouteListClickListener(companyName, mPalette, defaultColor);
    }
}
