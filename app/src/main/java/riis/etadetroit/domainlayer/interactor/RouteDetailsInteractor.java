package riis.etadetroit.domainlayer.interactor;

import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.datalayer.repository.Repository;

public class RouteDetailsInteractor {
    private Context context;

    public RouteDetailsInteractor(Context context){
        this.context = context;
    }

    public String getRouteDetails(String route){
        Repository repository = new Repository(context);

        Cursor routeDetailsCursor = repository.getRouteDetails(route);

        if (routeDetailsCursor.moveToFirst()) {

            return ("ROUTE DETAILS" +
                    "\n\nROUTE: " + route +
                    "\nROUTE NUMBER: " + routeDetailsCursor.getString(2) +
                    "\nDIRECTION 1: " + routeDetailsCursor.getString(3) +
                    "\nDIRECTION 2: " + routeDetailsCursor.getString(4) +
                    "\nDAYS ACTIVE: " + routeDetailsCursor.getString(5) +
                    "\n\nSTOPS");
        }
        return null;
    }

    public String getRouteId(String route){
        Repository repository = new Repository(context);

        Cursor routeDetailsCursor = repository.getRouteDetails(route);

        if (routeDetailsCursor.moveToFirst()){
            return routeDetailsCursor.getString(6);
        }
        return null;
    }
}
