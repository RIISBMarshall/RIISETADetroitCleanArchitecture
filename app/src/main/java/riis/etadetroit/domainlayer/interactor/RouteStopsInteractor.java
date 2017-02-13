package riis.etadetroit.domainlayer.interactor;

import android.content.Context;
import android.database.Cursor;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;

import riis.etadetroit.R;
import riis.etadetroit.datalayer.repository.Repository;

public class RouteStopsInteractor {

    private Context context;

    public RouteStopsInteractor(Context context){
        this.context = context;
    }

    public SimpleCursorAdapter getRouteStops(String route_id){
        Repository repository = new Repository(context);

        Cursor routeStopsCursor = repository.getRouteStops(route_id);

        return new SimpleCursorAdapter(context, R.layout.adapter_route_stops_cursor, routeStopsCursor, new String[]{"stop_name"},
                new int[]{R.id.list_content}, 0);
    }
}
