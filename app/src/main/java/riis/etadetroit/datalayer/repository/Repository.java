package riis.etadetroit.datalayer.repository;

import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.datalayer.entities.CompanyData;
import riis.etadetroit.datalayer.entities.ETADetroitDatabaseHelper;

/**
 * Created by bmarshall on 2/9/17.
 */

public class Repository {

    private ETADetroitDatabaseHelper eTADetroitDatabaseHelper;
    private Context context;

    public Repository(Context context){
        this.context = context;
        eTADetroitDatabaseHelper = new ETADetroitDatabaseHelper(context);
    }

    public int getCompanyListSize() {
        return eTADetroitDatabaseHelper.getCompanyNames().getCount();
    }

    public String getCompanyName(int position) {
        CompanyData companyData = new CompanyData(eTADetroitDatabaseHelper.getCompanyNames());
        return companyData.getCompanyName(position);
    }

    public int getCompanyImageResourceId(int position) {
        CompanyData companyData = new CompanyData(eTADetroitDatabaseHelper.getCompanyNames());
        return companyData.getCompanyImageResourceId(context, position);
    }

    public Cursor getRoutes(String company) {
        return eTADetroitDatabaseHelper.getRoutes(company);
    }

    public Cursor getRouteDetails(String route) {
        return eTADetroitDatabaseHelper.getRouteDetails(route);
    }

    public Cursor getRouteStops(String route_id) {
        return eTADetroitDatabaseHelper.getRouteStops(route_id);
    }
}
