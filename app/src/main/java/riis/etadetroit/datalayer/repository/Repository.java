package riis.etadetroit.datalayer.repository;

import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.datalayer.entities.ETADetroitDatabaseHelper;

public class Repository {

    private ETADetroitDatabaseHelper eTADetroitDatabaseHelper;

    public Repository(Context context) {
        eTADetroitDatabaseHelper = new ETADetroitDatabaseHelper(context);
    }

    public int getCompanyListSize() {
        return eTADetroitDatabaseHelper.getCompanyNames().getCount();
    }

    public Cursor getCompanyNames() {
        return eTADetroitDatabaseHelper.getCompanyNames();
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
