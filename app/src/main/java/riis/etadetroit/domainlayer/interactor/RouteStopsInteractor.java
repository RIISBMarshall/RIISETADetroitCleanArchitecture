package riis.etadetroit.domainlayer.interactor;

import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.datalayer.repository.Repository;

public class RouteStopsInteractor {

    private Context context;

    public RouteStopsInteractor(Context context){
        this.context = context;
    }

    public Cursor getRouteStops(String route_id){
        Repository repository = new Repository(context);
        return repository.getRouteStops(route_id);
    }
}
