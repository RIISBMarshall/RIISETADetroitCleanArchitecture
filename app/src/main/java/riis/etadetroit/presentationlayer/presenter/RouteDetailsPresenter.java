package riis.etadetroit.presentationlayer.presenter;

import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.domainlayer.interactor.RouteStopsInteractor;
import riis.etadetroit.domainlayer.interfaces.RouteDetailsContract;
import riis.etadetroit.datalayer.model.ETADetroitDatabaseHelper;

/**
 * Created by bmarshall on 2/6/17.
 */

public class RouteDetailsPresenter implements RouteDetailsContract.RouteDetailsPresenter {
    private Context context;

    public RouteDetailsPresenter(Context context){
        this.context = context;
    }

    public Cursor getRouteDetails(String route) {
        RouteDetailsPresenter routeDetailsPresenter = new RouteDetailsPresenter(context);
        return routeDetailsPresenter.getRouteDetails(route);
    }

    public Cursor getRouteStops(String route_id) {
        RouteStopsInteractor routeStopsInteractor = new RouteStopsInteractor(context);
        return routeStopsInteractor.getRouteDetails(route_id);
    }
}
