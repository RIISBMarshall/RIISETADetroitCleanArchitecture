package riis.etadetroit.presentationlayer.view;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import riis.etadetroit.R;
import riis.etadetroit.domainlayer.interfaces.RouteDetailsContract;
import riis.etadetroit.presentationlayer.presenter.RouteDetailsPresenter;

public class RouteDetailsActivity extends Activity implements RouteDetailsContract.RouteDetailsView {

    public static final String EXTRA_ROUTE = "route";
    private TextView routeDetails;
    private String route;
    private String routeId;
    private RouteDetailsPresenter routeDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_details);
        routeDetailsPresenter = new RouteDetailsPresenter(this);
        Intent intent = getIntent();
        route = intent.getStringExtra(EXTRA_ROUTE);
        routeDetails = (TextView) findViewById(R.id.routeDetails);
        showRouteDetails();
        showRouteStops();
    }

    public void showRouteDetails() {
        Cursor routeDetailsCursor = routeDetailsPresenter.getRouteDetails(route);

        if (routeDetailsCursor.moveToFirst()) {
            routeDetails.setText("ROUTE DETAILS" +
                    "\n\nROUTE: " + route +
                    "\nROUTE NUMBER: " + routeDetailsCursor.getString(2) +
                    "\nDIRECTION 1: " + routeDetailsCursor.getString(3) +
                    "\nDIRECTION 2: " + routeDetailsCursor.getString(4) +
                    "\nDAYS ACTIVE: " + routeDetailsCursor.getString(5) +
                    "\n\nSTOPS");

            routeId = routeDetailsCursor.getString(6);
        }
    }

    public void showRouteStops() {
        Cursor routeStopsCursor = routeDetailsPresenter.getRouteStops(routeId);

        CursorAdapter routeStopsCursorAdapter = new SimpleCursorAdapter(this, R.layout.adapter_route_stops_cursor, routeStopsCursor, new String[]{"stop_name"},
                new int[]{R.id.list_content}, 0);
        ListView stopList = (ListView) findViewById(R.id.stopList);
        stopList.setAdapter(routeStopsCursorAdapter);
    }
}
