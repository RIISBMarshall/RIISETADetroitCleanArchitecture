package riis.etadetroit.domainlayer.interfaces;

import android.database.Cursor;

public class RouteDetailsContract {


    public interface RouteDetailsView {
        void showRouteDetails();
        void showRouteStops();
    }

    public interface RouteDetailsPresenter{
        Cursor getRouteDetails(String route);

        Cursor getRouteStops(String route_id);
    }
}
